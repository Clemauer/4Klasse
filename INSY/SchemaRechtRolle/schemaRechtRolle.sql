\c postgres

DROP DATABASE fa02;

CREATE DATABASE fa02;

\c fa02;

CREATE SCHEMA IF NOT EXISTS pers;

CREATE SCHEMA IF NOT EXISTS buch;

CREATE TABLE pers.angestellte(
    id SERIAL PRIMARY KEY,
    name varchar(255),
    gehalt FLOAT,
    verkaeufer VARCHAR(255),
    ausbildung VARCHAR(255),
    bemerkung VARCHAR(255) 
);

CREATE TABLE buch.verkaeufe(
    id SERIAL PRIMARY KEY,
    produkt VARCHAR(255),
    vdatum DATE,
    betrag FLOAT,
    verkaeufer VARCHAR(255),
    kommentar VARCHAR(255)
);

DROP USER if EXISTS buser01;
DROP USER if EXISTS buser02;
DROP USER if EXISTS buser03;

DROP USER if EXISTS aduser01;
DROP USER if EXISTS aduser02;

DROP USER if EXISTS chef01;
DROP USER if EXISTS chef02;

DROP USER if EXISTS pers01;
DROP USER if EXISTS pers02;

DROP USER if EXISTS lag01;
DROP USER if EXISTS lag02;

CREATE USER buser01 WITH PASSWORD 'psw';

CREATE USER buser02 WITH PASSWORD 'psw';
CREATE USER buser03 WITH PASSWORD 'psw';

CREATE USER aduser01 WITH PASSWORD 'psw' ;
CREATE USER aduser02 WITH PASSWORD 'psw';

CREATE USER chef01 WITH PASSWORD 'psw';
CREATE USER chef02 WITH PASSWORD 'psw';

CREATE USER pers01 WITH PASSWORD 'psw';
CREATE USER pers02 WITH PASSWORD 'psw';

CREATE USER lag01 WITH PASSWORD 'psw';
CREATE USER lag02 WITH PASSWORD 'psw';

DROP ROLE IF EXISTS administration_role;
CREATE ROLE administration_role WITH LOGIN;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA public TO administration_role;
GRANT ALL PRIVILEGES ON ALL SEQUENCES IN SCHEMA public TO administration_role;

GRANT administration_role to aduser01;
GRANT administration_role to aduser02;
