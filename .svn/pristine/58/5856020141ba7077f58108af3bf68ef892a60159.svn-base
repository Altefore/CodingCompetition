
import javax.sound.sampled.*;

import java.io.IOException;
import java.net.URL;

/**
 * Allows for sound to be played by calling the member function for the desired sound 
 * @author Zach Williamson, Erik Cole, Jonathan Light
 *
 */
public class PlaySound {
	private Clip sound;
	private boolean mute;
	/**
	 * Constructor set if sound is on or off
	 *
	 */
	public PlaySound(boolean b) //constructor sets sound on or off
	{	
		mute = b;
	}
	public void mute() // toggles sound on or off
	{
		mute=!mute;
	}
	public boolean getMute() // returns mute status
	{
		return mute;
	}
	/**
	 * Plays fire sound
	 *
	 */
	public void playFire() //plays fire sound
	{ 
		if(mute==true)
		{
		URL url=getClass().getClassLoader().getResource("sound/Laser.wav");
		if(url == null)
		{
			fail("Can't Find Ref: ");
		}
		getSound(url);
		sound.setFramePosition(0);
		sound.start();
		}
	}
	/**
	 * Plays Intro sound
	 *
	 */
	public void playIntro() //plays sound 
	{
		if(mute==true)
		{
		URL url=getClass().getClassLoader().getResource("sound/Intro.wav");
		if(url == null)
		{
			fail("Can't Find Ref: ");
		}
		getSound(url);
		sound.setFramePosition(0);
		sound.start();
		}
	}
	/**
	 * Plays Destruction sound
	 * Plays a short and longer version
	 */
	public void playDeath(String s) //plays death sound 
	{
		if(mute==true)
		{
		URL url=getClass().getClassLoader().getResource("sound/Death.wav");
		if(url == null)
		{
			fail("Can't Find Ref: ");
		}
		getSound(url);
		if (s=="Short")
		{
		sound.setFramePosition(40000);
		}
		else
		{
		sound.setFramePosition(25000);
		}
		sound.start();
		}
	}
	/**
	 * The function that opens the audio stream and loads the clip
	 * @param url of resource to load.  
	 *
	 */
	private void getSound(URL url) // loads clip 
	{
		try {
			AudioInputStream soundIn =AudioSystem.getAudioInputStream(url);
			sound = AudioSystem.getClip();
			sound.open(soundIn);
		} catch (UnsupportedAudioFileException | IOException
				| LineUnavailableException e) {
			e.printStackTrace();
		}
	
	}
	/**
	 * Plays a Fail message  if loading doesnt work
	 * @param String of  error message to print.
	 */
	private void fail(String message) {
		// failed to load error message
	
		System.err.println(message);
		System.exit(0);
	}	
}
