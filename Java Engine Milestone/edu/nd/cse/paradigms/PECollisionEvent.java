package edu.nd.cse.paradigms;

import java.util.List;
import java.util.ArrayList;

public class PECollisionEvent extends PEEvent
{
	private List<PEWorldObject> myList = new ArrayList<PEWorldObject>();


	public PECollisionEvent(PEWorldObject wo1, PEWorldObject wo2)
	{
		this.myList.add(wo1);
		this.myList.add(wo2);
	}

	public List<PEWorldObject> getWorldObjects()
	{
		return this.myList;
	}
}

