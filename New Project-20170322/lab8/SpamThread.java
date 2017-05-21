package lab8;

import java.util.Random;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by DDshka on 05.05.2017.
 */
public class SpamThread extends Thread
{
    public SpamThread()
    {
         start();
    }

    private AtomicInteger counter = new AtomicInteger(0);

    @Override
    public void run()
    {
        ProcessorImitation pi = new ProcessorImitation();
        for (int i = 0; i < 10; i++)
        {
            try
            {
                pi.giveOp(() -> test(), 1+(int) (Math.random() * 2));
            } catch (Exception e) {e.printStackTrace();}
        }
    }

    public void test()
    {
        System.out.println("PROCESS " + counter.incrementAndGet() + " IS RUNNING");

    }
}
