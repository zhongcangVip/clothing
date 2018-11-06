<html>
	<head>
		<title>商品列表</title>
	</head>
	<body>
		<div> 
			<div style="margin-bottom: 20px;margin-left: 40px;">
				
				<input class="easyui-textbox" data-options="prompt:'商品名称'" style="width:180px" id="itemName"></input>
				<input class="easyui-textbox" data-options="prompt:'商品条码'" style="width:180px" id="barCode"></input>
				<input class="easyui-textbox" data-options="prompt:'助记码'" style="width:180px" id="helpCode"></input>
				<a id="btnQuery" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
				<a id="btnAdd" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-new'">新增</a>

			</div>
			<div>
				<table id="itemTable" >
				</table>
			</div>
		</div>
		<div id="info_win"></div>
		<script type="text/javascript" src="/scripts/model/ItemList.js?T=1136677331"></script>
		<script type="text/javascript">
			item.init();
		</script>
	</body>
</html>