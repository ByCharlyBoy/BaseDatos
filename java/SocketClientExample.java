import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.Scanner;

/**
* This class implements java socket client
* @author pankaj
*
*/
public class SocketClientExample 
{

	public static void main(String[] args) throws UnknownHostException, IOException, ClassNotFoundException, InterruptedException{
		//get the localhost IP address, if server is running on some other IP, you need to use that
		//InetAddress host = InetAddress.getLocalHost();
		InetAddress host = InetAddress.getByName("127.0.8.0");
		Socket socket = null;
		ObjectOutputStream oos = null;
		ObjectInputStream ois = null;
		Scanner myObj = new Scanner(System.in);
		String escojerLetra;

		System.out.println("Quieres jugar, piedra, papel o tijera? Si/No");

		while(true){
		//establish socket connection to server
		socket = new Socket(host.getHostName(), 9876);

		//write to socket using ObjectOutputStream
		oos = new ObjectOutputStream(socket.getOutputStream());

		System.out.println("Sending request to Socket Server");
		escojerLetra = myObj.nextLine();
		oos.writeObject(escojerLetra);

		//read the server response message
		ois = new ObjectInputStream(socket.getInputStream());
		String message = (String) ois.readObject();
		System.out.println("Message: " + message);

		//close resources
		ois.close();
		oos.close();
		Thread.sleep(100);
		}
	}
}