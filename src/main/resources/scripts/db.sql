CREATE TABLE users (
    email      VARCHAR(100),
    password   VARCHAR(300)
);

CREATE TABLE projects (
    project_id   INT,
    email        VARCHAR(100),
    title        VARCHAR(100)
);

CREATE TABLE caracteristics (
    project_id            INT,
    caracteristic_type    VARCHAR(200),
    caracteristic_value   VARCHAR(500)
);

ALTER TABLE users ADD CONSTRAINT pk_users PRIMARY KEY ( email );

ALTER TABLE projects ADD CONSTRAINT pk_projects PRIMARY KEY ( project_id );

ALTER TABLE caracteristics ADD CONSTRAINT pk_caracteristics PRIMARY KEY ( project_id,caracteristic_type );

ALTER TABLE projects ADD CONSTRAINT fk_projects_users FOREIGN KEY ( email )
    REFERENCES users ( email );

ALTER TABLE caracteristics ADD CONSTRAINT fk_caracteristics_projects FOREIGN KEY ( project_id )
    REFERENCES projects ( project_id );