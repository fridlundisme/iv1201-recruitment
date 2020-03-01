--
-- PostgreSQL database dump
--

-- Dumped from database version 12.1
-- Dumped by pg_dump version 12rc1

SET statement_timeout = 0;
SET lock_timeout = 0;
SET idle_in_transaction_session_timeout = 0;
SET client_encoding = 'UTF8';
SET standard_conforming_strings = on;
SELECT pg_catalog.set_config('search_path', '', false);
SET check_function_bodies = false;
SET xmloption = content;
SET client_min_messages = warning;
SET row_security = off;

--
-- Name: webapplication; Type: SCHEMA; Schema: -; Owner: fridlund
--

CREATE SCHEMA webapplication;


ALTER SCHEMA webapplication OWNER TO fridlund;

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: authority; Type: TABLE; Schema: webapplication; Owner: fridlund
--

CREATE TABLE webapplication.authority (
    id integer NOT NULL,
    name character varying(255)
);


ALTER TABLE webapplication.authority OWNER TO fridlund;

--
-- Name: availability; Type: TABLE; Schema: webapplication; Owner: fridlund
--

CREATE TABLE webapplication.availability (
    availability_id integer NOT NULL,
    person_id integer,
    from_date date NOT NULL,
    to_date date NOT NULL
);


ALTER TABLE webapplication.availability OWNER TO fridlund;

--
-- Name: availability_availability_id_seq; Type: SEQUENCE; Schema: webapplication; Owner: fridlund
--

CREATE SEQUENCE webapplication.availability_availability_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE webapplication.availability_availability_id_seq OWNER TO fridlund;

--
-- Name: availability_availability_id_seq; Type: SEQUENCE OWNED BY; Schema: webapplication; Owner: fridlund
--

ALTER SEQUENCE webapplication.availability_availability_id_seq OWNED BY webapplication.availability.availability_id;


--
-- Name: competence; Type: TABLE; Schema: webapplication; Owner: fridlund
--

CREATE TABLE webapplication.competence (
    competence_id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE webapplication.competence OWNER TO fridlund;

--
-- Name: competence_competence_id_seq; Type: SEQUENCE; Schema: webapplication; Owner: fridlund
--

CREATE SEQUENCE webapplication.competence_competence_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE webapplication.competence_competence_id_seq OWNER TO fridlund;

--
-- Name: competence_competence_id_seq; Type: SEQUENCE OWNED BY; Schema: webapplication; Owner: fridlund
--

ALTER SEQUENCE webapplication.competence_competence_id_seq OWNED BY webapplication.competence.competence_id;


--
-- Name: competence_profile; Type: TABLE; Schema: webapplication; Owner: fridlund
--

CREATE TABLE webapplication.competence_profile (
    competence_profile_id integer NOT NULL,
    person_id integer NOT NULL,
    competence_id integer NOT NULL,
    years_of_experience integer NOT NULL
);


ALTER TABLE webapplication.competence_profile OWNER TO fridlund;

--
-- Name: competence_profile_competence_profile_id_seq; Type: SEQUENCE; Schema: webapplication; Owner: fridlund
--

CREATE SEQUENCE webapplication.competence_profile_competence_profile_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE webapplication.competence_profile_competence_profile_id_seq OWNER TO fridlund;

--
-- Name: competence_profile_competence_profile_id_seq; Type: SEQUENCE OWNED BY; Schema: webapplication; Owner: fridlund
--

ALTER SEQUENCE webapplication.competence_profile_competence_profile_id_seq OWNED BY webapplication.competence_profile.competence_profile_id;


--
-- Name: hibernate_sequence; Type: SEQUENCE; Schema: webapplication; Owner: fridlund
--

CREATE SEQUENCE webapplication.hibernate_sequence
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE webapplication.hibernate_sequence OWNER TO fridlund;

--
-- Name: person; Type: TABLE; Schema: webapplication; Owner: fridlund
--

CREATE TABLE webapplication.person (
    person_id integer NOT NULL,
    name character varying NOT NULL,
    surname character varying NOT NULL,
    ssn character varying NOT NULL,
    email character varying NOT NULL,
    password character varying NOT NULL,
    role_id integer NOT NULL,
    username character varying NOT NULL
);


ALTER TABLE webapplication.person OWNER TO fridlund;

--
-- Name: person_person_id_seq; Type: SEQUENCE; Schema: webapplication; Owner: fridlund
--

CREATE SEQUENCE webapplication.person_person_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE webapplication.person_person_id_seq OWNER TO fridlund;

--
-- Name: person_person_id_seq; Type: SEQUENCE OWNED BY; Schema: webapplication; Owner: fridlund
--

ALTER SEQUENCE webapplication.person_person_id_seq OWNED BY webapplication.person.person_id;


--
-- Name: role; Type: TABLE; Schema: webapplication; Owner: fridlund
--

CREATE TABLE webapplication.role (
    role_id integer NOT NULL,
    name character varying NOT NULL
);


ALTER TABLE webapplication.role OWNER TO fridlund;

--
-- Name: role_role_id_seq; Type: SEQUENCE; Schema: webapplication; Owner: fridlund
--

CREATE SEQUENCE webapplication.role_role_id_seq
    AS integer
    START WITH 1
    INCREMENT BY 1
    NO MINVALUE
    NO MAXVALUE
    CACHE 1;


ALTER TABLE webapplication.role_role_id_seq OWNER TO fridlund;

--
-- Name: role_role_id_seq; Type: SEQUENCE OWNED BY; Schema: webapplication; Owner: fridlund
--

ALTER SEQUENCE webapplication.role_role_id_seq OWNED BY webapplication.role.role_id;


--
-- Name: availability availability_id; Type: DEFAULT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.availability ALTER COLUMN availability_id SET DEFAULT nextval('webapplication.availability_availability_id_seq'::regclass);


--
-- Name: competence competence_id; Type: DEFAULT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.competence ALTER COLUMN competence_id SET DEFAULT nextval('webapplication.competence_competence_id_seq'::regclass);


--
-- Name: competence_profile competence_profile_id; Type: DEFAULT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.competence_profile ALTER COLUMN competence_profile_id SET DEFAULT nextval('webapplication.competence_profile_competence_profile_id_seq'::regclass);


--
-- Name: person person_id; Type: DEFAULT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.person ALTER COLUMN person_id SET DEFAULT nextval('webapplication.person_person_id_seq'::regclass);


--
-- Name: role role_id; Type: DEFAULT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.role ALTER COLUMN role_id SET DEFAULT nextval('webapplication.role_role_id_seq'::regclass);


--
-- Data for Name: authority; Type: TABLE DATA; Schema: webapplication; Owner: fridlund
--



--
-- Data for Name: availability; Type: TABLE DATA; Schema: webapplication; Owner: fridlund
--



--
-- Data for Name: competence; Type: TABLE DATA; Schema: webapplication; Owner: fridlund
--



--
-- Data for Name: competence_profile; Type: TABLE DATA; Schema: webapplication; Owner: fridlund
--



--
-- Data for Name: person; Type: TABLE DATA; Schema: webapplication; Owner: fridlund
--



--
-- Data for Name: role; Type: TABLE DATA; Schema: webapplication; Owner: fridlund
--

INSERT INTO webapplication.role VALUES (1, 'recruit');


--
-- Name: availability_availability_id_seq; Type: SEQUENCE SET; Schema: webapplication; Owner: fridlund
--

SELECT pg_catalog.setval('webapplication.availability_availability_id_seq', 1, false);


--
-- Name: competence_competence_id_seq; Type: SEQUENCE SET; Schema: webapplication; Owner: fridlund
--

SELECT pg_catalog.setval('webapplication.competence_competence_id_seq', 1, false);


--
-- Name: competence_profile_competence_profile_id_seq; Type: SEQUENCE SET; Schema: webapplication; Owner: fridlund
--

SELECT pg_catalog.setval('webapplication.competence_profile_competence_profile_id_seq', 1, false);


--
-- Name: hibernate_sequence; Type: SEQUENCE SET; Schema: webapplication; Owner: fridlund
--

SELECT pg_catalog.setval('webapplication.hibernate_sequence', 4, true);


--
-- Name: person_person_id_seq; Type: SEQUENCE SET; Schema: webapplication; Owner: fridlund
--

SELECT pg_catalog.setval('webapplication.person_person_id_seq', 1, true);


--
-- Name: role_role_id_seq; Type: SEQUENCE SET; Schema: webapplication; Owner: fridlund
--

SELECT pg_catalog.setval('webapplication.role_role_id_seq', 3, true);


--
-- Name: authority authority_pkey; Type: CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.authority
    ADD CONSTRAINT authority_pkey PRIMARY KEY (id);


--
-- Name: availability availability_pk; Type: CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.availability
    ADD CONSTRAINT availability_pk PRIMARY KEY (availability_id);


--
-- Name: competence competence_pk; Type: CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.competence
    ADD CONSTRAINT competence_pk PRIMARY KEY (competence_id);


--
-- Name: competence_profile competence_profile_pk; Type: CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.competence_profile
    ADD CONSTRAINT competence_profile_pk PRIMARY KEY (competence_profile_id);


--
-- Name: person person_pk; Type: CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.person
    ADD CONSTRAINT person_pk PRIMARY KEY (person_id);


--
-- Name: role role_pk; Type: CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.role
    ADD CONSTRAINT role_pk PRIMARY KEY (role_id);


--
-- Name: competence_name_uindex; Type: INDEX; Schema: webapplication; Owner: fridlund
--

CREATE UNIQUE INDEX competence_name_uindex ON webapplication.competence USING btree (name);


--
-- Name: person_email_uindex; Type: INDEX; Schema: webapplication; Owner: fridlund
--

CREATE UNIQUE INDEX person_email_uindex ON webapplication.person USING btree (email);


--
-- Name: person_username_uindex; Type: INDEX; Schema: webapplication; Owner: fridlund
--

CREATE UNIQUE INDEX person_username_uindex ON webapplication.person USING btree (username);


--
-- Name: role_name_uindex; Type: INDEX; Schema: webapplication; Owner: fridlund
--

CREATE UNIQUE INDEX role_name_uindex ON webapplication.role USING btree (name);


--
-- Name: availability availability_person_person_id_fk; Type: FK CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.availability
    ADD CONSTRAINT availability_person_person_id_fk FOREIGN KEY (person_id) REFERENCES webapplication.person(person_id) ON UPDATE CASCADE;


--
-- Name: competence_profile competence_profile_competence_competence_id_fk; Type: FK CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.competence_profile
    ADD CONSTRAINT competence_profile_competence_competence_id_fk FOREIGN KEY (competence_id) REFERENCES webapplication.competence(competence_id) ON UPDATE CASCADE;


--
-- Name: competence_profile competence_profile_person_person_id_fk; Type: FK CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.competence_profile
    ADD CONSTRAINT competence_profile_person_person_id_fk FOREIGN KEY (person_id) REFERENCES webapplication.person(person_id);


--
-- Name: person person___fk; Type: FK CONSTRAINT; Schema: webapplication; Owner: fridlund
--

ALTER TABLE ONLY webapplication.person
    ADD CONSTRAINT person___fk FOREIGN KEY (role_id) REFERENCES webapplication.role(role_id) ON UPDATE CASCADE;


--
-- PostgreSQL database dump complete
--

