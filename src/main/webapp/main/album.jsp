<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<script type="text/javascript">
    $('#taa').treegrid({
        url:'<c:url value="/album/queryAlbum.do"/>',
        idField:'id',
        treeField:'name',
        fitColumns:true,
        columns:[[
            {field:'id',title:'编号',width:100},
            {field:'name',title:'名称',width:150},
            {field:'size',title:'大小',width:80},
            {field:'length',title:'长度',width:80},
            {field:'album_id',title:'所属视频',width:80},
            {field:'score',title:'评分',width:80},
            {field:'announcer',title:'播音员',width:80}
        ]],
        toolbar: [{
            iconCls: 'icon-edit',
            text:'专辑详情',
            handler: function(){
                var row=$("#taa").treegrid("getSelected");
                if(row==null){alert("请选中行")}
                else{
                   $.ajax({
                        type:'post',
                        url:'<c:url value="/album/queryAlbumById.do"/>',
                        data:'id='+row.id,
                        dataType:'json',
                        success:function (result) {
                            $("#introduce").dialog("open")
                            $("#name_introduce").val(result.name);
                            $("#pic_introduce").prop('src',result.cover);
                            $("#text_introduce").val(result.introduce);
                        }
                   })
                }
            }
        },'-',{
            iconCls: 'icon-help',
            text:'添加专辑',
            handler: function(){
                $("#addalbum").dialog("open")
            }
        },'-',{
            iconCls: 'icon-help',
            text:'添加章节',
            handler: function(){
                var row=$("#taa").treegrid("getSelected");
                if(row==null){alert("请选中行")}
                else{
                    $("#addchapter").dialog("open")
                }
            }
        },'-',{
            iconCls: 'icon-help',
            text:'下载音频',
            handler: function(){
                var row=$("#taa").treegrid("getSelected");
                if(row==null){alert("请选中行")}
                else{
                   $.ajax({
                       type:'post',
                       url:'<c:url value="/chapter/download.do"/>',
                       data:'id='+row.id,
                       dataType:'json',
                       success:function (result) {

                       }
                   })
                }
            }
        }]

    });
    $("#introduce").dialog({
        title:'专辑详情',
        width:'400px',
        height:'400px',
        closed:true,
        top:'120px',
    })
    $("#addalbum").dialog({
        title:'請輸入信息',
        width:400,
        height:330,
        top:70,
        draggable:false,
        href:'<c:url value="addalbum.jsp"/>',
        closed:true,
        buttons:[{
            text:'添加',
            iconCls:'icon-ok',
            onClick:function(){
                $("#addalbumForm").form('submit',{
                    url:'<c:url value="/album/insertAlbum.do"/>',
                    iframe:false,
                    onSubmit: function(){
                    },
                    success:function(data){
                        $("#addalbum").dialog("close");
                        $("#taa").edatagrid('reload');
                    }
                });
            },
            handler:function(){}
        },{
            text:'退出',
            iconCls:'icon-back',
            handler:function(){
                $("#addalbum").dialog("close");
            }
        }]
    });
    $("#addchapter").dialog({
        title:'請上传文件',
        width:400,
        height:330,
        top:70,
        draggable:false,
        closed:true,
        href:'<c:url value="addchapter.jsp"/>',
        buttons:[{
            text:'确定',
            iconCls:'icon-ok',
            onClick:function(){
                $("#addchapterForm").form('submit',{
                    url:'<c:url value="/chapter/insertChapter.do"/>',
                    iframe:false,
                    onSubmit: function(){
                    },
                    success:function(data){
                        $("#addchapter").dialog("close");
                        alert(data);
                        $("#taa").treegrid('reload');
                    }
                });
            },
            handler:function(){}
        },{
            text:'退出',
            iconCls:'icon-back',
            handler:function(){
                $("#addchapter").dialog("close");
            }
        }]
    })
</script>


<table id="taa" ></table>
<div id="introduce">
    <div style="height: 40px;margin-top: 30px;padding-left: 20%;padding-right: 20%">
        专辑名称：<input id="name_introduce" type="text" name="name"  value="" style="width:60%;height: 100%"/>
    </div>
    <div style="height: 100px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
        图&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp&nbsp片：<img id="pic_introduce" name="pic_introduce" src="" style="width:60%;height: 100%"/>
    </div>
    <div style="height:140px;margin-top: 10px;padding-left: 20%;padding-right: 20%">
        详细介绍：<textarea id="text_introduce" name="text_introduce" value="" style="width:60%;height: 100%"/>
    </div>
</div>
<div id="addalbum"></div>
<div id="addchapter"></div>










