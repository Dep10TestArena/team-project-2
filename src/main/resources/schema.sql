<<<<<<< HEAD
CREATE TABLE IF NOT EXISTS Customer(
    id VARCHAR(4) PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    address VARCHAR(400) NOT NULL
    );
=======
#DROP TABLE Student;
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

>>>>>>> origin/main
