number = input()
result = int(number[0]) * len(number)
result = str(result)
while True:
    result2 = int(result[0]) * len(result)
    result2 = str(result2)
    result = int(result2[0]) * len(result2)
    result = str(result)
    if result == result2:
        print("FA")
        break
    else:
        print("NFA")
        break

