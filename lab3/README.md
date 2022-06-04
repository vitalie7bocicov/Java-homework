<html>
<head> 
  
</head>
<body>
<a name="laborator3"></a>

<h1> Lab 3</h1>

<p>
<b>The Network Routing Problem</b><br>

A network contains various <i>nodes</i>, such as <i>computers</i>, <i>routers</i>, <i>switches</i>, etc.
Nodes in the network have unique names and may have other common properties such as hardware (MAC) address, the location on a map, etc. <br/>
Some of them are <i>identified</i> using an IP-address. Some of them are able to store data, having a <i>storage capacity</i>, expressed in gigabytes (GB). <br/>
The time (measured in milliseconds) required for a network packet to go from one node to another is known.

<br/>
<p>
Example: locations are: v1 (Computer A)  v2 (Router A) v3 (Switch A) v4 (Switch B) v5 (Router B) v6 (Computer B).
<table border="0">
<tr><td>
<table border="1">
<tr>
<th>From-To </th> <th> Cost </th>
<tr><td> v1--v2 </td> <td> 10 </td>
<tr><td> v1--v3 </td> <td> 50 </td>
<tr><td> v2--v3 </td> <td> 20 </td>
<tr><td> v2--v4 </td> <td> 20 </td>
<tr><td> v2--v5 </td> <td> 20 </td>
<tr><td> v3--v4 </td> <td> 10 </td>
<tr><td> v4--v5 </td> <td> 30 </td>
<tr><td> v4--v6 </td> <td> 10 </td>
<tr><td> v5--v6 </td> <td> 20 </td>
</table>
</td>
<td>
<image src="network.png"/>
</td>
</tr>
</table>
Computers and routers are identified by IPs, while only computers are able to store data.
  
<p>
The main specifications of the application are:
<hr>
<p><b>Compulsory</b> (1p)
<ul>
<li>Create an object-oriented model of the problem. You should have at least the following classes <i>Network, Node, Computer, Router, Switch</i>. 
The natural ordering of the nodes is given by their names.
<li>Create the interfaces <i>Identifiable</i> and <i>Storage</i>. The classes above must implement these interfaces accordingly.
<li>The <i>Network</i> class will contain a <i>List</i> of nodes. 
<li>Create and print all the nodes in the network (without the time costs).
</pre>
</ul>

<hr>
<p><b>Homework</b> (2p)
<br/>
<ul>
<li> Each node will contain a <i>Map</i> representing the time costs. Create and print the complete network in the example.
<li> Create a <i>default</i> method in the interface <i>Storage</i>, that is able to return the storage capacity in other units of storage (megabyte, kilobyte, byte).
<li> In the <i>Network</i> class, create a method to display the nodes that are <i>identifiable</i>, sorted by their addresses. 
<!-- <li> Create the class <i>NetworkInfo</i>. An instance of this class will contain a net and the preferences regarding the visiting order. -->
<li> Implement an <u>efficient</u> agorithm to determine <u>all the shortests times</u> required for data packets to travel from an identifiable node to another.
</ul>

</body>
</html>
