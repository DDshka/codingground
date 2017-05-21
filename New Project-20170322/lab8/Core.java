package lab8;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Created by DDshka on 05.05.2017.
 */
public class Core extends Thread
{
    private Thread operationThread = new Thread();
    private final List<Runnable> operations = new ArrayList<>();
    private String name = "";

    public Core(String name)
    {
        this.name = name;
        System.out.println(name + " created");
        this.start();
    }

    public void giveOperation(Runnable operation)
    {
        operations.add(operation);
    }

    public boolean isBusy()
    {
        return operationThread.isAlive();
    }

    @Override
    public void run()
    {
        while (true)
        {
            if (operations.size() > 0 && !operationThread.isAlive())
            {
                operationThread = new Thread(() ->
                {
                    System.out.println(name + " is handling operation...");
                    operations.get(0).run();
                    /*try
                    {
                        //Thread.sleep(new Random().nextInt(10)*1000);
                    }
                    catch (InterruptedException e) {e.printStackTrace();}
*/
                    System.out.println(name + " is free");
                    operations.remove(0);
                });
                operationThread.start();
            }
            try
            {
                Thread.sleep(0);
            }
            catch (Exception e) {}
        }
    }
}
