#  selenium






# 运行后报错： java.lang.IllegalStateException: The path to the driver executable must be set by the webdriver.chrome.driver system property; 
    1、查了一下，据说报这个错是因为在selenium和Firefox不兼容导致的，需要添加驱动。于是找到了驱动下载地址：
       谷歌： http://npm.taobao.org/mirrors/chromedriver/
    
     2、设置驱动路径
        火狐 ：System.setProperty("webdriver.gecko.driver", "F:\\Package\\Python_Environment\\geckodriver.exe");
        谷歌 ：System.setProperty("webdriver.chrome.driver", "F:\\Package\\Python_Environment\\chromedriver.exe");
        
        
        
#  运行后报错 
     Timed out connecting to Chrome, retrying...
     org.openqa.selenium.ElementNotVisibleException: element not interactable   
     
     原因： 由于要定位的页面元素 属性不存在！  或是 有变化！  导致的定位不到元素。
        
        
        
        
        
        
        
        
        
        
        