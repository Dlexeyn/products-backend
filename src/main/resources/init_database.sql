CREATE TABLE IF NOT EXISTS products(
    id UUID PRIMARY KEY,
    article VARCHAR NOT NULL UNIQUE,
    title VARCHAR NOT NULL,
    category VARCHAR,
    price BIGINT check ( price > 0 ),
    created_at VARCHAR,
    updated_at VARCHAR
)