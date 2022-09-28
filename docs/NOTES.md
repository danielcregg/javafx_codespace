# test-lab2
 Proof of concept for 1st year lab using Codespaces 


## Compiling and Running tests from command line
- Use [junit console launcher](https://junit.org/junit5/docs/current/user-guide/#running-tests-console-launcher) ([examples](https://mkyong.com/junit5/junit-5-consolelauncher-examples/)).
```sh
javac -cp './test/lib/junit-platform-console-standalone-1.9.0-M1.jar' ./test/ExampleJunitTest.java 
java -jar ./test/lib/junit-platform-console-standalone-1.9.0-M1.jar -cp './test' -c ExampleJunitTest
```


## Tests using console input/output
### Use [System Rules?](https://stefanbirkner.github.io/system-rules/)

#### Demo test using SystemRules
```
javac -cp "./test/lib/*"  ./test/SysOutTest.java
java -jar ./test/lib/junit-platform-console-standalone-1.9.0-M1.jar -cp "./test:./test/lib/system-rules-1.19.0.jar" -c SysOutTest
```
- Doesn't work
```
    => org.opentest4j.AssertionFailedError: expected: <hello world
> but was: <>
```
- Possibly because using Junit5 but system-rules is for Junit4?
  - Use [system-lambda](https://github.com/stefanbirkner/system-lambda) for JUnit5 instead?

### Using system-lambda
```
javac -cp "./test/lib/*"  ./test/LambdaSysOutTest.java
java -jar ./test/lib/junit-platform-console-standalone-1.9.0-M1.jar -cp "./test:./test/lib/system-lambda-1.2.1.jar" -c LambdaSysOutTest
```
- This works now (didn't work initially, pulled in all the test cases from the examples in the system-lambda README, now works. I know not why.)


## Compiling and Testing Student Code
```
javac -cp ".:./test/lib/*"  ./test/JavaScanner1Test.java 
java -jar ./test/lib/junit-platform-console-standalone-1.9.0-M1.jar -cp ".:./test:./test/lib/system-lambda-1.2.1.jar" -c JavaScanner1Test
```
