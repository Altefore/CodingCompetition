
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;
import java.net.UnknownHostException;
/*
 * 
 * game.scoreServer.sendData("400");
		System.out.println("HighScore " + game.scoreServer.read());
 * 
 * 
 * 
 * 
 */

/**
 * This class contains code to create a client and a GUI for requesting files from a server
 * 
 * @author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public class HighScoreServerClient{
	/**
	 * this object is the object stream that the client uses to send data to the server
	 */
	private ObjectOutputStream output;
	/**
	 * this object is the object stream that the client uses to receive data from the server 
	 */
	private ObjectInputStream input;
	/**
	 * this variable stores messages to be sent to the server
	 */
	@SuppressWarnings("unused")
	private String message = "";
	/**
	 * this variable stores the name of the server
	 */
	@SuppressWarnings("unused")
	private String fileServer;
	/**
	 * this object stores the socket on which communication with the server occurs
	 */
	private Socket socket;
	
	@SuppressWarnings("unused")
	private boolean running;
	
	public static void main(String[] args)
	{
		try {
			HighScoreServerClient scoreServer = new HighScoreServerClient(InetAddress.getLocalHost().getHostName());
			System.out.println("Client Read: " + scoreServer.read());
			scoreServer.closeConnection();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	
	
	/**
	 * this constructor initializes the client using the name of the server to connect to 
	 * 
	 * @param host the name (location) of the server to connect to
	 * @throws IOException 
	 * @throws UnknownHostException 
	 */
	public HighScoreServerClient(String host) throws UnknownHostException, IOException
	{		
		fileServer = host;
		socket = new Socket(InetAddress.getByName(host), 10005);
		
		System.out.println("Client: trying to get streams");
		
		output = new ObjectOutputStream(socket.getOutputStream());
		output.flush();
		input = new ObjectInputStream(socket.getInputStream());
		
		System.out.println("client: got streams");
	}
	
	public String read()
	{
		try {
			String message = (String)input.readObject();
			return message;
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return null;
	}
	
	public void sendData(String message)
	{
		try
		{
			output.writeObject(message);
			output.flush();
		}
		catch(IOException ioExcpetion)
		{
			ioExcpetion.printStackTrace();
		}
	}
	
	private void closeConnection()
	{	
		try
		{
			output.close();
			input.close();
			socket.close();
		}
		catch(IOException ioException)
		{
			ioException.printStackTrace();
		}
	}
	
}
