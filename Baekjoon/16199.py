y1, m1, d1 = map(int, input().split())
y2, m2, d2 = map(int, input().split())
r2 = y2 - y1 + 1
r3 = y2 - y1
if y1 == y2:
    r1 = 0
else:
    if m1 < m2:
        r1 = y2 - y1
    elif m1 > m2:
        r1 = y2 - y1 - 1
    else:
        if d1 < d2:
            r1 = y2 - y1
        elif d1 > d2:
            r1 = y2 - y1 - 1
        else:
            r1 = y2 - y1
print(r1)
print(r2)
print(r3)