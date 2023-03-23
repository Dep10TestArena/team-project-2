
CREATE TABLE IF NOT EXISTS Teachers
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)  NOT NULL,
    address VARCHAR(100) NOT NULL
) ;

INSERT INTO Teachers (name, address)
VALUES ('Nipuna', 'Eppawala'),
        ('Kushan', 'Meerigama'),
        ('Dilshan', 'Ganemulla'),
        ('Anupama', 'Kurunegala');


CREATE TABLE IF NOT EXISTS Customer(
    id VARCHAR(4) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
    );


CREATE TABLE IF NOT EXISTS Student(
                                      id INT PRIMARY KEY AUTO_INCREMENT,
                                      name VARCHAR(50) NOT NULL ,
                                      address VARCHAR(200) NOT NULL
);

INSERT INTO Customer (id, name, address) VALUES
                ('C001','sameers','kany');


