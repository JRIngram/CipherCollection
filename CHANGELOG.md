# Change Log

## [0.3.0] Unreleased.
### Added
 * Vigenere Class with encryption and decryption functionality.
### Changed
 * 'gui' is now a private variable within the main loop.

## [0.2.0] 2016-07-29
### Added
 * Caesar Class with encryption and decryption functionality.
 * Abstract Class Tab and AtbashTab Class
 * GUI now has its own package.

### Changed
 * Collection GUI now only creates "Tab" classes and displays them - the functionality of these tabs are created in the "Tab" classes themselves. E.g. Atbash GUI functionality is created in AtbashTab.

## [0.1.2] 2016-07-06
### Added
 * Version number at top of GUI.

### Removed
 * Unnecessary 'setReverseAlphabet' method in Atbash Class.
 * Unnecessary 'setEncryptedWord' method in Cipher Class.

### Changed
 * The reverseAlphabet array in Atbash class is now filled during construction.

## [0.1.1] 2016-07-05
### Added
  * Set default close operation on GUI to do nothing. Forcing user to shutdown the program properly using the quit button.

## [0.1.0] 2016-07-04
### Added
 * Added decryption to Atbash and added a decryption button to the GUI.
 * Atbash encryption functionality to GUI.

### Removed
  * Caesar Cipher from Github due to being committed too early with incomplete/buggy funtionality.
