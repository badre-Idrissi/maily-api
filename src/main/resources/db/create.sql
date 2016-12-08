-- Table: t_user

ALTER TABLE if exists t_mail DROP CONSTraint if exists  t_mail_user_id_fkey;
DROP TABLE if exists t_mail_user;
DROP TABLE if exists t_user;
DROP TABLE if exists t_mail;


CREATE TABLE t_user
(
    id serial primary key,
    login varchar(255) NOT NULL,
    first_name varchar(255) NOT NULL,
    last_name varchar(255) NOT NULL,
    password varchar(255) NOT NULL
    
);

CREATE TABLE t_mail
(
    id serial primary key,
    subject varchar(255) NOT NULL,
    body text NOT NULL,
    user_id int NOT NULL,
    FOREIGN KEY (user_id) REFERENCES t_user(id)

);

CREATE TABLE t_mail_user
(
    receivers_id int,
    t_mail_id int,
    
	CONSTRAINT pk_MAIL_USER PRIMARY KEY (t_mail_id,receivers_id)
);