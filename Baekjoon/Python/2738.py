n, m = map(int, input().split())
test = list()
test2 = list()
for k in range(n):
  temp_array = list(map(int, input().split()))
  test.append(temp_array)
for o in range(n):
  temp_array = list(map(int, input().split()))
  test2.append(temp_array)
result = [[test[i][j] + test2[i][j] for j in range(m)] for i in range(n)]
result2 = test[0] + test2[0]
for i in range(n):
  for j in range(m):
    if j == m-1:
      print(result[i][j], end="")
    else:
      print(result[i][j], end=" ")
  print("")