import java.io.IOException; 
import java.net.DatagramPacket; 
import java.net.DatagramSocket; 
import java.net.InetAddress; 
import java.util.StringTokenizer; 
  
public class Calc_Server_UDP 
{ 
    public static void main(String[] args) throws IOException 
    { 
        // Create a socket to listen at port 1234 
        DatagramSocket ds = new DatagramSocket(9898); 
        byte[] buf = null; 
        DatagramPacket DpReceive = null; 
        DatagramPacket DpSend = null; 
        while (true) 
        { 
            buf = new byte[65535]; 
  
            // create a DatgramPacket to receive the data. 
            DpReceive = new DatagramPacket(buf, buf.length); 
  
            // receive the data in byte buffer. 
            ds.receive(DpReceive); 
  
            String inp = new String(buf, 0, buf.length); 
  
            //To remove extra spaces. 
            inp=inp.trim(); 
            System.out.println("Equation Received:- " + inp); 
  
            // Exit the server if the client sends "bye" 
            if (inp.equals("bye")) 
            { 
                System.out.println("Client sent bye.....EXITING"); 
                break; 
            } 
  
            int result; 
  
            // Use StringTokenizer to break the 
            // equation into operand and operation 
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
  
            System.out.println("Sending the result..."); 
            String res = Integer.toString(result); 
  
            // Clear the buffer after every message. 
            buf = res.getBytes(); 
  
            // get the port of client. 
            int port = DpReceive.getPort(); 
  
            DpSend = new DatagramPacket(buf, buf.length, 
                          InetAddress.getLocalHost(), port); 
            ds.send(DpSend); 
        } 
    } 
}


/*	  DatagramSocket ds = new DatagramSocket(1234);
	  byte[] b1 = new byte[1024];
	  System.out.print("hello");
	  DatagramPacket dp =  new DatagramPacket(b1,b1.length);
	  ds.receive(dp);
	  
	  String str = new String(dp.getData(),0,dp.getLength());
	  int num = Integer.parseInt(str.trim());
	  System.out.print("hello"+num);
	  int res = num*num;
	  
	  byte[] b2 = String.valueOf(res).getBytes();
	  InetAddress ia = InetAddress.getLocalHost();
	  DatagramPacket dp1 = new DatagramPacket(b2,b2.length,ia,dp.getPort());
	  ds.send(dp1);
	  	
	  ds.close();*/
	   
	   

