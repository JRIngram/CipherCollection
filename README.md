# CipherCollection
# Introduction
## About
A collection of various ciphers/encryption techniques. Originally the ciphers within the project were individual programs, mostly created for programming exercises in various languages. The previous ciphers I have created have been standardised into a single Java application - the *CipherCollection*.

A *cipher* is an algorithm used for encrypting or decrypting a message of some form. The ciphers in the project are to use the English Alphabetical Characters as the inputs.

## LICENCE
[Click here](https://raw.githubusercontent.com/JRIngram/CipherCollection/doc/Update-Readme/LICENCE) to view the licence that this program has been released under.

## Technologies
CipherCollection has been developed and compiled using:
* Java 1.8
* Java Swing
* Java AWT

# Ciphers
Currently, the ciphers within the CipherCollection include:
* Atbash Cipher
* Caesar/Shift
* Vigenere

## Cipher Superclass
The Cipher Superclass is the superclass of all Ciphers within the CipherCollection. It consists of 4 methods and 4 fields.

During construction, an String constant array is filled with each letter of the alphabet: `alphabet[0] = "a"`, `alphabet[1] = "b" ect.`.

Another field is the String array `wordCharacters`, this contains the characters of the word that is to being either encrypted or decrypted. The `wordCharacters` array is populated using the `setWordChracters(String word)` method.

An example of this in use is:

  `setWordCharacters("apple")` would cause the `wordCharacters` to be filled in the following manner: `wordCharacters[0] = a`, `wordCharacters[1] = p`, `wordCharacters[2] = p`, `wordCharacters[3] = l`, `wordCharacters[4] = e`.

The Cipher class also contains the abstract methods `encrypt(String word)` and `decrypt(String wordToBeDecrypted)` which are intended to encrypt and decrypt Strings. Boths method should set the value of `encryptedWord`, which is retrieved using the `getEncryptedWord` method.

## Atbash Cipher
  The Atbash cipher works by substituting the first letter of the alphabet with the last, the second letter with the second to last, the final letter with the first and the second to last with the second ect.

  For example:  
  `atbash.encrypt("abcxyz")`, would set the `encryptedWord` variable to `ZYXCBA`.  
  `atbash.encrypt("example")`, would set the `encryptedWord` variable to `VCZNKOV`.

  It can be viewed as a special case of another cipher - the 'Affine Cipher' - which is not currently included within this cipher collection. Although an Atbash Cipher works with any cipher - the version used within this cipher collect only works with the English Alphabet.

  [Visit here for more information](https://en.wikipedia.org/wiki/Atbash).

## Caesar Cipher
  The Caesar Cipher contains two parts: The message and the key. The message is the String we wish to encrypt or decrypt, the key is the value `n` in the following equation:  

  Encryption: `Ei(x) = alphabet[((x + n) mod 26)];`  
  Decrypt: `Di(x) = alphabet[((x - n) mod 26)];`

  The `key` variable is set using the `setKey(int key)` method.

  For example:  
  `caesar.setKey(1) caesar.encrypt(abcxyz)`, would set the `encryptedWord` variable to `BCDYZA`.  
  `caesar.setKey(18) caesar.encrypt(example)`, would set the `encryptedWord` variable to `WPSEHDW`.

  [Visit here for more information](https://en.wikipedia.org/wiki/Caesar_cipher).

## Vigenere
