package kunal;

/**
 * Created by kunal on 22-10-2017.
 */
public class MultipleThreads {
    public void runMultipleThreads()
    {
        UserAccountThread userAccountThread =new UserAccountThread();
        userAccountThread.start();
        OperationBeforeLoginThread operationBeforeLoginThread =new OperationBeforeLoginThread();
        operationBeforeLoginThread.start();
        OperationsAfterLoginThread operationsAfterLoginThread =new OperationsAfterLoginThread();
        operationsAfterLoginThread.start();
        OperationsAfterLoginSubtractThread thread4=new OperationsAfterLoginSubtractThread();
        thread4.start();
        TransferThread transferThread =new TransferThread();
        transferThread.start();
    }
}
