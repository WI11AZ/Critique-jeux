CREATE TABLE User (
                         id INT PRIMARY KEY,
                         username VARCHAR(100),
                         email VARCHAR(100),
                         password VARCHAR(100)
);
CREATE TABLE Game (
                      id INT PRIMARY KEY,
                      name VARCHAR(100),
                      image VARCHAR(255),
);
CREATE TABLE Comment (
                         id INT PRIMARY KEY,
                         gameId INT,
                         content VARCHAR(255),
                         rating INT,
                         author VARCHAR(255),
                         FOREIGN KEY (gameId) REFERENCES Game(id),
                         FOREIGN KEY (author) REFERENCES User(username)
);
