package adventureGame;

import processing.core.PApplet;

public class Option {

	private boolean clicked;
	
	private PApplet p;
	
	private String action;
	
	private int x, y, r, g, b;
	
	public Option(PApplet parent, String action) 
	{
		clicked = false;
		
		p = parent;
		
		r = 255;
		b = 184;
		g = 179;
		
		this.action = action;
		
	}
	public String getAction()
	{
		return action;
	}
	
	public void drawOption(int xcoor, int ycoor)
	{
		p.fill(r, g, b);
//		p.fill(0);
		p.noStroke();
		
		p.rect(x - 5, y - 10, 175 - x, 15, 7);
		
		p.fill(0);
		p.stroke(1);
		p.text(action, xcoor, ycoor);
		
		x = xcoor;
		y = ycoor;
	}
	public boolean isClicked(int mouseX, int mouseY)
	{
		int size = 15;
		
		
		
		if((mouseX > x && mouseX < x + (175 - x)) && (mouseY > y - 10 && mouseY < y + size))
			return true;
		else
			return false;
	}
	public void changeColor(int r, int b, int g)
	{
		this.r = r;
		this.b = b;
		this.g = g;
		
	}

}


