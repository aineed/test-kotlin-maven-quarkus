CREATE TABLE ad
(
    ad_id SERIAL PRIMARY KEY,
    title VARCHAR NOT NULL,
    category_name VARCHAR references category(name),
    profile_id INTEGER references profile(profile_id)
);