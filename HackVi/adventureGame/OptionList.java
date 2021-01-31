package adventureGame;

import java.util.ArrayList;

import processing.core.PApplet;

public class OptionList {
	
	private PApplet p;

	private int x, y, total;
	
	private ArrayList<Option> options;
	/**
	 * Creates an options list of actions the player can perform
	 * 
	 * @param x: xcoor of where list would start
	 * @param y: ycoor of where list would start
	 */
	public OptionList(PApplet p, int x, int y) 
	{
		this.p = p;
		this.x = x;
		this.y = y;
		
	    options = new ArrayList<Option>();
		
		total = 0;
	}
	/**
	 * 
	 * @param o: option that is added to the list
	 */
	public void addOption(Option o)
	{
		options.add(o);
		
		total++;
	}
	/**
	 * 
	 * @param o: option that is removed from the list
	 */
	public void removeOption(Option o)
	{
		for(int i = options.size(); i >+0; i--)
			if(options.get(i).equals(o))
				options.remove(i);
		
		total--;
	}
	/**
	 * draws the options out
	 */
	public void drawOptions()
	{
		int ycoor = y; 
		
		for(Option o: options)
		{
			o.drawOption(x, ycoor);
			
			ycoor += 20;
		}
	}
	/**
	 * @return the number of total options in the list
	 */
	public int getTotalOptions()
	{
		return total;
	}
	public ArrayList<Option> getArrayOptions()
	{
		return options;
	}

}


