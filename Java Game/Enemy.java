import edu.nd.cse.paradigms.*;

public class Enemy extends PESquare
{
  protected PEEngine engine;
  
  int tick = 0;
  int rate = 10;

  int startX;
  int startY;
  
  int posX;
  int posY;

  int endX;
  int endY;

  public Enemy(PEEngine engine)
  {
    this.engine = engine;
  }

  public void startCenter(int x, int y)
  {
     startX = x;
     startY = y;
     posX = x;
     posY = y;
  }

  public void endCenter(int x, int y)
  {
     endX = x;
     endY = y;
  }

  public void tick()
  { // TODO: Maybe expand in diretions, right now only care about Y axis.
  if (tick > 2){
     if (posY != endY) {

	     /* If start y is greater, go lower */
	     if (posY > endY){
		     posY-= rate;
	     }
	     else
	     {
		     posY+= rate;
	     }

     }

     else /* They are equal, swap values and move once */
     { 
	     int temp1 = startY;
	     int temp2 = endY;

	     endY = temp1;
	     startY = temp2;

	     posY = startY; //Neccesary? Maybe. //

	     if (posY > endY)
		     posY -= rate;
	     else
		     posY += rate;

     }

     /* Set new center */
     setCenter(posX,posY);
     tick = 0;
  } 
  else 
    {
    tick++;
    }	
  
  }

}
