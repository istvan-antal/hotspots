# The problem

A Carriage may contain one or two WiFi Access Points (AP) hard­wired with each other via Ethernet.

Each AP may mesh with a single peer AP on a different carriage to form an Inter Carriage Link (ICL).

A series of ICLs forms a network backbone through which passengers can connect to the on­board

network.

Knowledge of the installation Carriage of the APs and their meshed peers allows us to build a picture of

which carriages are physically connected to each other. This is called a Network Consist (NC).

Construct your own representation of a Network Consist and maintain this consist by consuming a data

feed made up of name/value pairs:

Device ID sysLocation AP Carriage Reference

Device ID meshPeer AP Meshed Peer Device ID

Note: Sometimes an AP will lose its mesh connection. This does not mean that the carriage has de-
coupled. The Network Consist representation should expose this as information. Only when either of the

peered APs meshes with a different device should the Network Consist change.

Example Feed

Given the following data:

AP1 sysLocation Carriage­1

AP2 sysLocation Carriage­1

AP3 sysLocation Carriage­2

AP4 sysLocation Carriage­2

AP2 meshPeer AP3

AP3 meshPeer AP2

We can generate the following Network Consist:

[ (AP1) Carriage 1 (AP2)] + [ (AP3) Carriage 2 (AP4) ]

# Requirments

JDK 1.8
Maven

# Usage (Mac OS X)

Running: ./run.sh

Running tests: ./test.sh

Packaging: ./package.sh

Running packaged JAR file: JAVA_HOME=$(/usr/libexec/java_home -v 1.8) java -jar  target/hotspots-0.1.0.jar

# Usage (Other platforms)

Ensure that JAVA_HOME is set to a valid JDK 1.8 home.

# Design

Technologies used: Spring 4, Semantic UI, jQuery

The core concept is that the user adds inputs(host, name, value) which will be stored in
an in memory database. When the user queries the server for the current network consist,
the NetworkConsistModeller will fetch all the inputs, construct a model of the network
consist and transform it into a format that the client side could easily interpret.

The client side allows the user to add/remove inputs and visualise the current network
consist.