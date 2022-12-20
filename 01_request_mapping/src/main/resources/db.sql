
DROP TABLE IF EXISTS courses;
CREATE TABLE  IF NOT EXISTS courses(

 id INT NOT NULL AUTO_INCREMENT PRIMARY KEY,
 name VARCHAR(50) NOT NULL UNIQUE,
 level ENUM('Basic','Intermediate','Advence') DEFAULT 'Basic',
 fees INT NOT NULL,
 duration INT NOT NULL

);