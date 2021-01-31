package pixelator;


import java.awt.Color;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;


import processing.core.PApplet;

import processing.core.PImage;

public class Pixelate extends PApplet{

	PImage character;
	
	int[] pixels;
	
	final int SIZE = 10;
	
	public static void main(String[] args) 
	{
		
		PApplet.main("pixelator.Pixelate");
		
	}
	public void settings()
	{
		size(800, 800);
	}
	public void setup()
	{
		character = loadImage("alienGame/flowercat.png");
		
		pixels = character.pixels;
		
		
		background(0, 0, 0);
	}
	public void draw()
	{
		background(0);
		
		image(character, 0, 0);
		
		pixelateImage(10);
		
	}
	
	public void pixelate()
	{
		
		int[] pixelSegment = new int[SIZE];
		int[] newPixels = new int[character.height/SIZE];
		
		int[][] pixels2D = new int[800][800];
		
		int pixelPos = 0;
		
		for(int i = 0; i < pixels2D.length; i++)
		{
			for(int j = 0; j < pixels2D[0].length; j++)
			{
				pixels2D[i][j] = pixels[pixelPos];
				
				pixelPos++;
			}
		}
		
		pixelPos = 0;
		int ueh = 0;
		
		for(int i = 0; i < character.height; i = i + SIZE)
		{
			for(int j = 0; i < character.pixelWidth; j = j + SIZE)
			{
				for(int x = i; x < i + SIZE; x++)
				{
					for(int y = j; y < y + SIZE; y++)
					{
						pixelSegment[pixelPos] = pixels2D[x][y];
						
						pixelPos++;
					}
					
					pixelPos = 0;
				}
				
				newPixels[ueh] = getAverage(pixelSegment);
				ueh++;
			}
		}
		
		pixelPos = 0;
		
		
		for(int i = 0; i < character.height/SIZE; i++)
		{
			for(int j = 0; i < character.width/SIZE; i++)
			{
				character.set(i, j, newPixels[pixelPos]);
				pixelPos++;
			}
		}
	}
	public int getAverage(int[] nums)
	{
		int sum = 0;
		
		for(int i : nums)
		{
			sum += i;
		}
		
		return sum/nums.length;
	}
	void pixelateImage(int pxSize) {
		 
		  // use ratio of height/width...
		  float ratio;
		  if (width < height) {
		    ratio = height/width;
		  }
		  else {
		    ratio = width/height;
		  }
		  
		  // ... to set pixel height
		  int pxH = (int) (pxSize * ratio);
		  
		  noStroke();
		  for (int x=0; x<width; x+=pxSize) {
		    for (int y=0; y<height; y+=pxH) {
		      fill(character.get(x, y));
		      rect(x, y, pxSize, pxH);
		    }
		  }
		}



}
