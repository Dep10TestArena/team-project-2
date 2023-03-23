CREATE TABLE IF NOT EXISTS Student(
    id INT PRIMARY KEY AUTO_INCREMENT,
    name VARCHAR(50) NOT NULL ,
    address VARCHAR(200) NOT NULL
);

INSERT INTO Student (name, address) VALUES
    ('sameers','kany'),
    ('anupama','pothuhera'),
    ('bhathiya','mathara'),
    ('rashmitha','weligama');