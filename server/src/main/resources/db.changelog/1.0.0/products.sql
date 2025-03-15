--liquibase formatted sql

--changeset yuliezai
create table products
(
    product_id   uuid         not null
        constraint pk_products primary key,
    article      varchar(50)  not null,
    image_url    varchar(255) not null,
    product_name varchar(255) not null,
    status       varchar(50)  not null
        constraint ch_products_status check (status in ('NOT_PROCESSED', 'PROCESSED', 'IGNORED')),
    created_at   timestamp    not null default now(),
    updated_at   timestamp    not null
);

comment on table products is 'Таблица товаров со статусами';
comment on column products.product_id is 'Уникальный идентификатор товара';
comment on column products.article is 'Артикул товара во внешней системе';
comment on column products.image_url is 'Ссылка на изображение товара';
comment on column products.product_name is 'Наименование товара';
comment on column products.status is 'Статус товара';
comment on column products.created_at is 'Дата и время создания записи';
comment on column products.updated_at is 'Дата и время обновления записи';

--changeset yuliezai runInTransaction:false
create index concurrently if not exists idx_products_status on products (status);