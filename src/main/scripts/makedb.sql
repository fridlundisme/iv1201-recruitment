DROP TABLE IF EXISTS webapplication.role CASCADE;
DROP TABLE IF EXISTS webapplication.person CASCADE;
DROP TABLE IF EXISTS webapplication.availability CASCADE;
DROP TABLE IF EXISTS webapplication.competence CASCADE;
DROP TABLE IF EXISTS webapplication.competence_profile CASCADE;

create sequence hibernate_sequence;

alter sequence hibernate_sequence owner to dudsnbmnmrhudp;

create table role
(
    role_id serial  not null
        constraint role_pk
            primary key,
    name    varchar not null
);

alter table role
    owner to dudsnbmnmrhudp;

create unique index role_name_uindex
    on role (name);

create table person
(
    person_id serial  not null
        constraint person_pk
            primary key,
    name      varchar not null,
    surname   varchar not null,
    ssn       varchar not null,
    email     varchar not null,
    password  varchar not null,
    role_id   integer not null
        constraint person___fk
            references role
            on update cascade,
    username  varchar not null
);

alter table person
    owner to dudsnbmnmrhudp;

create unique index person_email_uindex
    on person (email);

create unique index person_username_uindex
    on person (username);

create table availability
(
    availability_id serial not null
        constraint availability_pk
            primary key,
    person_id       integer
        constraint availability_person_person_id_fk
            references person
            on update cascade,
    from_date       date   not null,
    to_date         date   not null
);

alter table availability
    owner to dudsnbmnmrhudp;

create table competence
(
    competence_id serial  not null
        constraint competence_pk
            primary key,
    name          varchar not null
);

alter table competence
    owner to dudsnbmnmrhudp;

create unique index competence_name_uindex
    on competence (name);

create table competence_profile
(
    competence_profile_id serial  not null
        constraint competence_profile_pk
            primary key,
    person_id             integer not null
        constraint competence_profile_person_person_id_fk
            references person,
    competence_id         integer not null
        constraint competence_profile_competence_competence_id_fk
            references competence
            on update cascade,
    years_of_experience   integer not null
);

alter table competence_profile
    owner to dudsnbmnmrhudp;

create table authority
(
    id   integer not null
        constraint authority_pkey
            primary key,
    name varchar(255)
);

alter table authority
    owner to dudsnbmnmrhudp;

