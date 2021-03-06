# Change Log

## [0.4.0] 2016-10-16

### Added
 * XOR class with encryption and decryption functionality.

### Changed
 * Removal of getAlphabetLetter in Cipher class.

### Removed
 * Vigenere cipher printing to console the results of tests.

## [0.3.1] 2016-09-06
### Added
 * A TakesUserTextInput superclass created to remove duplicated code and increase modularity.
 * Buttons no longer availabile in Vigenere Tab if non-alphabetical key added.

### Changed
 * setWordCharacters in the Cipher superclass now turns the parametered string into upper case letters.

## [0.3.0] 2016-08-21
### Added
 * Vigenere Class with encryption and decryption functionality.
 * Minimum size of the software window.
 * Scroll and word wrapping functionality for the input/output boxes.

### Changed
 * 'gui' is now a private variable within the main loop.
 * Tab class is now protected so it cannot be instantiated.
 * Refactoring to remove duplicated code within many of the individual cipher classes.
 * Public visibility of variables within in Tab class, more variables are now private.
 * Input boxes and Output boxes are now larger.

### Fixed
 * Bug where on decryption, the Atbash tab would swap the output of the previous encryption and place it in the input and then decrypt this word rather than decrypting the users actual input.
 * Error in CaesarTab explanation.

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
