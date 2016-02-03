import java.util.ArrayList;
/**
 * 
 * @author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public abstract class FlightController {
	public ArrayList<Enemy> ships;
	protected static int xSpeed = 100;
	protected static double mainY = 0;
	protected static double yIncrement = 0;
	protected double yOffset;
	public boolean isActive = false;
	public boolean isPaused = false;

	public FlightController() {
		ships = new ArrayList<Enemy>();
		yOffset = 0.0;
		isActive = false;
		isPaused = false;
	}
	
	
	
	@SuppressWarnings("unchecked")
	public void addShips(ArrayList<Enemy> enemyShips)
	{
		ships.clear();
		ships = (ArrayList<Enemy>) enemyShips.clone();
	}
	
	public void setYOffset(double offset)
	{
		this.yOffset = offset;
	}

	public void update(long delta)
	{
	
	}

	public void go() {
		isActive = true;
	}
	
	public void pause()
	{
		isPaused = true;
	}
	
	public void unPause()
	{
		isPaused = false;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<Enemy> getShips()
	{
		return (ArrayList<Enemy>) ships.clone();
	}
}