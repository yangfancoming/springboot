

#  dtu 点击 注册后 提示 
    Winsock error 10054: OnClientRead recv reported a socket error.  
    
    原因 dtu 默认是 udp协议 查看项目启动后 是启动的TCP 还是 UDP 如果以TCP启动 就会报那个错

 #  断包，粘包 问题
 
    接收端在接受数据时有可能会遇到下面四种情况
    
    A.先接收到dataA然后接收到dataB.
    B.先接收到dataA的部分数据,然后接收到dataA余下的部分以及dataB的全部.
    C.先接收到了dataA的全部数据和dataB的部分数据,然后接收到了dataB的余下的数据.
    D.一次性接收到了dataA和dataB的全部数据.
    
    A为正常情况，无粘包或断包。
    B为断包+粘包。
    C为粘包+断包。
    D为粘包。

# 如何处理Mina中遇到的粘包和断包问题
    在Mina框架中有个CumulativeProtocolDecoder 累积性的协议解码器，专门用来处理粘包和断包问题。doDecode()的返回值有重要作用。
    
    A.你的doDecode()方法返回true 时，CumulativeProtocolDecoder 的decode()方法会首先判断你是否在doDecode()方法中从内部的IoBuffer 缓冲区读取了数据，
    如果没有，则会抛出非法的状态异常，也就是你的doDecode()方法返回true 就表示你已经消费了本次数据（相当于聊天室中一个完整的消息已经读取完毕），
    进一步说，也就是此时你必须已经消费过内部的IoBuffer 缓冲区的数据（哪怕是消费了一个字节的数据）。
    如果验证过通过，那么CumulativeProtocolDecoder 会检查缓冲区内是否还有数据未读取，
    如果有就继续调用doDecode()方法，没有就停止对doDecode()方法的调用，直到有新的数据被缓冲。
    
    B. 当你的doDecode()方法返回false 时，CumulativeProtocolDecoder 会停止对doDecode()方法的调用，
    但此时如果本次数据还有未读取完的，就将含有剩余数据的IoBuffer 缓冲区保存到IoSession 中，以便下一次数据到来时可以从IoSession 中提取合并。
    如果发现本次数据全都读取完毕，则清空IoBuffer 缓冲区（让父类进行接收下一个包）。
    简而言之，当你认为读取到的数据已经够解码了，那么就返回true，否则就返回false。
    这个CumulativeProtocolDecoder 其实最重要的工作就是帮你完成了数据的累积，因为这个工作是很烦琐的。
    也就是说返回true，那么CumulativeProtocolDecoder会再次调用decoder，并把剩余的数据发下来；
    （意思就是会把剩余数据给doDecode()处理，剩余数据就是remaining()的数据），返回false就不处理剩余的，
    （不把剩余数据给doDecode()处理）当有新数据包来的时候就把剩余的数据和新的数据拼接在一起，然后再调用decoder。

 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 
 