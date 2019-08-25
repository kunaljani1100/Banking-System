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
public class LoginPage {
    private static int balance;
    public void login()
    {
        String name;
        String password;
        String message;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter name:");
        name=scanner.nextLine();
        System.out.println("Enter password:");
        password=scanner.nextLine();
        try(Socket socket=new Socket("localhost",4601))
        {
            BufferedReader getMessage=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sendDetails=new PrintWriter(socket.getOutputStream(),true);
            sendDetails.println(name);
            sendDetails.println(password);
            message=getMessage.readLine();
            System.out.println(message);
            String recievedBalance=getMessage.readLine();
            balance=Integer.parseInt(recievedBalance);
            System.out.println("Current balance:"+balance);
            if(message.equals("Wrong password."))
            {
                System.exit(-1);
            }
            else
            {
                MenuAfterLogin menuAfterLogin=new MenuAfterLogin();
                menuAfterLogin.runMenuAfterLogin();
            }
        }
        catch(IOException e)
        {
            System.out.println("Not connected.");
        }
    }
    public static int getBalance()
    {
        return balance;
    }
}
//encriypt password using one way hash like md5
//thread naming convention