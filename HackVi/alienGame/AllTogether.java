package alienGame;

import processing.core.PApplet;
import processing.core.PImage;

public class AllTogether extends PApplet{
	
	private Tile[][] grid;
	
	private MainCharacter mc;
	private MainCharacter prologueMC;
	private MainCharacter oldMC;
	
	private Tile clickedTile;
	private boolean prelogue;
	
	private int wordKeys;

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
		
		prelogue = true;
		
		mc = new MainCharacter(this, 600, 500, "alienGame/dorkSpace.png");
		prologueMC = new MainCharacter(this, 600, 500, "alienGame/dork.png");
		oldMC = new MainCharacter(this, 300, 500, "alienGame/fred.png");
		
		wordKeys = 0;
		
		makeTiles();
	}
	public void draw()
	{
		background(0); 
		
		
		if(prelogue)
		{
			image(loadImage("alienGame/mars.png"), 0, 0);
			
			prologueMC.draw();
			
			oldMC.draw();
			
			writePrologue();
			
			System.out.println(wordKeys);
		}
		else
		{
			drawTiles();
			
			if(clickedTile != null && (mc.getX() != clickedTile.getX() || mc.getY() != clickedTile.getY()))
			{
				mc.moveTo(clickedTile.getX(), clickedTile.getY());
			}
			
			mc.draw();
		}
		

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

					
				}
			}
		}
	}
	
	public void keyPressed()
	{
		if(key == CODED)
		{
			if(keyCode == SHIFT)
			{
				prelogue = false;
			}
			if(keyCode == LEFT)
			{
				wordKeys--;
				
				System.out.println("left");
			}
			if(keyCode == RIGHT)
			{
				wordKeys++;
				
				System.out.println("right");
			}
		}
	}
	
	public void writePrologue()
	{
		if(wordKeys < 0)
		{
			wordKeys = 0;
		}
		else if(wordKeys == 1)
		{
			oldMC.say("hi there Dork!");
		}
		else if(wordKeys == 2)
		{
			mc.say("hey grandpa! whats up!");			
		}
		else if(wordKeys == 3)
		{
			oldMC.say("oh the same old.. you konw");
		}
		else if(wordKeys == 4)
		{
			oldMC.say("just thinking about humans");
		}
		else if(wordKeys == 5)
		{
			mc.say("classic gramps - so fascinated by humans");
		}
		else if(wordKeys == 6)
		{
			oldMC.say("i just feel like it would be so cool to actually see some human artifacts!");
		}
		else if(wordKeys == 7)
		{
			oldMC.say("like a... a.. baguette!! or.. or a piece of China!!");
		}
		else if(wordKeys == 8)
		{
			mc.say("you know what gramps? I'm visiting Earth next week!");
		}
		else if(wordKeys == 9)
		{
			mc.say("Maybe I can bring you some stuff back!!");
		}
		else if(wordKeys == 10)
		{
			oldMC.say("OH DORK THAT WOULD BE SO LOVELY!");
		}
		else if(wordKeys == 11)
		{
			mc.say("anything for you gramps <3");
		}
		else if(wordKeys > 12)
		{
			wordKeys = 12;
		}
	}
			
}
