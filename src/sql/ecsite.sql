set names utf8;
set foreign_key_checks=0;
drop database if exists ecsite;

create database if not exists ecsite;
use ecsite;

/* 商品カテゴリ */
create table item_categories_transaction(
category_id int not null primary key auto_increment,
category_name varchar(10) not null,
category_image varchar(50),
insert_date datetime,
update_date datetime
);

/* 商品情報 */
create table item_info_transaction(
item_id int not null primary key auto_increment,
item_name varchar(50),
category_id int,
item_price int,
category_name varchar(10),
item_image varchar(100),
item_stock int,
insert_date datetime,
update_date datetime,

foreign key(category_id)references item_categories_transaction(category_id)
);

/* ユーザー商品レビュー情報 */
create table item_comment_transaction(
comment_id int not null primary key auto_increment,
user_id int,
user_name varchar(50),
item_id int,
item_comment varchar(1000),
comment_date varchar(20),
insert_date datetime,
update_date datetime,

foreign key(user_id)references login_user_transaction(user_id),
foreign key(item_id)references item_info_transaction(item_id)
);

/* ユーザーカート情報 */
create table cart_list_transaction(
cart_id int not null primary key auto_increment,
item_id int,
user_id int,
item_count int,
insert_date datetime,
update_date datetime,

foreign key(item_id)references item_info_transaction(item_id),
foreign key(user_id)references login_user_transaction(user_id)
);

/* ユーザーアカウント */
create table login_user_transaction(
user_id int not null primary key auto_increment,
login_id varchar(16) unique,
login_pass varchar(16),
user_name varchar(50),
insert_date datetime,
updated_date datetime
);

/* ユーザー個人情報 */
create table user_information(
user_information_id int not null primary key auto_increment,
user_id int,
postcode varchar(15),
prefectures varchar(30),
street_address_a varchar(30),
street_address_b varchar(30),
street_address_c varchar(50),
insert_date datetime,
updated_date datetime,

foreign key(user_id)references login_user_transaction(user_id)
);

/* ユーザー購入情報 */
create table user_buy_item_transaction(
user_buy_item_id int not null primary key auto_increment,
user_id int,
total_price int,
pay int,
insert_date datetime,
delete_date datetime,

foreign key(user_id)references login_user_transaction(user_id)
);

/* ユーザー購入情報2(購入商品の詳細) */
create table user_buy_item_transaction2(
user_buy_item2_id int not null primary key auto_increment,
user_buy_item_id int,
user_id int,
item_id int,
item_name varchar(50),
item_count int,
item_price int,
insert_date datetime,
delete_date datetime,

foreign key(user_buy_item_id)references user_buy_item_transaction(user_buy_item_id),
foreign key(user_id)references user_information(user_id),
foreign key(item_id)references item_info_transaction(item_id)
);

/*商品分類*/
INSERT INTO item_categories_transaction(category_name, category_image) values
("時計", "./images/goods_icon2.jpg"),
("雑貨", "./images/goods_icon1.jpg"),
("家具", "./images/goods_icon3.jpg"),
("金具", "./images/goods_icon4.jpg"),
("証明", "./images/goods_icon5.jpg"),
("鏡", "./images/goods_icon6.jpg"),
("空き瓶", "./images/goods_icon7.jpg"),
("食器", "./images/goods_icon8.jpg"),
("ビジョン", "./images/goods_icon9.jpg");


/*商品情報*/
INSERT INTO item_info_transaction(item_id,item_name,category_id,item_price,category_name,item_image,item_stock) VALUES
(1,"2003GP 手巻き式懐中時計(スケルトン)",1, 100000,"時計", "./goodsImages/tokei/EposPocketWatch01.jpg",50),
(2,"トリプルカレンダームーンフェイズ", 1,300000, "時計","./goodsImages/tokei/MoonPhase01.jpg", 50),
(3,"Welbyチークウッド・リーフ＆メタル・サンバーストクロック",1,69800,"時計", "./goodsImages/tokei/SunBurstClock01.jpg", 50),
(4,"アンティークブック",2, 3800, "雑貨","./goodsImages/zakka/antiqueBook01.jpg",50),
(5,"アンティークブリキポット",2, 33000, "雑貨","./goodsImages/zakka/blikPod01.jpg", 50),
(6,"アンティークボビン･サンドタイマー",2, 2300,"雑貨","./goodsImages/zakka/sundTimer01.jpg", 50);

/*ユーザ情報*/
INSERT INTO login_user_transaction(login_id, login_pass, user_name) VALUES
("internous", "internous01", "test"),
("a", "1", "test");