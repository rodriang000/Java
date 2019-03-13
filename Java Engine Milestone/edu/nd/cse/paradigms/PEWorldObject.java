package edu.nd.cse.paradigms;

import java.lang.Object;

abstract public class PEWorldObject extends Object
{
	protected int x;
	protected int y;
	protected int color;

	public PEWorldObject(){
	}

	public abstract int getSize();
	public abstract boolean inObjectBoundry(int fx, int fy);

	public void setCenter(int x, int y)
	{
		this.x = x;
		this.y = y;
	}

	public void setColor(int color)
	{
		this.color = color;
	}

	public int getX()
	{
		return this.x;
	}

	public int getY()
	{
		return this.y;
	}

	public abstract void tick();
	public abstract void render(PEScreen screen);
}


