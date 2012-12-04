Garagedroid
===========

A simple app for controlling a garage door wirelessly over the Internet.  You'll also need an Arduino (some other hardware for interfaceing with the garage door), a WiFi Shield, and the Arduino code ([Garageduino](https://github.com/bransorem/Garageduino)).  Garagedroid uses HTTP headers to communicate.

Make it work
------------

To make it work, you'll need to change a few things.

In strings.xml, change the address to your URL, and the port to whatever port you coded in the [Garageduino](https://github.com/bransorem/Garageduino) code.

In HttpTask.java, you can change the custom headers to be whatever you want - just make sure to update it in the Garageduino code also.

Example:

```diff
-           get.addHeader(new BasicHeader("CUSTOM", "toggle"));
+           get.addHeader(new BasicHeader("Bacon", "5 pieces"));
```
