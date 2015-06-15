myWord = input("Enter a word:")
myList = []
myList.extend(myWord)

for z in range(0, len(myList)):
    print("Z is => {}, {}".format(z, myList[z]))
    for x in range(z, 0, -1):
        print("X is => {}, {}".format(x, myList[x]))
        if (x - 1) >= 0:
            if myList[x] < myList[x - 1]:
                myList[x], myList[x - 1] = myList[x - 1], myList[x]
                print("[x]{} [x-1]{}".format(myList[x], myList[x - 1]))

print("".join(myList))
