real_password, try_password = map(int, input().split())
result = real_password - try_password + 1
print(result)
