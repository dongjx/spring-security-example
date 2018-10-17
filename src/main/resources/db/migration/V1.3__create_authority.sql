DROP TABLE IF EXISTS t_authority;
DROP SEQUENCE IF EXISTS t_authority_id_seq;

CREATE SEQUENCE t_authority_id_seq;
CREATE TABLE t_authority (
    id        INT PRIMARY KEY  NOT NULL DEFAULT nextval('t_authority_id_seq'),
    name      VARCHAR(50) NOT NULL
 );
 ALTER SEQUENCE t_authority_id_seq OWNED BY t_authority.id;