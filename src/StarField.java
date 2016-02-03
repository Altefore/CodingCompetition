import java.awt.Graphics;
import java.util.ArrayList;

/**
 * 
 */

/**
 * @author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public class StarField {
	private Game game;
	
	private ArrayList<BigStar> bigStars;
	private ArrayList<SmallStar> smallStars;
	
	private ArrayList<BigStar> bigRemoveList;
	private ArrayList<SmallStar> smallRemoveList;
	
	private final int SMALLSTARDELAY = 400;
	private final int BIGSTARDELAY = 300;
	
	private long timeOfLastSmallStar;
	private long timeOfLastBigStar;
	
	public StarField(Game parentGame)
	{
		game = parentGame;
		
		bigStars = new ArrayList<BigStar>();
		smallStars = new ArrayList<SmallStar>();
		
		bigRemoveList = new ArrayList<BigStar>();
		smallRemoveList = new ArrayList<SmallStar>();
		
		timeOfLastSmallStar = 0;
		timeOfLastBigStar = 0;
	}
	
	public void update(long delta)
	{
		long currentTime = System.currentTimeMillis();
		
		for(SmallStar ss : smallStars)
		{
			ss.update();
			ss.move(delta);
			if(ss.getY() > Game.gameDimensions.getHeight())
			{
				smallRemoveList.add(ss);
			}
		}
		
		for(BigStar bs : bigStars)
		{
			bs.update();
			bs.move(delta);
			if(bs.getY() > Game.gameDimensions.getHeight())
			{
				bigRemoveList.add(bs);
			}
		}
		
		for(SmallStar ss : smallRemoveList)
		{
			smallStars.remove(ss);
		}
		smallRemoveList.clear();
		
		for(BigStar bs : bigRemoveList)
		{
			bigStars.remove(bs);
		}
		bigRemoveList.clear();
		
		
		if(currentTime - timeOfLastSmallStar > SMALLSTARDELAY)
		{
			if (game.gameBeingPlayed)
				smallStars.add(new SmallStar(game));
			if (!game.gameBeingPlayed)
				smallStars.add(new SmallStar(game,1));
			timeOfLastSmallStar = currentTime;
		}
		
		if(currentTime - timeOfLastBigStar > BIGSTARDELAY)
		{
			if (game.gameBeingPlayed)
				bigStars.add(new BigStar(game));
			if (!game.gameBeingPlayed)
				bigStars.add(new BigStar(game,1));
			timeOfLastBigStar = currentTime;
		}
	}
	
	public void draw(Graphics g)
	{
		for(SmallStar ss : smallStars)
		{
			ss.draw(g);
		}
		
		for(BigStar bs : bigStars)
		{
			bs.draw(g);
		}
	}
}
