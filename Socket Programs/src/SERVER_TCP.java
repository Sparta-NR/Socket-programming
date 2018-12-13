//client server model to double a number using TCP
import java.io.*;
import java.net.*;
import java.util.*;

public class SERVER_TCP 
{
  public static void main(String ar[]) throws IOException
  {
	  int number,temp;
	 
	  ServerSocket listen = new ServerSocket(1236);   //socket to listen to client
	  System.out.print("Server is listening.....");
	  Socket ss = listen.accept();  //accepts incoming requests
	  
	  Scanner sc = new Scanner(ss.getInputStream());  //accept data from client
	  number = sc.nextInt();
	  
	  temp =2*number;
	  PrintStream ob = new PrintStream(ss.getOutputStream()); //convert data to stream tp send to server
	  ob.println(temp);
	 
	  ss.close();
  }
}
