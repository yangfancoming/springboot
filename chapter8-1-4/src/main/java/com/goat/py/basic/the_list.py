# -*- coding: utf-8 -*-
# @Time    : 2019/2/18 11:14
# @Author  : 64274
# @Desc    :
# @File    : test1.py
# @Software: PyCharm

classmates = ['Michael', 'Bob', 'Tracy']
print('classmates =', classmates)
print('len(classmates) =', len(classmates))
print('classmates[0] =', classmates[0])
print('classmates[1] =', classmates[1])
print('classmates[2] =', classmates[2])
print('classmates[-1] =', classmates[-1])
classmates.pop()
print('classmates =', classmates)




# 列表 ： 创建一个列表，只要把逗号分隔的不同的数据项使用方括号括起来即可,且列表的数据项不需要具有相同的类型
country = ['法国', '美国', '日本', '中国',123,True]
print(country)

# 通过索引来访问列表
print(country[1])  # 第二个元素
print(country[-1])  # 最后一个元素

# 通过方括号的形式来截取列表中的数据
print(country[0:2])

# 通过索引对列表的数据项进行修改或更新
country[2]=456
print(country)

country.append('泰国') # 将元素添加到列表末尾
country.insert(2, '新加坡') # 使用insert()在列表的任何位置添加元素
del country[0] # 使用del()函数删除元素，只需提供元素在列表中的位置索引即可

print('-----------------我是华丽的分割线-----------------')

country = ['法国', '美国', '日本', '中国']
temp = country.pop()  # 方法pop()可删除列表末尾的元素，并能继续使用它的值，类似与，弹出栈顶元素
temp = country.pop(1) # 使用pop()删除任何位置的元素

# 如果你要从列表中删除一个元素，且不再以任何方式使用它，就使用del()
# 如果你要做删除元素后还能继续使用它，就使用pop()

country.remove('日本') # 使用remove()根据值删除元素

print(temp)
print(country)


"""
List （列表）函数&方法
cmp(list1, list2)	比较两个列表的元素
len(list)	列表元素个数
max(list)	返回列表元素最大值
min(list)	返回列表元素最小值
list(seq)	将元组转换为列表
list.append(obj)	在列表末尾添加新的对象
list.count(obj)	统计某个元素在列表中出现的次数
list.extend(seq)	在列表末尾一次性追加另一个序列中的多个值（用新列表扩展原来的列表）
list.index(obj)	从列表中找出某个值第一个匹配项的索引位置
list.insert(index, obj)	将对象插入列表
list.pop(obj=list[-1])	移除列表中的一个元素（默认最后一个元素），并且返回该元素的值
list.reverse()	反向列表中元素
list.sort([func])	对原列表进行排序

"""

