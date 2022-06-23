month = int(input())
days = int(input())

if month < 2:
    print("Before")
elif month == 2:
    if days == 18:
        print("Special")
    elif days < 18:
        print("Before")
    else:
        print("After")
else:
    print("After")