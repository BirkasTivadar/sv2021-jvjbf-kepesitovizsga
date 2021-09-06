CREATE TABLE recorder
(
    id            BIGINT AUTO_INCREMENT,
    recorder_name VARCHAR(255),
    date_of_birth DATE,
    PRIMARY KEY (id)
);

CREATE TABLE world_record
(
    id              BIGINT AUTO_INCREMENT,
    description     VARCHAR(255),
    value           DOUBLE,
    unit_of_measure VARCHAR(255),
    date_of_record  DATE,
    recorder_id     BIGINT,
    PRIMARY KEY (id)
);