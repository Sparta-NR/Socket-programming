
import java.io.*;
import java.net.*;
import java.util.*;

public class CLIENT_TCP 
{
  public static void main(String ar[]) throws IOException
  {
	  int number,temp;
	  
	  Scanner sc = new Scanner(System.in);    //to take input from user
	  Socket cl = new Socket("localhost",1236);   //creating socket
	  Scanner sc1 = new Scanner(cl.getInputStream());  //take data from server
	  
	  System.out.print("Enter 5 numbers");
	
	  number = sc.nextInt();    
	  PrintStream ob = new PrintStream(cl.getOutputStream()); //convert data to stream tp send to server
	  ob.println(number);  //send data to server using print stream object
	  
	  temp = sc1.nextInt();
	  System.out.println(temp);  
	  
	  cl.close();
	  sc1.close();
  } 
}
