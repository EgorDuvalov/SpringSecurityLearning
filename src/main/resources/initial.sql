CREATE TABLE users
(
    id       SERIAL PRIMARY KEY NOT NULL,
    login    varchar(32)        NOT NULL,
    password varchar(255)       NOT NULL,
    email    varchar(64)        NOT NULL,
    role     varchar(16)        NOT NULL DEFAULT ('USER'),
    status   varchar(16)        NOT NULL DEFAULT ('ACTIVE')
);

INSERT INTO users(login, password, email, role, status)
VALUES ('Admin','$2y$12$S2yBurltEW5/2mLlMhwGQOuVXKuFjTP6ermIFlD.mmAQzt9Iw/hni','admin.admin@admin.com','ADMIN','ACTIVE'),
       ('User', '$2y$12$UIrl7Ag49gqIup55bsXc.uTUOFGpGjKn.LJm/sCGj727gV6KJgLj6','user.user@user.com','USER','BANNED');