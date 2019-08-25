package kunal;

/**
 * Created by kunal on 22-10-2017.
 */
public class OperationsAfterLoginThread extends Thread
{
    @Override
    public void run()
    {
        OperationsAfterLogin operationsAfterLogin=new OperationsAfterLogin();
        operationsAfterLogin.addBalance();
    }
}
