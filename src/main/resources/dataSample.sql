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

-- Table: public.address

-- DROP TABLE IF EXISTS public.address;

CREATE TABLE IF NOT EXISTS public.address
(
    id integer NOT NULL,
    city character varying(255) COLLATE pg_catalog."default" NOT NULL,
    country character varying(255) COLLATE pg_catalog."default" NOT NULL,
    zip_code integer,
    street_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    street_number integer NOT NULL,
    CONSTRAINT address_pkey PRIMARY KEY (id)
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.address
    OWNER to postgres;

INSERT INTO public.address (id, city, country, zip_code, street_name, street_number)
VALUES
    (1, 'Antibes', 'France', '06600', 'Route de Grasse', '1770'),
    (2, 'Mandelieu-la-Napoule', 'France', '06210', 'Rn', '7'),
    (3, 'Cannes la Bocca', 'France', '06150', 'Avenue Francis Tonner', '130'),
    (4, 'Mandelieu-la-Napoule', 'France', '06210', 'Avenue Janvier Passero', '560'),
    (5, 'Le Bar-sur-Loup', 'France', '06620', 'Chemin des fontaites', '298' ),
    (6, 'Grasse', 'France', '06130', 'Route de Saint-Jean', '75');

-- Table: public.supplier

-- DROP TABLE IF EXISTS public.supplier;

CREATE TABLE IF NOT EXISTS public.supplier
(
    id integer NOT NULL,
    company_name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    address_id integer,
    CONSTRAINT supplier_pkey PRIMARY KEY (id),
    CONSTRAINT uk78419iap4p0q918rhlcr1phkl UNIQUE (address_id),
    CONSTRAINT fk95a8oipih48obtbhltjy7hgvb FOREIGN KEY (address_id)
        REFERENCES public.address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.supplier
    OWNER to postgres;

INSERT INTO public.supplier (id, company_name, address_id)
VALUES
    (1, 'Carrefour', 1),
    (2, 'Auchamps', 2),
    (3, 'Intermarché', 3);

-- Table: public.product

-- DROP TABLE IF EXISTS public.product;

CREATE TABLE IF NOT EXISTS public.product
(
    id integer NOT NULL,
    name character varying(255) COLLATE pg_catalog."default" NOT NULL,
    price real NOT NULL,
    vat real NOT NULL,
    category_id integer,
    supplier_id integer,
    CONSTRAINT product_pkey PRIMARY KEY (id),
    CONSTRAINT fk1mtsbur82frn64de7balymq9s FOREIGN KEY (category_id)
        REFERENCES public.category (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION,
    CONSTRAINT fk2kxvbr72tmtscjvyp9yqb12by FOREIGN KEY (supplier_id)
        REFERENCES public.supplier (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.product
    OWNER to postgres;

INSERT INTO public.product (id, name, price, vat, category_id, supplier_id)
VALUES
    (1, 'Pomme', 2.49, 10, 1, 1),
    (2, 'Poire', 1.31, 10, 1, 2),
    (3, 'Banane', 0.99, 10, 1, 3),
    (4, 'Asperge', 2.86, 10, 2, 3),
    (5, 'Aubergine', 4.21, 10, 2, 1),
    (6, 'Carotte', 1.08, 10, 2, 2),
    (7, 'Abricot', 3.86, 10, 1, 1),
    (8, 'Cassis', 3.33, 10, 1, 3),
    (9, 'Fraise', 1.19, 10, 1, 2),
    (10, 'Melon', 4.60, 10, 1, 2),
    (11, 'Brocoli', 3.19, 10, 2, 2),
    (12, 'Concombre', 2.18, 10, 2, 1);


-- Table: public.contact

-- DROP TABLE IF EXISTS public.contact;

CREATE TABLE IF NOT EXISTS public.contact
(
    id integer NOT NULL,
    email character varying(255) COLLATE pg_catalog."default",
    firstname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    lastname character varying(255) COLLATE pg_catalog."default" NOT NULL,
    phone_number character varying(255) COLLATE pg_catalog."default",
    address_id integer,
    CONSTRAINT contact_pkey PRIMARY KEY (id),
    CONSTRAINT ukhdhcc7238a2lwr4yjw78qvlof UNIQUE (address_id),
    CONSTRAINT fkl0sju2uai8cgdtic18wy5hlfr FOREIGN KEY (address_id)
        REFERENCES public.address (id) MATCH SIMPLE
        ON UPDATE NO ACTION
        ON DELETE NO ACTION
)

TABLESPACE pg_default;

ALTER TABLE IF EXISTS public.contact
    OWNER to postgres;

INSERT INTO public.contact (id, email, firstname, lastname, phone_number, address_id)
VALUES
    (1, 'je.roussy@gmail.com', 'Jeremy', 'Roussy', '0771252779', 4),
    (2, 'contact.marika.maggioli@gmail.com', 'Marika', 'Maggioli', '0661963960', 5),
    (3, 'kevin.benard00@gmail.com', 'Kévin', 'Bénard', '0623964064', 6);