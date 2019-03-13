package edu.nd.cse.paradigms;


public class PESquare extends PEWorldObject{

	private int size;


	public PESquare()
	{}

	public void tick()
	{
	}

	public void setSize(int size)
	{
		this.size = size;
	}

	public int getSize()
	{
		return this.size;
	} //

	public void render(PEScreen screen)
	{
		int xPosition = getX();
		int yPosition = getY();

		int yMin = yPosition - this.size/2;
		int yMaximum = yPosition + this.size/2;
		int xMinimum = xPosition - this.size/2;
		int xMax = xPosition + this.size/2;

		for (int i = xMinimum; i < xMax; i++)
		{
			for(int j = yMin; j < yMaximum; j++)
			{
				screen.setPixel(i, j, color);
			}
		}

	}

	public boolean inObjectBoundry(int qx, int qy)
	{
	if ((getX() == qx) && (getY() == qy))
		return true;
	else
	{
		int xPosition = getX();
		int yPosition = getY();
		int yMin = yPosition - this.size/2;
		int yMaximum = yPosition + this.size/2;
		int xMinimum = xPosition - this.size/2;
		int xMax = xPosition + this.size/2;

		for (int i = xMinimum; i < xMax; i++)
		{
			for(int j = yMin; j < yMaximum; j++)
			{
				if ((i == qx) && (j == qy))
					return true;
			}
		}

	
	}
	return false;
	}

}

