import edu.nd.cse.paradigms.*;

public class HardCollider extends Collider
{

  int i = 0;

  public HardCollider(PEEngine engine)
  {
    super(engine); // Call parent constructor
  }

  public void processCollision(Bullet b, Enemy e)
  { 
  System.out.println("HIT!");
  i++;
  if (i == 3)
	  engine.remove(e);
  if (i == 2)
	  e.setColor(0xdb8080);
  else
	  e.setColor(0xed4040);
  }
}
