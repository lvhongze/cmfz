<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
	$("#showUser").datagrid({
        url: "<c:url value='/user/showUsers.do'/>",
        fitColumns: true,
        remoteSort: false,
        pagination: true,
        columns: [[
            {field: 'code', checkbox: true, sortable: true, width: 100},
            {field: 'id', title: '编号', sortable: true, width: 100, hidden: true},
            {field: 'name', title: '姓名', sortable: true, width: 100},
            {field: 'photoNum', title: '电话 ', sortable: true, width: 100},
            {field: 'farmington', title: '法号 ', sortable: true, width: 100},
            {field: 'localtion', title: '国家 ', sortable: true, width: 100},
            {field: 'province', title: '省份 ', sortable: true, width: 100},
            {field: 'city', title: '城市 ', sortable: true, width: 100},
            {field: 'description', title: '签名 ', sortable: true, width: 100},
            {field: 'guruid', title: '所属上师id ', sortable: true, width: 100},
            {field: 'status', title: '状态 ', sortable: true, width: 100},
            {field: 'date', title: '注册日期 ', sortable: true, width: 100},
            {field: 'photo', title: '头像 ', sortable: true, width: 100,
                formatter: function (value, row, index) {
                    return "<img src='" + value + "' style='width:60px;height:60px'/>";
                },
			},
		]],
        toolbar: [{
            iconCls: 'icon-edit',
            text:'自定义导出',
            handler: function(){
                $("#export").dialog("open")
            }
        },'-',{
            iconCls: 'icon-help',
            text:'冻结用户',
            handler: function(){

            }
        }]
	})
    $("#export").dialog({
        title:'导出目录',
        width:400,
        height:330,
        top:70,
        draggable:false,
        closed:true,
        buttons:[{
            text:"导出",
            iconCls:'icon-ok',
            handler:function(){
                var a=$("#ccs").combotree("getText");
                var b=$("#ccs").combotree("getValues");
                $.ajax({
                    type:'post',
                    url:'<c:url value="/user/export.do"/>',
                    data:'name='+a+'&value='+b,
                    dataType:'json',
                    success:function (data) {
                        alert(data);
                        $("#export").dialog("close")
                    }
                })
            }
        },{
            text:'退出',
            iconCls:'icon-back',
            handler:function(){
                $("#export").dialog("close")
            }
        }]
    });
    $("#ccs").combotree({
        url:'<c:url value="/json/combotree.json"/>'
    })
</script>
<table id="showUser">

</table>

<div id="export">
    <select id="ccs" class="easyui-combotree" style="width:200px;"
            data-options="required:true,checkbox:true,onlyLeafCheck:true,multiple:true"></select>
</div>