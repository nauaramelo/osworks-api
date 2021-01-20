create table service_order (
	id bigint not null auto_increment,
	client_id bigint not null,
	description text not null,
	price decimal (10,2) not null,
	open_date datetime not null,
	end_date datetime,

	primary key (id)

); 

alter TABLE service_order add CONSTRAINT fk_service_order_client
FOREIGN KEY (client_id) REFERENCES client (id);