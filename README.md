# CheckerFramework
This repository contains two java files, that solve the eight queens problem with a backtracking approach.

EightQueens.java is unannotated, while AnnotatedEightQueens.java has been annotated for the "Nullness Checker" of the Checker Framework.

Thus preventing the program to run into null pointer exceptions.

The above program can be run with the Nullness Checker by executing the following command in the terminal.-

javacheck -processor org.checkerframework.checker.nullness.NullnessChecker EightQueens.java

Here javacheck is an alias that is defined by adding the following lines in ~./bashrc file

export CHECKERFRAMEWORK=${HOME}/checker-framework-2.4.0
alias javacheck='$CHECKERFRAMEWORK/checker/bin/javac'

More information can be found here- https://checkerframework.org/manual
 
 
