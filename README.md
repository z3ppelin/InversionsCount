Counting inversions in an array
===================

About
------------
Given array A[1... n], for every i < j, counts all inversion pairs such that A[i] > A[j].

Running code examples
------------
**C** implementation:

You should compile the source file first.

    cd C/
    gcc -o InversionsCount InversionsCount.c (Linux)
    ./InversionsCount ../in/inputBig.txt (Linux)
    
    compile with Visual Studio | MinGW | DevC++ (Windows) 
    InversionsCount.exe ../in/inputBig.txt (Windows)

**Java** implementation:

Contains also a JUnit test file.

Used java 1.6.0_33, junit 4.10 to compile source files.

    cd Java/
    java InversionsCount ../in/inputBig.txt (Windows & Linux)
    java -cp "<path_to_junit_4.x_jar_file>;./" org.junit.runner.JUnitCore InversionsCountTest (Windows)
    java -cp "<path_to_junit_4.x_jar_file>:./" org.junit.runner.JUnitCore InversionsCountTest (Linux)

To compile yourself the source files:

    cd Java/
    javac InversionsCount.java (Windows & Linux)
    javac -cp "<path_to_junit_4.x_jar_file>;./" InversionsCountTest.java (Windows)
    javac -cp "<path_to_junit_4.x_jar_file>:./" InversionsCountTest.java (Linux)

For the input files in *in/* folder the expected results are: *inputTiny.txt*: 19, *inputBig.txt*: 2407905288