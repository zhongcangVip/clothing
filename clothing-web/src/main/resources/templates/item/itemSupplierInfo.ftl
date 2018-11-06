<html>
	<head>
		<title>商品供应商列表</title>
		<style type="text/css">
			ul li{
				margin-left: -30px;margin-bottom: 10px;
			}
		</style>
	</head>
	<body>
		<div>
			<ul style="list-style: none;">
				<li><input key='edit' id="supplierCode" <#if supplier??>disabled="disabled"</#if> class="easyui-textbox" label='编码/简称:'  style="width:80%;" value="<#if supplier??>${supplier.code!''}</#if>">	</li>
				<li><input key='edit' id="supplierName" class="easyui-textbox" label='名称:'  style="width:80%;"  value="<#if supplier??>${supplier.name!''}</#if>">	</li>
				<li><input key='edit' id="contacts" class="easyui-textbox" label='联系人:'  style="width:80%;"  value="<#if supplier??>${supplier.contacts!''}</#if>">	</li>
				<li><input key='edit' id="mobile" class="easyui-textbox" label='电话:'  style="width:80%;"  value="<#if supplier??>${supplier.mobile!''}</#if>">	</li>
				<li><input key='edit' id="qq" class="easyui-textbox" label='QQ:'  style="width:80%;"  value="<#if supplier??>${supplier.qq!''}</#if>">	</li>
				<li><input key='edit' id="wx" class="easyui-textbox" label='微信:'  style="width:80%;"  value="<#if supplier??>${supplier.wx!''}</#if>">	</li>
				<li><input key='edit' id="email" class="easyui-textbox" label='email:'  style="width:80%;"  value="<#if supplier??>${supplier.email!''}</#if>">	</li>
				<li><input key='edit' id="address" class="easyui-textbox" label="地址:"  multiline="true" value="<#if supplier??>${supplier.address!''}</#if>"
				 style="width:80%;height: 60px;">	</li>
			</ul>
		</div>
		<input type="hidden" name="id" value="<#if supplier??>${supplier.id!''}</#if>">
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