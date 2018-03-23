CREATE STREAM foo
FROM KAFKA
OPTIONS(
  'kafka.bootstrap.servers'='localhost:9092'
);

CREATE TEMPORARY VIEW bar AS
SELECT * FROM foo;

SAVE STREAM bar
TO VERTICA
OPTIONS(
  'url'='jdbc:vertica://localhost:5433/default'
);
