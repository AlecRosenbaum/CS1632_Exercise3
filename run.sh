mkdir -p build
javac -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:lib/mockito-all-1.10.19.jar -d build src/*.java && \
java -cp .:lib/junit-4.12.jar:lib/hamcrest-core-1.3.jar:lib/mockito-all-1.10.19.jar:build CitySim9005 $@