
<%@ page contentType="text/html;charset=UTF-8" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="../js/jquery-1.7.js"></script>
</head>
<body>

<div>
    <form id="f">
        <input type="file" name="license" id="license" />
    </form>
    <input type="button" value="上传证书" onclick="importExcel();" />
</div>

<hr>
<input type=checkbox id="fuck1" name="kk1">
<hr>
<input type=checkbox id="fuck2"name="kk2">
<hr>
</body>
</html>
<script type="text/javascript">
    var ctx = "${ctx}";
    function importExcel() {
        var form = new FormData(document.getElementById("f"));
        $.ajax({
            url : ctx + "/uploadLicense/upload",
            type : "post",
            data : form,
            processData : false,
            contentType : false,
            error : function(request) {
                alert('系统错误');
            },
            success : function(data) {
                alert(data.msg);
            }
        });
    }
</script>