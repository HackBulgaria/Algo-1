brackets = ["(", ")", "[", "]", "{", "}"]
closingBrackets = [")",  "]", "}"]
openingBrackets = ["(",  "[", "{"]


class Stack(list):

    def push(self, item):
        self.append(item)

    def isEmpty(self):
        return not self


def checker(dataInput):
    bracketsStack = Stack()
    for i in dataInput:
        if i in brackets:
            bracketsStack.push(i)

    if dataInput[:1] not in brackets:
        return False

    is_first = True

    if len(bracketsStack) > 2:
        for i in bracketsStack:
            if not is_first:
                if i in closingBrackets:
                    return False
                break
            is_first = False

    return check_validity(bracketsStack)


def check_validity(bracketsStack):

    is_first = True
    can_expect = []

    for i in bracketsStack:
        if not is_first:
            if i not in can_expect or i == brackets[4]:
                return False
        if i == brackets[0]:
            can_expect = [brackets[1]]
        if i == brackets[1]:
            can_expect = [brackets[0], brackets[2], brackets[3], brackets[4]]
        if i == brackets[2]:
            can_expect = [brackets[0], brackets[3]]
        if i == brackets[3]:
            can_expect = [brackets[0], brackets[2], brackets[4], brackets[5]]
        if i == brackets[4]:
            can_expect = [brackets[2], brackets[5]]
        if i == brackets[5]:
            can_expect = [brackets[0], brackets[2]]
        is_first = False

    return True


def next_position_brackets(myExpression):
    myIndex = -1
    for i in range(0, len(myExpression)):
        for z in range(0, 6):
            if myExpression[i] == brackets[z]:
                if myIndex >= 0:
                    myIndex = min(myIndex, i)
                else:
                    myIndex = i
    return myIndex


def main(expression):
    if not (checker(expression)):
        return "NO"

    counter = 0
    result = 0
    double = 0
    isFirst = True

    for i in expression:
        new_expression = expression[counter:]
        positionZero = next_position_brackets(new_expression)
        if positionZero:
            currentResult = int(i) * 10 ** (int(positionZero) - 1)
            if double:
                currentResult *= double
            result += currentResult
        else:
            if i in openingBrackets:
                if isFirst:
                    isFirst = False
                else:
                    double += 2
            if i in closingBrackets:
                double = max(0, (double - 2))

        counter += 1

    return result


print("\n\nOld style tests:\n")
print("Valid ==v:\n")
print(main("(123)"))
print(main("[(123)(123)]"))
print(main("[23(123)12(123)]"))
print(main("{123[123(123)123(123)]23[123]2}"))
print(main("[123]"))
print(main("{123}"))
print("NOT VALID ==v:\n")
print(main("123(123)"))
print(main("(123[123])"))
print(main("[123(123])"))
print(main("[123{123}]"))
print(main("(123)(123)"))
print(main("{125()125}"))
print(main("{125[12]{125}[12]125}"))
print(main("{125[12(123]125}"))
print("Now valid ==v:\n")
print(main("[123(145)38(37)812]"))
print(main("{125[2][(1)][3]125}"))
print(main("[125()125()125()125]"))
