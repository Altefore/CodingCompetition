import java.util.Random;
/**
 * 
 * @author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public class Star extends Actor{
	
	Random random = new Random();
	
	public Star(Game parentGame) {
		super(parentGame, SpriteStore.getInstance().getSprite("images/galaga_star_sprite.png"), 0, 0);
		this.setX(random.nextInt(Game.gameDimensions.width - 20));
		this.setYSpeed(250+random.nextInt(250));
		
	}
	public Star(Game parentGame , int i) {
		super(parentGame, SpriteStore.getInstance().getSprite("images/galaga_star_sprite.png"), 0, 0);
		this.setX(random.nextInt(Game.gameDimensions.width - 20));
		this.setYSpeed(250+random.nextInt(250));
		
	}

	@Override
	public void doLogic() {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void collidedWith(Actor other) {
		if(other instanceof Actor)
		{
			//TODO:add logic for passing behind sprite
		
		}
	}

	public void update() {
		// TODO Auto-generated method stub
		if(getY() > 800)
		{
			getGame().removeActor(this);
		}
		
	}
	
}
