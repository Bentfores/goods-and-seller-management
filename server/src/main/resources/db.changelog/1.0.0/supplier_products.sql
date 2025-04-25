--liquibase formatted sql

--changeset yuliezai:1
create table supplier_products
(
    id          uuid primary key,
    supplier_id uuid references suppliers (supplier_id),
    product_id  uuid references products (product_id)
);

comment on table supplier_products is 'Таблица для связи поставщиков и товаров';
comment on column supplier_products.product_id is 'Уникальный идентификатор товара';
comment on column supplier_products.supplier_id is 'Уникальный идентификатор поставщика';
