import datetime

A = list(map(int, input().split()))
B = list(map(int, input().split()))
C = list(map(int, input().split()))

time_1 = datetime.timedelta(hours=A[0], minutes=A[1], seconds=A[2])
time_2 = datetime.timedelta(hours=A[3], minutes=A[4], seconds=A[5])
time = time_2 - time_1
time = str(time).replace(":", " ")
time = time.replace("00", "0")
print(time)

time_1 = datetime.timedelta(hours=B[0], minutes=B[1], seconds=B[2])
time_2 = datetime.timedelta(hours=B[3], minutes=B[4], seconds=B[5])
time = time_2 - time_1
time = str(time).replace(":", " ")
time = time.replace("00", "0")
print(time)

time_1 = datetime.timedelta(hours=C[0], minutes=C[1], seconds=C[2])
time_2 = datetime.timedelta(hours=C[3], minutes=C[4], seconds=C[5])
time = time_2 - time_1
time = str(time).replace(":", " ")
time = time.replace("00", "0")
print(time)