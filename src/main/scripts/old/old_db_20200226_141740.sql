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

SET default_tablespace = '';

SET default_table_access_method = heap;

--
-- Name: availability; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.availability (
    availability_id bigint NOT NULL,
    person_id bigint,
    from_date date,
    to_date date
);


ALTER TABLE public.availability OWNER TO postgres;

--
-- Name: competence; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.competence (
    competence_id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.competence OWNER TO postgres;

--
-- Name: competence_profile; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.competence_profile (
    competence_profile_id bigint NOT NULL,
    person_id bigint,
    competence_id bigint,
    years_of_experience numeric(4,2)
);


ALTER TABLE public.competence_profile OWNER TO postgres;

--
-- Name: person; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.person (
    person_id bigint NOT NULL,
    name character varying(255),
    surname character varying(255),
    ssn character varying(255),
    email character varying(255),
    password character varying(255),
    role_id bigint,
    username character varying(255)
);


ALTER TABLE public.person OWNER TO postgres;

--
-- Name: role; Type: TABLE; Schema: public; Owner: postgres
--

CREATE TABLE public.role (
    role_id bigint NOT NULL,
    name character varying(255)
);


ALTER TABLE public.role OWNER TO postgres;

--
-- Data for Name: availability; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.availability VALUES (1, 2, '2014-02-23', '2014-05-25');
INSERT INTO public.availability VALUES (2, 2, '2014-07-10', '2014-08-10');


--
-- Data for Name: competence; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.competence VALUES (1, 'Korvgrillning');
INSERT INTO public.competence VALUES (2, 'Karuselldrift');


--
-- Data for Name: competence_profile; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.competence_profile VALUES (1, 2, 1, 3.50);
INSERT INTO public.competence_profile VALUES (2, 2, 2, 2.00);


--
-- Data for Name: person; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.person VALUES (1, 'Greta', 'Borg', NULL, NULL, 'wl9nk23a', 1, 'borg');
INSERT INTO public.person VALUES (2, 'Per', 'Strand', '19671212-1211', 'per@strand.kth.se', NULL, 2, NULL);


--
-- Data for Name: role; Type: TABLE DATA; Schema: public; Owner: postgres
--

INSERT INTO public.role VALUES (1, 'recruit');
INSERT INTO public.role VALUES (2, 'applicant');


--
-- Name: availability availability_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.availability
    ADD CONSTRAINT availability_pkey PRIMARY KEY (availability_id);


--
-- Name: competence competence_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competence
    ADD CONSTRAINT competence_pkey PRIMARY KEY (competence_id);


--
-- Name: competence_profile competence_profile_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competence_profile
    ADD CONSTRAINT competence_profile_pkey PRIMARY KEY (competence_profile_id);


--
-- Name: person person_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_pkey PRIMARY KEY (person_id);


--
-- Name: role role_pkey; Type: CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.role
    ADD CONSTRAINT role_pkey PRIMARY KEY (role_id);


--
-- Name: availability availability_person_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.availability
    ADD CONSTRAINT availability_person_id_fkey FOREIGN KEY (person_id) REFERENCES public.person(person_id);


--
-- Name: competence_profile competence_profile_competence_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competence_profile
    ADD CONSTRAINT competence_profile_competence_id_fkey FOREIGN KEY (competence_id) REFERENCES public.competence(competence_id);


--
-- Name: competence_profile competence_profile_person_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.competence_profile
    ADD CONSTRAINT competence_profile_person_id_fkey FOREIGN KEY (person_id) REFERENCES public.person(person_id);


--
-- Name: person person_role_id_fkey; Type: FK CONSTRAINT; Schema: public; Owner: postgres
--

ALTER TABLE ONLY public.person
    ADD CONSTRAINT person_role_id_fkey FOREIGN KEY (role_id) REFERENCES public.role(role_id);


--
-- PostgreSQL database dump complete
--

