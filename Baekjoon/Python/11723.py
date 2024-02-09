import sys


S = set()
M = int(input())
for _ in range(M):
    order_list = list(map(str, sys.stdin.readline().split()))
    if order_list[0] == 'add':
        S.add(order_list[1])
    elif order_list[0] == 'remove':
        S.discard(order_list[1])
    elif order_list[0] == 'check':
        if order_list[1] in S:
            print(1)
        else:
            print(0)
    elif order_list[0] == 'toggle':
        if order_list[1] in S:
            S.remove(order_list[1])
        else:
            S.add(order_list[1])
    elif order_list[0] == 'all':
        S = {'1', '2', '3', '4', '5', '6', '7', '8', '9', '10', '11', '12', '13', '14', '15', '16', '17', '18', '19',
             '20'}
    elif order_list[0] == 'empty':
        S.clear()
    else:
        print('wrong input')
