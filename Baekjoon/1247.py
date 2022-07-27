for i in range(3):
    t = int(input())
    num_sum = 0
    for j in range(t):
        n = int(input())
        num_sum = num_sum + n
    if num_sum > 0:
        print("+")
    elif num_sum < 0:
        print("-")
    else:
        print("0")
