package com.recinven.recinvenbackend.service;

import com.recinven.recinvenbackend.dto.SaleDto;
import com.recinven.recinvenbackend.entity.Product;
import com.recinven.recinvenbackend.entity.Sale;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.entity.idclass.SaleId;
import com.recinven.recinvenbackend.exceptions.exception.EntityNotFoundException;
import com.recinven.recinvenbackend.mapper.SaleMapper;
import com.recinven.recinvenbackend.repository.SaleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class SaleService {
    private final SaleRepository saleRepository;
    private final SaleMapper saleMapper;
    private final ProductService productService;
    private final MaterialService materialService;
    private final UserService userService;

    @Autowired
    public SaleService(SaleRepository saleRepository, SaleMapper saleMapper, ProductService productService, MaterialService materialService, UserService userService) {
        this.saleRepository = saleRepository;
        this.saleMapper = saleMapper;
        this.productService = productService;
        this.materialService = materialService;
        this.userService = userService;
    }

    public List<Sale> findAllByTransaction(Long userId, Long transactionId) {
        User user = userService.findById(userId);
        return saleRepository.findAllByUserAndTransactionId(user, transactionId).orElseThrow(() -> new EntityNotFoundException(Sale.class, transactionId));
    }

    public List<Sale> findAllByProduct(Long userId, Long productId) {
        Product product = productService.findById(userId, productId);
        return saleRepository.findAllByProduct(product).orElseThrow(() -> new EntityNotFoundException(Sale.class, productId));
    }

    public Sale findById(Long userId, Long transactionId, Long productId) {
        Product product = productService.findById(userId, productId);
        return saleRepository.findById(new SaleId(transactionId, product)).orElseThrow(() -> new EntityNotFoundException(Sale.class, String.format("%d %d", productId, transactionId)));
    }

    @Transactional
    public Sale updateById(Long userId, Long transactionId, Long productId, SaleDto saleDto) {
        Product product = productService.findById(userId, productId);
        return saleRepository.findById(new SaleId(transactionId, product))
                .map(sale -> {
                    int originalQuantitySold = sale.getQuantitySold();
                    saleMapper.updateFromDto(saleDto, sale);

                    Sale result = saleRepository.save(sale);

                    if (saleDto.quantitySold > 0) {
                        int difference = saleDto.quantitySold - originalQuantitySold;

                        result.getProduct().makeSale(difference, result.getUnitPrice());
                        productService.create(userId, result.getProduct());

                        result.getProduct().getProductMaterials()
                                .forEach(productMaterial -> {
                                    productMaterial.getMaterial().makeSale(productMaterial.getAmount() * difference);
                                    materialService.create(userId, productMaterial.getMaterial());
                                });
                    }

                    return result;
                })
                .orElseThrow(() -> new EntityNotFoundException(Sale.class, String.format("%d %d", productId, transactionId)));
    }

    public void deleteById(Long userId, Long transactionId, Long productId) {
        Product product = productService.findById(userId, productId);
        SaleId saleId = new SaleId(transactionId, product);

        if (saleRepository.findById(saleId).isEmpty()) {
            throw new EntityNotFoundException(Sale.class, String.format("%d %d", productId, transactionId));
        }

        saleRepository.deleteById(saleId);
    }

    @Transactional
    public Sale create(Long userId, Long productId, Sale sale) {
        sale.setProduct(productService.findById(userId, productId));

        // Set unit cost to sum of current cost of all materials used to create product
        if (sale.getUnitCost() == 0) {
            sale.calculateUnitCost();
        }

        // Set unit price to current price of product
        if (sale.getUnitPrice() == 0) {
            sale.calculateUnitPrice();
        }

        // Make sale early in case it fails
        Sale result = saleRepository.save(sale);

        // Increase total sold and total earned of product sold
        result.getProduct().makeSale(result.getQuantitySold(), result.getUnitPrice());
        productService.create(userId, result.getProduct());

        // Reduce current quantity of materials used
        result.getProduct().getProductMaterials()
                .forEach(productMaterial -> {
                    productMaterial.getMaterial().makeSale(productMaterial.getAmount() * result.getQuantitySold());
                    materialService.create(userId, productMaterial.getMaterial());
                });

        return result;
    }
}
