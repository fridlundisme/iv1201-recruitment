create sequence "public"."availability_availability_id_seq";

create sequence "public"."competence_competence_id_seq";

create sequence "public"."competence_profile_competence_profile_id_seq";

create sequence "public"."hibernate_sequence";

create sequence "public"."person_person_id_seq";

create sequence "public"."role_role_id_seq";

alter table "public"."availability" drop constraint "availability_person_id_fkey";

alter table "public"."competence_profile" drop constraint "competence_profile_competence_id_fkey";

alter table "public"."competence_profile" drop constraint "competence_profile_person_id_fkey";

alter table "public"."person" drop constraint "person_role_id_fkey";

alter table "public"."availability" drop constraint "availability_pkey";

alter table "public"."competence" drop constraint "competence_pkey";

alter table "public"."competence_profile" drop constraint "competence_profile_pkey";

alter table "public"."person" drop constraint "person_pkey";

alter table "public"."role" drop constraint "role_pkey";

drop index if exists "public"."availability_pkey";

drop index if exists "public"."competence_pkey";

drop index if exists "public"."competence_profile_pkey";

drop index if exists "public"."person_pkey";

drop index if exists "public"."role_pkey";


alter table "public"."availability" alter column "availability_id" set default nextval('availability_availability_id_seq'::regclass);

alter table "public"."availability" alter column "availability_id" set data type integer using "availability_id"::integer;

alter table "public"."availability" alter column "from_date" set not null;

alter table "public"."availability" alter column "person_id" set data type integer using "person_id"::integer;

alter table "public"."availability" alter column "to_date" set not null;

alter table "public"."competence" alter column "competence_id" set default nextval('competence_competence_id_seq'::regclass);

alter table "public"."competence" alter column "competence_id" set data type integer using "competence_id"::integer;

alter table "public"."competence" alter column "name" set not null;

alter table "public"."competence" alter column "name" set data type character varying using "name"::character varying;

alter table "public"."competence_profile" alter column "competence_id" set not null;

alter table "public"."competence_profile" alter column "competence_id" set data type integer using "competence_id"::integer;

alter table "public"."competence_profile" alter column "competence_profile_id" set default nextval('competence_profile_competence_profile_id_seq'::regclass);

alter table "public"."competence_profile" alter column "competence_profile_id" set data type integer using "competence_profile_id"::integer;

alter table "public"."competence_profile" alter column "person_id" set not null;

alter table "public"."competence_profile" alter column "person_id" set data type integer using "person_id"::integer;

alter table "public"."competence_profile" alter column "years_of_experience" set not null;

alter table "public"."competence_profile" alter column "years_of_experience" set data type integer using "years_of_experience"::integer;

alter table "public"."person" alter column "email" set not null;

alter table "public"."person" alter column "email" set data type character varying using "email"::character varying;

alter table "public"."person" alter column "name" set not null;

alter table "public"."person" alter column "name" set data type character varying using "name"::character varying;

alter table "public"."person" alter column "password" set not null;

alter table "public"."person" alter column "password" set data type character varying using "password"::character varying;

alter table "public"."person" alter column "person_id" set default nextval('person_person_id_seq'::regclass);

alter table "public"."person" alter column "person_id" set data type integer using "person_id"::integer;

alter table "public"."person" alter column "role_id" set not null;

alter table "public"."person" alter column "role_id" set data type integer using "role_id"::integer;

alter table "public"."person" alter column "ssn" set not null;

alter table "public"."person" alter column "ssn" set data type character varying using "ssn"::character varying;

alter table "public"."person" alter column "surname" set not null;

alter table "public"."person" alter column "surname" set data type character varying using "surname"::character varying;

alter table "public"."person" alter column "username" set not null;

alter table "public"."person" alter column "username" set data type character varying using "username"::character varying;

alter table "public"."role" alter column "name" set not null;

alter table "public"."role" alter column "name" set data type character varying using "name"::character varying;

alter table "public"."role" alter column "role_id" set default nextval('role_role_id_seq'::regclass);

alter table "public"."role" alter column "role_id" set data type integer using "role_id"::integer;

CREATE UNIQUE INDEX availability_pk ON public.availability USING btree (availability_id);

CREATE UNIQUE INDEX competence_name_uindex ON public.competence USING btree (name);

CREATE UNIQUE INDEX competence_pk ON public.competence USING btree (competence_id);

CREATE UNIQUE INDEX competence_profile_pk ON public.competence_profile USING btree (competence_profile_id);

CREATE UNIQUE INDEX person_email_uindex ON public.person USING btree (email);

CREATE UNIQUE INDEX person_pk ON public.person USING btree (person_id);

CREATE UNIQUE INDEX person_username_uindex ON public.person USING btree (username);

CREATE UNIQUE INDEX role_name_uindex ON public.role USING btree (name);

CREATE UNIQUE INDEX role_pk ON public.role USING btree (role_id);

alter table "public"."availability" add constraint "availability_pk" PRIMARY KEY using index "availability_pk";

alter table "public"."competence" add constraint "competence_pk" PRIMARY KEY using index "competence_pk";

alter table "public"."competence_profile" add constraint "competence_profile_pk" PRIMARY KEY using index "competence_profile_pk";

alter table "public"."person" add constraint "person_pk" PRIMARY KEY using index "person_pk";

alter table "public"."role" add constraint "role_pk" PRIMARY KEY using index "role_pk";

alter table "public"."availability" add constraint "availability_person_person_id_fk" FOREIGN KEY (person_id) REFERENCES person(person_id) ON UPDATE CASCADE;

alter table "public"."competence_profile" add constraint "competence_profile_competence_competence_id_fk" FOREIGN KEY (competence_id) REFERENCES competence(competence_id) ON UPDATE CASCADE;

alter table "public"."competence_profile" add constraint "competence_profile_person_person_id_fk" FOREIGN KEY (person_id) REFERENCES person(person_id);

alter table "public"."person" add constraint "person___fk" FOREIGN KEY (role_id) REFERENCES role(role_id) ON UPDATE CASCADE;


