-- Insert data into Motherboard
INSERT INTO motherboard (name, price, socketType) VALUES
('Gigabyte Aorus Z590', 250, 'LGA 1200'),
('MSI B450 TOMAHAWK MAX', 100, 'AM4'),
('ASUS ROG Crosshair VIII', 400, 'AM4');

-- Insert data into PSU
INSERT INTO psu (name, price, voltage) VALUES
('Corsair RM850x', 130, '850W'),
('EVGA SuperNOVA 650 G3', 90, '650W'),
('Cooler Master MWE Gold 750', 100, '750W');

-- Insert data into CPU
-- Make sure you insert motherboard IDs first, as CPUs are related to motherboards
INSERT INTO cpu (name, price, generation, socketType, motherboard_id) VALUES
('Intel Core i9-11900K', 550, 11, 'LGA 1200', 1),
('AMD Ryzen 5 3600', 200, 3, 'AM4', 2),
('AMD Ryzen 9 5900X', 750, 5, 'AM4', 3);

-- Insert data into GPU
-- Make sure you insert PSU IDs first, as GPUs are related to PSUs
INSERT INTO gpu (name, price, voltage, PSU_id) VALUES
('NVIDIA GeForce RTX 3080', 700, '750W', 1),
('AMD Radeon RX 6800 XT', 650, '750W', 2),
('NVIDIA GeForce GTX 1660', 250, '450W', 3);
