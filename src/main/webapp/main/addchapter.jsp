<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
    var row=$("#taa").treegrid("getSelected");
    $("#aaa").val(row.id)
</script>
<form id="addchapterForm" method="post" enctype="multipart/form-data">
	<div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
		专辑名称：<input name="album_id" id="aaa" class="easyui-textbox" value="" readonly="readonly" style="width:60%;height: 100%">
	</div>
	<div style="height: 40px;margin-bottom: 30px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
		<input name="music" required="true"  class="easyui-filebox" style="width:100%;height: 100%">
	</div>
</form>