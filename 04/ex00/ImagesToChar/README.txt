# removing target directory
rm -rf target

# creating target directory
mkdir target

# compiling files
javac -d target src/java/edu/school21/printer/*/*.java

# starting program
java -classpath target edu/school21/printer/app/Program . 0 /Users/$USER/Desktop/it.bmp