CREATE TABLE notification
(
    id INT PRIMARY KEY AUTO_INCREMENT,
    notifier BIGINT NOT NULL,
    receiver BIGINT NOT NULL,
    outid BIGINT NOT NULL,
    type INT,
    gmt_create BIGINT NOT NULL,
    status INT DEFAULT 0 NOT NULL
);