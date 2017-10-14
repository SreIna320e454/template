drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

drop table if exists login_user_transaction;

create table login_user_transaction(
id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

drop table if exists item_info_transaction;

create table item_info_transaction(
id int not null primary key auto_increment,
item_category varchar(50),
item_name varchar(50),
item_price int,
item_image varchar(255),
item_stock int,
insert_date datetime,
update_date datetime
);

drop table if exists user_buy_item_transaction;

create table user_buy_item_transaction(
id int not null primary key auto_increment,
item_transaction_id int,
total_price int,
total_count int,
user_master_id varchar(16),
pay varchar(30),
insert_date datetime,
delete_date datetime
);

/*商品情報 時計*/
INSERT INTO item_info_transaction(item_category, item_name, item_price, item_image, item_stock)
VALUES("時計","2003GP 手巻き式懐中時計(スケルトン)", 100000, "../goodsImages/clock/EposPocketWatch01.jpg",50);
INSERT INTO item_info_transaction(item_category, item_name, item_price, item_image, item_stock)
VALUES("時計","トリプルカレンダームーンフェイズ", 300000, "../goodsImages/clock/MoonPhase01.jpg", 50);
INSERT INTO item_info_transaction(item_category, item_name, item_price, item_image, item_stock)
VALUES("時計","Welbyチークウッド・リーフ＆メタル・サンバーストクロック",69800, "../goodsImages/clock/SunBurstClock01.jpg", 50);
/*商品情報 雑貨*/
INSERT INTO item_info_transaction(item_category, item_name, item_price, item_image, item_stock)
VALUES("雑貨","アンティークブック", 3800, "../goodsImages/zakka/antiqueBook01.jpg",50);
INSERT INTO item_info_transaction(item_category, item_name, item_price, item_image, item_stock)
VALUES("雑貨","アンティークブリキポット", 33000, "../goodsImages/zakka/blikPod01.jpg", 50);
INSERT INTO item_info_transaction(item_category, item_name, item_price, item_image, item_stock)
VALUES("雑貨","アンティークボビン･サンドタイマー", 2300,"../goodsImages/zakka/sundTimer01.jpg", 50);
/*ユーザ情報*/
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("internous", "internous01", "test");
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES("a", "1", "test");