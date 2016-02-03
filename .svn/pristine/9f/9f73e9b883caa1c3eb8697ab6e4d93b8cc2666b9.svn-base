import java.util.Random;

/**
 * @author Zach Williamson, Erik Cole, Jonathan Light
 */
public class EnemyMissle extends Artillary{

	private Random random;

	public EnemyMissle(Game parentGame) {
		super(parentGame, SpriteStore.getInstance().getSprite("images/galaga_enemy_missle_sprite.png"), 0, 0, 0, 0);
		random = new Random();
	}
	
	public EnemyMissle(Game parentGame, double x, double y)
	{
		this(parentGame);
		this.setLocation(x, y);
		this.setXSpeed((double)(30-random.nextInt(60)));
		this.setYSpeed((double)(280-random.nextInt(60)));
		//getGame().SoundController.playFire();
	}

	public EnemyMissle(Game parentGame, double x, double y , double ySpeed) // only used by boss
	{
		this(parentGame);
		this.setLocation(x, y);
		this.setXSpeed((double)(30-random.nextInt(60)));
		this.setYSpeed(ySpeed);
		getGame().SoundController.playFire();
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collidedWith(Actor other) {
		if(other instanceof Player)
		{
			getGame().removeActor(this);
		}
		
	}

	@Override
	public void update() {
		// TODO Auto-generated method stub
		
	}
	
}
