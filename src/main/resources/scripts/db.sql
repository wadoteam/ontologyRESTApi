CREATE TABLE users (
    email      VARCHAR2(100),
    password   VARCHAR2(300)
);

CREATE TABLE projects (
    project_id   NUMBER,
    email        VARCHAR2(100),
    title        VARCHAR2(100)
);

CREATE TABLE caracteristics (
    project_id            NUMBER,
    caracteristic_type    VARCHAR2(200),
    caracteristic_value   VARCHAR2(500)
);

ALTER TABLE users ADD CONSTRAINT pk_users PRIMARY KEY ( email );

ALTER TABLE projects ADD CONSTRAINT pk_projects PRIMARY KEY ( project_id );

ALTER TABLE caracteristics ADD CONSTRAINT pk_caracteristics PRIMARY KEY ( project_id,caracteristic_type );

ALTER TABLE projects ADD CONSTRAINT fk_projects_users FOREIGN KEY ( email )
    REFERENCES users ( email );

ALTER TABLE caracteristics ADD CONSTRAINT fk_caracteristics_projects FOREIGN KEY ( project_id )
    REFERENCES projects ( project_id );