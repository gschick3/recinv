package com.recinven.recinvenbackend.service;

import com.recinven.recinvenbackend.dto.MaterialDto;
import com.recinven.recinvenbackend.entity.Material;
import com.recinven.recinvenbackend.entity.User;
import com.recinven.recinvenbackend.exceptions.exception.EntityNotFoundException;
import com.recinven.recinvenbackend.mapper.MaterialMapper;
import com.recinven.recinvenbackend.repository.MaterialRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
public class MaterialService {
    private final MaterialRepository materialRepository;
    private final MaterialMapper materialMapper;
    private final UserService userService;

    @Autowired
    public MaterialService(MaterialRepository materialRepository, MaterialMapper materialMapper, UserService userService) {
        this.materialRepository = materialRepository;
        this.materialMapper = materialMapper;
        this.userService = userService;
    }

    public List<Material> findAll(Long userId) {
        User user = userService.findById(userId);
        return materialRepository.findAllByUser(user).orElseThrow(() -> new EntityNotFoundException(User.class, userId));
    }

    public Material findById(Long userId, Long materialId) {
        User user = userService.findById(userId);
        return materialRepository.findByUserAndMaterialId(user, materialId).orElseThrow(() -> new EntityNotFoundException(Material.class, materialId));
    }

    @Transactional
    public Material updateById(Long userId, Long materialId, MaterialDto materialDto) {
        User user = userService.findById(userId);
        return materialRepository.findByUserAndMaterialId(user, materialId)
                .map(material -> {
                    materialMapper.updateFromDto(materialDto, material);
                    return materialRepository.save(material);
                })
                .orElseThrow(() -> new EntityNotFoundException(Material.class, materialId));
    }

    public void deleteById(Long userId, Long materialId) {
        User user = userService.findById(userId);
        if (materialRepository.findByUserAndMaterialId(user, materialId).isEmpty()) {
            throw new EntityNotFoundException(Material.class, materialId);
        }

        materialRepository.deleteById(materialId);
    }

    @Transactional
    public Material create(Material material) {
        return materialRepository.save(material);
    }

    public boolean existsByBrandAndDescription(Material material) {
        return material.getUser() != null && material.getBrand() != null && material.getDescription() != null
                && materialRepository.existsByUserAndBrandAndDescription(material.getUser(), material.getBrand(), material.getDescription());
    }
}
