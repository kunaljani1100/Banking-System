package kunal;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;
import java.util.Scanner;

/**
 * Created by kunal on 22-10-2017.
 */
public class NewAccount {
    public void createNewAccount()
    {
        Scanner scanner=new Scanner(System.in);
        String name;
        String password;
        String confirmPassword;
        System.out.println("Enter name:");
        name=scanner.nextLine();
        System.out.println("Enter password:");
        password=scanner.nextLine();
        System.out.println("Confirm password:");
        confirmPassword=scanner.nextLine();
        if(!password.equals(confirmPassword))
        {
            System.out.println("The passwords do not match.");
            System.exit(-1);
        }
        else
        {
            try(Socket socket=new Socket("localhost",4600))
            {
                BufferedReader getMessage=new BufferedReader(new InputStreamReader(socket.getInputStream()));
                PrintWriter sendDetails=new PrintWriter(socket.getOutputStream(),true);
                sendDetails.println(name);
                sendDetails.println(password);
                System.out.println(getMessage.readLine());
            }
            catch(IOException e)
            {
                System.out.println("Not connected to the server.");
            }
        }
    }
}
