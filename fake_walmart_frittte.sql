
--Creating customer table 
create table customer (
   username varchar (25) primary key,
   "password" varchar (32) not null,
   fname varchar (20) not null,
   lname varchar (20) not null,
   dob varchar (15) not null,   
   employee bit ,
   admin bit
  
);

--Creating Credit Card table

create table credit_card (
 cc_number varchar (16) primary key,
 cc_name varchar (20) not null,
 ccv int not null,
 exp_date varchar (15) not null,
 limit_l numeric not null,
 customer_username varchar (25)

)

--Creating a foreign key relationship between customer table and credit card table 

alter table credit_card 
add constraint  fk_username_cc 
foreign key(customer_username) references customer(username)
on delete cascade

--Creating a foreign key relationship between customer table and order table 
alter table order_o
add constraint fk_username_or
foreign key (customer_username) references customer (username)
on delete cascade

create table order_o (

 id INT IDENTITY (1,1) primary key,
 order_date varchar (15) not null,
 item_name varchar (50) not null,
 customer_username varchar (25),
 comment_t text

);

create table food (

 id INT IDENTITY(1,1),
 item_name varchar (50) primary Key,
 cost_t numeric not null,
 weight numeric not null,
 volume numeric not null,
 frozen bit
 
 );

alter table order_o
add constraint fk_item_name
foreign key (item_name) references food (item_name)
on delete cascade

create table chat (

 id INT IDENTITY(1,1),
 chat_username varchar (25) primary key,
 title varchar (25) not null,
 date_t varchar (15) not null,
 people varchar (50) not null
 
 );

alter table chat
add constraint fk_username_chat
foreign key (chat_username) references customer (username)
on delete cascade



create table message (

 id INT IDENTITY(1,1) primary key,
 sender varchar (25) not null,
 text_t varchar (255) not null,
 created_date varchar (15) not null,
 );

alter table message
add constraint fk_sender
foreign key (sender) references chat (chat_username)
on delete cascade

