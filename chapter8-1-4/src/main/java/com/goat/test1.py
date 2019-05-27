# -*- coding: utf-8 -*-
# @Time    : 2019/2/18 11:14
# @Author  : 64274
# @Desc    : 
# @File    : test1.py
# @Software: PyCharm

# 列表
country = ['法国', '美国', '日本', '中国',123,True]
print(country)
print(country[1])  # 第二个元素
print(country[-1])  # 最后一个元素
country.append('泰国') # 将元素添加到列表末尾
country.insert(2, '新加坡') # 使用insert()在列表的任何位置添加元素
del country[0] # 使用del()函数删除元素，只需提供元素在列表中的位置索引即可

print('-----------------我是华丽的分割线-----------------')

country = ['法国', '美国', '日本', '中国']
temp = country.pop() # 方法pop()可删除列表末尾的元素，并能继续使用它的值，类似与，弹出栈顶元素
temp = country.pop(1) # 使用pop()删除任何位置的元素

# 如果你要从列表中删除一个元素，且不再以任何方式使用它，就使用del()
# 如果你要做删除元素后还能继续使用它，就使用pop()

country.remove('日本') # 使用remove()根据值删除元素

print(temp)
print(country)


