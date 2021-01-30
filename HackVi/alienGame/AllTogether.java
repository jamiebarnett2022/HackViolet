package alienGame;

import processing.core.PApplet;
import processing.core.PImage;

public class AllTogether extends PApplet{
	
	private Tile[][] grid;
	private MainCharacter mc;
	
	private Tile clickedTile;

	public static void main(String[] args) {
		
		PApplet.main("alienGame.AllTogether");

	}
	public void settings()
	{
		size(1000, 1000);
	}
	public void setup()
	{
		grid = new Tile[10][10];
		
		clickedTile = null;
		
		mc = new MainCharacter(this, 800, 800);
		
		makeTiles();
	}
	public void draw()
	{
		background(0); 
		drawTiles();
		
		if(clickedTile != null && (mc.getX() != clickedTile.getX() || mc.getY() != clickedTile.getY()))
		{
			mc.moveTo(clickedTile.getX(), clickedTile.getY());
		}
		
		mc.draw();

	}
	
	public void makeTiles()
	{
		for(int x = 0; x < 10; x++)
		{
			for(int y = 0; y < 10; y++)
			{
				
				grid[x][y] = new Tile(this, x * 100, y * 100);
				
			}
		}
	}
	
	public void drawTiles()
	{
		for(Tile[] row : grid)
		{
			for(Tile t : row)
			{
				t.draw();
			}
		}
	}
	
	public void mouseClicked()
	{
//		System.out.println(mouseX + ", " + mouseY);
		
		boolean isClicked;
		
		for(Tile[] row : grid)
		{
			for(Tile t : row)
			{
				isClicked = t.isClicked(mouseX, mouseY);
				
				if(isClicked)
				{
					t.changeClicked();
					
					clickedTile = t;
					
					if()
					{
						
					}
					
				}
			}
		}
	}
			
}
