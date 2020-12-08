#  selenium

# selenium定位弹窗的方法
    一、弹出框是alert类型
    
    如果弹窗是alert弹窗，可以使用alert弹窗的方法
    
    二、弹出框不是alert类型
    
    1、弹出框是div层，跟平常一样定位，不用管弹出框
    
    #点击退出按钮
    
    FindElement(self.brower,"classname","btn-exit").click()
    
    #time.sleep(3)
    
    #点击确认按钮（直接定位元素不用管页面的弹出样式，driver.window_handles打印出来的窗口在同一个页面）
    
    FindElement(self.brower, "classname", "pro-btn.btn-2.btn-confirm").click()
    
     
    
    2、弹出框是iframe
    
    driver.switch_to.frame("frame1")之后进行定位元素
     
    
    3、弹出内容是嵌入的窗口解决思路：
    
    # 打印所有的handle
    
    all_handles = driver.window_handles print(all_handles)
    
    # 切换到新的handle上
    
    driver.switch_to.window(all_handles[1])




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
        
        
        
        
        
        
        
        
        
        
        