import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Random;

/**
* This class implements java Socket server
* @author pankaj
*
*/
public class SocketServerExample 
{
	//static ServerSocket variable
	private static ServerSocket server;
	//socket server port on which it will listen
	private static int port = 9876;

	public static void main(String args[]) throws IOException, ClassNotFoundException 
	{
		int r, p, t;

		r = 1;
		p = 2; 
		t = 3;
		//create the socket server object
		server = new ServerSocket(port);
		Random random = new Random();

		//keep listens indefinitely until receives 'exit' call or program terminates
		while(true){
			System.out.println("Esperando la respuesta del jugador");
			//creating socket and waiting for client connection
			Socket socket = server.accept();

			//read from socket to ObjectInputStream object
			ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());

			//create ObjectOutputStream object
			ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());

			String message = (String) ois.readObject();
			int playerNum1 = (int)(Math.random()*3+1);
			System.out.println(player1);
			int msg = Integer.parseInt(message); 

			//Roca
			if (msg == 1 && playerNum1 == 1)
			{
				oos.writeObject("roca vs roca \n empate");
				System.out.println("Elegiste a la roca");
			}
			if (msg == 1 && playerNum1 == 2)
			{
				oos.writeObject("roca vs papel \n derrota")	
				System.out.println("Elegiste a la roca");
			}
			if (msg == 1 && playerNum1 == 3)
			{
				oos.writeObject("roca vs tijera \n victoria");
				System.out.println("Elegiste a la roca");
			}

			//Papel
			if (msg == 2 &&  playerNum1 == 2)
			{
				oos.writeObject("papel vs papel \n empate");
				System.out.println("Elegiste a el papel");
			}
			if (msg == 2 && playerNum1 == 1) 
			{
			 	oos.writeObject("papel vs roca \n victoria");
				System.out.println("Elegiste a el papel");
			}
			if (msg == 2 && playerNum1 == 3)
			{
				oos.writeObject("papel vs tijera\n derrota");
				System.out.println("Elegiste a el papel");
			}

			//Tijeras
			if (msg == 3 && playerNum1 == 3)
			{
				oos.writeObject("tijeras vs tijeras \n empate");
				System.out.println("Elegiste a las tijeras");
			}
			if (msg == 3 && playerNum1 == 1)
			{
				oos.writeObject("tijeras vs roca \n derrota");
				System.out.println("Elegiste a las tijeras");
			}
			if (msg == 3 && playerNum1 == 2)
			{
				oos.writeObject("tijeras vs papel \n victoria");
				System.out.println("Elegiste a las tijeras");
			}

			//close resources
			ois.close();
			oos.close();
			socket.close();
			//terminate the server if client sends exit request;
		}
		System.out.println("Shutting down Socket server!!");
		//close the ServerSocket object
		server.close();	
	}
}



