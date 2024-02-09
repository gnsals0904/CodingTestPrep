from datetime import datetime, timedelta

d = datetime.now()
d = d + timedelta(hours=9)
if(d.month > 10):
    print(d.year,d.month,d.day,sep='-')
else:
    temp = '0' + str(d.month)
    print(d.year, temp, d.day, sep='-')