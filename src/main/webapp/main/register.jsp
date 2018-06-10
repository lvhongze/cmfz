<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
</script>
<form id="regUserForm" method="post" enctype="multipart/form-data">
	<div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
		<input name="name" required="true" class="easyui-textbox" data-options="iconCls:'icon-pencil',prompt:'请输入图片名'" style="width:100%;height: 100%">
	</div> 
	<div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
		<span style="height: 100%;width: 30%;display: inline-block;margin: 0;padding: 0;text-align: center;">
		    <span style="line-height: 40px;display: block;font-size: 14px">状&nbsp;&nbsp;态:</span>
		</span>
		<span style="height: 100%;width: 69%;display: inline-block;margin: 0;padding: 0;float: right">
		   <input class="easyui-switchbutton" name="status" data-options="onText:'展示',offText:'不展示',handleWidth:85,handleText:'是否展示'" style="width:100%;height: 100%">
		</span>
	</div>  
	<div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
		介绍：<input id="introduce" required="true"  name="introduce" class="easyui-textbox" data-options="" style="width:84%;height: 100%">
	</div>  
	<div style="height: 40px;margin-bottom: 30px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
		<input name="image" required="true"  class="easyui-filebox" style="width:100%;height: 100%">
	</div>  
</form>