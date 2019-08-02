HTTPServerApplication
PROBLEM STATEMENT:
Create a simple Web Server using Socket Programming in Java. The Server must be able to handle GET request from the browser and respond back the requested resources to the browser. The Server must also be able to handle multiple request. Contents like HTML, CSS, JS, JPEG, JPG files should be handled by the server. 


SOLUTION:
Classes Created: 
•	Server
o	This is the wrapper class for ServerSocket class in java. With functionality like 
like listening for the client. 
•	ClientWrapper
o	This is the wrapper class for Socket class in java. With the functionality getHttpReqeust and sendResponse
•	ClientHandlerThread
o	This is the class for handling particular client. (Supporting Multithreading)
•	HttpRequestParser
o	This is a helper class for parsing the HttpRequest sent by the client. (Like getting the requested method(GET/POST) and the requested Resources
(index.html aboutus.html )
•	HttpRequestWrapper
o	This is the wrapper class for the reqeustMethod and request Resource. (The one created in the above point in HttpRequestParser)
•	FileHandler
o	This is a helper class for reading the contents of the files requested by the client
•	PrepareHeader
o	This is the helper class for preparing different kinds of Http header for different types of files requested by the client.
•	Response
o	This is a wrapper class for the Response that is to be sent to the client. It has Content and header. 
•	ServerCommunicationApp
o	This is the main class that uses the above classes to make the whole application. 


Control Flow:
	
