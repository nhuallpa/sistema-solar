DROP TABLE sistema_solar IF EXISTS;

CREATE TABLE sistema_solar  (
    dia BIGINT IDENTITY NOT NULL PRIMARY KEY,
    periodo VARCHAR(40),
    intensidad int
);