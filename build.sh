
##directory where jar file is located    
mvn clean compile
mvn package

echo "maven build completed"
arg="$1"
java -cp target/product_list_problem-1.0-SNAPSHOT.jar \application/MainClass $1
open "$arg"




