
import java.util.concurrent.Executors;
public class TestVisibility
{
	public static void main(String[] args)
	{
		// volatileCount();
		count();
        
	}

	private static volatile int volatileCount = 0;
    private static void volatileCount() 
    {
        for (int i = 0; i < 10; i ++) 
        {
            Executors.newFixedThreadPool(3).execute(() -> 
            {
                try 
                {
                    Thread.sleep(100);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " volatile count: " + ++volatileCount);
            });
        }
    }

    private static int count = 0;
    private static void count() 
    {
        for (int i = 0; i < 10; i ++) 
        {
            Executors.newFixedThreadPool(3).execute(() -> 
            {
                try 
                {
                    Thread.sleep(100);
                } 
                catch (InterruptedException e) 
                {
                    e.printStackTrace();
                }
                System.out.println(Thread.currentThread().getName() + " count: " + ++ count);
            });
        }
    }
}