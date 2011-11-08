Twitter Client for Java
=============

This client automatically answers to a twitter user.
It uses [twitter4j](https://github.com/yusuke/twitter4j) to call the TwitterAPI.

**Description is for Unix only!**

Notice to the [OAuth Process](https://dev.twitter.com/docs/auth/oauth)
-------

To get access to the Twitter API you have to [create a new application](https://dev.twitter.com/apps/new). You need this to get a consumer key and consumer secret.
These to values you have to add to the `TwitterAuthorization.java`:

    private final static String O_AUTH_CONSUMER_KEY = "*********************";
    private final static String O_AUTH_CONSUMER_SECRET = "******************************************";

should look like this after adding the values

    private final static String O_AUTH_CONSUMER_KEY = "GDdmIQH6jhtmLUypg82g";
    private final static String O_AUTH_CONSUMER_SECRET = "MCD8BKwGdgPHvAuvgvz4EQpqDAtx89grbuNMRd7Eh98";


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

Usage
-------

To use the programm you have to start it with the java virtual machine. Use `java` to do so.
If you are still in the same directory as above use this:

    java -cp bin:lib/twitter4j-core-2.2.5.jar:lib/twitter4j-async-2.2.5.jar:lib/twitter4j-stream-2.2.5.jar TwitterApp

After the programm is running it will ask you to enter the given URL into your browser. Follow the steps on this website and copy the pin to the programm.
Your client is ready now. If someone mentions you with `@` your client will answer with a random calculation questtion.
