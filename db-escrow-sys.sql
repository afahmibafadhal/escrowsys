create table master_merchant(
master_merchant_id bigint not null,
general_account_id bigint not null,
master_merchant_name character varying(300),
master_merchant_shop_name character varying(200),
master_merchant_address text,
master_merchant_tax_no character varying(200),
master_merchant_office_phone_no character varying(100),
master_merchant_office_fax character varying(100),
master_merchant_pic_name character varying(200),
master_merchant_pic_phone_no character varying(100),
master_merchant_additional_info text,
constraint pk_master_merchant_id primary key(master_merchant_id),
constraint fk_mm_general_account_id foreign key(general_account_id) references general_account(general_account_id)
);

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
general_account_id bigint not null,
merchant_name character varying(300),
merchant_shop_name character varying(200),
merchant_address text,
merchant_tax_no character varying(200),
merchant_office_phone_no character varying(100),
merchant_office_fax character varying(100),
merchant_pic_name character varying(200),
merchant_pic_phone_no character varying(100),
merchant_additional_info text,
constraint pk_merchant_id primary key(merchant_id),
constraint fk_merchant_general_account_id foreign key(general_account_id) references general_account(general_account_id)
);


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


create table payment_formula(
payment_formula_id int not null,
payment_channel_id bigint not null,
formula_status boolean,
formula_start_date date,
formula_end_date date,
payment_mdr_fee numeric(6,2),
payment_debit_fee numeric(10,2),
payment_escrow_fee numeric(10,2),--service fee
payment_payment_gateway_fee numeric(6,2),
payment_fraud_detection_fee numeric(6,2),
payment_additional_fee_1 numeric(6,2),
payment_additional_fee_2 numeric(6,2),
payment_additional_fee_3 numeric(6,2),
fee_charge_to character(1) default 'M',--M for master merchant H for merchant and C for Customer
constraint pk_payment_formula_id primary key (payment_formula_id),
constraint fk_pf_payment_channel_id foreign key(payment_channel_id) references payment_channel(payment_channel_id));

create table master_merchant_formula(
master_merchant_formula_id bigint not null,
merchant_connector_id bigint not null,
payment_formula_id int not null,
formula_percentage_type character(1),--M for master merchant, H for Merchant
merchant_share_percentage numeric(6,2) default 0.00,
master_merchant_share_percentage numeric(6,2) default 0.00,
master_merchant_formula_status boolean,
master_merchant_formula_start_date date,
master_merchant_formula_end_date date,
constraint pk_master_merchant_formula_id primary key(master_merchant_formula_id),
constraint fk_mmf_merchant_connector_id foreign key(merchant_connector_id) references merchant_connector(merchant_connector_id),
constraint fk_mmf_payment_formula_id foreign key(payment_formula_id) references payment_formula(payment_formula_id));

create table transactions(
transactions_id bigint not null,
transactions_state character(1),
transactions_status character(1),
transactions_time timestamp,
transactions_done_time timestamp,
master_merchant_formula_id bigint,
transactions_amount numeric(12,2),
user_account_or_cardnumber character varying(100),
credit_card_no character varying(20),
card_holder_name character varying(100),
card_holder_email character varying(100),
card_holder_city character varying(100),
card_holder_region character varying(100),
card_holder_country character varying(100),
card_holder_phone_no character varying(100),
card_holder_postal_code character varying(100),
transactions_vat_amount numeric(12,2),
transactions_nett_goods numeric(12,2),
transactions_nett_margins numeric(12,2),
transactions_amount_1 numeric(12,2),
transactions_amount_2 numeric(12,2),
transactions_amount_3 numeric(12,2),
batch_id bigint not null,
constraint pk_trx_transactions_id primary key(transactions_id),
constraint fk_trx_master_merchant_formula_id foreign key(master_merchant_formula_id) references master_merchant_formula(master_merchant_formula_id),
constraint fk_trx_batch_id foreign key(batch_id) references batch(batch_id)
);

create table batch(
batch_id bigint not null,
batch_count int not null default 0,
batch_total_amount numeric(20,2) default 0.00,
batch_status character(1) default 'O',
batch_open_date timestamp,
batch_close_date timestamp,
general_account_id bigint not null,
constraint pk_batch_id primary key(batch_id),
constraint fk_batch_general_account_id foreign key(general_account_id) references general_account(general_account_id));



create table general_account(
general_account_id bigint not null,
general_account_type character(1),
general_transaction_type character(1),
general_total_credit numeric(20,2),
general_total_debit numeric(20,2),
general_total_balance numeric(20,2),
constraint pk_general_account_id primary key(general_account_id));


create table transactions_share_data(
transactions_share_data_id bigint not null,
transactions_id bigint not null,
general_account_id bigint not null,
share_type character(1),
share_remark text,
share_amount numeric(20,2) default 0.00,
constraint pk_transactions_share_data_id primary key(transactions_share_data_id),
constraint fk_tsd_transactions_id foreign key(transactions_id) references transactions(transactions_id),
constraint fk_tsd_general_account_id foreign key(general_account_id) references general_account(general_account_id));



create table master_merchant_users(
merchant_users_id int not null,
merchant_users_name character varying(200),
merchant_users_login_id character varying(200),
merchant_users_password character varying(300),
merchant_users_password_1 character varying(300),
merchant_users_password_2 character varying(300),
merchant_users_password_3 character varying(300),
master_merchant_id bigint not null,
constraint pk_merchant_users_id primary key(merchant_users_id),
constraint fk_mmu_merchant_id foreign key(master_merchant_id) references master_merchant(master_merchant_id)
);

create table master_merchant_menu(
menu_id int not null,
menu_name character varying(100),
menu_description text,
menu_url text,
menu_icon text,
menu_root_id int,
constraint pk_master_merchant_menu_id primary key(menu_id),
constraint fk_mm_menu_root_id foreign key(menu_root_id) references master_merchant_menu(menu_id));

create table admin_menu(
menu_id int not null,
menu_name character varying(100),
menu_description text,
menu_url text,
menu_icon text,
menu_root_id int,
constraint pk_admin_menu_id primary key(menu_id),
constraint fk_am_menu_root_id foreign key(menu_root_id) references admin_menu(menu_id));

create table admin_role(
role_id int not null,
role_name character varying(100),
role_description text,
constraint pk_admin_role_id primary key(role_id));

create table admin_role_menu_link(
link_id int not null,
role_id int not null,
menu_id int not null,
constraint 


create table merchant_role(
role_id int not null,
role_name character varying(100),
role_description text,
constraint pk_merchant_role_id primary key(role_id));




create table admin_users(
admin_users_id int not null,
admin_users_name character varying(200),
admin_users_login_id character varying(200),
admin_users_password character varying(300),
admin_users_password_1 character varying(300),
admin_users_password_2 character varying(300),
admin_users_password_3 character varying(300),
admin_user_type int not null,
constraint pk_admin_users_id primary key(admin_users_id));




CREATE SEQUENCE seq_master_merchant_users_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;



CREATE SEQUENCE seq_master_merchant_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE seq_bank_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE seq_merchant_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE seq_merchant_connector_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


CREATE SEQUENCE seq_payment_channel_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;


CREATE SEQUENCE seq_payment_formula_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE seq_transactions_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE seq_batch_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE seq_general_account_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;

CREATE SEQUENCE seq_transactions_share_data_id
  INCREMENT 1
  MINVALUE 1
  MAXVALUE 9223372036854775807
  START 1
  CACHE 1;



