-- To drop a user, you need firstly to either
-- drop all artefacts owned by the user
-- revoke all privleges for user from artefacts

-- to drop everything owned by a user:
DROP OWNED BY UMSUSR;

-- to revoke ownership:
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA UMS FROM UMSUSR;

-- now you can drop the user
DROP USER IF EXISTS UMSUSR;
CREATE USER UMSUSR WITH PASSWORD 'UMSUSR';
CREATE SCHEMA IF NOT EXISTS UMS AUTHORIZATION UMSUSR;
