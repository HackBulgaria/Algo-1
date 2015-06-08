def is_palindrome(testInput):
    cut_at = int(len(testInput) / 2)

    if testInput[(-1) * cut_at:] == testInput[:cut_at][::-1]:
        return True


def start_program(myInput):
    x = 0
    listResults = []

    while x < len(myInput):

        cut_part = myInput[x:] + myInput[:x]
        if (is_palindrome(cut_part)):
            listResults.append(cut_part)
            print(cut_part)

        x += 1

    if not len(listResults):
        print("NONE")


start_program("labalaa")
start_program("akawwaka")
start_program("shakira")
