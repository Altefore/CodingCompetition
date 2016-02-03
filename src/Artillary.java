/**
 * 
 */

/**
 * @author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public abstract class Artillary extends Actor
{	 
	public Artillary(Game parentGame, Sprite sprite, int x, int y, double xSpeed, double ySpeed) {
		super(parentGame, sprite, x, y, xSpeed, ySpeed);
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		if(getY() < 0 || getY() > Game.gameDimensions.getHeight())
		{
			getGame().removeActor(this);
		}
		
	}

}
