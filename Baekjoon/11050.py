n, k = map(int, input().split())
fac = [1, 1]
for i in range(2, 11):
    fac.append(fac[i - 1] * i)
print(fac[n]//(fac[k] * fac[n - k]))
