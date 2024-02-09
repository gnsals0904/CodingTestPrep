number = int(input())
result = number % 8
if result == 0 or result == 2:
    # 검지
    print("2")
elif result == 1:
    # 엄지
    print("1")
elif result == 3 or result == 7:
    # 중지
    print("3")
elif result == 4 or result == 6:
    # 약지
    print("4")
else:
    # 새끼
    print("5")
