var item={};

item.init=function(){
	$("#btnQuery").bind("click",function(){
		item.query();
	});
	$("#btnAdd").bind("click",function(){
		item.add();
	});
	item.initGrid();
	
};

item.initGrid=function(){
	$("#itemTable").datagrid({
		url:'/item/listData',
		pagination:true,
		pageSize:20,
		height:800,
		columns:[[
		{field:'id',width:0,checkBox:true},
		{field:'code',title:'商品编码',width:100},
		{field:'name',title:'商品名称',width:200},
		{field:'shortName',title:'简称',width:100},
		{field:'barCode',title:'条码',width:100},
		{field:'helpCode',title:'助记码',width:100},
		{field:'category',title:'商品类别',width:100},
		{field:'unit',title:'单位',width:100},
		{field:'supplier',title:'品牌供应商',width:150},
		{field:'buyingPrice',title:'进货价',width:100},
		{field:'retailPrice',title:'零售价',width:100}
    ]]
	});
}
item.query=function(){
	var name= $("#itemName").textbox("getValue");
	var barCode=$("#barCode").textbox('getValue');
	var helpCode=$("#helpCode").textbox('getValue');
	$("#itemTable").datagrid('reload',{
		name:name,
		barCode:barCode,
		helpCode:helpCode
	});
}



item.add=function(id,title){
	if(!id){
		id=$("#id").val();
	}
	if(!title){
		title="添加商品"
	}
	var dialog=$("#info_win").dialog({
		href:"/item/addOrEdit",
		title:title,
		width:920,
		height:420,
		colsed:true,
		buttons:[{
			text:'保存',
			handler:function(){
				var itemCode=$("#itemCode").textbox('getValue');
				if(!itemCode){
					$.messager.alert('提示','商品货号不能为空!');
					return;
				}
				var name=$("#itemName").textbox("getValue");
				var color=$("#itemColor").combobox("getValue");
				var size=$("#itemSize").combobox("getValue");
				var helpCode=$("#itemHelpCode").textbox("getValue");
				var material=$("#itemMaterial").textbox("getValue");
				var category=$("#itemCategory").textbox("getValue");
				var unit=$("#itemUnit").textbox("getValue");
				var supplier=$("#itemSupplier").textbox("getValue");
				var retailPrice=$("#itemRetailPrice").numberbox("getValue");
				var buyingPrice=$("#itemBuyingPrice").numberbox("getValue");
				var vipPrice=$("#itemVipPrice").numberbox("getValue");
				var minPrice=$("#itemMinPrice").numberbox("getValue");
				var disCount=$("#disCount").val();
				var integral=$("#integral").val();
				if(!name){
					$.messager.alert("提示","商品名称不能为空!");
					return;
				}
				if(!buyingPrice){
					
				}
				var description=$("#description").textbox("getValue");			
				var json={};
				json.id=id;
				json.code=itemCode;
				json.name=name;
				json.color=color;
				json.size=size;
				json.helpCode=helpCode;
				json.material=material;
				json.category=category;
				json.unit=unit;
				json.supplier=supplier;
				json.retailPrice=retailPrice;
				json.buyingPrice=buyingPrice;
				json.vipPrice=vipPrice;
				json.minPrice=minPrice;
				json.disCount=disCount;
				json.integral=integral;
				$.post("/item/submit",json,function(data){
					if(data && data.status=='SUCCESS'){
						$.messager.alert('提示','商品添加成功!');
						$('#info_win').window('close');
					}else{
						$.messager.alert('提示','商品添加失败!');
					}
				});
			}
		},{
			text:'取消',
			handler:function(){
				$('#info_win').window('close');
			}
		}]
	});
}

