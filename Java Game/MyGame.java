import edu.nd.cse.paradigms.*;

import java.util.List;
import java.util.ArrayList;

public class MyGame extends PEGame
{
  protected PEEngine engine;
  private Collider collider;
  private Player player;
  private Enemy enemy1;
  private Enemy enemy2;
  private Target target;
  private Bullet bullet;

  public void start()
  {
  engine = new PEEngine(this);
  
  collider = new MediumCollider(engine);
  player = new Player(engine); 
  target = new Target(engine);
  enemy1 = new Enemy(engine);
  enemy2 = new Enemy(engine);
  

  /* Set up player */
  player.setRadius(25);
  player.setCenter(25,25);
  player.setColor(0xFFFFFF);
  engine.add(player);

  /* Set up target */
  target.setCenter(300,300);
  target.setSize(10);
  target.setColor(0x740977);
  engine.add(target);

  /* Set up enemy 1*/
  enemy1.setCenter(600,100);
  enemy1.startCenter(600,100);
  enemy1.endCenter(600, 430);  
  enemy1.setSize(50);

  engine.add(enemy1);

  /*Set up enemy 2*/
  enemy2.setCenter(400,400);
  enemy2.startCenter(400,400);
  enemy2.endCenter(400, 100);
  enemy2.setSize(30);

  engine.add(enemy2);
  }

  public void tick()
  {
	  try {
		if (bullet.destroy() == true)
			engine.remove(bullet);
	  }

	  catch(java.lang.NullPointerException e)
	  {} 


  }

  public void collisionDetected(List<PEWorldObject> worldObjects)
  {
  int i =  0;
  for (PEWorldObject w0: worldObjects)
    {
    collider.processCollision(w0, worldObjects.get(i^1));
    i++;
    }
  }

  public void keyPressed(int keycode)
  {
  int playerX = player.getX();
  int playerY = player.getY();

  int targetX = target.getX();
  int targetY = target.getY();

  switch(keycode)
  {
    /*set up the arrow keys for player*/
    case PEKeyEvent.VK_DOWN:
	playerY += 5;
	break;
    case PEKeyEvent.VK_LEFT:
	playerX -= 5;
	break;
    case PEKeyEvent.VK_RIGHT:
        playerX += 5;
        break;
    case PEKeyEvent.VK_UP:
	playerY -= 5;
        break;
    /*Set up the WASD for target */
    case PEKeyEvent.VK_W:
    	targetY -= 5;
        break;
    case PEKeyEvent.VK_S:
	targetY += 5;
        break;
    case PEKeyEvent.VK_A:
	targetX -= 5;
	break;
    case PEKeyEvent.VK_D:
	targetX += 5;
	break;
    /*Set up for if they press the space button */
    case PEKeyEvent.VK_SPACE:
	bullet = new Bullet(engine);
	
	bullet.setCenter(playerX,playerY);
  	bullet.setSize(5);
  	bullet.setColor(0x15f4f4);
  	bullet.setTarget(targetX, targetY);

	engine.add(bullet);
	break;
	/* create projectile */

  }
  
  target.setCenter(targetX, targetY);
  player.setCenter(playerX, playerY);
  }
}

