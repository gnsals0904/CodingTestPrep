N = int(input())
plan = list(input().split())
x, y = 1, 1
for i in plan:
    if i == 'L':
        if y > 1:
            y -= 1
    elif i == 'R':
        y += 1
    elif i == 'U':
        if x > 1:
            x -= 1
    else:
        x += 1
print(x, y)

