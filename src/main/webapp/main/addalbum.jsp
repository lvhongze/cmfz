<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
</script>
<form id="addalbumForm" method="post" enctype="multipart/form-data">
	<div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
		<input name="name" required="true" class="easyui-textbox" data-options="iconCls:'icon-pencil',prompt:'请输入专辑名'" style="width:100%;height: 100%">
	</div> 
	<div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
		<input name="author" required="true" class="easyui-textbox" data-options="iconCls:'icon-pencil',prompt:'请输入视频作者名称'" style="width:100%;height: 100%">
	</div>  
	<div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
		<input name="announcer" required="true" class="easyui-textbox" data-options="iconCls:'icon-pencil',prompt:'请输入播音员名'" style="width:100%;height: 100%">
	</div>
	<div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
		<input name="episode" required="true" class="easyui-textbox" data-options="iconCls:'icon-pencil',prompt:'请输入集数'" style="width:100%;height: 100%">
	</div>
	<div style="height: 40px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
		<input name="introduce" required="true" class="easyui-textbox" data-options="iconCls:'icon-pencil',prompt:'请输入专辑介绍'" style="width:100%;height: 100%">
	</div>
	<div style="height: 40px;margin-bottom: 30px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
		<input name="image" required="true"  class="easyui-filebox" style="width:100%;height: 100%">
	</div>  
</form>