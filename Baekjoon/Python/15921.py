n = int(input())
if n == 0:
    print("divide by zero")
else:
    grade = list(map(int, input().split()))
    avg = sum(grade) / len(grade)
    temp_sum = 0
    for i in range(len(grade)):
        temp_sum = temp_sum + grade[i] / len(grade)
    result = avg/temp_sum
    str = "{:.2f}".format(result)
    print(str)
