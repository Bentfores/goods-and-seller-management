\c

create user "bentfores-goods-and-seller-management" with password 'bentfores-goods-and-seller-management';

create database "bentfores-goods-and-seller-management" with owner = postgres;

grant all privileges on database "bentfores-goods-and-seller-management" to "bentfores-goods-and-seller-management";

\c "bentfores-goods-and-seller-management"

alter role "bentfores-goods-and-seller-management" set search_path = bentfores_goods_and_seller_management, public;

create schema bentfores_goods_and_seller_management authorization "bentfores-goods-and-seller-management";
