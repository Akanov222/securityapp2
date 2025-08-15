DROP TABLE IF EXISTS person;

CREATE TABLE person(
    id INTEGER GENERATED ALWAYS AS IDENTITY PRIMARY KEY,
    username varchar(100) NOT NULL,
    password varchar NOT NULL,
    role varchar(60)
);

-- Clear databasechangelog
-- UPDATE databasechangelog
-- SET md5sum = '9:045b0c692543b46a2eae20595b312f53'
-- WHERE id = '1' AND author = 'your_name';
--
-- UPDATE databasechangelog
-- SET md5sum = '9:70cc26a43786837e6d5ec86e3c2beeba'
-- WHERE id = '2' AND author = 'your_name';
