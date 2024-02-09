hour, minute, second = map(int, input().split())
need_minute = int(input())
temp = second + need_minute
if temp > 3599:
    # 몇시간 이상
    hour_temp = temp // 3600
    temp = temp % 3600
    minute_temp = temp // 60
    second_temp = temp % 60
elif temp > 59:
    # 몇 분 이상
    hour_temp = 0
    minute_temp = temp // 60
    second_temp = temp % 60
else:
    # 몇 초 이상
    hour_temp = 0
    minute_temp = 0
    second_temp = temp
hour = hour + hour_temp
minute = minute + minute_temp
second = second_temp
if minute > 59:
    hour_plus = minute // 60
    minute = minute % 60
    hour = hour + hour_plus
if hour > 23:
    hour = hour % 24
print(hour,minute,second)