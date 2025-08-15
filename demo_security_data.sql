INSERT INTO person(username, password, role) VALUES
('text_user1', '111', 'ROLE_USER'),
('text_user2', '111', 'ROLE_USER');

-- TRUNCATE TABLE person;
-- ALTER TABLE person ADD COLUMN role varchar(100) NOT NULL

-- UPDATE person set role='ROLE_ADMIN' WHERE id = 1;