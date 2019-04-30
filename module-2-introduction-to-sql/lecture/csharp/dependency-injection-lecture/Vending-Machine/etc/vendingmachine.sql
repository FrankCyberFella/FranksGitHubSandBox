create table inventory
(
	slot_id char(2) not null,
	product_name varchar(150) not null,
	cost decimal(10,2) not null,
	product_type varchar(20) not null,
		
	primary key (slot_id)
);

create table transaction_log
(
	transaction_id 	int 			identity(1,1),
	tx_type			varchar(20)		not null,
	message			varchar(150)		null,
	initial_balance	money	not null,
	ending_balance 	money 	not null,
	timestamp		datetime 		not null,
	
	primary key (transaction_id)
);

insert into inventory values
('A1','Doritos',0.75, 'Chip'),
('A2','Kettel Chips',0.75, 'Chip'),
('A3','Pringles',0.60, 'Chip'),
('A4','Ruffles',0.85, 'Chip'),
('A5','Sun Chips',0.85, 'Chip'),
('B1','Crunch Bar',1.25, 'Candy'),
('B2','Kitkat',1.50, 'Candy'),
('B3','Milky Way',0.65, 'Candy'),
('B4','Snickers',1.10, 'Candy'),
('B5','Twix',1.10, 'Candy'),
('C1','Pepsi',1.20, 'Pop'),
('C2','Diet Pepsi',0.90, 'Pop'),
('C3','Mountain Dew',0.95, 'Pop'),
('C4','Diet Mountain Dew',1.00, 'Pop'),
('D1','Double Mint',0.75, 'Gum'),
('D2','Big Red',0.75, 'Gum');