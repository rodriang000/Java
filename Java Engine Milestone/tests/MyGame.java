import edu.nd.cse.paradigms.*;

import java.util.List;
import java.util.ArrayList;

public class MyGame extends PEGame
{
	private PESquare square;
	private PECircle circle;
	protected PEEngine engine;
	

	public void start()
	{
		engine = new PEEngine(this);
		square = new PESquare();
		circle = new PECircle();

		square.setCenter(200,200);
		square.setColor(0xFFFFFF);
		square.setSize(25);
		engine.add(square);

		circle.setCenter(300,300);
		circle.setColor(0xFFFFFF);
		circle.setSize(40);
		engine.add(circle);
	}

	public void tick()
	{
	}

	public void collisionDetected(List<PEWorldObject> worldObects)
	{
	}

	public void keyPressed(int keycode)
	{
		int x = square.getX();
		int y = square.getY();

		switch(keycode)
		{
			case PEKeyEvent.VK_DOWN:
				y += 5;
				break;
			case PEKeyEvent.VK_RIGHT:
				x += 5;
				break;
		}
		square.setCenter(x, y);
	}
}

