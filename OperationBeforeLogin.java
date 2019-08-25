package kunal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kunal on 22-10-2017.
 */
public class OperationBeforeLogin
{
    private static String userName;
    private static String password;
    public void checkLoginDetails()
    {
        String recievedName;
        String recievedPassword;
        String extractedPassword;
        try
        {
            ServerSocket serverSocket=new ServerSocket(4601);
            Socket socket=serverSocket.accept();
            BufferedReader getMessage=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sendDetails=new PrintWriter(socket.getOutputStream(),true);
            recievedName=getMessage.readLine();
            recievedPassword=getMessage.readLine();
            userName=recievedName;
            password=recievedPassword;
            BufferedReader reader=new BufferedReader(new FileReader(recievedName+".txt"));
            extractedPassword=reader.readLine();
            extractedPassword=reader.readLine();
            if(!extractedPassword.equals(recievedPassword))
            {
                sendDetails.println("Wrong password.");
            }
            else
            {
                sendDetails.println("You have successfully logged in.");
                sendDetails.println(reader.readLine());
            }
            reader.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public static String getUserName()
    {
        return userName;
    }
    public static String getPassword()
    {
        return password;
    }
}
