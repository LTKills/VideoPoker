all:
	javac -sourcepath src -d class src/*

run:
	java -cp class Main
