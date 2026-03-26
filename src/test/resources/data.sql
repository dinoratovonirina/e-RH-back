INSERT INTO users (
    id,
    email,
    first_name,
    is_active,
    last_name,
    password,
    departement_id,
    role_id
) VALUES (
    1,
    'rakoto@yahoo.fr',
    'rakoto',
    true,
    'koto',
    '123456',
    1,
    2
),
(
    2,
    'rakotovao@yahoo.fr',
    'rakotonoro',
    true,
    'noro',
    '123456',
    2,
    1
);


INSERT INTO roles (id, role_name) VALUES
	 (1, 'ADMIN'),
	 (2, 'MANAGER'),
	 (3, 'EMPLOYEE');


INSERT INTO public.departements (id, departement_name) VALUES
	 (1, 'INFORMATIQUE'),
	 (2, 'AUDITE'),
	 (3, 'FORMATION ET DOCUMENTATION');
