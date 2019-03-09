// layui.use(['form','layer','layedit','laydate','upload'],function(){
//     var form = layui.form
//         layer = parent.layer === undefined ? layui.layer : top.layer,
//         laypage = layui.laypage,
//         upload = layui.upload,
//         layedit = layui.layedit,
//         laydate = layui.laydate,
//         $ = layui.jquery;
//
//
//     form.verify({
//         newsName : function(val){
//             if(val == ''){  return "文章标题不能为空";}
//         },
//         content : function(val){
//             if(val == ''){ return "文章内容不能为空"; }
//         }
//     })
//     // lay-filter="save"
//     form.on("submit(save)",function(data){
//         alert(11111111)
//         //弹出loading
//         var index = top.layer.msg('数据提交中，请稍候',{icon: 16,time:false,shade:0.8});
//         // 实际使用时的提交信息
//         // $.post("/index",{
//         //     newsName : $(".newsName").val(),  //文章标题
//         //     abstract : $(".abstract").val(),  //文章摘要
//         //     content : layedit.getContent(editIndex).split('<audio controls="controls" style="display: none;"></audio>')[0],  //文章内容
//         //     newsImg : $(".thumbImg").attr("src"),  //缩略图
//         //     classify : '1',    //文章分类
//         //     newsStatus : $('.newsStatus select').val(),    //发布状态
//         //     newsTime : submitTime,    //发布时间
//         //     newsTop : data.filed.newsTop == "on" ? "checked" : "",    //是否置顶
//         // },function(res){
//         //     console.log(res,'hahahaha')
//         // })
//         setTimeout(function(){
//             top.layer.close(index);
//             top.layer.msg("文章添加成功！");
//             layer.closeAll("iframe");
//             //刷新父页面
//             parent.location.reload();
//         },500);
//         return false;
//     })
//
// })