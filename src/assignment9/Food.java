package assignment9;

import edu.princeton.cs.introcs.StdDraw;

public class Food {

    public static final double FOOD_SIZE = 0.02;
    private double x, y;
    private boolean isPowerup;  // Track if this food is a power-up
    double EdgeSurface = 0.1;
    
    /**
     * Creates a new Food at a random location, with a 20% chance of being a power-up
     */
    public Food() {
        x = EdgeSurface +  Math.random() *0.8;
        y = EdgeSurface + Math.random()*0.8;
        isPowerup = Math.random() > 0.80; // 20% chance for power-up food
    }
    
    /**
     * Draws the Food
     */
    public void draw() {
        if (isPowerup) {
            StdDraw.setPenColor(StdDraw.GREEN);  // Power-up food is yellow
            StdDraw.filledCircle(x, y, FOOD_SIZE);
        } else {
            StdDraw.setPenColor(StdDraw.RED);  // Regular food is red
            StdDraw.filledCircle(x, y, FOOD_SIZE);
        }
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public boolean isPowerup() {
        return isPowerup;  // Return if the food is a power-up
    }
}
