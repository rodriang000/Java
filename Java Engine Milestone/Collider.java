import edu.nd.cse.paradigms.*;

abstract class Collider
{
  protected PEEngine engine;

  public Collider(PEEngine engine)
  {
    this.engine = engine;
  }

 public abstract void processCollision(Bullet b, Enemy e);
  
 public void processCollision(PEWorldObject wo1, PEWorldObject wo2)
  {
   if (wo1 instanceof Player && wo2 instanceof Enemy)
     engine.remove(wo1);
   if (wo1 instanceof Bullet && wo2 instanceof Enemy)
   {
     processCollision((Bullet) wo1, (Enemy) wo2);
     engine.remove(wo1);
   }
  }

}
