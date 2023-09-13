CREATE TABLE IF NOT EXISTS customer(
   id INTEGER PRIMARY KEY AUTOINCREMENT,
   phone_no TEXT NOT NULL,
   name TEXT NOT NULL,
   address TEXT NOT NULL
);

INSERT INTO customer(id, phone_no, name, address) VALUES (1, '7970460076', 'Rishi Agarwal', 'Hume Pipe Nirmal Nagar, Jamshedpur');
INSERT INTO customer(id, phone_no, name, address) VALUES (2, '9334638328', 'Rajesh Agarwal', 'Hume Pipe Nirmal Nagar, Jamshedpur');
INSERT INTO customer(id, phone_no, name, address) VALUES (3, '8789738298', 'Akash Kumar', 'Hume Pipe Nirmal Nagar, Jamshedpur');