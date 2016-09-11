# CipherCollection
A collection of various ciphers/encryption techniques.
# CipherCollection
# Introduction
## About
A collection of various ciphers/encryption techniques. Originally the ciphers within the project were individual programs, mostly created for programming exercises in various languages. The previous ciphers I have created have been standardised into a single Java application - the *CipherCollection*.

## LICENCE
[Click here](https://raw.githubusercontent.com/JRIngram/CipherCollection/doc/Update-Readme/LICENCE) to view the licence that this program has been released under.

## Technologies
CipherCollection has been developed and compiled using:
* Java 1.8
* Java Swing
* Java AWT

# Ciphers
Currently, the ciphers within the CipherCollection include:
* Atbash
* Caesar/Shift
* Vigenere

## Cipher Superclass

## Atbash Cipher
  The Atbash cipher works by substituting the first letter of the alphabet with the last, the second letter with the second to last, the final letter with the first and the second to last with the second ect.

  For example: `encrypt("abcxyz")`, would set the `encryptedWord` variable to `ZYXCBA`.

  It can be viewed as a special case of another cipher - the 'Affine Cipher', which is not currently included within this cipher collection. Although an Atbash Cipher works with any cipher - the version used within this cipher collect only works with the English Alphabet.

## Caesar Cipher

## Vigenere
