
# -*- coding: utf-8 -*-

d = { 'Michael': 95, 'Bob': 75,'Tracy': 85 }

print('d[\'Michael\'] =', d['Michael'])
print('d[\'Bob\'] =', d['Bob'])
print('d[\'Tracy\'] =', d['Tracy'])
print('d.get(\'Thomas\', -1) =', d.get('Thomas', -1))



dict1={'liangdianshui':'111111' ,'twowater':'222222' ,'两点水':'333333'}
print(dict1)
# 新增一个键值对
dict1['jack']='444444'
print(dict1)
# 修改键值对
dict1['liangdianshui']='555555'
print(dict1)


# 通过 key 值，删除对应的元素
del dict1['twowater']
print(dict1)
# 删除字典中的所有元素
dict1.clear()
print(dict1)
# 删除字典
del dict1



""" dict （字典） 的函数和方法
cmp(dict1, dict2)	比较两个字典元素
len(dict)	计算字典元素个数
str(dict)	输出字典可打印的字符串表示
type(variable)	返回输入的变量类型，如果变量是字典就返回字典类型
dict.clear()	删除字典内所有元素
dict.copy()	返回一个字典的浅复制
dict.values()	以列表返回字典中的所有值
popitem()	随机返回并删除字典中的一对键和值
dict.items()	以列表返回可遍历的(键, 值) 元组数组

"""