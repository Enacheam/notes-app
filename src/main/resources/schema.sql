DROP TABLE IF EXISTS TBL_EMPLOYEES;

CREATE TABLE DAILY_NOTES (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  title VARCHAR(250) NOT NULL,
  sub_title VARCHAR(250) NOT NULL,
  inserted_date date,
  description TEXT DEFAULT NULL
);