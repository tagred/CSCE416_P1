//Taylor Gordon
/* A Java program for a Server */
import java.net.*; 
import java.io.*; 
  
public class Server 
{ 
/* initialize socket and input stream */
private Socket socket = null; 
private ServerSocket server = null;
private DataInputStream in = null; 
private BufferedReader input = null; 
private DataOutputStream out = null; 

/* constructor with port */
public Server(int port) 
{ 
	/* starts server and waits for a connection */
	try { 
		server = new ServerSocket(port); 
	} catch(Exception i) {
		System.out.println("Error in port");
		System.exit(0);
	}
	System.out.println("Server started"); 

	System.out.println("Waiting for a client ..."); 
	try {
		socket = server.accept(); 
		System.out.println("Client accepted"); 
		
		/* takes input from the client socket */
		in = new DataInputStream( 
		    new BufferedInputStream(socket.getInputStream())); 
		out = new DataInputStream( 
			    new BufferedInputStream(socket.getOutputStream())); 
		input = new BufferedReader(new InputStreamReader(System.in)); 
		String line = ""; 
		
		/* reads message from client until "Over" is sent */
		while (!line.equals("Over")) 
		{ 
				system.out.println("Got input from Client ....")
		        line = in.readUTF(); 
		        System.out.println("Printing input: " + line); 
		        line = input.readLine(); 
				out.writeUTF(line);
		} 
		System.out.println("Closing connection"); 
		
		/* close connection */
		socket.close(); 
		in.close(); 
		input.close();
		out.close();
		
	} catch(EOFException i) { 
	    System.out.println(i); 
	} 
	catch(Exception i) { 
	    System.out.println(i); 
	} 
}

public static void main(String args[]) 
{ 
	if (args.length < 1) {
		System.out.println("Server usage: java Server #port_number");
	}
	else {
		try {
			Server server = new Server(Integer.parseInt(args[0])); 
		} catch(Exception i) {
			System.out.println("Error in port");	
		}
	}
} 

} 
