package kunal;

import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * Created by kunal on 22-10-2017.
 */
public class OperationsAfterLogin {
    public void addBalance()
    {
        String increment;
        int amount;
        String readBalance="0";
        try(ServerSocket serverSocket=new ServerSocket(4602))
        {
            Socket socket = serverSocket.accept();
            BufferedReader getMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sendDetails = new PrintWriter(socket.getOutputStream(), true);
            increment = getMessage.readLine();
            amount = Integer.parseInt(increment);

            BufferedReader reader = new BufferedReader(new FileReader(OperationBeforeLogin.getUserName() + ".txt"));
            readBalance = reader.readLine();
            readBalance = reader.readLine();
            readBalance = reader.readLine();
            reader.close();

            int currentBalance = Integer.parseInt(readBalance);
            currentBalance=currentBalance+amount;
            boolean success=new File(OperationBeforeLogin.getUserName()+".txt").delete();
            BufferedWriter writer = new BufferedWriter(new FileWriter(OperationBeforeLogin.getUserName() + ".txt",true));
            writer.write(OperationBeforeLogin.getUserName()+"\n");
            writer.write(OperationBeforeLogin.getPassword()+"\n");
            writer.write(currentBalance+"\n");
            writer.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void subtractBalance()
    {
        String increment;
        int amount;
        String readBalance="0";
        try(ServerSocket serverSocket=new ServerSocket(4603))
        {
            Socket socket = serverSocket.accept();
            BufferedReader getMessage = new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sendDetails = new PrintWriter(socket.getOutputStream(), true);
            increment = getMessage.readLine();
            amount = Integer.parseInt(increment);
            BufferedReader reader = new BufferedReader(new FileReader(OperationBeforeLogin.getUserName() + ".txt"));
            readBalance = reader.readLine();
            readBalance = reader.readLine();
            readBalance = reader.readLine();
            reader.close();

            int currentBalance = Integer.parseInt(readBalance);
            if(currentBalance<amount)
            {
                return;
            }
            currentBalance=currentBalance-amount;
            boolean success=new File(OperationBeforeLogin.getUserName()+".txt").delete();

                BufferedWriter writer = new BufferedWriter(new FileWriter(OperationBeforeLogin.getUserName() + ".txt",true));
                writer.write(OperationBeforeLogin.getUserName()+"\n");
                writer.write(OperationBeforeLogin.getPassword()+"\n");
                writer.write(currentBalance+"\n");
                writer.close();

        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
    public void transferMoney()
    {
        String receiver;
        String amount;
        int amountToBeTransferred;
        String senderBalance="";
        int currentSenderBalance;
        String receiverBalance="";
        int currentReceiverBalance;
        String receiverPassword="";
        try(ServerSocket serverSocket=new ServerSocket(4604))
        {
            Socket socket=serverSocket.accept();
            BufferedReader getMessage=new BufferedReader(new InputStreamReader(socket.getInputStream()));
            PrintWriter sendDetails=new PrintWriter(socket.getOutputStream(),true);
            receiver=getMessage.readLine();
            amount=getMessage.readLine();
            amountToBeTransferred=Integer.parseInt(amount);

            BufferedReader reader=new BufferedReader(new FileReader(OperationBeforeLogin.getUserName()+".txt"));
            senderBalance=reader.readLine();
            senderBalance=reader.readLine();
            senderBalance=reader.readLine();
            reader.close();

            currentSenderBalance=Integer.parseInt(senderBalance);
            if(amountToBeTransferred>currentSenderBalance)
            {
                return;
            }
            currentSenderBalance=currentSenderBalance-amountToBeTransferred;
            boolean success=new File(OperationBeforeLogin.getUserName()+".txt.").delete();
            try
            {
                BufferedWriter writer = new BufferedWriter(new FileWriter(OperationBeforeLogin.getUserName() + ".txt",true));
                writer.write(OperationBeforeLogin.getUserName()+"\n");
                writer.write(OperationBeforeLogin.getPassword()+"\n");
                writer.write(currentSenderBalance+"\n");
                writer.close();
            }
            catch(IOException e)
            {
                e.printStackTrace();
            }

            reader=new BufferedReader(new FileReader(receiver+".txt"));
            receiverBalance=reader.readLine();
            receiverPassword=reader.readLine();
            receiverBalance=reader.readLine();
            reader.close();

            currentReceiverBalance=Integer.parseInt(receiverBalance);
            currentReceiverBalance=currentReceiverBalance+amountToBeTransferred;
            boolean success1=new File(receiver+".txt.").delete();

            BufferedWriter writer = new BufferedWriter(new FileWriter(receiver + ".txt",true));
            writer.write(receiver+"\n");
            writer.write(receiverPassword+"\n");
            writer.write(currentReceiverBalance+"\n");
            writer.close();
        }
        catch(IOException e)
        {
            e.printStackTrace();
        }
    }
}

