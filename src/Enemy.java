import java.util.Random;
 /**
  * 
  * @author Zach Williamson, Erik Cole, Jonathan Light
  *
  */
public abstract class Enemy extends Actor{
	
	protected int score = 0;
	Random random = new Random();
	public boolean isDead;
	protected double multiplier;
	
	public Enemy (Game game, Sprite sprite , int x, int y){
		
		super (game, sprite, x, y);
		isDead = false;
		multiplier = 1;
		
	}
	
	public double getMultiplier()
	{
		return multiplier;
	}
	
	@Override
	public void collidedWith(Actor other) {
		// TODO Auto-generated method stub
		
		if(other instanceof Missle)
		{
			//getGame().SoundController.playExplosion();
			getGame().SoundController.playDeath("Short");
			getGame().addActor(new Explosion(getGame(), getX(), getY()));
			
			getGame().removeActor(this);
			isDead = true;
			Game.enemyCount--;
			getGame().addScore(score);
		}
		
		if(other instanceof Player){
			getGame().removeActor(this);
			Game.enemyCount--;
		}
		
	}
	
	public void tryToFireFast(long fireTime ){
		if (this != null){
			getGame().addActor(new EnemyMissle(getGame(),getX()+getSprite().getWidth()/2-4,getY()+40));
			
			//timeSinceFire = FIRETIME;
		}
	}
	
	public void tryToFireSlow(long fireTime ){
		if (this != null){
			getGame().addActor(new EnemySlowFire(getGame(),getX()+getSprite().getWidth()/2-4,getY()+40));
			
			//timeSinceFire = FIRETIME;
		}
	}
}
