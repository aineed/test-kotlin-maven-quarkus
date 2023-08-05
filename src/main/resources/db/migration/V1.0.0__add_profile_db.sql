CREATE TABLE profile
(
    profile_id SERIAL PRIMARY KEY,
    username VARCHAR UNIQUE NOT NULL,
    firstname VARCHAR NOT NULL,
    lastname VARCHAR NOT NULL,
    email VARCHAR NOT NULL,
    phone_number VARCHAR(10) NOT NULL,
    user_type VARCHAR NOT NULL,
    description VARCHAR NOT NULL,
    skills VARCHAR NOT NULL
);