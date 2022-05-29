# removing target directory
rm -rf target

# creating target directory
mkdir target

# copying resources
cp -R src/resources target/

# compiling files
javac -d target src/java/edu/school21/printer/*/*.java

# making jar
jar -cfm target/images-to-chars-printer.jar src/manifest.txt -C target .
chmod u+x target/images-to-chars-printer.jar

# starting program
java -jar target/images-to-chars-printer.jar . 0