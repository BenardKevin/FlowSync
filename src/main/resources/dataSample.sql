-- Table: public.category

-- DROP TABLE IF EXISTS public.category;

CREATE TABLE IF NOT EXISTS public.category
(
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT category_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.category
    OWNER to postgres;

INSERT INTO public.category (id, name)
VALUES
    (1, 'Fruit'),
    (2, 'Légume');


-- Table: public.product

-- DROP TABLE IF EXISTS public.product;

CREATE TABLE IF NOT EXISTS public.product
(
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default",
    price real,
    category_id integer,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT fk1mtsbur82frn64de7balymq9s FOREIGN KEY (category_id)
        REFERENCES public.category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product
    OWNER to postgres;

INSERT INTO public.product (id, name, price, category_id)
VALUES
    (1, 'Pomme', 2.49, 1),
    (2, 'Poire', 1.31, 1),
    (3, 'Banane', 0.99, 1),
    (4, 'Asperge', 2.86, 2),
    (5, 'Aubergine', 4.21, 2),
    (6, 'Carotte', 1.08, 2),
    (7, 'Abricot', 3.86, 1),
    (8, 'Cassis', 3.33, 1),
    (9, 'Fraise', 1.19, 1),
    (10, 'Melon', 4.60, 1),
    (11, 'Brocoli', 3.19, 2),
    (12, 'Concombre', 2.18, 2);


-- Table: public.contact

-- DROP TABLE IF EXISTS public.contact;

CREATE TABLE IF NOT EXISTS public.contact
(
    id integer NOT NULL,
    address character varying(255) COLLATE pg_catalog."default",
    email character varying(255) COLLATE pg_catalog."default",
    first_name character varying(255) COLLATE pg_catalog."default",
    name character varying(255) COLLATE pg_catalog."default",
    CONSTRAINT contact_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contact
    OWNER to postgres;

INSERT INTO public.contact (id, address, email, firstname, name)
VALUES
    (1, '560 Avenue Janvier Passero, 06210 Mandelieu-la-Napoule', 'je.roussy@gmail.com', 'Jeremy', 'Roussy'),
    (2, '298c Chemin des fontaites, 06620 Le Bar-sur-Loup', 'contact.marika.maggioli@gmail.com', 'Marika', 'Maggioli'),
    (3, '75 Route de Saint-Jean, 06130 Grasse', 'kevin.benard00@gmail.com', 'Kévin', 'Bénard');