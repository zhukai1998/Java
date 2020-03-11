import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.Executors;
public class TestAtomicity
{
	public static void main(String[] args)
	{
		atomicCount();
		// count();
	}

	private static AtomicInteger atomicCount = new AtomicInteger(0);
    private static void atomicCount() 
    {
        for (int i = 0; i < 10; i++) 
        {
        	// 固定大小的线程池：同时可以处理[参数]个任务。多余的任务会排队
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
                // atomicCount.incrementAndGet()方法的意思是让其自增 1，等同于++
                System.out.println(Thread.currentThread().getName() + " atomic count: " + atomicCount.incrementAndGet());
            });
        }
    }

    private static int count = 0;

    private static void count()
    {
    	for(int i = 0; i < 10; i ++)
    	{
    		// 固定大小的线程池：同时可以处理[参数]个任务。多余的任务会排队
    		Executors.newFixedThreadPool(3).execute(() ->
    		{
    			try
    			{
    				Thread.sleep(100);
    			}
    			catch(InterruptedException e)
    			{
    				e.printStackTrace();
    			}
    			System.out.println(Thread.currentThread().getName() + " count : " + (++ count));
    		});
    	}
    }
}