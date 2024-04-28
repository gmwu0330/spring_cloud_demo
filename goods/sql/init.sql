CREATE TABLE t_goods
(
id bigint unsigned NOT NULL COMMENT '流水號' PRIMARY KEY,
goods_no VARCHAR(32) NOT NULL COMMENT '商品編號',
goods_name VARCHAR(64) NOT NULl COMMENT '商品名稱',
create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '創建時間',
create_by VARCHAR(32) NOT NULL COMMENT '創建者',
update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間',
update_by VARCHAR(32) NOT NULL COMMENT '更新者',
)COMMENT '商品';


CREATE TABLE t_order
(
id bigint unsigned NOT NULL COMMENT '流水號' PRIMARY KEY,
order_no VARCHAR(32) NOT NULL COMMENT '訂單編號',
create_date DATETIME DEFAULT CURRENT_TIMESTAMP NOT NULL COMMENT '創建時間',
create_by VARCHAR(32) NOT NULL COMMENT '創建者',
update_date DATETIME DEFAULT CURRENT_TIMESTAMP ON UPDATE CURRENT_TIMESTAMP COMMENT '更新時間'
update_by VARCHAR(32) NOT NULL COMMENT '更新者',
)COMMENT '訂單';