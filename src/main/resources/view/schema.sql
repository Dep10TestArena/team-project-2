CREATE TABLE IF NOT EXISTS Employee(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL ,
    address VARCHAR(200) NOT NULL
);

INSERT INTO Employee (name,address)VALUES ('kushan','gampaha'),('pt','ganemulla');

