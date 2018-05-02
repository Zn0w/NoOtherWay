@echo off
javac -d bin -sourcepath src src/com/znow/gamecore/Main.java
java -cp bin com.znow.gamecore.Main
pause