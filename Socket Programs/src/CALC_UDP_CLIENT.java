import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.Scanner;
class CALC_UDP_CLIENT
{
  public static void main(String[] args) throws IOException
  {
	  Scanner sc = new Scanner(System.in);
	  
	  DatagramSocket ds = new DatagramSocket();
	  
	  InetAddress ip = InetAddress.getLocalHost(); 
      byte buf[] = null; 

      // loop while user not enters "bye" 
      while(true)
      {
    	  System.out.print("Enter the equation in the format:"); 
          System.out.println("'operand1 operator operand2'"); 
          String inp = sc.nextLine(); 
          buf = new byte[65535]; 
          
          
       // convert the String input into the byte array. 
          buf = inp.getBytes(); 

          // Step 2:Create the datagramPacket for sending the data. 
          DatagramPacket DpSend = 
                    new DatagramPacket(buf, buf.length, ip, 1234); 

          // invoke the send call to actually send the data. 
          ds.send(DpSend); 

          // break the loop if user enters "bye" 
          if (inp.equals("bye")) 
              break; 

          buf = new byte[65535];
          DatagramPacket DpReceive = 
                               new DatagramPacket(buf, buf.length); 
          ds.receive(DpReceive); 

          System.out.println("Answer = " + 
                              new String(buf,0,buf.length)); 
          
      }	  
	  
  }
  




}
