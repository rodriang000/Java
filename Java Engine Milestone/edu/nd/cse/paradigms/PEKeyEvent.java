package edu.nd.cse.paradigms;
import java.awt.event.KeyEvent;

public class PEKeyEvent extends PEEvent
{
	private KeyEvent keyEvent;
	public static final int VK_W = 87;
	public static final int VK_S = 83;
	public static final int VK_D = 68;
	public static final int VK_A = 65;
	public static final int VK_DOWN = 40;
	public static final int VK_RIGHT = 39;
	public static final int VK_UP = 38;
	public static final int VK_LEFT = 37;
	public static final int VK_SPACE = 32;

	public PEKeyEvent(KeyEvent awtKeyEvent)
	{
	//	System.out.println("In PEKeyEvent");
		/* Set this KeyEvent */
		this.keyEvent = awtKeyEvent;
	}

	public int getKeyCode()
	{
		return this.keyEvent.getKeyCode();
	}
}
	
