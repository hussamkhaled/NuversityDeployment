-- To drop a user, you need firstly to either
-- drop all artefacts owned by the user
-- revoke all privleges for user from artefacts

-- to drop everything owned by a user:
DROP OWNED BY LMSUSR;

-- to revoke ownership:
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA LMS FROM LMSUSR;

-- now you can drop the user
DROP USER IF EXISTS LMSUSR;
CREATE USER LMSUSR WITH PASSWORD 'LMSUSR';
CREATE SCHEMA IF NOT EXISTS LMS AUTHORIZATION LMSUSR;
