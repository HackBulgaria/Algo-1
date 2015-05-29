# Encrypted message

This task comes with a cryptic message and the algorithm that produced it. Your goal is to reverse the steps and find the original message. It contains instructions that you have to follow.

## Message

The message that we received is going to look like something like this:

```
TJKUMbUUJTIREuKOXD'HR.sTOVSWU!KSJ(O.sVYtWZTTZVULsNOBdYONXFsvEu(PgWJsRTSVsYKOfDZOJSNVWu(IU!yAaMs?OW.tYaVET.A IQXTMQURJ.HLs'VHa'OTYUSzCQ!SePzsuMTzYQ!SM!NOdOH SuPMa)yA!LsKOPEUM,VAaMs.SuKOkDJEcIIStHACKBULGARIA~1260~abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ .',!?()rEPNtg,yTYMsJOFOtkZ sd EKsVYtXPIOUMs HK't(PYSROEAsq.JfPyAJ HVRVCUYaZsPITzMQ'UMZTEJXANEBCUYWRI!Os.Su(IkD!OdADLCKNFXDZOJ THRVCQdZMRRUMPNIDtISGTJQSz
```

## Encryption algorithm

This message was produced by applying the following steps on a standard English text:

### Alphabet and key

1. We selected a string of symbols that we call the **alphabet** of our message. The **alphabet** contains every symbol that is present in the message.
2. We picked a string of symbols that will be the secret **key** used to encrypt the message. The length of the **key** is smaller than the length of the message being encrypted.

### Steps to encrypt

We created an **encrypted message** going through every character of the original message and following these steps:

* Sum the alphabet index of the message character with the alphabet index of the key character.
* Limit the resulted number within the bounds of the alphabet.
* This resulted number is the alphabet index of the character that is the encrypted version of the original.
* P.S: The key we picked is shorter than the message so what we did in order to be able to apply this step for all characters is just repeat the key once you go to the end of it. (If the message is `"abcdefgh"` and the key is `"xyz"`, what you have to do is construct a compound key that will be `"xyzxyzxy"` and use it with the message.)
3. We constructed a string that is in the form **`"{length of alphabet}~{alphabet}{encrypted message}{key}~{length of key}"`**
4. Then we sliced this string in half (rounding down) and swapped the two halves.

## Example

Let say we want to encrypt the message `"I love algorithms"`. Here are the steps we follow:

0. We have to choose an alphabet for the encryption and it should contain all characters of the message being encrypted and there should be no repeating characters. Let say the alphabet is `"Ilocveakgrithms "`.
1. We have to choose a key for the encryption. The characters of the key should also be part of the alphabet. For example `"hack"`.
2. We have to sum the indices of the characters in the message with the indices of the characters in the key. We repeat the key so that every character in the original message is covered:
    * `"I love algorithms"` has indices `[ 0, 15, 1, 2,  4,  5, 15,  6,  1,  8, 2,  9, 10, 11, 12, 13, 14]`
    * `"hackhackhackhackh"` has indices `[12,  6, 3, 7, 12,  6,  3,  7, 12,  6, 3,  7, 12,  6,  3,  7, 12]`
    * So the sum of these indices is  `[12, 21, 4, 9, 16, 11, 18, 13, 13, 14, 5, 16, 22, 17, 15, 20, 26]`
    * However, we have an alphabet of length **16** so we need to constrain our indices so that they are within that range. We do this by taking the remainder of division by 16: `[12, 5, 4, 9, 0, 11, 2, 13, 13, 14, 5, 0, 6, 1, 15, 4, 10]`
    * Now we map the resulting indices to characters from the alphabet: `"hevrItommseIal vi"`
3. Now we construct a string containing the encrypted message, the alphabet, the key and their lengths: `"16~Ilocveakgrithms hevrItommseIal vihack~4"`
4. Finally, we slice the message in half and swap the two halves: `"vrItommseIal vihack~416~Ilocveakgrithms he"`

So the encrypted message that we end up with is `"vrItommseIal vihack~416~Ilocveakgrithms he"`

Here are more examples of messages that we encrypted:

### Example 1

* original: `"this is a secret."`
* alphabet: `"thisaecr ."`
* key: `"rest"`
* encoded: `"rc hscesi tcrest~410~thisaecr .rcese"`

### Example 2

* original: `"I love freckles."`
* alphabet: `" .Ifrckslove"`
* key: `"kv."`
* encoded: `"fl k.ccfsIolskv.~312~ .Ifrckslovelvo"`

### Example 3

* original: `"is this fun or what?"`
* alphabet: `"orwa? thfuisn"`
* key: `"wat?"`
* encoded: `"o?uin uw?stutnfwat?~413~orwa? thfuisnnrsiu"`

## The problem

Your task is to write a program that reverses this process and results in the original message and follow the instructions that it carries :)

* On the standard input, you are going to receive a single line of string - the encrypted message.
* On the standard output, output the original message.

