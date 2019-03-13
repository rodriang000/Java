import edu.nd.cse.paradigms.*;

public class MediumCollider extends Collider
{
 
  int i = 0;

  public MediumCollider(PEEngine engine)
  {
    super(engine); // Call parent constructor
  }

  public void processCollision(Bullet b, Enemy e) //TODO: Change color, see if dead, if not change color and add tick.
  {
  System.out.println("HIT!");
  i++;
  if (i == 2)
	  engine.remove(e);
  else    
	  e.setColor(0xed4040);
  }
}
