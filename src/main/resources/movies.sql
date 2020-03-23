CREATE DATABASE bootcamp;
CREATE TABLE if not exists movies (
id VARCHAR(255) PRIMARY KEY,
title VARCHAR(255) NOT NULL,
rating SMALLINT NOT NULL,
plot VARCHAR(255),
link VARCHAR(255)
);
INSERT INTO movies
VALUES ('fba0ae8e-6b0a-4bb4-8155-6cd84fb58542', 'Inception', 10, 'A thief who steals corporate secrets through the use of dream-sharing technology is given the inverse task of planting an idea into the mind of a C.E.O.', 'https://www.imdb.com/title/tt1375666/?ref_=fn_al_tt_1');
INSERT INTO movies
VALUES ('77c7e1c6-f4c2-4bd4-aeab-466a4815916b', 'Matrix', 10, 'A computer hacker learns from mysterious rebels about the true nature of his reality and his role in the war against its controllers.', 'https://www.imdb.com/title/tt0133093/?ref_=fn_al_tt_1');
INSERT INTO movies
VALUES ('18d53d37-64c0-4c58-a047-03e2d3a46a62', 'Crazy, Stupid, Love', 8, 'A middle-aged husband''s life changes dramatically when his wife asks him for a divorce. He seeks to rediscover his manhood with the help of a newfound friend, Jacob, learning to pick up girls at bars.', 'https://www.imdb.com/title/tt1570728/');
INSERT INTO movies
VALUES ('5223df98-8991-40ec-bbc9-8741af473735', 'Fight Club', 9, 'An insomniac office worker and a devil-may-care soapmaker form an underground fight club that evolves into something much, much more.', 'https://www.imdb.com/title/tt0137523/?ref_=fn_al_tt_1');
INSERT INTO movies
VALUES ('e51ddca2-3f12-4722-8d51-abfd804da6b3', 'The Butterfly Effect', 8, 'Evan Treborn suffers blackouts during significant events of his life. As he grows up, he finds a way to remember these lost memories and a supernatural way to alter his life by reading his journal.', 'https://www.imdb.com/title/tt0289879/?ref_=fn_al_tt_1');