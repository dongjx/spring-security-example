DROP TABLE IF EXISTS t_user;
DROP SEQUENCE IF EXISTS t_user_id_seq;

CREATE SEQUENCE t_user_id_seq;
CREATE TABLE t_user (
    id        INT PRIMARY KEY  NOT NULL DEFAULT nextval('t_user_id_seq'),
    username      VARCHAR(50) NOT NULL,
    password  VARCHAR(100) NOT NULL
 );

 ALTER SEQUENCE t_user_id_seq
 OWNED BY t_user.id;