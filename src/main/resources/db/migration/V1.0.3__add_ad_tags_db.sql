CREATE TABLE adtags
(
    ad_id INTEGER references ad(ad_id),
    tag_name VARCHAR references tag(name),

    PRIMARY KEY(ad_id, tag_name)
);