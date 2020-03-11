
import java.util.concurrent.Executors;
public class TestOrderly
{
	public static void main(String[] args)
	{
		synchronizedCount();

	}

	private static int synchronizedCount = 0;
    private static void synchronizedCount()
    {
        for(int i = 0; i < 10; i ++)
        {
            Executors.newFixedThreadPool(3).execute(() ->
            {
                // 通过 synchronized 关键字来保证线程之间的有序性
                synchronized(TestOrderly.class)
                {
                    System.out.println(Thread.currentThread().getName() + " synchronized count : " + ++ synchronizedCount);
                }
            });
        }
    }




}