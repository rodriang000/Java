package edu.nd.cse.paradigms;


public class PECircle extends PEWorldObject{

	private int size;


	public PECircle()
	{}

	public void tick()
	{
	}

	public void setRadius(int radius)
	{
		this.size = radius;
	}


	public int getSize()
	{
		return this.size;
	}

	public void render(PEScreen screen)
	{
	/* Formula taken from StackOverflow */
	/* Brute force method */
	/* https://stackoverflow.com/questions/1201200/fast-algorithm-for-drawing-filled-circles */
	for (int fy = -this.size; fy <= this.size; fy++)
		for(int fx = -this.size; fx <= this.size; fx++)
			if (fx*fx + fy*fy <= this.size * this.size)
				screen.setPixel(getX()+fx, getY() + fy, this.color);
	}

	public boolean inObjectBoundry(int qx, int qy) 
	{
	
		if ((getX() == qx) && (getY() == qy))
			return true;
		else
		{
		for (int fy = -this.size; fy <= this.size; fy++)
			for(int fx = -this.size; fx <= this.size; fx++)
				if (fx*fx + fy*fy <= this.size * this.size)
					if ( (getX() + fx == qx) && (getY() + fy == qy) )
						return true;
	
		}

		return false;
	}

}

