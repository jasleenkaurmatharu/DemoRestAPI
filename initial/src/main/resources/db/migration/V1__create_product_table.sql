CREATE TABLE IF NOT EXISTS product
(
    id BIGINT GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    category TEXT NOT NULL,
    description TEXT NOT NULL,
    price BIGINT NOT NULL
);