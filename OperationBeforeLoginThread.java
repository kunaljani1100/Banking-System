package kunal;

/**
 * Created by kunal on 22-10-2017.
 */
public class OperationBeforeLoginThread extends Thread
{
    @Override
    public void run()
    {
        OperationBeforeLogin operationBeforeLogin=new OperationBeforeLogin();
        operationBeforeLogin.checkLoginDetails();
    }
}
