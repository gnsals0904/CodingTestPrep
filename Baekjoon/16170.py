import datetime

dt_utc = datetime.datetime.utcnow()
print(dt_utc.year)
if dt_utc.month > 10: print(dt_utc.month)
else: print("0"+str(dt_utc.month))
print(dt_utc.day)