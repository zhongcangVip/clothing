<html>
	<head>
		<title>商品单位列表</title>
		<style type="text/css">
			ul li{
				margin-left: -30px;margin-bottom: 10px;
			}
		</style>
	</head>
	<body>
		<div>
			<ul style="list-style: none;">
				<li><input id="categoryCode" key='edit' class="easyui-textbox" label='编码:'  style="width:100%;" <#if category??>disabled="disabled" value="${category.code!''}</#if>">	</li>
				<li><input id="categoryName" key='edit' class="easyui-textbox" label='名称:'  style="width:100%;"  value="<#if category??>${category.name!''}</#if>">	</li>
			</ul>
		</div>
		<input type="hidden" name="id" value="<#if category??>${category.id!''}</#if>">
		<script type="text/javascript">
			var openModel="${openModel!''}";
			$(document).ready(function(){
				$("input[key='edit']").each(function(){
					if(openModel=='view'){
						$(this).attr("disabled","disabled");
					}
				});
			});
		</script>
	</body>
</html>