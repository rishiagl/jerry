DROP TABLE customer CASCADE;
CREATE TABLE IF NOT EXISTS customer(
   id INTEGER PRIMARY KEY AUTOINCREMENT,
   phone_no TEXT NOT NULL UNIQUE,
   name TEXT NOT NULL,
   address TEXT NOT NULL
);
INSERT INTO customer(phone_no, name, address) VALUES ('7970460076', 'Rishi Agarwal', 'Hume Pipe Nirmal Nagar, Jamshedpur');
INSERT INTO customer(phone_no, name, address) VALUES ('9334638328', 'Rajesh Agarwal', 'Hume Pipe Nirmal Nagar, Jamshedpur');
INSERT INTO customer(phone_no, name, address) VALUES ('8789738298', 'Akash Kumar', 'Hume Pipe Nirmal Nagar, Jamshedpur');

DROP TABLE product CASCADE;
CREATE TABLE IF NOT EXISTS product(
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    name TEXT NOT NULL UNIQUE,
    hsn TEXT NOT NULL,
    tax_rate INTEGER NOT NULL
);
INSERT INTO product(name, hsn, tax_rate) VALUES ('Bajaj Air Cooler', '84796000', 18);
INSERT INTO product(name, hsn, tax_rate) VALUES ('Voltas Air Conditioner', '8415', 28);
INSERT INTO product(name, hsn, tax_rate) VALUES ('Samsung Refridgerator', '82344523', 18);

DROP TABLE invoice CASCADE;
CREATE TABLE IF NOT EXISTS invoice (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    date_created TEXT NOT NULL,
    customer_name TEXT NOT NULL,
    customer_id INTEGER NOT NULL,
    FOREIGN KEY(customer_id) REFERENCES customer(id) ON DELETE RESTRICT
);
INSERT INTO invoice(date_created, customer_name, customer_id) VALUES('2023-09-16', 'RIshi Agarwal', 1);

DROP TABLE invoice_itme_list CASCADE;
CREATE TABLE IF NOT EXISTS invoice_item_list (
    id INTEGER PRIMARY KEY AUTOINCREMENT,
    invoice_id INTEGER NOT NULL,
    product_id INTEGER NOT NULL,
    qty INTEGER NOT NULL,
    rate INTEGER NOT NULL,
    FOREIGN KEY(invoice_id) REFERENCES invoice(id) ON DELETE RESTRICT,
    FOREIGN KEY(product_id) REFERENCES product(id) ON DELETE RESTRICT
);
INSERT INTO invoice_item_list(invoice_id, product_id, qty, rate) VALUES(1, 1, 2, 5000);