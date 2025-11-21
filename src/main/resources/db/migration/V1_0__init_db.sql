CREATE TABLE IF NOT EXISTS `groups` (
    id     CHAR(36) PRIMARY KEY,
    number VARCHAR(100) UNIQUE NOT NULL
);

CREATE TABLE IF NOT EXISTS students (
    id     CHAR(36) PRIMARY KEY,
    first_name VARCHAR(100) NOT NULL,
    last_name VARCHAR(100) NOT NULL,
    middle_name VARCHAR(100) NOT NULL,
    receipt_date TIMESTAMP NOT NULL,
    group_id CHAR(36) REFERENCES `groups`(id)
);