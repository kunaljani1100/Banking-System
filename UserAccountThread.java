package kunal;

/**
 * Created by kunal on 22-10-2017.
 */
public class UserAccountThread extends Thread
{
    @Override
    public void run()
    {
        UserAccount userAccount=new UserAccount();
        userAccount.createNewAccount();
    }
}
