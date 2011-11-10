Twitter Client for Java
=============

This client automatically answers to a twitter user.
It uses [twitter4j](https://github.com/yusuke/twitter4j) to call the [Twitter REST API](https://dev.twitter.com/docs/api).

**Description is for Unix only!**

Notice to the [OAuth Process](https://dev.twitter.com/docs/auth/oauth)
-------

To get access to the Twitter API you have to [create a new application](https://dev.twitter.com/apps/new). You need this to get a consumer key and secret.

### Setting up the access level

Make sure your application has **Read and Write** acces. Go to the "Settings" page of your app and scroll down to "Application type" where you can set this option.
Go back to the "Details" page and copy the consumer key and secret into `src/TwitterAuthorization.java` to the following lines:

    private final static String O_AUTH_CONSUMER_KEY = "*********************";
    private final static String O_AUTH_CONSUMER_SECRET = "******************************************";

The code should look like this after adding the values (*the keys here won't work. they are used as an example*)

    private final static String O_AUTH_CONSUMER_KEY = "GDdmIQH6jhtmLUypg82g";
    private final static String O_AUTH_CONSUMER_SECRET = "MCD8BKwGdgPHvAuvgvz4EQpqDAtx89grbuNMRd7Eh98";


Compiling
-------

If you are familiar with Java you should know how to compile a project.

### Step by step

At first you have to get a copy of this code on your machine. 

After this move the files to your desired folder. For example we use

    cd ~/TwitterClient/

Now we create the folder for the binaries

    mkdir bin

With the following command you can run the java compiler `javac` configured 
for this project

    javac -sourcepath src -classpath bin:lib/twitter4j-core-2.2.5.jar:lib/twitter4j-stream-2.2.5.jar src/*.java -d bin

Usage
-------

To use the programm you have to start it with the java virtual machine. Use `java` to do so.
If you are still in the same directory as above use this:

    java -cp bin:lib/twitter4j-core-2.2.5.jar:lib/twitter4j-stream-2.2.5.jar TwitterApp

After the programm is running it will ask you to enter the given URL into your browser. Follow the steps on this website and copy the pin to the programm.
Your client is ready now. If someone mentions you with `@<YourTwitterUserName>` your client will answer with a random calculation question.
