
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.7.js"></script>
    <link href="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/css/select2.min.css" rel="stylesheet" />
    <script src="https://cdnjs.cloudflare.com/ajax/libs/select2/4.0.6-rc.0/js/select2.min.js"></script>
</head>
<body>

${msg}


<select style="width:500px;" class="js-example-basic-single"  name="state">
    <option value="AL">Alabama</option>
    <option value="WY">Wyoming</option>
</select>

<br/>

<select style="width:500px;"  class="js-example-basic-single" multiple="multiple" name="state">
    <option value="AL">Alabama</option>
    <option value="WY">Wyoming</option>
</select>

<br>

单个文件上传：form表单 <br/>
<form action="/upload" method="post" enctype="multipart/form-data">
    <input type="file" name="file"/>
    <input type="submit" value="提交上传"/>
</form>


单个文件上传：Ajax<br/>
<form class="form-horizontal" id="upload_form" method="post" enctype="multipart/form-data">
    <div class="form-group">
        <label class="col-sm-3 control-label">请选择License.lic文件：</label>
        <div class="col-sm-6">
            <input type="file" class="form-control" id="file" name="file"/>
        </div>

        <div class="col-sm-3">
            <input type="button" name="btnUpload" id="btnUpload" value="上传" class="btn btn-primary" onclick="importLicense()">
        </div>
    </div>
</form>
<br/>
多个文件上传：
<form action="/uploads" method="post" enctype="multipart/form-data">
    文件1：<input type="file" name="file"/><br/>
    文件2：<input type="file" name="file"/><br/>
    文件3：<input type="file" name="file"/><br/>
    <input type="submit" value="上传多个文件"/>
</form>


</body>
</html>

<script>
    $(document).ready(function() {
        $('.js-example-basic-single').select2();
    });

    $(".js-example-basic-multiple-limit").select2({
        maximumSelectionLength: 2
    });

    function importLicense() {
        var str = $("#file").val();
        var fileName = getFileName(str); // 获取上传 文件名
        var fileExt = str.substring(str.lastIndexOf('.') + 1);  // 获取上传 文件后缀名
        console.log(fileName + "\r\n" + fileExt,123123123123);
        if (fileName != "license.lic") {
            alert("请上传 license.lic 证书文件！")
            return;
        }
        var formData = new FormData($("#upload_form")[0]);
        $.ajax({
            type: "POST",
            url: "/upload",
            data: formData,
            dataType: "json",
            async: false,
            enctype: "multipart/form-data",
            cache: false,
            contentType: false,
            processData: false,
            success: function (result) {
                console.log(result,22222222);
            },
            error:function(data){ // doit 为什么返回值 不走 success  而会走这里？
                console.log(data,111111111);
            }
        });
    }
    //获取文件名称
    function getFileName(path) {
        var pos1 = path.lastIndexOf('/');
        var pos2 = path.lastIndexOf('\\');
        var pos = Math.max(pos1, pos2);
        if (pos < 0) {
            return path;
        } else {
            return path.substring(pos + 1);
        }
    }
</script>