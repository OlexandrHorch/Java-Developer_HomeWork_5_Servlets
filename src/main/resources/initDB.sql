-- Home work 1.1
-- Creating tables and links between them

CREATE DATABASE it_relationship;
USE it_relationship;


-- table companies
CREATE TABLE companies	(id INT(10) AUTO_INCREMENT,
						name VARCHAR(50) NOT NULL,
                        address VARCHAR(150) NOT NULL,
						PRIMARY KEY (id));


-- table customers
CREATE TABLE customers	(id INT(10) AUTO_INCREMENT,
						name VARCHAR(50) NOT NULL,
                        address VARCHAR(150) NOT NULL,
						PRIMARY KEY (id));


-- table developers
CREATE TABLE developers	(id INT(10) AUTO_INCREMENT,
						first_name VARCHAR(20) NOT NULL,
                        age INT(3) NOT NULL,
                        id_company INT(10) NOT NULL,
                        PRIMARY KEY (id),
                        FOREIGN KEY (id_company) REFERENCES companies (id));


-- table skills
CREATE TABLE skills		(id INT(10) AUTO_INCREMENT,
						area VARCHAR(15) NOT NULL,
                        level VARCHAR(10) NOT NULL,
                        PRIMARY KEY (id));


-- table projects
CREATE TABLE projects	(id INT(10) AUTO_INCREMENT,
						name VARCHAR(20) NOT NULL,
                        id_company INT(10) NOT NULL,
                        id_customer INT(10) NOT NULL,
						PRIMARY KEY (id),
                        FOREIGN KEY (id_company) REFERENCES companies (id),
                        FOREIGN KEY (id_customer) REFERENCES customers (id));


-- table developers and skills
CREATE TABLE developers_skills
						(id INT(10) AUTO_INCREMENT,
                        id_developer INT(10) NOT NULL,
                        id_skill INT(10) NOT NULL,
						PRIMARY KEY (id),
                        FOREIGN KEY (id_developer) REFERENCES developers (id),
                        FOREIGN KEY (id_skill) REFERENCES skills (id));


-- table developers and projects
CREATE TABLE developers_projects
						(id INT(10) AUTO_INCREMENT,
                        id_developer INT(10) NOT NULL,
                        id_project INT(10) NOT NULL,
						PRIMARY KEY (id),
                        FOREIGN KEY (id_developer) REFERENCES developers (id),
                        FOREIGN KEY (id_project) REFERENCES projects (id));