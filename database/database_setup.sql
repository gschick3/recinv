-- E.164 standard (i.e. +1234567890)
CREATE DOMAIN PHONE_NUMBER AS TEXT CHECK(
  octet_length(VALUE) BETWEEN 1 /*+*/ + 8 AND 1 /*+*/ + 15 + 3
  AND VALUE ~ '^\+\d+$'
);

-- CREATE TYPE role AS ENUM('USER', 'MODERATOR', 'ADMIN')

CREATE TABLE IF NOT EXISTS users (
  user_id             BIGINT          PRIMARY KEY           GENERATED ALWAYS AS IDENTITY,
  email               TEXT            NOT NULL UNIQUE,
  name                TEXT            NOT NULL,
  phone               PHONE_NUMBER    UNIQUE,
  date_format         VARCHAR(10),
  pass_hash           TEXT            NOT NULL
);

CREATE TABLE IF NOT EXISTS products (
  product_id          BIGINT          PRIMARY KEY           GENERATED ALWAYS AS IDENTITY,
  user_id             BIGINT          NOT NULL              REFERENCES users      ON DELETE CASCADE,
  description         TEXT            NOT NULL,
  UNIQUE(user_id, description),
  current_price       NUMERIC(10, 3)  NOT NULL,
  total_sold          INT             NOT NULL DEFAULT 0,
  total_earned        NUMERIC(15, 4)  NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS materials (
  material_id         BIGINT          PRIMARY KEY           GENERATED ALWAYS AS IDENTITY,
  user_id             BIGINT          NOT NULL              REFERENCES users      ON DELETE CASCADE,
  brand               TEXT            NOT NULL,
  description         TEXT            NOT NULL,
  UNIQUE(user_id, brand, description),
  unit                TEXT            NOT NULL DEFAULT 'units',
  current_quantity    NUMERIC(10, 3)  NOT NULL DEFAULT 0,
  total_purchased     NUMERIC(10, 3)  NOT NULL DEFAULT 0,
  current_cost        NUMERIC(10, 3)  NOT NULL,
  total_spent         NUMERIC(15, 4)  NOT NULL DEFAULT 0
);

CREATE TABLE IF NOT EXISTS product_materials (
  product_id          BIGINT          NOT NULL              REFERENCES products   ON DELETE CASCADE,
  material_id         BIGINT          NOT NULL              REFERENCES materials  ON DELETE CASCADE,
  amount              NUMERIC(10, 3)  NOT NULL,
  PRIMARY KEY (product_id, material_id)
);

CREATE TABLE IF NOT EXISTS sales (
  product_id          BIGINT          NOT NULL              REFERENCES products   ON DELETE RESTRICT,
  transaction_id      BIGINT          NOT NULL,
  quantity_sold       INT             NOT NULL,
  unit_cost           NUMERIC(10, 3)  NOT NULL,
  unit_price          NUMERIC(10, 3)  NOT NULL,
  date                DATE            NOT NULL,
  PRIMARY KEY (product_id, transaction_id)
);

CREATE TABLE IF NOT EXISTS purchases (
  material_id         BIGINT          NOT NULL              REFERENCES materials  ON DELETE RESTRICT,
  transaction_id      BIGINT          NOT NULL,
  quantity_purchased  NUMERIC(10, 3)  NOT NULL,
  unit_cost           NUMERIC(10, 3)  NOT NULL,
  date                DATE            NOT NULL,
  PRIMARY KEY (material_id, transaction_id)
);