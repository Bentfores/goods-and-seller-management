--liquibase formatted sql

--changeset yuliezai
create table suppliers
(
    supplier_id   uuid         not null
        constraint pk_suppliers primary key,
    supplier_url  varchar(255) not null,
    supplier_name varchar(255) not null,
    status        varchar(50)  not null default 'NOT_COOPERATING'
        constraint ch_suppliers_status check (status in
                                              ('COOPERATING', 'NOT_COOPERATING', 'BLACKLISTED', 'MESSAGE_SENT')),
    created_at    timestamp    not null default now(),
    updated_at    timestamp    not null
);

comment on table suppliers is 'Таблица товаров со статусами';
comment on column suppliers.supplier_id is 'Уникальный идентификатор товара';
comment on column suppliers.supplier_url is 'Ссылка на изображение товара';
comment on column suppliers.supplier_name is 'Наименование товара';
comment on column suppliers.status is 'Статус товара';
comment on column suppliers.created_at is 'Дата и время создания записи';
comment on column suppliers.updated_at is 'Дата и время обновления записи';

--changeset yuliezai runInTransaction:false
create index concurrently if not exists idx_suppliers_status on suppliers (status);