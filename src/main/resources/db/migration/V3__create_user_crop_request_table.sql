CREATE TABLE user_crop_request (
 id SERIAL PRIMARY KEY,
 user_id SERIAL,
 crop_name SERIAL,
 price NUMERIC (7, 2) NOT NULL,
 FOREIGN KEY (user_id) REFERENCES user_data(id),
 FOREIGN KEY (crop_name) REFERENCES crops(id)
);