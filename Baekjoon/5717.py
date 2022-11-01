i = True
while i:
    a, b = map(int, input().split())
    if a == 0 & b == 0:
        i = False
    else:
        print(a + b)
