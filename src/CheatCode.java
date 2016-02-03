import java.lang.String;
/**
 * @author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public class CheatCode {

	private String code;

	private Game game;
	

	public CheatCode(Game g,String s)
	{
	game=g;
	code=s;
    
    
	checkCode(); //campares entered code to valid cheat codes.	
	}
	private void checkCode()
	{

					if(0==code.compareTo("klife")) // checks for adding life code
					{
						Game.playerLives = 3;
						
					}
					else if(0==code.compareTo("kscoe")) //checks for add constant value to score
					{
						game.addScore(250);
						game.setCode("");
					    
					}
					else if (0==code.compareTo("k777"))  //rolling score adds 50
					{
						game.addScore(50);
						
					}
					else if (0==code.compareTo("kfast")) // speeds up laser fire rate
					{
					Player.setFireTime(50); 
					
					game.setCode("");
					}
					else if(0==code.compareTo("kslow")) // sets fire rate to starting speed
					{
					Player.setFireTime(250);
					game.setCode("");
					}
					else if(code.length()>=5) //sets invalid code attempts back to 0
					{
						game.setCode("");
					}
						
				
				
	}
	
}
