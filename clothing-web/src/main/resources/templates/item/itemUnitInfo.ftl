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
				<li><input id="unitCode" key='edit' class="easyui-textbox" label='编码:'  style="width:100%;" value="<#if itemUnit??>${itemUnit.code!''}</#if>">	</li>
				<li><input id="unitName" key='edit' class="easyui-textbox" label='名称:'  style="width:100%;"  value="<#if itemUnit??>${itemUnit.name!''}</#if>">	</li>
				<li><input id="description" key='edit' class="easyui-textbox" label="描述:"  multiline="true" value="<#if itemUnit??>${itemUnit.description!''}</#if>"
				 style="width:100%;height: 60px;">	</li>
			</ul>
		</div>
		<input type="hidden" name="id" value="<#if itemUnit??>${itemUnit.id!''}</#if>">
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