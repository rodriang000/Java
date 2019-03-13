package edu.nd.cse.paradigms;

import java.util.ArrayList;
import java.awt.Color;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class PEEngine extends Frame implements KeyListener
{
    protected PEGame game;
    protected PEScreen screen;
    protected PECentralClock clock;
    protected int width = 640;
    protected int height = 480;
    protected int titlebarHeight = 0;
    ArrayList<PEWorldObject> list;
    Queue<PEEvent> queue;
    int counter = 0;
    
    public PEEngine(PEGame game)
    {
        this.game = game;
        this.screen = new PEScreen(width, height);

        addKeyListener(this);
        setSize(width, height);
        setVisible(true);
        
        clock = new PECentralClock(this, 100);
        this.list = new ArrayList<PEWorldObject>();
        this.queue = new LinkedList<PEEvent>();
    }
    
    private void processEvent(PEKeyEvent evt)
    {
        this.game.keyPressed(evt.getKeyCode());
    }

    private void processEvent(PECollisionEvent evt){
	    this.game.collisionDetected(evt.getWorldObjects());
    }

    private void eventLoopIterate()
    {
        PEEvent pEvent = this.queue.poll();
        
	while(pEvent != null)
        {
            if (pEvent instanceof PEKeyEvent)
            {
                this.processEvent((PEKeyEvent)pEvent);
            } 
	    else if (pEvent instanceof PECollisionEvent)
	    {
	    	this.processEvent((PECollisionEvent)pEvent);
	    }
            pEvent = this.queue.poll();
        }
    }

    public void keyPressed(KeyEvent evt)
    {
        this.queue.add(new PEKeyEvent(evt));
    }

    public void keyReleased(KeyEvent evt)
    {
    }

    public void keyTyped(KeyEvent evt)
    {
    }

    public void add(PEWorldObject wo)
    {
        this.list.add(wo);
    }

    public void remove(PEWorldObject wo)
    {
        this.list.remove(wo);
    }

    public boolean detectCollision(PEWorldObject wo1, PEWorldObject wo2)
    {
	    if (wo1 instanceof PESquare){
		/* Loop through square pixels */
          	int xPosition = wo1.getX();
		int yPosition = wo1.getY();
		int yMin = yPosition - wo1.getSize()/2;
		int yMaximum = yPosition + wo1.getSize()/2;
		int xMinimum = xPosition - wo1.getSize()/2;
		int xMax = xPosition + wo1.getSize()/2;

		for (int i = xMinimum; i < xMax; i++)
		{
			for(int j = yMin; j < yMaximum; j++)
			{
			   if (wo2.inObjectBoundry(i,j) == true)
				   return true;
			}
		}

	    }
	    else if (wo1 instanceof PECircle){
		    /*Loop through circle pixels */
		    //System.out.println("It's a circle");
		for (int fy = -wo1.getSize(); fy <= wo1.getSize(); fy++)
                	for(int fx = -wo1.getSize(); fx <= wo1.getSize(); fx++)
                        	if (fx*fx + fy*fy <= wo1.getSize() * wo1.getSize())
					if (wo2.inObjectBoundry(wo1.getX()+fx, wo1.getY() +fy))
						return true;

	    }
	    return false;
    }


    public void tick()
    {
	/* Check collisions */
	//System.out.println(this.list.size());
	if (counter == 5)
	{
		int i = 0;
		for (PEWorldObject wo: this.list)
		{
			System.out.println(wo);
			if (detectCollision(wo, this.list.get(i^1)) == true)
			{
				System.out.println("In detectCollision");
        			this.queue.add(new PECollisionEvent(wo, this.list.get(i^1)));
			}
			i++;
		}
		eventLoopIterate();
		counter = 0;
	}

	/* Update every world object */
        for (int index = 0; index < this.list.size(); index++)
        {
            this.list.get(index).tick();
        }

        screen.clear();

	/* Render world objects */
        for (int index = 0; index < this.list.size(); index++)
        {
            screen.renderWorldObject(list.get(index));
        }

        repaint();
        
        counter++;
    }
    
    public void update(Graphics g)
    {
        this.paint(g);
    }

    public void paint(Graphics g)
    {
        g.drawImage(screen.render(), 0, titlebarHeight, width, height, Color.BLACK, null);
    }
}
