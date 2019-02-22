# Script to automatically display results of program
# Run chmod +x test.sh

rm -rf bin/*
javac -d target/classes -classpath target/dependencies/gson-2.8.5.jar -sourcepath core/sprite core/sprite/*.java
java -classpath target/classes:target/dependencies/gson-2.8.5.jar core.sprite.Main
