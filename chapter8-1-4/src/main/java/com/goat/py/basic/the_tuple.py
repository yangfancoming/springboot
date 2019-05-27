
# -*- coding: utf-8 -*-

classmates = ('Michael', 'Bob', 'Tracy')
print('classmates =', classmates)
print('len(classmates) =', len(classmates))
print('classmates[0] =', classmates[0])
print('classmates[1] =', classmates[1])
print('classmates[2] =', classmates[2])
print('classmates[-1] =', classmates[-1])

# cannot modify tuple:
classmates[0] = 'Adam'


# tuple（元组）可以使用下标索引来访问元组中的值
tuple1=('两点水','twowter','liangdianshui',123,456)
tuple2='两点水','twowter','liangdianshui',123,456

print(tuple1[1])
print(tuple2[0])


# tuple 元组中的元素值是不允许删除的，但我们可以使用 del 语句来删除整个元组
print(tuple1)
del tuple1



""" 元组内置函数
cmp(tuple1, tuple2)	比较两个元组元素
len(tuple)	计算元组元素个数
max(tuple)	返回元组中元素最大值
min(tuple)	返回元组中元素最小值
tuple(seq)	将列表转换为元组

"""