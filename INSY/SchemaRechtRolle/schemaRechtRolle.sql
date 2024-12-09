-- ausfuehren mit \i schemaRechtRolle.sql
-- wurde mit mehreren testdaten getestet und funktioniert


\c postgres

DROP DATABASE fa02;

CREATE DATABASE fa02;

\c fa02;

CREATE SCHEMA IF NOT EXISTS pers;

CREATE SCHEMA IF NOT EXISTS buch;

CREATE TABLE pers.angestellte(
    id SERIAL,
    name varchar(255),
    gehalt FLOAT,
    geschlecht varchar(255),
    verkaeufer VARCHAR(255),
    ausbildung VARCHAR(255),
    bemerkung VARCHAR(255) 
);

CREATE TABLE buch.verkaeufe(
    id SERIAL,
    produkt VARCHAR(255),
    vdatum DATE,
    betrag FLOAT,
    verkaeufer VARCHAR(255),
    kommentar VARCHAR(255)
);


DROP ROLE IF EXISTS arole01;
CREATE ROLE arole01;
GRANT USAGE ON SCHEMA pers,buch TO arole01;
GRANT ALL PRIVILEGES ON ALL TABLES IN SCHEMA pers, buch TO arole01;
ALTER ROLE arole01 WITH CREATEROLE CREATEDB;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA pers, buch TO arole01;


GRANT arole01 to aduser01;
GRANT arole01 to aduser02;

DROP ROLE IF EXISTS chefrole;
CREATE ROLE chefrole;
GRANT USAGE ON SCHEMA pers,buch TO chefrole;
GRANT SELECT ON ALL TABLES IN SCHEMA pers, buch TO chefrole;
GRANT UPDATE (gehalt) ON pers.angestellte TO chefrole;
GRANT UPDATE (kommentar) ON buch.verkaeufe TO chefrole;
ALTER ROLE chefrole WITH CREATEROLE CREATEDB;

DROP ROLE IF EXISTS prole;
CREATE ROLE prole;
GRANT USAGE ON SCHEMA pers TO prole;
GRANT INSERT, SELECT, UPDATE ON TABLE pers.angestellte TO prole;
GRANT USAGE ON ALL SEQUENCES IN SCHEMA pers, buch TO prole;


DROP ROLE IF EXISTS lrole;
CREATE ROLE lrole;
GRANT USAGE ON SCHEMA buc,pers TO lrole;
GRANT SELECT (name) ON TABLE pers.angestellte TO lrole;
GRANT SELECT (produkt) ON Table buch.verkaeufe TO lrole;

DROP ROLE IF EXISTS brole01;
CREATE ROLE brole01;
GRANT USAGE ON SCHEMA buch TO brole01;
GRANT SELECT ON TABLE buch.verkaeufe TO brole01;
GRANT UPDATE (kommentar) ON TABLE buch.verkaeufe TO brole01;

DROP ROLE IF EXISTS brole02;
CREATE ROLE brole02;
GRANT USAGE ON SCHEMA buch TO brole02;
GRANT SELECT ON TABLE buch.verkaeufe TO brole02;
GRANT UPDATE (kommentar) ON TABLE buch.verkaeufe TO brole02;

DROP USER IF EXISTS buser01;
CREATE USER buser01 WITH PASSWORD 'psw';

DROP USER IF EXISTS buser02;
CREATE USER buser02  WITH PASSWORD 'psw';

DROP USER IF EXISTS buser03;
CREATE USER buser03 WITH PASSWORD 'psw';

DROP USER IF EXISTS aduser01;
CREATE USER aduser01 WITH PASSWORD 'psw';

DROP USER IF EXISTS aduser02;
CREATE USER aduser02 WITH PASSWORD 'psw';

DROP USER IF EXISTS chef01;
CREATE USER chef01 WITH PASSWORD 'psw';

DROP USER IF EXISTS chef02;
CREATE USER chef02 WITH PASSWORD 'psw';

DROP USER IF EXISTS pers01;
CREATE USER pers01 WITH PASSWORD 'psw';

DROP USER IF EXISTS pers02;
CREATE USER pers02 WITH PASSWORD 'psw';

DROP USER IF EXISTS lag01;
CREATE USER lag01 WITH PASSWORD 'psw';

DROP USER IF EXISTS lag02;
CREATE USER lag02 WITH PASSWORD 'psw';

GRANT CONNECT ON DATABASE fa02 TO buser01;
GRANT CONNECT ON DATABASE fa02 TO buser02;
GRANT CONNECT ON DATABASE fa02 TO buser03;

GRANT CONNECT ON DATABASE fa02 TO aduser01;
GRANT CONNECT ON DATABASE fa02 TO aduser02;

GRANT CONNECT ON DATABASE fa02 TO chef01;
GRANT CONNECT ON DATABASE fa02 TO chef02;

GRANT CONNECT ON DATABASE fa02 TO pers01;
GRANT CONNECT ON DATABASE fa02 TO pers02;

GRANT CONNECT ON DATABASE fa02 TO lag01;
GRANT CONNECT ON DATABASE fa02 TO lag02;

GRANT chefrole to chef01;
GRANT chefrole to chef02;


GRANT brole01 TO buser01;
GRANT brole01 TO buser02;
GRANT brole01 TO buser03;

GRANT arole01 TO aduser01;
GRANT arole01 TO aduser02;

GRANT prole TO pers01;
GRANT prole TO pers02;


GRANT lrole TO lag01;
GRANT lrole TO lag02;

