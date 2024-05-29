import java.io.*;
import java.net.*;
import java.util.*; 
public class ServeCalc {
   public static void main(String args[]) throws IOException {
      // establishing the socket connection
      ServerSocket Serve = new ServerSocket(6666);
      Socket sock = Serve.accept();
      // to send and receive data through streams
      DataInputStream inpStrm = new DataInputStream(sock.getInputStream());
      DataOutputStream outpStrm = new DataOutputStream(sock.getOutputStream());
      try {
         while (true) {
            // reading input from client
            int oprtr = inpStrm.readInt();
            System.out.println("Client has requested for " + oprtr + " operation");
            int res = 0;
            int data1 = 15;
            int data2 = 5;
            switch(oprtr) {
	            case 1 : 
	               res = data1 + data2;
                  outpStrm.writeUTF(Integer.toString(res));
		            break;
	            case 2 :
		            res = data1 - data2;
                  outpStrm.writeUTF(Integer.toString(res));
		            break;
	            case 3 :
		            res = data1 * data2;
                  outpStrm.writeUTF(Integer.toString(res));
		            break;
	            case 4 :
		            res = data1 / data2;
                  outpStrm.writeUTF(Integer.toString(res));
		            break;
	            default :
		         outpStrm.writeUTF(" You have given invalid choice! ");
		            break; 
            }
            System.out.println("Result sent to the client...");
         }
      }
      // to handle exception
      catch(Exception exp) {
         System.out.println(exp);
      } 
   }
}