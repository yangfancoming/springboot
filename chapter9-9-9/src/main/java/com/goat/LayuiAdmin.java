package com.goat;

import java.io.*;
import java.net.HttpURLConnection;
import java.net.URL;

/**
 * Created by laotang on 2018/11/7.
 */
public class LayuiAdmin {

    // 指定本地保存目录
    private static String fileDirPath = "C:/workspace/html/layuiAdmin";

    // 需要下载的参数，基本不用改
    private static String baseDirUrl = "https://www.layui.com/admin/std/dist";
    private static  String htmlDirPath = "/views";
    private static String jsDirPath = "/layuiadmin";
    private static String[] htmlArray = {"index.html","app/message/index.html","set/user/info.html","set/user/password.html","home/console.html","home/homepage1.html","home/homepage2.html","component/grid/list.html","component/grid/mobile.html","component/grid/mobile-pc.html","component/grid/all.html","component/grid/stack.html","component/grid/speed-dial.html","component/button/index.html","component/form/element.html","component/form/group.html","component/nav/index.html","component/tabs/index.html","component/progress/index.html","component/panel/index.html","component/badge/index.html","component/timeline/index.html","component/anim/index.html","component/auxiliar/index.html","component/layer/list.html","component/layer/special-demo.html","component/layer/theme.html","component/laydate/demo1.html","component/laydate/demo2.html","component/laydate/theme.html","component/laydate/special-demo.html","component/table/static.html","component/table/simple.html","component/table/auto.html","component/table/data.html","component/table/tostatic.html","component/table/page.html","component/table/resetPage.html","component/table/toolbar.html","component/table/totalRow.html","component/table/height.html","component/table/checkbox.html","component/table/radio.html","component/table/cellEdit.html","component/table/form.html","component/table/style.html","component/table/fixed.html","component/table/operate.html","component/table/parseData.html","component/table/onrow.html","component/table/reload.html","component/table/initSort.html","component/table/cellEvent.html","component/table/thead.html","component/laypage/demo1.html","component/laypage/demo2.html","component/upload/demo1.html","component/upload/demo2.html","component/colorpicker/index.html","component/slider/index.html","component/rate/index.html","component/carousel/index.html","component/flow/index.html","component/util/index.html","component/code/index.html","template/personalpage.html","template/addresslist.html","template/caller.html","template/goodslist.html","template/msgboard.html","template/search.html","template/tips/404.html","template/tips/error.html","app/content/list.html","app/content/tags.html","app/content/comment.html","app/content/listform.html","app/content/tagsform.html","app/forum/list.html","app/forum/replys.html","app/message/index.html","app/workorder/list.html","senior/echarts/line.html","senior/echarts/bar.html","senior/echarts/map.html","user/forget.html","user/login.html","user/reg.html","user/user/list.html","user/administrators/list.html","user/administrators/role.html","user/administrators/adminform.html","user/administrators/roleform.html","user/user/userform.html","set/system/website.html","set/system/email.html","set/user/info.html","set/user/password.html"};
    private static String[] jsArray = {"config.js","lib/extend/echarts.js","lib/extend/echartsTheme.js","lib/admin.js","lib/index.js","lib/view.js","modules/common.js","modules/forum.js","modules/console.js","modules/message.js","modules/workorder.js","modules/contlist.js","modules/sample.js","modules/senior.js","modules/set.js","modules/user.js","modules/useradmin.js"};
    private static String[] cssArray = {"style/admin.css","style/login.css","style/template.css","style/res/template/portrait.png","style/res/template/huge.jpg","style/res/template/character.jpg","style/res/logo.png","style/res/layui-logo.jpg"};
    // layui框架的下载地址，如有必要，可更改下载地址，目前最新版为2.4.5
    private static String layuiZipUrl = "https://res.layui.com/static/download/layui/layui-v2.4.5.zip";

    public static void main(String[] args){
        run(htmlArray, htmlDirPath);
        run(jsArray, jsDirPath);
        run(cssArray, jsDirPath);
        System.out.println("\n************* 手动完成以下操作 ************");
        System.out.println("\t1，请用迅雷下载【 "+layuiZipUrl+" 】解压后，将解压后的文件夹下的【layui】剪切至【"+fileDirPath+jsDirPath+"】,最后将zip文件及解压后的文件夹删除");
        System.out.println("\t2，将【"+fileDirPath+htmlDirPath+"/index.html】文件里的第15行代码注释掉，保存退出。");
        System.out.println("\t3，双击打开index.html即可！");
    }

    public static void run(String[] arrays, String itemPath)  {
        String baseUrl, filePath;
        for(String url : arrays) {
            baseUrl  = baseDirUrl +itemPath+"/"+url;
            filePath = fileDirPath+itemPath +"/"+url;
            File file = getFile(baseUrl, filePath,"GET");
            System.out.println("create " + file + " is success");
        }
    }

    public static File getFile(String url, String filePath, String method){
//        System.out.println("url------->: " +  url +"           filePath---->"+filePath);
        String dirPath = filePath.substring(0, filePath.lastIndexOf("/"));
        //如果文件夹不存在，则创建新的的文件夹
        File dir=new File(dirPath);
        if(!dir.exists()) {
            dir.mkdirs();
        }
        //创建不同的文件夹目录
        File file=new File(filePath);
        //判断文件夹是否存在
        if (!file.exists()) {
            //如果文件不存在，则创建新的的文件
            try {
                file.createNewFile();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        FileOutputStream fileOut = null;
        HttpURLConnection conn = null;
        InputStream inputStream = null;
        try {
            // 建立链接
            URL httpUrl=new URL(url);
            conn=(HttpURLConnection) httpUrl.openConnection();
            //以Post方式提交表单，默认get方式
            conn.setRequestMethod(method);
            conn.setDoInput(true);
            conn.setDoOutput(true);
            // post方式不能使用缓存
            conn.setUseCaches(false);
            //连接指定的资源
            conn.connect();
            //获取网络输入流
            inputStream=conn.getInputStream();
            BufferedInputStream bis = new BufferedInputStream(inputStream);
            //判断文件的保存路径后面是否以/结尾
            if (!filePath.endsWith("/")) {
                filePath += "/";
            }
            //写入到文件（注意文件保存路径的后面一定要加上文件的名称）
            //fileOut = new FileOutputStream(filePath+"db.xml");
            //写入到文件（已经加了文件名）
            fileOut = new FileOutputStream(filePath);
            BufferedOutputStream bos = new BufferedOutputStream(fileOut);

            byte[] buf = new byte[4096];
            int length = bis.read(buf);
            //保存文件
            while(length != -1) {
                bos.write(buf, 0, length);
                length = bis.read(buf);
            }
            bos.close();
            bis.close();
            conn.disconnect();
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("抛出异常！！");
        }
        return file;
    }
}
