<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
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
<div class="panel admin-panel">
  <div class="panel-head"><strong class="icon-reorder"> 商品列表</strong></div>
  <table class="table table-hover text-center">
    <tr>
      <th width="3%">ID</th>
      <th width="5%">商品名称</th>
      <th width="10%">商品描述</th>
        <th width="3%">商品价格</th>
        <th width="3%">商品折扣</th>
      <th width="10%">操作</th>
    </tr>
      <c:forEach items="${commodityEntities}" var="commodityEntitie">
        <tr>
            <td>${commodityEntitie.commodityid}</td>
            <td>${commodityEntitie.commodityname}</td>
            <td>${commodityEntitie.description}</td>
            <td>${commodityEntitie.price}</td>
            <td>${commodityEntitie.discount}</td>
            <td><div class="button-group"> <a class="button border-main" href="getCommodity?commodityid=${commodityEntitie.commodityid}"><span class="icon-edit"></span> 修改</a> <a class="button border-red" href="deleltCommodity?commodityid=${commodityEntitie.commodityid}" onclick="return del(1,2)"><span class="icon-trash-o"></span> 删除</a> </div></td>
        </tr>
      </c:forEach>
  </table>
</div>
<script type="text/javascript">
function del(id,mid){
	if(confirm("您确定要删除吗?")){			
		return true;
	}
    return false;
}
</script>
</body>
</html>