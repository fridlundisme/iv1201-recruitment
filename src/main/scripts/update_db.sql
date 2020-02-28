UPDATE availability
SET from_date= '1900-01-01'
WHERE from_date IS NULL;

UPDATE availability
SET to_date = '1900-01-01'
WHERE to_date IS NULL

UPDATE competence 
SET name = ('MISSING INFO')
WHERE (name) IS NULL;

UPDATE competence_profile
SET years_of_experience = -1
WHERE years_of_experience IS NULL;

UPDATE person
SET email = 'MISSING INFO'
WHERE email IS NULL;

UPDATE person
SET name = 'MISSING INFO'
WHERE name IS NULL;

UPDATE person
SET password = 'MISSING INFO'
WHERE password IS NULL;

UPDATE person
SET ssn = 'MISSING INFO'
WHERE ssn IS NULL;

UPDATE person
SET surname = 'MISSING INFO'
WHERE surname IS NULL;

UPDATE person
SET username = 'MISSING INFO'
WHERE username IS NULL;

UPDATE role
SET name = 'MISSING INFO'
WHERE name IS NULL;
