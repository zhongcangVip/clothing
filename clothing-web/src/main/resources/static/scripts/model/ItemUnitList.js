var itemUnit={};

itemUnit.init=function(){
	$("#btnQuery").bind("click",function(){
		itemUnit.query();
	});
	$("#btnAdd").bind("click",function(){
		itemUnit.add();
	});
	itemUnit.initGrid();
};

itemUnit.initGrid=function(){
	var grid=$("#itemTable").datagrid({
		url:'/itemUnit/listData',
		pagination:true,
		pageSize:20,
		height:800,
		columns:[[
		{field:'id',width:0,checkbox:true},
		{field:'code',title:'单位编码',width:100},
		{field:'name',title:'单位名称',width:200},
		{field:'status',title:'状态',width:100,formatter:itemUnit.formatStatus},
		{field:'description',title:'描述',width:100},
		{field:'x',title:'操作',width:180,formatter:itemUnit.formatOperator},
    ]]
	});
}

itemUnit.query=function(){
	var name= $("#name").textbox("getValue");
	var code=$("#code").textbox('getValue');
	var status=$("#status").combobox('getValue');
	$("#itemTable").datagrid('reload',{
		name:name,
		code:code,
		status:status
	});
}

itemUnit.add=function(){
	var dialog=$("#info_win").dialog({
		href:"/itemUnit/toAddOrEdit",
		title:"添加单位",
		width:320,
		height:320,
		colsed:true,
		buttons:[{
			text:'保存',
			handler:function(){
				var code=$("#unitCode").textbox('getValue');
				if(!code){
					$.messager.alert('提示','单位编码不能为空!');
					return;
				}
				var name=$("#unitName").textbox("getValue");
				var description=$("#description").textbox("getValue");
				if(!name){
					$.messager.alert('提示','单位名称不能为空!');
					return;
				}				
				var id=$("#id").val();
				$.post("/itemUnit/submit",{id:id,code:code,name:name,description:description},function(data){
					if(data && data.status=='SUCCESS'){
						$.messager.alert('提示','单位添加成功!');
						$('#info_win').window('close');
					}else{
						$.messager.alert('提示','单位添加失败!');
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
itemUnit.edit=function(id){
	var dialog=$("#info_win").dialog({
		href:"/itemUnit/toAddOrEdit?id="+id,
		title:"修改单位信息",
		width:320,
		height:320,
		colsed:true,
		buttons:[{
			text:'保存',
			handler:function(){
				var code=$("#unitCode").textbox('getValue');
				if(!code){
					$.messager.alert('提示','单位编码不能为空!');
					return;
				}
				var name=$("#unitName").textbox("getValue");
				var description=$("#description").textbox("getValue");
				if(!name){
					$.messager.alert('提示','单位名称不能为空!');
					return;
				}				
				var id=$("#id").val();
				$.post("/itemUnit/submit",{id:id,code:code,name:name,description:description},function(data){
					if(data && data.status=='SUCCESS'){
						$.messager.alert('提示','单位修改成功!');
						itemUnit.query();
						$('#info_win').window('close');
					}else{
						$.messager.alert('提示','单位添加失败!');
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
itemUnit.view=function(id){
	var dialog=$("#info_win").dialog({
		href:"/itemUnit/toView?id="+id,
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
itemUnit.updateStatus=function(id){
	$.post("/itemUnit/updateStatus",{id:id},function(data){
		$.messager.alert('提示','状态修改成功!');
		itemUnit.query();
	});

}
itemUnit.formatStatus=function(val,row){
	if(val=='NORMAL'){
		return "正常";
	}else{
		return "禁用";
	}
}
itemUnit.formatOperator=function(val,row){
	var viewHtml="&nbsp;&nbsp;<a href='javascript:void(0);' onclick='itemUnit.view("+row.id+")'>详情</a> &nbsp;&nbsp;&nbsp;";
	var editHtml="&nbsp;<a href='javascript:void(0);' onclick='itemUnit.edit("+row.id+")'>修改</a> &nbsp;&nbsp;&nbsp;";
	var closeHtml="&nbsp;<a href='javascript:void(0);' onclick='itemUnit.updateStatus("+row.id+")'>禁用</a> &nbsp;&nbsp;&nbsp;";
	var openHtml="&nbsp;<a href='javascript:void(0);' onclick='itemUnit.updateStatus("+row.id+")'>启用</a> &nbsp;&nbsp;&nbsp;";
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