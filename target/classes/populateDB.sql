-- Home work 1.1
-- Filling in tables with data

USE it_relationship;

INSERT INTO companies (name, address) VALUES
	('ABC', 'Kiev'),
	('S-cod', 'Lviv');

INSERT INTO customers (name, address) VALUES
	('Car trader', 'Kiev'),
	('Best food', 'Chernigiv');

INSERT INTO developers (first_name, age, id_company) VALUES
	('Sergiy', 25, 1),
	('Ivan', 35, 1),
	('Sergiy', 40, 1),
	('Andriy', 31, 2),
	('Iruna', 28, 2),
	('Masha', 27, 2);

INSERT INTO skills (area, level) VALUES
	('Java', 'junior'),
	('Java', 'middle'),
	('Java', 'senior'),
	('C++', 'junior'),
	('C++', 'middle'),
	('C++', 'senior'),
	('C#', 'junior'),
	('C#', 'middle'),
	('C#', 'senior'),
	('JS', 'junior'),
	('JS', 'middle'),
	('JS', 'senior');

INSERT INTO projects (name, id_company, id_customer) VALUES
	('Clients', 2, 1),
	('Store', 2, 1),
	('Sales', 1, 2),
	('Warehouse', 1, 2);

INSERT INTO developers_skills (id_developer, id_skill) VALUES
	(1, 1),
	(2, 3),
	(2, 4),
	(2, 11),
	(3, 2),
	(3, 4),
	(4, 5),
	(4, 8),
	(5, 3),
	(5, 6),
	(5, 10),
	(6, 11);

INSERT INTO developers_projects (id_developer, id_project) VALUES
	(4, 1),
	(5, 1),
	(6, 1),
	(4, 2),
	(6, 2),
	(1, 3),
	(2, 3),
	(3, 3),
	(2, 4),
	(3, 4);