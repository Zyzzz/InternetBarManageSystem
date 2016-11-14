<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title></title>  
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>  
</head>
<body>
<form method="post" action="">
  <div class="panel admin-panel">
    <div class="panel-head"><strong class="icon-reorder"> 订单管理</strong></div>
    <div class="padding border-bottom">
      <ul class="search">

      </ul>
    </div>
    <table class="table table-hover text-center">
      <tr>
        <th width="120">ID</th>
        <th>用户邮箱</th>
        <th>用户姓名</th>
        <th>商品名称</th>
        <th>数量</th>
        <th>尺码</th>
        <th>价格</th>
        <th width="120">创建时间</th>
        <th>操作</th>       
      </tr>
      <c:forEach items="${indentEntities}" var="indentEntity">
        <tr>
          <td>${indentEntity.indentid}</td>
          <td>${indentEntity.userByUserid.email}</td>
          <td>${indentEntity.userByUserid.firstname}${indentEntity.userByUserid.lastname}</td>
          <td>${indentEntity.commodityByCommodityId.commodityname}</td>
           <td>${indentEntity.number}</td>
          <td>${indentEntity.size}</td>
          <td>${(indentEntity.commodityByCommodityId.price*indentEntity.commodityByCommodityId.discount)*indentEntity.number}</td>
          <td>${indentEntity.time}</td>
          <td><div class="button-group"> <a name="finishindent" class="button border-red" href="deleltIndent?indentid=${indentEntity.indentid}"> 完成订单</a> </div></td>
        </tr>
      </c:forEach>
    </table>
  </div>
</form>
<script type="text/javascript">
function del(id){
    //document.getElementsByClassName("button border-red").href="deleltIndent?indentid=id";
}

$("#checkall").click(function(){ 
  $("input[name='id[]']").each(function(){
	  if (this.checked) {
		  this.checked = false;
	  }
	  else {
		  this.checked = true;
	  }
  });
})

function createXMLHttpRequest() {
    var xmlHttp;
    if (window.XMLHttpRequest) {
        xmlHttp = new XMLHttpRequest();
        if (xmlHttp.overrideMimeType)
            xmlHttp.overrideMimeType('text/xml');
    } else if (window.ActiveXObject) {
        try {
            xmlHttp = new ActiveXObject("Msxml2.XMLHTTP");
        } catch (e) {
            try {
                xmlHttp = new ActiveXObject("Microsoft.XMLHTTP");
            } catch (e) {
            }
        }
    }
    return xmlHttp;
}

function DelSelect(){
	var Checkbox=false;
	 $("input[name='id[]']").each(function(){
	  if (this.checked==true) {		
		Checkbox=true;	
	  }
	});
	if (Checkbox){
		var t=confirm("您确认要删除选中的内容吗？");
		if (t==false) return false; 		
	}
	else{
		alert("请选择您要删除的内容!");
		return false;
	}
}

</script>
</body></html>