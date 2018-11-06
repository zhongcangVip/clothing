var itemCategory={};

itemCategory.init=function(){
	$("#btnQuery").bind("click",function(){
		itemCategory.query();
	});
	$("#btnAdd").bind("click",function(){
		itemCategory.add();
	});
	itemCategory.initGrid();
};

itemCategory.initGrid=function(){
	var grid=$("#itemTable").datagrid({
		url:'/itemCategory/listData',
		pagination:true,
		pageSize:20,
		height:800,
		columns:[[
		{field:'id',width:0,checkbox:true},
		{field:'code',title:'分类编码',width:100},
		{field:'name',title:'分类名称',width:200},		
		{field:'status',title:'状态',width:100,formatter:itemCategory.formatStatus},
		{field:'x',title:'操作',width:180,formatter:itemCategory.formatOperator},
    ]]
	});
}

itemCategory.query=function(){
	var name= $("#searchName").textbox("getValue");
	var code=$("#searchCode").textbox('getValue');
	var status=$("#status").combobox('getValue');
	$("#itemTable").datagrid('reload',{
		name:name,
		code:code,
		status:status
	});
}

itemCategory.add=function(id,title){
	if(!title){
		title="添加商品类别";
	}
	if(!id){
		id=$("#id").val();
	}
	var dialog=$("#info_win").dialog({
		href:"/itemCategory/toAddOrUpdate?id="+id,
		title:title,
		width:320,
		height:380,
		colsed:true,
		buttons:[{
			text:'保存',
			handler:function(){
				var code=$("#categoryCode").textbox('getValue');
				if(!code){
					$.messager.alert('提示','分类编码不能为空!');
					return;
				}
				var name=$("#categoryName").textbox("getValue");
				if(!name){
					$.messager.alert('提示','分类名称不能为空!');
					return;
				}
				var json={};
				json.id=id;
				json.code=code;
				json.name=name;
				$.post("/itemCategory/submit",json,function(data){
					if(data && data.status=='SUCCESS'){
						$.messager.alert('提示','分类提交成功!');
						itemCategory.query();
						$('#info_win').window('close');
					}else{
						$.messager.alert('提示','分类添加失败!');
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
itemCategory.edit=function(id){
	itemCategory.add(id,"修改商品分类信息");
}
itemCategory.view=function(id){
	var dialog=$("#info_win").dialog({
		href:"/itemCategory/toView?id="+id,
		title:"分类详情",
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
itemCategory.updateStatus=function(id){
	$.post("/itemCategory/updateStatus",{id:id},function(data){
		$.messager.alert('提示','状态修改成功!');
		itemCategory.query();
	});

}
itemCategory.formatStatus=function(val,row){
	if(val=='NORMAL'){
		return "正常";
	}else{
		return "禁用";
	}
}
itemCategory.formatOperator=function(val,row){
	var viewHtml="&nbsp;&nbsp;<a href='javascript:void(0);' onclick='itemCategory.view("+row.id+")'>详情</a> &nbsp;&nbsp;&nbsp;";
	var editHtml="&nbsp;<a href='javascript:void(0);' onclick='itemCategory.edit("+row.id+")'>修改</a> &nbsp;&nbsp;&nbsp;";
	var closeHtml="&nbsp;<a href='javascript:void(0);' onclick='itemCategory.updateStatus("+row.id+")'>禁用</a> &nbsp;&nbsp;&nbsp;";
	var openHtml="&nbsp;<a href='javascript:void(0);' onclick='itemCategory.updateStatus("+row.id+")'>启用</a> &nbsp;&nbsp;&nbsp;";
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