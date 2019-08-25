package kunal;

import java.util.Scanner;

/**
 * Created by kunal on 22-10-2017.
 */
public class MenuAfterLogin {
    public void runMenuAfterLogin()
    {
        Balance balance=new Balance();
        Scanner scanner=new Scanner(System.in);
        int choice=0;
        while(choice!=4)
        {
            System.out.println("Enter your choice:");
            System.out.println("1.Deposit");
            System.out.println("2.Withdraw");
            System.out.println("3.Transfer");
            System.out.println("Press any number other than 1,2 or 3 to exit.");
            choice = scanner.nextInt();
            if(choice==1)
            {
                balance.addBalance();
            }
            else if(choice==2)
            {
                balance.subtractBalance();
            }
            else if(choice==3)
            {
                balance.transferMoney();
            }
            else
            {
                System.exit(0);
            }
        }
    }
}
