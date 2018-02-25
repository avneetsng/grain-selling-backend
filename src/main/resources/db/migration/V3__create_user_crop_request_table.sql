CREATE TABLE user_crop_request (
 id SERIAL PRIMARY KEY,
 user_id SERIAL,
 crop_id SERIAL,
 price NUMERIC (7, 2) NOT NULL,
 quantity NUMERIC (5, 2) NOT NULL,
 FOREIGN KEY (user_id) REFERENCES user_data(id),
 FOREIGN KEY (crop_id) REFERENCES crops(id)
);