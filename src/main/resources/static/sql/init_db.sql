DROP TABLE IF EXISTS cocktails CASCADE;
DROP TABLE IF EXISTS ingredients CASCADE;
DROP TABLE IF EXISTS tags CASCADE;
DROP TABLE IF EXISTS ricepts CASCADE;
DROP TABLE IF EXISTS cocktail_tag CASCADE;

create table cocktails
(
--     id        serial  not null primary key,
--     alcohol   integer not null,
--     comment   varchar(255),
--     name      varchar(255),
--     photo_url varchar(255)
    id integer NOT NULL,
    alcohol integer NOT NULL,
    comment character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    photo_url character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT cocktails_pkey PRIMARY KEY (id)
);

create table ingredients
(
--     id          serial  not null primary key,
--     name        varchar(255),
--     unit        varchar(255),
--     value       integer not null,
--     cocktail_id integer,
--     FOREIGN key (cocktail_id) references cocktails (id)
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    unit character varying(255) COLLATE pg_catalog."default",
    value integer NOT NULL,
    cocktail_id integer,
    CONSTRAINT ingredients_pkey PRIMARY KEY (id),
    CONSTRAINT ingredients_cocktail_id_fkey FOREIGN KEY (cocktail_id)
        REFERENCES public.cocktails (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

create table ricepts
(
--     id           serial not null primary key,
--     description  varchar(255),
--     order_ricept integer,
--     cocktail_id  integer,
--     FOREIGN key (cocktail_id) references cocktails (id)
    id integer NOT NULL,
    description character varying(255) COLLATE pg_catalog."default",
    order_ricept integer,
    cocktail_id integer,
    CONSTRAINT ricepts_pkey PRIMARY KEY (id),
    CONSTRAINT ricepts_cocktail_id_fkey FOREIGN KEY (cocktail_id)
        REFERENCES public.cocktails (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);

create table tags
(
--     id   serial not null primary key,
--     name varchar(255)
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT tags_pkey PRIMARY KEY (id)
);

create table cocktail_tag
(
--     cocktails_id int,
--     tags_id      int,
--     foreign key (cocktails_id) references cocktails (id),
--     foreign key (tags_id) references tags (id),
--     primary key (cocktails_id, tags_id)
    cocktails_id integer NOT NULL,
    tags_id integer NOT NULL,
    CONSTRAINT cocktail_tag_pkey PRIMARY KEY (cocktails_id, tags_id),
    CONSTRAINT cocktail_tag_cocktails_id_fkey FOREIGN KEY (cocktails_id)
        REFERENCES public.cocktails (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT cocktail_tag_tags_id_fkey FOREIGN KEY (tags_id)
        REFERENCES public.tags (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
);


insert into cocktails (alcohol, comment, name, photo_url)
VALUES (40, 'good', 'Marry', 'phoroUrl1');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (50, 'bad', 'Garry', 'phoroUrl2');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (60, 'nice', 'Tommy', 'phoroUrl3');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (80, 'cool', 'Jhonny', 'phoroUrl4');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (40, 'good', 'Marry1', 'phoroUrl1');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (50, 'bad', 'Garry1', 'phoroUrl2');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (60, 'nice', 'Tommy1', 'phoroUrl3');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (80, 'cool', 'Jhonny1', 'phoroUrl4');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (40, 'good', 'Marry2', 'phoroUrl1');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (50, 'bad', 'Garry2', 'phoroUrl2');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (60, 'nice', 'Tommy2', 'phoroUrl3');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (80, 'cool', 'Jhonny2', 'phoroUrl4');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (40, 'good', 'Marry3', 'phoroUrl1');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (50, 'bad', 'Garry3', 'phoroUrl2');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (60, 'nice', 'Tommy3', 'phoroUrl3');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (80, 'cool', 'Jhonny3', 'phoroUrl4');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (40, 'good', 'Marry4', 'phoroUrl1');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (50, 'bad', 'Garry4', 'phoroUrl2');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (60, 'nice', 'Tommy4', 'phoroUrl3');
insert into cocktails (alcohol, comment, name, photo_url)
VALUES (80, 'cool', 'Jhonny4', 'phoroUrl4');



insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 1);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 2);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 3);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 3);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 4);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 4);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 5);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 5);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 6);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 6);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 7);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 7);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 8);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 8);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 9);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 9);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 10);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 10);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 11);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 11);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 12);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 12);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 13);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 14);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 15);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 16);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 17);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 18);
insert into ingredients (name, unit, value, cocktail_id)
values ('malina', 'ml', 20, 19);
insert into ingredients (name, unit, value, cocktail_id)
values ('banana', 'ml', 40, 20);

insert into tags (name)
values ('nice1');
insert into tags (name)
values ('nice2');
insert into tags (name)
values ('nice3');
insert into tags (name)
values ('nice4');
insert into tags (name)
values ('nice5');

insert into cocktail_tag (cocktails_id, tags_id)
values (1, 2);
insert into cocktail_tag (cocktails_id, tags_id)
values (2, 1);
insert into cocktail_tag (cocktails_id, tags_id)
values (3, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (4, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (5, 2);
insert into cocktail_tag (cocktails_id, tags_id)
values (5, 1);
insert into cocktail_tag (cocktails_id, tags_id)
values (7, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (7, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (6, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (6, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (8, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (8 ,3);

insert into cocktail_tag (cocktails_id, tags_id)
values (9, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (9, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (10, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (10, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (11, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (11, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (12, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (12, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (13, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (13, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (14, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (14, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (15, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (15, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (16, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (16, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (17, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (17, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (18, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (18, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (19, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (19, 3);

insert into cocktail_tag (cocktails_id, tags_id)
values (20, 4);
insert into cocktail_tag (cocktails_id, tags_id)
values (20, 3);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Pour', 1, 1);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Shake up', 2, 1);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 3, 1);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 4, 1);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Pour', 2, 2);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Shake up', 1, 2);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 4, 2);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 3, 2);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Pour', 4, 3);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Shake up', 3, 3);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 3);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 3);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Pour', 4, 4);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Shake up', 3, 4);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 4);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 4);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Pour', 4, 5);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Shake up', 3, 5);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 5);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 5);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Pour', 4, 6);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Shake up', 3, 6);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 6);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 6);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Pour', 4, 7);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Shake up', 3, 7);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 7);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 7);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Pour', 4, 8);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Shake up', 3, 8);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 8);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 8);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Pour', 4, 9);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Shake up', 3, 9);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 9);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 9);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 10);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 10);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 11);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 11);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 12);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 12);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 13);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 13);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 14);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 14);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 15);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 15);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 16);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 16);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 17);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 17);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 18);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 18);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 19);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 19);

insert into ricepts (description, order_ricept, cocktail_id)
values ('Hinder', 2, 20);
insert into ricepts (description, order_ricept, cocktail_id)
values ('Add cherry', 1, 20);
