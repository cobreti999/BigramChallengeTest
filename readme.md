# The Bigram Parsing Problem:

An application that can take as input any text file and output a histogram of the bigrams in the text.
A bigram is any two adjacent words in the text disregarding case and punctuation. A histogram
is the count of how many times that particular bigram occurred in the text.

Example:
Given the text: “The quick brown fox and the quick blue hare.” The bigrams with their counts would be.
* “the quick” 2
* “quick brown” 1
* “brown fox” 1
* “fox and” 1
* “and the” 1
* “quick blue” 1
* “blue hare” 1

## Getting Started

These instructions will get you a copy of the project up and running on your local machine for development and testing purposes.

### Prerequisites

You can just import/build and run the project in Intellij IDEA or do this from command line.
If you are using command line, you need to have Java and Gradle installed.

```
Java - https://www.oracle.com/java/technologies/javase-jdk13-downloads.html
Gradle - https://gradle.org/install/
```

### Installing

Clone the code in a directory of your choice, and do:

```
gradle build
```

The project should have built correctly.

### Running the tests

To run the unit tests do:

```
gradle test
```

The unit tests should have run correctly.

### Running the application

To run the application do:

```
gradle run --args=BigramChallengeTest.txt
```

You should see the output:

> Task :run
* 'the quick' 2
* 'quick brown' 1
* 'brown fox' 1
* 'fox and' 1
* 'and the' 1
* 'quick blue' 1
* 'blue hare' 1