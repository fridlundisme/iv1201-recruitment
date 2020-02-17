DROP TABLE IF EXISTS webapplication.role CASCADE;
DROP TABLE IF EXISTS webapplication.person CASCADE;
DROP TABLE IF EXISTS webapplication.availability CASCADE;
DROP TABLE IF EXISTS webapplication.competence CASCADE;
DROP TABLE IF EXISTS webapplication.competence_profile CASCADE;

CREATE TABLE webapplication.role (
    role_id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE webapplication.person (
    person_id SERIAL PRIMARY KEY,
    name VARCHAR(255) NOT NULL,
    surname VARCHAR(255) NOT NULL,
    ssn VARCHAR(255) NOT NULL,
    email VARCHAR(255) UNIQUE NOT NULL,
    password VARCHAR(255) NOT NULL,
    role_id BIGINT REFERENCES webapplication.role(role_id) ON DELETE CASCADE,
    username VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE webapplication.availability (
    availability_id SERIAL PRIMARY KEY,
    person_id BIGINT REFERENCES webapplication.person(person_id) ON DELETE CASCADE,
    from_date DATE NOT NULL,
    to_date DATE NOT NULL
);

CREATE TABLE webapplication.competence (
    competence_id SERIAL PRIMARY KEY,
    name VARCHAR(255) UNIQUE NOT NULL
);

CREATE TABLE webapplication.competence_profile (
    competence_profile_id SERIAL PRIMARY KEY,
    person_id BIGINT REFERENCES webapplication.person(person_id) ON DELETE CASCADE,
    competence_id BIGINT REFERENCES webapplication.competence(competence_id) ON DELETE CASCADE,
    years_of_experience NUMERIC(4,2) NOT NULL
);
