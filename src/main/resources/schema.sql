<<<<<<< HEAD
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
