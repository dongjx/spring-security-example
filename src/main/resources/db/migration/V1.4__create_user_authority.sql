DROP TABLE IF EXISTS t_user_authority;
DROP SEQUENCE IF EXISTS t_user_authority_id_seq;

CREATE SEQUENCE t_user_authority_id_seq;
CREATE TABLE t_user_authority (
    id        INT PRIMARY KEY  NOT NULL DEFAULT nextval('t_user_authority_id_seq'),
    user_id       INT NOT NULL,
    authority_id  INT NOT NULL
 );
  ALTER SEQUENCE t_user_authority_id_seq OWNED BY t_user_authority.id;