<html>
<head> <title> Lab 10</title> </head>
<body>

<a name="lab10"></a>

<h1> Lab 10</h1>

<p>
<b>Networking</b> <br>

Create an application where clients connect to a server in order to form a <i>social network</i>.
The application will contain two parts (create a project for each one):

<ul>
<li>The <b>server</b> is responsible with the management of the clients and the implementation of the services.
<li>The <b>client</b> will communicate with the server, sending it <i>commands</i> containing the name of the service and the required parameters. The commands are:
	<ul>
	<li> register <i>name</i>: adds a new person to the social network;
	<li> login <i>name</i>: establishes a connection between the server and the client;
	<li> friend <i>name<sub>1</sub> name<sub>2</sub> ... name<sub>k</sub></i>: adds friendship relations between the person that sends the command and other persons;
	<li> send <i>message</i>: sends a message to all friends.
	<li> read: reads the messages from the server.
	</ul> 
</ul>

<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)

<ul>
<li> Create the project for the server application.
<li> Implement the class responsible with  the creation of a <i>ServerSocket</i> running at a specified port.
The server will receive requests (commands) from clients and it will execute them. 
<li> Create a class that will be responsible with communicating with a client <i>Socket</i>. The communication will be on a separate thread.
If the server receives the command <i>stop</i> it will stop and will return to the client the respons "Server stopped", otherwise it return: "Server received the request ... ".
<li> Create the project for the client application.
<li> A client will read commands from the keyboard and it will send them to the server. The client stops when it reads from the keyboard the string "exit".
</ul>

<hr>
<p><b>Homework</b> (2p)
<br/>

<ul>
<li> Create an object-oriented model for your application and implement the commands. <br/>
The command <i>stop</i> should "gracefully" stop the server - it will not accept new games but it will finish those in progress. When there are no more games, it will shutdown.
<li> Implement a timeout for a connection (a number of minutes). 
If the server does not receive any command from a logged in client in the specified period of time, it will terminate the connection.

<li> (+0.5p) Upload a HTML document containing the social network representation directly from the application to a Web server. 
You may use <a href="http://www.jcraft.com/jsch/"> JCraft </a> for connecting to a server using SFTP and transferring a file (or a similar solution). <br/>
</ul>

</body>
</html>
