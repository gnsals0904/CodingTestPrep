while True:
    member_name, member_age, member_kg = input().split()
    if member_name == "#":
        break
    if int(member_kg) >= 80 or int(member_age) > 17:
        print(member_name + " Senior")
    else:
        print(member_name + " Junior")
