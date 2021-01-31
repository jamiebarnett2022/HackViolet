package adventureGame;

import processing.core.PApplet;

public class Tile {
	/**
	 * Draws a 2D array of specified length 
	 * Places plants on specified tiles
	 * 
	 */
	
	private PApplet p;
	
	private int x, y;
	
	private final int size = 50;
	
	private int red, green, blue;
	
	private boolean plantTruth;
	
	private String plant;
	
	public Tile(PApplet parent, int x, int y, int r, int g, int b) 
	{
		p = parent;
		
		this.x = x;
		this.y = y;
		
		red = r;
		green = g;
		blue = b;
		
		plantTruth = false;
		
		plant = "";
	}
	
	/**
	 * draws the Tile
	 */
	public void drawTile()
	{
		p.fill(red, green, blue);
		
		p.rect(x, y, size, size);
		
		if(plantTruth)
		{
			if(plant.equals("carrot"))
			{
				p.fill(240, 180, 25);
				p.ellipse((int)(x + (0.5 * size)), (int)(y + (0.5 * size)), 20, 20);
			}
			else if(plant.equals("radish"))
			{
				p.fill(175, 20, 75);
				p.ellipse((int)(x + (0.5 * size)), (int)(y + (0.5 * size)), 20, 20);
			}
		}
		
	} 

	/**
	 * checks to see if the tile has been clicked
	 */
	public boolean isClicked(int mouseX, int mouseY)
	{
		if((mouseX > x && mouseX < x + size) && (mouseY > y && mouseY < y + size))
			return true;
		else
			return false;
	}
	/**
	 * checks to see if there is a plant on the tile
	 */
	public boolean hasPlant()
	{
		return plantTruth;
	}
	public void placePlant(String plant)
	{
		plantTruth = true;
		
		this.plant = plant;
	}
	
	/**
	 * darkens or lightens color of soil
	 * @param b
	 */
	public void changeColor(boolean b)
	{
		if(b)
		{
			red = 133;
			green = 110;
			blue = 62;
			
		}
		else
		{ 
			red = 186;
			green = 155;
			blue = 91;
		}

	}

}


