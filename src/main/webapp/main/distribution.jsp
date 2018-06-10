<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<div id="main" style="width: 600px;height:400px;"></div>
<script type="text/javascript">
    // 基于准备好的dom，初始化echarts实例
    var myChart = echarts.init(document.getElementById('main'));

    // 指定图表的配置项和数据
    var option = {
        title: {
            text: '持明法洲'
        },
        tooltip: {},
        legend: {
            data:['注册人数']
        },
        xAxis: {
            data: ["这周","上一周","上上一周"]
        },
        yAxis: {},
    };

    // 使用刚指定的配置项和数据显示图表。
    myChart.setOption(option);

    $.ajax({
        type:'post',
        url:'<c:url value="/user/distribution.do"/>',
        data:'',
        dataType:'json',
        success:function (data) {
            myChart.setOption({
                series : [{
                name: '注册人数',
                type: 'bar',
                data: data
                }]
            });
        }
    })
</script>