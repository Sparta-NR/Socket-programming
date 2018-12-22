import java.io.*;
import java.net.*;
import java.util.*;
public class CLIENT_UDP
{
	//every packet should know where it is going
	public static void main(String afa[]) throws IOException
	{
	  DatagramSocket ds = new DatagramSocket();
	  int i=8;
	  byte[] b = (i+" ").getBytes();//converting to byte form to send data
	  InetAddress ia = InetAddress.getLocalHost();
	  DatagramPacket dp = new DatagramPacket(b,b.length,ia,1234); //sending data to server
	  
	  byte[] b1 = new byte[1024];
	  DatagramPacket dp1 = new DatagramPacket(b,b.length); //receiving data do not mention other 
	  ds.receive(dp1);//receiving data from socket
	  
	  String str = new String(dp1.getData());
	  System.out.print(str);
	  
	  ds.close();
	}
}
