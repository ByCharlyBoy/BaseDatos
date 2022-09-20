import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.ClassNotFoundException;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Scanner;
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
		//create the socket server object
		server = new ServerSocket(port);

		Random random = new Random(); 

		System.out.println("Ingresa la letra"); 

		
		

			//keep listens indefinitely until receives 'exit' call or program terminates
			while(true)
			{
				System.out.println("Esperando la respuesta del cliente");
				//creating socket and waiting for client connection
				Socket socket = server.accept();
				//read from socket to ObjectInputStream object
				ObjectInputStream ois = new ObjectInputStream(socket.getInputStream()); 
				//convert ObjectInputStream object to String
				String message = (String) ois.readObject();

				String responde = (String) ois.readObject();

				if (responde.equalsIgnoreCase("Si")){
					oos.writeObject("Elige el objeto: ");
					responde = (String) ois.readObject();
					int serverEligeMundo = random.nextInt(3) + 1;

					//switch(serverEligeMundo){
					//case 1:
					//if(responde.equalsIgnoreCase("Roca")); 
					//oos.writeObject("Elige este:" + responde + "algo");
					//break; 
					//}
					

				}

				System.out.println("Mensaje Recibido: " + message);
				//create ObjectOutputStream object
				ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
				//write object to Socket
				oos.writeObject("Hola usuario "+message);
				//close resources
				ois.close();
				oos.close();
				socket.close();
				//terminate the server if client sends exit request
				if(message.equalsIgnoreCase("exit")) break;
			}

		System.out.println("Shutting down Socket server!!");
		//close the ServerSocket object
		server.close();
	}

}