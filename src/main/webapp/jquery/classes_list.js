$(function () {
    loadDate();
});

function loadDate() {
    $.post("pages/back/classes/classes_list.action",{},function (obj) {
        $("#classesTable tr:gt(0)").remove();
        for (var x = 0;x <obj.allClasses.length;x++){
            addRow(obj.allClasses[x].cid,obj.allClasses[x].cname,obj.allClasses[x].note);
        }
    },"json");
}

function addRow(cid,cname,note) {
    var str = "<tr>" +
        "<td><input type='checkbox' name='classesId' value='"+cid+"'/></td>"+
        "<td>"+cid+"</td>"+
        "<td>"+cname+"</td>"+
        "<td>"+note+"</td>"
    "</tr>";
    $("#classesTable").append($(str));
}

function getCheckValue(){  //jquery获取复选框值
    var data = "";
    $('input[name="classesId"]:checked').each(function(){
        data += this.value + "|";
    });
    return data;
}

$("#allCheak").click(function(){
    $("[name='classesId']").each(function(){//反选
        if($(this).attr("checked")){
            $(this).removeAttr("checked");
        }
        else{
            $(this).attr("checked",'true');
        }
    });
});

//修改按钮
$(function(){
    $("#updateByn").click(function(){
        var chk_value = getCheckValue();
        if(chk_value.length == 0){
            alert("请选择数据");
            return;
        }
        if(chk_value.length > 1){
            alert("只能选择一条数据");
            return;
        }
        $.ajax({
            type: 'POST',//提交方式 post 或者get
            url: "",//提交到那里 后他的服务
            data: chk_value,//提交的参数
            success: function(msg){
                alert("成功了");//弹出窗口，这里的msg 参数 就是访问aaaa.action 后 后台给的参数
            },
            error:function(){
                alert("提交失败的处理函数");
            }
        });
    });
});

//删除按钮
$(function(){
    $("#deleteByn").click(function(){
        var url = "/pages/back/classes/classes_deleteClasses.action";
        var data = getCheckValue();
        if (data == ""){
            alert("请选择数据后操作！")
        }
        else{
            $.post(url,{"cids":data},function(obj){
                if(obj == "true"){
                    alert("删除成功");
                }
                loadDate();

            },"text");
        }
    });
});