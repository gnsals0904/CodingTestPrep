N = int(input())
count = 0
check = False
for _ in range(N):
    s = str(input())
    for x in s:
        if x == '(':
            count += 1
        else:
            count -= 1
        if count < 0:
            print("NO")
            check = True
            break
    if count == 0:
        print("YES")
    elif not check:
        print("NO")
    check = False
    count = 0
