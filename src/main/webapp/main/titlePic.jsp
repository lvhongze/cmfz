<%@ page language="java" contentType="text/html; charset=utf-8" pageEncoding="utf-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
    $(function() {
        $("#titlePicTable").datagrid({
            url: "<c:url value='/titlePic/queryPic.do'/>",
            updateUrl:"<c:url value='/titlePic/update.do'/>",
            fitColumns: true,
            remoteSort: false,
            pagination: true,
            columns: [[
                {field: 'code', checkbox: true, sortable: true, width: 100},
                {field: 'id', title: 'id', sortable: true, width: 100, hidden: true},
                {field: 'name', title: 'name', sortable: true, width: 100},
                {field: 'introduce', title: 'introduce', sortable: true, width: 100},
                {field: 'status', title: 'status', sortable: true, width: 100,
                    editor: {
                        type: 'text',
                        options: {required: true}
                    }
                },
                {field: 'thumbnail', name: 'thumbnail', sortable: true, width: 100,
                    formatter: function (value, row, index) {
                        return "<img src='" + value + "' style='width:60px;height:60px'/>";
                    },
                },
            ]],
            view: detailview,
            detailFormatter: function(rowIndex, rowData){
                return '<table><tr>' +
                    '<td rowspan=2 style="border:0"><img src="'+rowData.thumbnail+'" style="height:50px;"></td>' +
                    '<td style="border:0">' +
                    '<p>Attribute: ' + rowData.introduce + '</p>' +
                    '<p>Status: ' + rowData.status + '</p>' +
                    '</td>' +
                    '</tr></table>';
            },
            toolbar:[{
                iconCls: 'icon-clear',
                text:'刪除',
                onClick:function(){

                },
                handler: function(){
                    $.messager.confirm('确认','您确认想要删除记录吗？',function(r){
                        if (r){
                            var a=$("#titlePicTable").edatagrid('getSelections');
                            var s="";
                            for(var i=0;i<a.length;i++){
                                if(i==a.length-1) s=s+a[i].id;
                                else s=s+a[i].id+",";
                            }
                            $.ajax({
                                type:"post",
                                url:"<c:url value= '/titlePic/deletePic.do'/> ",
                                data:"string="+s,
                                dataType:"text",
                                success:function(result){
                                    $("#titlePicTable").edatagrid('reload');
                                }
                            })
                        };
                    });
                },
            },{
                iconCls: 'icon-pencil',
                text:'修改',
                handler: function(){
                    var row = $("#titlePicTable").edatagrid("getSelected");
                    if (row == null) {
                    alert("请选中行")
                    } else {
                    $("#titlePicTable").edatagrid("editRow", $("#titlePicTable").edatagrid("getRowIndex", row))
                    }
                }
            },{
                iconCls: 'icon-add',
                text:'增加',
                handler: function(){
                    $("#register").dialog("open");
                }
            },{
                iconCls: 'icon-more',
                text:'帮助',
                handler: function(){alert('修改按钮');}
            }]
        })
        $("#register").dialog({
            title:'請輸入信息',
            width:400,
            height:330,
            top:70,
            draggable:false,
            href:'<c:url value="register.jsp"/>',
            closed:true,
            buttons:[{
                text:'注冊',
                iconCls:'icon-ok',
                onClick:function(){
                    $("#regUserForm").form('submit',{
                        url:'<c:url value="/titlePic/insert.do"/>',
                        iframe:false,
                        onSubmit: function(){
                        },
                        success:function(data){
                            $("#register").dialog("close");
                            $("#titlePicTable").edatagrid('reload');
                        }
                    });
                },
                handler:function(){}
            },{
                text:'退出',
                iconCls:'icon-back',
                handler:function(){
                    $("#register").dialog("close");
                }
            }]
        });
    })

</script>
<table id="titlePicTable">

</table>
<div id="register">

</div>