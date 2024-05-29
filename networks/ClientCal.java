import java.io.*;
import java.net.*;
import java.util.*;
public class ClientCal {
   public static void main(String[] args) throws IOException {
      // fetching address of localhost
      InetAddress addr = InetAddress.getLocalHost();
      Scanner inp = new Scanner(System.in);
      // establishing socket connection
      Socket sock = new Socket(addr, 6666);
      // to send and receive data through streams
      DataInputStream inpStrm = new DataInputStream(sock.getInputStream());
      DataOutputStream outpStrm = new DataOutputStream(sock.getOutputStream());
      try {
         while (true) {
            System.out.println("Type 1 for Addition");
		   System.out.println("Type 2 for Subtraction");
		   System.out.println("Type 3 for Multiplication");
		   System.out.println("Type 4 for Division");
            System.out.println("Enter your choice: ");
            int oprtr = inp.nextInt();
            // Type 0 for cut the connection
            if (oprtr == 0) {
               break;
            }
            // sending the operator for operation
            outpStrm.writeInt(oprtr); 
            // reading result from server
            String res = inpStrm.readUTF();
            System.out.println("Your Result for the given operation = " + res);
         }
      }
      // to handle exception
      catch(Exception exp) {
         System.out.println(exp);
      } 
   }
}