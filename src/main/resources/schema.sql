CREATE TABLE IF NOT EXISTS Teachers
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50)  NOT NULL,
    address VARCHAR(100) NOT NULL
) ;

INSERT INTO Teachers (Teachers.name, address)
VALUES (('Nipuna', 'Eppawala'),
        ('Kushan', 'Meerigama'),
        ('Dilshan', 'Ganemulla'),
        ('Anupama', 'Kurunegala'));
