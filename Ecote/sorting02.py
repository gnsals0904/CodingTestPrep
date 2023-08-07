N = int(input())
arr = []
for i in range(N):
    input_data = input().split()
    arr.append((input_data[0], input_data[1]))

arr = sorted(arr, key=lambda student: student[1])

for student in arr:
    print(student[0], end=' ')
    