import edu.nd.cse.paradigms.*;
import java.lang.Math;

public class Bullet extends PESquare
{
  protected PEEngine engine;

  int targetX;
  int targetY;
  int rate = 5;

  public Bullet(PEEngine engine)
  {
    this.engine = engine;
  }
  
  public void setTarget(int x, int y) 
  {
  targetX = x;
  targetY = y;
  }

  public void tick() 
  {
     /* Find the distance */
    int currX = getX();
    int currY = getY();

    int disX = currX - targetX;
    int disY = currY - targetY;
   
    int absdisY = java.lang.Math.abs(currY);
    int absdisX = java.lang.Math.abs(currX);
     /* If x is -, go + */
     if (disX < 0) {
	if (absdisX + rate >= targetX)
		currX = targetX;
	else
		currX += rate;
     }

     else { /* x is +, go - */
	if (absdisX - rate <= targetX)
		currX = targetX;
	else
		currX -= rate;
     }
     
     if(disY < 0) {
	if (absdisY + rate >= targetY)
		currY = targetY;
	else
		currY += rate;
     }

     else {
	if (absdisY - rate <= targetY)
		currY = targetY;
	else
		currY -= rate;
     } 
     

     /* set the new position */
     setCenter(currX, currY);
   
     /* Check if at target, if so, delete. */
     /*if ((currX == targetX) && (currY == targetY))
	     engine.remove(this.Bullet()); */
     
  }

  public boolean destroy()
  {
	  if ((getX() == targetX) && (getY() == targetY))
		  return true;
	  else
		  return false;
  }
}
