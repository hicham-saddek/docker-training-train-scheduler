CREATE TABLE trains
(
    id                 INT AUTO_INCREMENT PRIMARY KEY,
    origin             VARCHAR(255)                       NOT NULL,
    destination        VARCHAR(255)                       NOT NULL,
    starting_date_time DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL,
    ending_date_time   DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL
);

INSERT INTO trains (id, origin, destination, starting_date_time, ending_date_time)
    VALUE (2, 'Metz', 'Nancy', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);

INSERT INTO trains (id, origin, destination, starting_date_time, ending_date_time)
    VALUE (1, 'Nancy', 'Metz', CURRENT_TIMESTAMP, CURRENT_TIMESTAMP);
