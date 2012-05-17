create table master_merchant(
master_merchant_id bigint not null,
master_merchant_name character varying(300),
master_merchant_shop_name character varying(200),
master_merchant_address text,
master_merchant_tax_no character varying(200),
master_merchant_office_phone_no character varying(100),
master_merchant_office_fax character varying(100),
master_merchant_pic_name character varying(200),
master_merchant_pic_phone_no character varying(100),
master_merchant_additional_info text,
constraint pk_master_merchant_id primary key(master_merchant_id));

create table bank_account_master_merchant(
bank_account_id bigint not null,
account_name character varying(200),
account_no character varying(200),
account_bank_name character varying(300),
account_bank_branch character varying(300),
master_merchant_id bigint not null,
constraint pk_bank_account_id primary key(bank_account_id),
constraint fk_ba_master_merchant_id foreign key(master_merchant_id) references
master_merchant(master_merchant_id));

create table merchant(
merchant_id bigint not null,
merchant_name character varying(300),
merchant_shop_name character varying(200),
merchant_address text,
merchant_tax_no character varying(200),
merchant_office_phone_no character varying(100),
merchant_office_fax character varying(100),
merchant_pic_name character varying(200),
merchant_pic_phone_no character varying(100),
merchant_additional_info text,
constraint pk_merchant_id primary key(merchant_id));


create table merchant_connector(
merchant_connector_id bigint not null,
master_merchant_id bigint not null,
merchant_id bigint not null,
connector_status boolean,
connector_expiry_date date,
pk_merchant_connector_id primary key(merchant_connector_id),
fk_mc_master_merchant_id foreign key(master_merchant_id) references master_merchant(master_merchant_id),
fk_mc_merchant_id foreign key(merchant_id) references merchant(merchant_id));


create table payment_channel(
payment_channel_id bigint not null,
payment_channel_name character varying(100),
payment_channel_status boolean,
payment_channel_jndi_proc text,
payment_channel_pg_code character varying(100),
payment_channel_pg_additional_code_1 character varying(100),
payment_channel_pg_additional_code_2 character varying(100),
payment_channel_pg_additional_code_3 character varying(100),
payment_channel_redirect_url_1 text,
payment_channel_redirect_url_2 text,
payment_channel_redirect_url_3 text,
constraint pk_payment_channel_id primary key(payment_channel_id));


create table payment_method(
payment_method_id bigint not null,

