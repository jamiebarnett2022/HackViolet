package adventureGame;

import java.util.ArrayList;

import processing.core.PApplet;

public class AllTogetherNow extends PApplet{

	Tile[][] farmland = new Tile[3][3];
	
	OptionList options = new OptionList(this, 25, 35);
	
	private boolean colorTile = false;
	private boolean colorOption = false;
	private boolean text = false;
	
	private Tile clickedOnTile = null;

	
	public static void main(String[] args) 
	{
		PApplet.main("adventureGame.AllTogetherNow");

	}
	public void settings()
	{
		size(500, 500);
	}
	public void setup()
	{
		background(194, 230, 193);
		
		setPlot();
		
		options.addOption(new Option(this, "carrot"));
		options.addOption(new Option(this, "radish"));

	}
	public void draw()
	{
		background(194, 230, 193);
		
		drawPlot();
		
		if(text)
		{
			fill(255, 185, 180);
			noStroke();
				
			rect(10, 5, 175, (options.getTotalOptions() * 20 + 20), 7);
				
			fill(0);
			stroke(1);
			text("What do you want to plant? ", 14, 16);
			
			options.drawOptions();
		}
	}
	public void drawPlot()
	{
		for(Tile[] row: farmland)
		{
			for(Tile t: row)
			{
				t.drawTile();
			}
		}
	}
	public void setPlot()
	{
		for(int i = 0; i < farmland.length; i++)
		{
			for(int x = 0; x < farmland[0].length; x++)
			{
				farmland[i][x] = new Tile(this, 300 + (i * 50), 300 + (x * 50), 186, 155, 91);
			}
		}
	}

	public void mouseClicked()
	{
		System.out.println(mouseX);
		System.out.println(mouseY);
		
	//Checks to see if any Tiles are clicked; if so, darkens color and sets text to true
		for(int i = 0; i < farmland.length; i++)
		{
			for(int x = 0; x < farmland[0].length; x++)
			{
				if(farmland[i][x].isClicked(mouseX, mouseY))
				{
					colorTile = !colorTile;
					
					clickedOnTile = farmland[i][x];
					
					farmland[i][x].changeColor(colorTile);
										
					text = !text;
					
				}

				farmland[i][x].drawTile();
			}
		}
		
	//Checks to see it any of the options are clicked; if so, darkens the color of selected option, and places the plant
		ArrayList<Option> ops = options.getArrayOptions();
		
		for(Option o: ops)
		{
			if(o.isClicked(mouseX, mouseY))
			{
				colorOption = !colorOption;
				
				if(!colorOption)
				{
					o.changeColor(255 - 25, 185 - 25, 180 - 25);
					
					clickedOnTile.placePlant(o.getAction());
				}
				else
					o.changeColor(255, 185, 180);
			}

		}

		
		

	}
}

