import java.util.Random;
/**
 * 
 *@author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public class EnemyShipMedium extends Enemy{

	//private long timeSinceFire;
	//private final int FIRETIME = 150;
	//private int lastFire = 0;
	
	private static Sprite frame1 = SpriteStore.getInstance().getSprite("images/galaga_enemy21_sprite.png");
	private static Sprite frame2 = SpriteStore.getInstance().getSprite("images/galaga_enemy22_sprite.png");
	private static Sprite frame3 = SpriteStore.getInstance().getSprite("images/galaga_enemy23_sprite.png");
	private static Sprite frame4 = SpriteStore.getInstance().getSprite("images/galaga_enemy24_sprite.png");
	private static Sprite frame5 = SpriteStore.getInstance().getSprite("images/galaga_enemy25_sprite.png");
	private static Sprite frame6 = SpriteStore.getInstance().getSprite("images/galaga_enemy26_sprite.png");
	private final long DURATION = 2000;
	
	private int hits;
	
	Random random = new Random();
	
	public EnemyShipMedium (Game game, int x, int y){
		
		super(game, frame1, x,  y);
		//this.setXSpeed(Game.ENEMY_SPEED_X);

		//timeSinceFire = System.currentTimeMillis();
		
		score = 15;
		
		hits = 0;
	}
	/**
	 * move allows for the sprite to move back and fourth across the screen while not diving
	 */
	@Override
	public void move(long delta)
	{
		/*
		if(getX() >= Game.gameDimensions.width - 50 || getX() <= 50){
			
			this.setXSpeed(-this.getXSpeed());
			this.setY(this.getY() + 10);
		}
		
		if (this.getY() > 800) {
			//TODO:get actor to reappear at the top of the screen
		}
		*/
		super.move(delta);
	}
	@Override
	public void doLogic() {
		// TODO Auto-generated method stub
		
		
	}

	@Override
	public void update() {
		
		if(System.currentTimeMillis() % DURATION < DURATION/4)
		{
			if(hits == 0)
			{	
				setSprite(frame1);
			}
			if(hits == 1)
			{
				setSprite(frame4);
			}
		}
		else if (System.currentTimeMillis() % DURATION < DURATION*2/4)
		{
			if(hits == 0)
			{	
				setSprite(frame2);
			}
			if(hits == 1)
			{
				setSprite(frame5);
			}
		}
		else if (System.currentTimeMillis() % DURATION < DURATION*3/4)
		{
			if(hits == 0)
			{	
				setSprite(frame1);
			}
			if(hits == 1)
			{
				setSprite(frame4);
			}
		}
		else
		{
			if(hits == 0)
			{	
				setSprite(frame3);
			}
			if(hits == 1)
			{
				setSprite(frame6);
			}
		}
	}
	
	@Override
	public void collidedWith(Actor other) {
		// TODO Auto-generated method stub
		
		if(other instanceof Missle)
		{
			if(hits == 0)
			{
				hits = 1;
			}
			else if(hits == 1)
			{
				getGame().SoundController.playDeath("Short");
				getGame().addActor(new Explosion(getGame(), getX(), getY()));
			
				getGame().removeActor(this);
				isDead = true;
				Game.enemyCount--;
				getGame().addScore(score);
			}
		}
		
		if(other instanceof Player){
			getGame().removeActor(this);
			Game.enemyCount--;
			getGame().addScore(score);
		}
		
	}
}
