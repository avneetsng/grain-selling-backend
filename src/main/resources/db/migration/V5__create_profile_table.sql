CREATE TABLE user_profile (
 id SERIAL PRIMARY KEY,
 user_id SERIAL,
 name  VARCHAR(100) NOT NULL,
 gender VARCHAR(1) NOT NULL,
 address VARCHAR(200) NOT NULL,
 contact VARCHAR(16) NOT NULL,
 dob DATE NOT NULL,
 FOREIGN KEY (user_id) REFERENCES user_data(id)
);