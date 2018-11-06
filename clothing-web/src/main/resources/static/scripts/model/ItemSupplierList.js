var itemSupplier={};

itemSupplier.init=function(){
	$("#btnQuery").bind("click",function(){
		itemSupplier.query();
	});
	$("#btnAdd").bind("click",function(){
		itemSupplier.add();
	});
	itemSupplier.initGrid();
};

itemSupplier.initGrid=function(){
	var grid=$("#itemTable").datagrid({
		url:'/itemSupplier/listData',
		pagination:true,
		pageSize:20,
		height:800,
		columns:[[
		{field:'id',width:0,checkbox:true},
		{field:'code',title:'供应商编码',width:100},
		{field:'name',title:'供应商名称',width:200},
		{field:'contacts',title:'联系人',width:200},
		{field:'mobile',title:'联系方式',width:200},
		{field:'address',title:'地址',width:200},
		{field:'qq',title:'QQ',width:200},
		{field:'wx',title:'微信',width:200},
		{field:'status',title:'状态',width:100,formatter:itemSupplier.formatStatus},
		{field:'description',title:'描述',width:100},
		{field:'x',title:'操作',width:180,formatter:itemSupplier.formatOperator},
    ]]
	});
}

itemSupplier.query=function(){
	var name= $("#name").textbox("getValue");
	var code=$("#code").textbox('getValue');
	var status=$("#status").combobox('getValue');
	$("#itemTable").datagrid('reload',{
		name:name,
		code:code,
		status:status
	});
}

itemSupplier.add=function(id,title){
	if(!title){
		title="添加供应商";
	}
	if(!id){
		id=$("#id").val();
	}
	var dialog=$("#info_win").dialog({
		href:"/itemSupplier/toAddOrEdit?id="+id,
		title:title,
		width:320,
		height:380,
		colsed:true,
		buttons:[{
			text:'保存',
			handler:function(){
				var code=$("#supplierCode").textbox('getValue');
				if(!code){
					$.messager.alert('提示','商家编码不能为空!');
					return;
				}
				var name=$("#supplierName").textbox("getValue");
				var contacts=$("#contacts").textbox("getValue");
				var mobile=$("#mobile").textbox("getValue");
				var wx=$("#wx").textbox("getValue");
				var qq=$("#qq").textbox("getValue");
				var email=$("#email").textbox("getValue");
				var address=$("#address").textbox("getValue");
				if(!name){
					$.messager.alert('提示','商家名称不能为空!');
					return;
				}
								
				
				var json={};
				json.id=id;
				json.code=code;
				json.name=name;
				json.address=address;
				json.contacts=contacts;
				json.mobile=mobile;
				json.wx=wx;
				json.qq=qq;
				json.email=email;
				alert(1);
				$.post("/itemSupplier/submit",json,function(data){
					if(data && data.status=='SUCCESS'){
						$.messager.alert('提示','供应商提交成功!');
						$('#info_win').window('close');
					}else{
						$.messager.alert('提示','供应商添加失败!');
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
itemSupplier.edit=function(id){
	itemSupplier.add(id,"修改供应商信息");
}
itemSupplier.view=function(id){
	var dialog=$("#info_win").dialog({
		href:"/itemSupplier/toView?id="+id,
		title:"单位详情",
		width:320,
		height:320,
		colsed:true,
		buttons:[{
			text:'关闭',
			handler:function(){
				$('#info_win').window('close');
			}
		}]
	});
}
itemSupplier.updateStatus=function(id){
	$.post("/itemSupplier/updateStatus",{id:id},function(data){
		$.messager.alert('提示','状态修改成功!');
		itemSupplier.query();
	});

}
itemSupplier.formatStatus=function(val,row){
	if(val=='NORMAL'){
		return "正常";
	}else{
		return "禁用";
	}
}
itemSupplier.formatOperator=function(val,row){
	var viewHtml="&nbsp;&nbsp;<a href='javascript:void(0);' onclick='itemSupplier.view("+row.id+")'>详情</a> &nbsp;&nbsp;&nbsp;";
	var editHtml="&nbsp;<a href='javascript:void(0);' onclick='itemSupplier.edit("+row.id+")'>修改</a> &nbsp;&nbsp;&nbsp;";
	var closeHtml="&nbsp;<a href='javascript:void(0);' onclick='itemSupplier.updateStatus("+row.id+")'>禁用</a> &nbsp;&nbsp;&nbsp;";
	var openHtml="&nbsp;<a href='javascript:void(0);' onclick='itemSupplier.updateStatus("+row.id+")'>启用</a> &nbsp;&nbsp;&nbsp;";
	var html="";
	html+=viewHtml ;
	html+=editHtml;
	if(row.status=='NORMAL'){
		html+=closeHtml;
	}else{
		html+=openHtml;
	}
	return html;
}