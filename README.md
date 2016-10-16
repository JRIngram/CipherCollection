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
  `caesar.setKey(1); caesar.encrypt(abcxyz)`, would set the `encryptedWord` variable to `BCDYZA`.  
  `caesar.setKey(18); caesar.encrypt(example)`, would set the `encryptedWord` variable to `WPSEHDW`.

  [Visit here for more information](https://en.wikipedia.org/wiki/Caesar_cipher).

## Vigenere
  The Vigenere Cipher can be viewed as a more advanced Caesar Cipher and, like the Caesar Cipher, contains a message and a key. Unlike the Caesar Cipher however the key is a String of alphabetical characters, the length of which should be equal or less than the length of the message we wish to encrypt.  
  Each letter within the key is given a shift value, equal to their position in the `alphabet` array; the letter in the message that corresponds to the same position as the key letter (e.g. `message[0]` and `key[0]`) is shifted by the shift value of that letter.  

  The `key` variable is set using the `setKeyCharacters(String key)` method, which sets the values in the String array `keyCharacters`. If the key length is less than the length of the message the key wraps.

  For Example:  
  `vigenere.setKeyCharacters("ab"); vigenere.encrypt("abcxyz")`, would set the `encryptedWord` variable to `ACCYYA`.  
  `vigenere.setKeyCharacters("s"); vigenere.encrypt("example")`, would set the `encryptedWord` variable to `WPSEHDW`. This would be the same as:  
  `caesar.setKey(18); caesar.encrypt(example)` as `s`'s shift value is 18.

  [Visit here for more information](https://en.wikipedia.org/wiki/Vigen%C3%A8re_cipher).

## XOR Cipher
  The XOR cipher works by converting the input string and the key (of the same length) into binary strings and performing an XOR operation between each respective character. The key variable is set using `setKey(String key)` with the key being an alphabetical string. An example of an XOR operation would be (assuming `a = 0001 b = 0010 c = 0011`):
```
0001 (a, the plaintext)
0010 (b, the key)
-----
0011 (c the encrypted text)
```
  As we can see, if we were to use the same key and perform an XOR operation on the encrypt text, the plaintext would be produced.

  [Visit here for more information](https://en.wikipedia.org/wiki/XOR_cipher#Example).
