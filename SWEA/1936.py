a, b = map(int, input().split())
if max(a, b) == a:
    if a == 3 and b == 1:
        print("B")
    else:
        print("A")
else:
    if b == 3 and a == 1:
        print("A")
    else:
        print("B")
