# Squable

This is an iteration of the hit game Wordle, implemented in Java. The program enables users to guess mystery words, with feedback provided for each letter's correctness and position, mimicking the classic gameplay experience.

## Main Classes

### 1. `Letter`
- Represents a single letter in a word.
- Tracks its state: unset, unused, used, or correct.
- Provides methods to decorate the letter’s display based on its state (e.g., + for used, - for unused, ! for correct).
- Supports equality checking and conversion from strings to arrays of `Letter`.

### 2. `ExtendedLetter`
- Subclass of `Letter` that adds extra context like `content`, `family`, and a `related` flag.
- Supports specialized equality logic, marking letters as related if their families match.
- Provides static utility to create arrays of `ExtendedLetter` from arrays of strings and codes.

### 3. `LinearNode<E>`
- Generic node for linked list structures.
- Stores an element and a reference to the next node.
- Used to construct linked lists for both letters and words.

### 4. `Word`
- Represents a word as a linked list of `Letter` objects.
- Provides string conversion and the core logic for labeling guesses (`labelWord`), marking each letter in a guess as correct, used, or unused based on comparison with the mystery word.

### 5. `WordLL`
- Implements a linked list of `Word` objects to keep track of guess history.
- Stores the mystery word and updates the guess history with each attempt.
- Method `tryWord` checks a guess against the mystery word, updating states and history accordingly.

### 6. `WordLLExamples`
- Main entry point (`main` method).
- Loads a set of possible mystery words from a file.
- Handles user interaction via console:
  - Picks a random mystery word.
  - Prompts the user to guess words of the correct length.
  - Displays feedback/history after each guess.
  - Ends when the correct word is guessed or user exits ("XX").

## How to Run

1. **Compile all Java files**:
   ```sh
   javac *.java

2. Place a file named `words` in the same directory, containing possible mystery words (one per line).

3. Run the main program:
```sh
java WordLLExamples
```

## File Overview

| File                   | Purpose                                      |
|------------------------|----------------------------------------------|
| `Letter.java`          | Letter state and display logic               |
| `ExtendedLetter.java`  | Advanced letter logic and grouping support   |
| `LinearNode.java`      | Linked list node for custom data structures  |
| `Word.java`            | Word logic and feedback for guesses          |
| `WordLL.java`          | Guess history tracking and win/loss logic    |
| `WordLLExamples.java`  | Main program, I/O, and game loop             |
