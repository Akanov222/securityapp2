DROP TABLE IF EXISTS person;

CREATE TABLE person(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username varchar(100) NOT NULL,
    password varchar NOT NULL
);