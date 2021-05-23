/* drop table if exists database_setting; */

create table if not exists database_setting (
   id bigint auto_increment primary key,
   type varchar(1000),
   host varchar(1000),
   username varchar(1000),
   password varchar(1000),
   created_at date,
   updated_at date
);
