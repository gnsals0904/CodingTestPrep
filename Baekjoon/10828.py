import sys


N = int(input())
stack = list()
count = 0
for i in range(N):
    one_line = list(map(str, sys.stdin.readline().split()))
    if one_line[0] == 'push':
        stack.append(one_line[1])
        count += 1
    elif one_line[0] == 'top':
        if count == 0:
            print(-1)
        else:
            print(stack[count - 1])
    elif one_line[0] == 'size':
        print(count)
    elif one_line[0] == 'empty':
        if count == 0:
            print(1)
        else:
            print(0)
    # pop
    else:
        if count == 0:
            print(-1)
        else:
            print(stack.pop())
            count -= 1
