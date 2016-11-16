<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<!DOCTYPE html>
<html lang="zh-cn">
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no" />
    <meta name="renderer" content="webkit">
    <title>商品信息</title>
    <link rel="stylesheet" href="css/pintuer.css">
    <link rel="stylesheet" href="css/admin.css">
    <link rel="stylesheet" href="css/fileinput.min.css">
    <script src="js/jquery.js"></script>
    <script src="js/pintuer.js"></script>
    <script src="js/fileinput.min.js"></script>
    <script src="js/zh.js"></script>
    <script>
        $(".file").on("change","input[type='file']",function(){
            var filePath=$(this).val();
            if(filePath.indexOf("jpg")!=-1 || filePath.indexOf("png")!=-1){
                $(".fileerrorTip").html("").hide();
                var arr=filePath.split('\\');
                var fileName=arr[arr.length-1];
                $(".showFileName").html(fileName);
            }else{
                $(".showFileName").html("");
                $(".fileerrorTip").html("您未上传文件，或者您上传文件类型有误！").show();
                return false
            }
        })
    </script>
</head>
<body>
<div class="panel admin-panel">
    <div class="panel-head"><strong><span class="icon-pencil-square-o"></span> 商品信息</strong></div>
    <div class="body-content">
        <form method="post" class="form-x" action="editCommodity">

            <div class="form-group">
                <div class="label">
                    <label>商品名称：</label>
                </div>
                <div class="field">
                    <input type="text" readonly="readonly" class="input" name="commodityId" value="${commodityEntity.commodityid}" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>商品名称：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="commodityName" value="${commodityEntity.commodityname}" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>商品价格：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="price" value="${commodityEntity.price}" />
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>商品描述：</label>
                </div>
                <div class="field">
                    <input type="text"  class="input" name="description" value="${commodityEntity.description}"  style="height:80px"/>
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label>商品折扣：</label>
                </div>
                <div class="field">
                    <input type="text" class="input" name="discount" value="${commodityEntity.discount}" />
                    <div class="tips"></div>
                </div>
            </div>

            <div class="form-group">
                <div class="label">
                    <label></label>
                </div>
                <div class="field">
                    <button class="button bg-main icon-check-square-o" type="submit"> 提交</button>
                </div>
            </div>
        </form>
    </div>
</div>
</body></html>