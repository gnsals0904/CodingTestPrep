for _ in range(3):
    one_line = list(map(int, input().split()))
    result = sum(one_line)
    # 윷
    if result == 0:
        print("D")
    # 도
    elif result == 1:
        print("C")
    # 개
    elif result == 2:
        print("B")
    # 걸
    elif result == 3:
        print("A")
    # 모
    else:
        print("E")
