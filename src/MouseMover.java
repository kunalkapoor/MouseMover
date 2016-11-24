

import java.awt.*;
import java.util.*;

public class MouseMover implements Runnable
{
	boolean finished = false;
	@Override
	public void run() 
	{
		Robot rob = null;
		try
		{
			rob = new Robot();
		 
	    	Random random = new Random();
	    	while(finished == false)
	    	{
	    		int x = random.nextInt() % 640;
	    		int y = random.nextInt() % 480;
	    		rob.mouseMove(x,y);
	    		Thread.sleep(1000*90);
	    	}
		}
		catch (Exception e) 
		{
			e.printStackTrace();
		}
	}
	
	public void start()
	{
		finished = false;
	}
	
	public void stop()
	{
		finished = true;
	}
}