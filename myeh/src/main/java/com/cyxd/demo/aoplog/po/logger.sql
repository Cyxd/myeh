CREATE TABLE `logger` (
  `id` int(11) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `operate` varchar(255) DEFAULT NULL COMMENT '操作',
  `operate_type` varchar(64) DEFAULT NULL COMMENT '操作类型',
  `operator` varchar(64) DEFAULT NULL COMMENT '操作人',
  `operate_date` varchar(19) DEFAULT NULL COMMENT '操作日期',
  `operate_ip_addr` varchar(64) DEFAULT NULL COMMENT '操作终端IP',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;