package kunal;

import java.util.Scanner;

/**
 * Created by kunal on 22-10-2017.
 */
public class MenuBeforeLogin
{
    public void runMenuBeforeLogin()
    {
        Scanner scanner=new Scanner(System.in);
        int choice=0;
        while(choice!=3)
        {
            System.out.println("Enter your choice:");
            System.out.println("1.Create new account");
            System.out.println("2.Login using existing account.");
            System.out.println("Press any number other than 1 or 2 to exit.");
            choice = scanner.nextInt();
            if(choice==1)
            {
                NewAccount newAccount=new NewAccount();
                newAccount.createNewAccount();
            }
            else if(choice==2)
            {
                LoginPage loginPage=new LoginPage();
                loginPage.login();
            }
            else
            {
                System.exit(0);
            }
        }
    }
}
