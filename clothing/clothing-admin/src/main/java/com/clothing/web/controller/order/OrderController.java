package com.clothing.web.controller.order;

public class OrderController {

	/**
	 * 商品采购--》生成商品采购单
	 * purchase --》purchaseDetail
	 * 如果只有一个店铺，则可以直接库存去到此店铺
	 * 如果有多个店铺，则可以先保存入库单 ，生成入库单 来到具体的店铺
	 * 
	 * 商品销售则每一笔都要生成销售单。并且财务那边需要流水
	 * 销售 sale 
	 * 销售单据
	 * 
	 * 库存  inventory 
	 * 库存流水 inventory_flow 
	 * 库存盘点 inventory_make
	 * 调拨 inventory_allocation
	 * 入库 stock_in
	 * 出库 stock_out
	 * 
	 * 
	 * 报表
	 * 
	 * 条码的生成与打印
	 * 
	 * 
	 * 
	 */
}
