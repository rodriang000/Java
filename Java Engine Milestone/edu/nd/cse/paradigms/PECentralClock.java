package edu.nd.cse.paradigms;
import java.util.Timer;
import java.util.TimerTask;

public class PECentralClock extends TimerTask{
	
	private PEEngine engine;

	public PECentralClock(PEEngine engine, int rate)
	{
		this.engine = engine;

		Timer timer = new Timer();
		timer.scheduleAtFixedRate(this,0,rate);
	}

	public void run(){
		this.engine.tick();
	}
}
