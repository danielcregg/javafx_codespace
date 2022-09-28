#!/bin/bash  
    
# Read the user input      
echo "Testing $1 "  

testClass="$1Test"
javac -d target -cp ".:./test/lib/*"  ./test/$testClass.java
if [ $? -eq 0 ]; then
   echo Compiled successfully
else
   echo Failed to compile
   exit 1
fi

echo  Running test...
java -jar ./test/lib/junit-platform-console-standalone-1.9.0-M1.jar -cp "./target:./test/lib/system-lambda-1.2.1.jar:./test/lib/hamcrest-2.2.jar" -c $testClass

