package alienGame;

import processing.core.PApplet;

import processing.core.PImage;


public class MainCharacter {

	private int locX, locY;
	private PApplet parent;
	
	public MainCharacter(PApplet p, int x, int y) 
	{
		locX = x;
		locY = y;
		
		parent = p;
	}
	public void draw()
	{
		PImage character = parent.loadImage("alienGame/dorkSpace.png");
		
		character.resize(200, 200);
		
		parent.image(character, locX, locY);
	}
	
	public void moveTo(int intx, int inty)
	{
		
		int x = intx ;
		int y = inty ;
		
		double xDist = locX - x;
		double yDist = locY - y;
		
		int rate = 25;
		
		double averageX = xDist/rate;
		double averageY = yDist/rate;
		
		System.out.println("go To: " + x + ", " +  y);
		System.out.println("now: " + locX + ", " +  locY);
		System.out.println("xyDist: " + xDist + ", " +  yDist);
		System.out.println("averageXY: " + averageX + ", " +  averageY);
		System.out.println(" ");
		
		
			locX -= averageX;
			locY -= averageY;
		
	}
	
	public int getX()
	{
		return locX;
	}
	public int getY()
	{
		return locY;
	}

}
