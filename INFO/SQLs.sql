CREATE DATABASE demo_db;

CREATE TABLE IF NOT EXISTS users
( id INTEGER NOT NULL AUTO_INCREMENT,
  user_name VARCHAR(128) NOT NULL,
  first_name VARCHAR(128) NOT NULL,
  last_name VARCHAR(128) NOT NULL,
  email VARCHAR(128) NOT NULL,
  PRIMARY KEY (id)
);


-- HQL
INSERT INTO User (userName, firstName, lastName, email) VALUES (:userName, :firstName, :lastName, :email)
-- SQL
INSERT INTO users (user_name, first_name, last_name, email) VALUES (:userName, :first_name, :last_name, :email)


-- HQL
FROM User
-- SQL
SELECT * FROM users


-- HQL
UPDATE User SET email = :email WHERE id = :id
-- SQL
UPDATE users SET email = :email WHERE id = :id


-- HQL
DELETE FROM User WHERE id = :id
-- SQL
DELETE FROM users WHERE id = :id;
