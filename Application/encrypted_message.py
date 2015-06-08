def start_program(myInput, alphabet, encryptionKeyOriginal):
    encryptionKey = generate_key(len(myInput), encryptionKeyOriginal)

    myInputIndices = generate_indices(alphabet, myInput)
    myEncryptionIndices = generate_indices(alphabet, encryptionKey)
    mySumedIndices = [
        x + y for x, y in zip(myInputIndices, myEncryptionIndices)]
    myRemainderIndices = [x % len(alphabet) for x in mySumedIndices]

    mapped = map_index_to_alhpa_char(myRemainderIndices, alphabet)
    message = str(len(alphabet)) + "~" + alphabet + mapped + \
        encryptionKeyOriginal + "~" + str(len(encryptionKeyOriginal))

    finalResult = swap(message)
    print(finalResult)


def map_index_to_alhpa_char(myRemainderIndices, alphabet):
    result = []
    for x in range(0, len(myRemainderIndices)):
        position = int(myRemainderIndices[x])
        result.append(alphabet[position])
    result = "".join(str(x) for x in result)
    return result


def generate_indices(alphabet, inputString):
    result = []

    for x in range(0, len(inputString)):
        myInt = alphabet.index(inputString[x])
        result.append(myInt)
    return result


def generate_key(myInputLen, encryptionKey):
    counter = 0
    producedKey = encryptionKey

    while myInputLen > len(producedKey):
        producedKey += producedKey[counter]
        if counter < len(producedKey):
            counter += 1
    return producedKey


def swap(myInput):
    cut_at = int(len(myInput) / 2)

    return myInput[(-1) * cut_at:] + myInput[:cut_at]


def start_reverse(myMessage):
    step1 = swap(myMessage)
    step2 = step1.split("~")

    lenAlphabet = int(step2[0])
    rest = step2[1]
    lenKey = int(step2[2])

    alphabet = rest[:lenAlphabet]
    key = rest[(-1) * lenKey:]

    encryptedMessage = rest[lenAlphabet:]
    encryptedMessage = encryptedMessage[:lenKey * (-1)]

    keyEncription = generate_key(len(encryptedMessage), key)
    keyIndexList = generate_indices(alphabet, keyEncription)
    encryptedMessageList = generate_indices(alphabet, encryptedMessage)

    aResult = [x - y for x, y in zip(encryptedMessageList, keyIndexList)]
    for x in range(0, len(aResult)):
        if aResult[x] < 0:
            aResult[x] += lenAlphabet

    aResult = map_index_to_alhpa_char(aResult, alphabet)

    print(aResult)


originalmessage = "TJKUMbUUJTIREuKOXD'HR.sTOVSWU!KSJ(O.sVYtWZTTZVULsNOBdYONXFsvEu(PgWJsRTSVsYKOfDZOJSNVWu(IU!yAaMs?OW.tYaVET.A IQXTMQURJ.HLs'VHa'OTYUSzCQ!SePzsuMTzYQ!SM!NOdOH SuPMa)yA!LsKOPEUM,VAaMs.SuKOkDJEcIIStHACKBULGARIA~1260~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .',!?()rEPNtg,yTYMsJOFOtkZ sd EKsVYtXPIOUMs HK't(PYSROEAsq.JfPyAJ HVRVCUYaZsPITzMQ'UMZTEJXANEBCUYWRI!Os.Su(IkD!OdADLCKNFXDZOJ THRVCQdZMRRUMPNIDtISGTJQSz"
# start_program("I love algorithms", "Ilocveakgrithms ", "hack")
# start_program("this is a secret.", "thisaecr .", "rest")
# start_program("I love freckles.", " .Ifrckslove", "kv.")
# start_program("is this fun or what?", "orwa? thfuisn", "wat?")
start_reverse(originalmessage)
# Ilocveakgrithms hevrItommseIal vihack
