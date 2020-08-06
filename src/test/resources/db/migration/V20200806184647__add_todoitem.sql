DROP TABLE IF EXISTS todoitem;
CREATE TABLE todoitem (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  content VARCHAR(100) NOT NULL,
  status Boolean
);
 INSERT INTO todoitem (content,status) VALUES
   ('chengcheng',false),
   ('yuexie',true),
   ('haifeng',true),
   ('ang',false);