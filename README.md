Twitter Client for Java
=============

This client automatically answers to a twitter user.
It uses [twitter4j]{https://github.com/yusuke/twitter4j} to call the TwitterAPI.

**Description is for Unix only!**

Compiling
-------
If you are familiar with java you should know how to compile the project.

### Step by step
At first you have to get a copy of this code on your machine. 

After this move the files to your desired folder. For example we use

    cd ~/TwitterClient/

Now we create the folder for the binaries

    mkdir bin

With the following command you can run the java compiler `javac` configured 
for this project

    javac -sourcepath src -classpath bin:lib/twitter4j-core-2.2.5.jar:lib/twitter4j-async-2.2.5.jar:lib/twitter4j-stream-2.2.5.jar src/*.java -d bin

Activate the app
-------


Usage
-------
