import sys


num_list = []
one_line = list(map(str, sys.stdin.readline().split()))
start = True
for x in one_line:
    if start:
        count = int(x)
        start = False
    else:
        num_list.append(int(x[::-1]))
        count -= 1
while count > 0:
    one_line = list(map(str, sys.stdin.readline().split()))
    for x in one_line:
        num_list.append(int(x[::-1]))
        count -= 1
num_list.sort()
for result in num_list:
    print(result)
