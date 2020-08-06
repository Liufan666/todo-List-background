DROP TABLE IF EXISTS todoitem;
CREATE TABLE todoitem (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content VARCHAR(100) NOT NULL,
  status int
);
