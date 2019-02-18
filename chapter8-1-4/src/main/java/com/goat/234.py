# -*- coding: utf-8 -*-  # sos 当前文件编码格式声明
# @Time    : 2018/11/30 23:31
# @Author  : 64274
# @Desc    : 
# @File    : 234.py
# @Software: PyCharm

# 这是单行注释   #和文字 中间要有一个空格
print("hello world")  # 这是单行注释   #和前面代码 中间要有两个空格

"""
这里是多行注释
这里是多行注释

"""

# 函数声明
def add(a,b):return a+b
def sub(a,b):return a-b

# 函数调用
print(add(3,4))
print(sub(7,3))

# 变量类型  在程序运行时  Python解释器会自动推断出变量的类型
name = "小明"    # str 姓名
age = 18         # int 年龄
sex = True       # bool 性别
height = 1.75    # float 身高