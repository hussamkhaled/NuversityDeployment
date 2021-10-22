-- To drop a user, you need firstly to either
-- drop all artefacts owned by the user
-- revoke all privleges for user from artefacts

-- to drop everything owned by a user:
DROP OWNED BY DIGUSR;

-- to revoke ownership:
REVOKE ALL PRIVILEGES ON ALL TABLES IN SCHEMA DIGID FROM DIGUSR;

-- now you can drop the user
DROP USER IF EXISTS DIGUSR;
CREATE USER DIGUSR WITH PASSWORD 'DIGUSR';
CREATE SCHEMA IF NOT EXISTS DIGID AUTHORIZATION DIGUSR;
