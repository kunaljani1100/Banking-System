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
public class Balance {
    public void addBalance()
    {
        int amountToDeposit;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the amount that you want to deposit:");
        amountToDeposit=scanner.nextInt();
        try(Socket socket=new Socket("localhost",4602))
        {
            BufferedReader getMessage=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sendDetails=new PrintWriter(socket.getOutputStream(),true);
            sendDetails.println(Integer.toString(amountToDeposit));
        }
        catch(IOException e)
        {
            System.out.println("Not connected.");
        }
    }
    public void subtractBalance()
    {
        int amountToDeposit;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the amount that you want to remove:");
        amountToDeposit=scanner.nextInt();
        if(amountToDeposit>LoginPage.getBalance())
        {
            System.out.println("Insufficient balance!");
            return;
        }
        try(Socket socket=new Socket("localhost",4603))
        {
            BufferedReader getMessage=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sendDetails=new PrintWriter(socket.getOutputStream(),true);
            sendDetails.println(Integer.toString(amountToDeposit));
        }
        catch(IOException e)
        {
            System.out.println("Not connected.");
        }
    }
    public void transferMoney()
    {
        int amountToTransfer;
        String receiver;
        Scanner scanner=new Scanner(System.in);
        System.out.println("Enter the name of the receiver:");
        receiver=scanner.nextLine();
        System.out.println("Enter the amount that you want to transfer:");
        amountToTransfer=scanner.nextInt();
        if(LoginPage.getBalance()<amountToTransfer)
        {
            System.out.println("Insufficient balance.");
            return;
        }
        try(Socket socket=new Socket("localhost",4604))
        {
            BufferedReader getMessage=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sendDetails=new PrintWriter(socket.getOutputStream(),true);
            sendDetails.println(receiver);
            sendDetails.println(Integer.toString(amountToTransfer));
        }
        catch(IOException e)
        {
            System.out.println("Not connected.");
        }
    }
}
