import java.awt.Graphics;

// TODO add sprite member variable with getters, setters, and mutators
// TODO add functionality to draw entity (assign sprite in constructors, set visibility, manipulate sprite, draw to screen)

/**
 * Represents every object in the game that is capable of being displayed and interacted with
 * 
 * @author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public abstract class Entity {
	/******************************************************
	 * Member variables                                   *
	 ******************************************************/

	/**
	 * the unique id associated with this entity
	 */
	private int id;
	/**
	 * the last id given to an entity
	 */
	private static int lastId;
	/**
	 * the x coordinate of the entity
	 */
	private double x;
	/**
	 * the y coordinate of the entity
	 */
	private double y;
	/**
	 * the sprite displayed for this entity
	 */
	private Sprite sprite;
	
	private Game game;
	
	/******************************************************
	 * Constructors                                       *
	 ******************************************************/
	
	/**
	 * construct a new entity with a given name and location (0,0)
	 * @param entityName the name to assign the new entity
	 */
	public Entity(Game parentGame)
	{
		sprite = null;
		id = ++lastId;
		x = 0;
		y = 0;
		game = parentGame;
	}
	
	/**
	 * construct a new entity with a given name, sprite, and location (0,0)
	 * @param entityName the name to assign the new entity
	 * @param entitySprite the sprite to assign to this entity
	 */
	public Entity(Game parentGame, Sprite entitySprite)
	{
		this(parentGame);
		sprite = entitySprite;
	}
	
	/**
	 * construct a new entity with a given name and location
	 * @param entityName the name to assign the new entity
	 * @param entitySprite the sprite to assign to this entity
	 * @param xPosition the x position to assign the new entity
	 * @param yPosition the y position to assign the new entity
	 */
	public Entity(Game parentGame, Sprite entitySprite, double xPosition, double yPosition)
	{
		this(parentGame, entitySprite);
		x = xPosition;
		y = yPosition;
	}
	
	/******************************************************
	 * Getters                                            *
	 ******************************************************/

	/**
	 * get the unique id of the entity
	 * @return the unique id of the entity
	 */
	public int getId(){return id;}
	/**
	 * get the x coordinate of the entity
	 * @return the x coordinate of the entity
	 */
	public double getX(){return x;}
	/**
	 * get the y coordinate of the entity
	 * @return the y coordinate of the entity
	 */
	public double getY(){return y;}
	/**
	 * get the sprite from the entity
	 * @return the entities sprite
	 */
	public Sprite getSprite(){return sprite;}
	/**
	 * return the game that contains the entity
	 * @return the game that contains the entity
	 */
	public Game getGame(){return game;}
	
	/******************************************************
	 * Setters                                            *
	 ******************************************************/
	
	/**
	 * set the x coordinate of the entity
	 * @param xPosition the x coordinate to assign to the entity
	 */
	public void setX(double xPosition)
	{
		x = xPosition;
	}
	
	/**
	 * set the y coordinate of the entity
	 * @param yPosition the y coordinate to assign to the entity
	 */
	public void setY(double yPosition)
	{
		y = yPosition;
	}
	
	
	/**
	 * set the x and y coordinates of the entity
	 * @param xPosition the x coordinate to assign to the entity
	 * @param yPosition the y coordinate to assign to the entity
	 */
	public void setLocation(double xPosition, double yPosition)
	{
		setX(xPosition);
		setY(yPosition);
	}
	
	public void setSprite(Sprite entitySprite)
	{
		sprite = entitySprite;
	}
	
	/**
	 * perform any actions required between draws
	 */
	public abstract void update();
	
	public void draw(Graphics g)
	{
		sprite.draw(g, (int)getX(), (int)getY());
	}
	
	/**
	 * set the sprite associate with the entity
	 * @param entitySprite the sprite to assign to the entity
	 */
	//TODO:Might have to have two seperate setLocation functions, one for X and one for Y
	// -Jonathan
	/*
	 *public void setLocationX(double xPosition){
	 * 	setX(xPosition);
	 *}
	 *public void setLocationX(double yPosition){
	 *	setY(yPosition);
	 *}
	 */
}
