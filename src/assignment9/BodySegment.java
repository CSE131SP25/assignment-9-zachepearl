package assignment9;

import java.awt.Color;

import edu.princeton.cs.introcs.StdDraw;

public class BodySegment {

	private double x, y, size;
	private Color color;
	
	public BodySegment(double x, double y, double size) {
		this.x = x;
		this.y = y;
		this.size =size;
		this.color = StdDraw.BLACK;
		
	}
	
	/**
	 * Draws the segment
	 */
	public void draw() {
		StdDraw.setPenColor(color);
		StdDraw.filledCircle(x, y, size/2);
	}
	public double getX() {
		return x;
		
	}
	public double getY() {
		return y;
		
	}
	
	public double getSize() {
		return size;
		
	}
}
