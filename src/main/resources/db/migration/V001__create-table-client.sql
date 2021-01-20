create table client(
	id BIGINT not null AUTO_INCREMENT,
    name VARCHAR(60) not null,
    email VARCHAR(255) not null,
    phone VARCHAR(20) not null,
    
    PRIMARY KEY(id)
);