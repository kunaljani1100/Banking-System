package kunal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kunal on 22-10-2017.
 */
public class UserAccount {
    private String name;
    private String password;
    private int accountBalance;
    public void createNewAccount()
    {
        String recievedName="";
        String recievedPassword="";
        String message;
        try
        {
            ServerSocket serverSocket=new ServerSocket(4600);
            Socket socket=serverSocket.accept();
            BufferedReader getMessage=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sendDetails=new PrintWriter(socket.getOutputStream(),true);
            recievedName=getMessage.readLine();
            recievedPassword=getMessage.readLine();
            message="Account has been created.";
            sendDetails.println(message);
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
        this.name=recievedName;
        this.password=recievedPassword;
        this.accountBalance=0;
        try
        {
            BufferedWriter bufferedWriter=new BufferedWriter(new FileWriter(name+".txt",true));
            bufferedWriter.write(name+"\n");
            bufferedWriter.write(password+"\n");
            bufferedWriter.write(accountBalance+"\n");
            bufferedWriter.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}
