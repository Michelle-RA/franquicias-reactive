-- Creación de la tabla de franquicias
CREATE TABLE IF NOT EXISTS franquicias (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL
);

-- Creación de la tabla de sucursales
CREATE TABLE IF NOT EXISTS sucursales (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    franquicia_id BIGINT NOT NULL,
    FOREIGN KEY (franquicia_id) REFERENCES franquicias(id) ON DELETE CASCADE
);

-- Creación de la tabla de productos
CREATE TABLE IF NOT EXISTS productos (
    id SERIAL PRIMARY KEY,
    nombre VARCHAR(255) NOT NULL,
    stock INT NOT NULL,
    sucursal BIGINT NOT NULL,
    FOREIGN KEY (sucursal) REFERENCES sucursales(id) ON DELETE CASCADE
);
