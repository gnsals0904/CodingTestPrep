list = []
i = 1
while i < 31 :
    list.append(i)
    i = i + 1
n = 28
while n > 0 :
    temp = input()
    list.remove(int(temp))
    n = n - 1
list_len = len(list)
pop_num = 0
while pop_num < list_len :
    print(list.pop(pop_num))
    list_len = list_len - 1
