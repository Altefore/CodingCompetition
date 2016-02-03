/**
 * 
 */

/**
 * @author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public class EnemySlowFire extends Artillary{
	private static Sprite frame1 = SpriteStore.getInstance().getSprite("images/galaga_enemy_missle21_sprite.png");
	private static Sprite frame2 = SpriteStore.getInstance().getSprite("images/galaga_enemy_missle22_sprite.png");
	private static Sprite frame3 = SpriteStore.getInstance().getSprite("images/galaga_enemy_missle23_sprite.png");
	private static Sprite frame4 = SpriteStore.getInstance().getSprite("images/galaga_enemy_missle24_sprite.png");
	private final int DURATION = 1000;
	
	public EnemySlowFire(Game parentGame, double x, double y) {
		super(parentGame, frame1, (int)x, (int)y, 0, 100);
		// TODO Auto-generated constructor stub
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collidedWith(Actor other) {
		// TODO Auto-generated method stub
		
	}
	
	@Override
	public void update() {
		if(System.currentTimeMillis() % DURATION < DURATION/6)
		{
			setSprite(frame2);
		}
		else if(System.currentTimeMillis() % DURATION < DURATION/3)
		{
			setSprite(frame3);
		}
		else if(System.currentTimeMillis() % DURATION < DURATION/2)
		{
			setSprite(frame4);
		}
		else if(System.currentTimeMillis() % DURATION < (DURATION*2)/3)
		{
			setSprite(frame3);
		}
		else if(System.currentTimeMillis() % DURATION < (DURATION*5)/6)
		{
			setSprite(frame2);
		}
		else
		{
			setSprite(frame1);
		}
		
		super.update();
	}

}
