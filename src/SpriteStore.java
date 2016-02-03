

import java.awt.GraphicsConfiguration;
import java.awt.GraphicsEnvironment;
import java.awt.Image;
import java.awt.Transparency;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URL;
import java.util.HashMap;

import javax.imageio.ImageIO;
/**
 * This class is used as a resouce manager for sprites
 * @author Zach Williamson, Erik Cole, Jonathan Light
 */
public class SpriteStore {

	private static SpriteStore single = new SpriteStore();
	/**
	 * gets a single instance of this class
	 * @return single the single instance
	 */
	public static SpriteStore getInstance(){
		return single;
	}
	
	private HashMap<String, Sprite> map = new HashMap<String, Sprite>();
	
	/**
	 * 
	 */
	public Sprite getSprite(String reference){
		
		if (map.get(reference)!=null){
			return (Sprite) map.get(reference);
		}
		BufferedImage sourceImage = null;
		try 
		{
			URL url = this.getClass().getClassLoader().getResource(reference);
		
			if(url == null)
			{
				fail("Can't Find Ref: "+reference);
			}
			sourceImage=ImageIO.read(url);
		}
		catch(IOException e){
			fail("Failed To load: "+ reference );
		}
		
		GraphicsConfiguration gc = GraphicsEnvironment.getLocalGraphicsEnvironment().getDefaultScreenDevice().getDefaultConfiguration();
		Image image = gc.createCompatibleImage(sourceImage.getWidth(),sourceImage.getHeight(),Transparency.BITMASK);
	
		image.getGraphics().drawImage(sourceImage,0,0,null);
	
		Sprite sprite = new Sprite(image);
		map.put(reference,sprite);
		return sprite;
	
	}
	
	private void fail(String message) {
		// we'n't available
		// we dump the message and exit the game

		System.err.println(message);
		System.exit(0);
	}
	
}
