<html>
	<head>
		<title>商品分类列表</title>
	</head>
	<body>
		<div>
			<div style="margin-bottom: 20px;margin-left: 40px;">
				
				<input class="easyui-textbox" data-options="prompt:'单位名称'" style="width:180px" id="searchName"></input>
				<input class="easyui-textbox" data-options="prompt:'单位编码'" style="width:180px" id="searchCode"></input>
				
				<select id="status" class="easyui-combobox" name="dept" style="width:200px;">
					<option value="">所有</option>
				    <option value="NORMAL">正常</option>
				    <option value="DELETE">禁用</option>
				</select>
				<a id="btnQuery" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-search'">查询</a>
				<a id="btnAdd" href="javascript:void(0);" class="easyui-linkbutton" data-options="iconCls:'icon-add'">新增</a>
			</div>
			<div>
				<table id="itemTable" >
				</table>
			</div>
		</div>
		<div id="info_win"></div>
		<script type="text/javascript" src="/scripts/model/ItemCategoryList.js?t=123"></script>
		<script type="text/javascript">			
			itemCategory.init();
		</script>
	</body>
</html>