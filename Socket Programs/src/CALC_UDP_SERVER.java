import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.StringTokenizer;
//client server in UDP as a calculator

public class CALC_UDP_SERVER
{
   public static void main(String ad[]) throws IOException
   {
	 DatagramSocket ds = new DatagramSocket(1234);
	 byte[] buf = null; 
     DatagramPacket DpReceive = null; 
     DatagramPacket DpSend = null; 
     
	 while(true)
	 {
	  buf = new byte[65535];
	  	 
      // create a DatgramPacket to receive the data.
	  DpReceive = new DatagramPacket(buf,buf.length);
	  ds.receive(DpReceive);
	  
	  String inp = new String(buf,0,buf.length);
	  
	  inp=inp.trim();
	  System.out.print("Equation Received:- " + inp);
	  
	  // Exit the server if the client sends "bye" 
      if (inp.equals("bye")) 
      { 
          System.out.println("Client sent bye.....EXITING"); 
          break; 
      } 

      
      int result;
      
      StringTokenizer st = new StringTokenizer(inp);
      int oprnd1 = Integer.parseInt(st.nextToken());
      String operation = st.nextToken();
      int oprnd2 = Integer.parseInt(st.nextToken());
      
      
      // perform the required operation. 
      if (operation.equals(" + ")) 
          result = oprnd1 + oprnd2; 

      else if (operation.equals(" - ")) 
          result = oprnd1 - oprnd2; 

      else if (operation.equals(" * ")) 
          result = oprnd1 * oprnd2; 

      else
          result = oprnd1 / oprnd2;
      
      System.out.println("Sending the result");
      String res = Integer.toString(result);
      // Clear the buffer after every message. 
      buf = res.getBytes(); 

      // get the port of client. 
      int port = DpReceive.getPort(); 

      DpSend = new DatagramPacket(buf, buf.length, 
                    InetAddress.getLocalHost(), port); 
      ds.send(DpSend);	 
	 }
	 ds.close();
	   
   }
}