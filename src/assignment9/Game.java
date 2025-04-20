package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {

    private Snake snake;
    private Food food;
    private long powerupTime;  // To track when the powerup was consumed
    private static final long POWERUP_DISPLAY_TIME = 100;  // Time to display powerup message (in milliseconds)
    private int pnum=0;
    

    public Game() {
        StdDraw.enableDoubleBuffering();

        // Construct new Snake and Food objects
        snake = new Snake();
        food = new Food();
        
        // Set the scale for the drawing canvas
        StdDraw.setXscale(0, 1);
        StdDraw.setYscale(0, 1);
    }

    public void play() {
        while (snake.isInbounds()) {

            int dir = getKeypress();
            if (dir != -1) {
                snake.changeDirection(dir);  // Update snake's direction
            }

            snake.move();  // Move the snake

            if (snake.eatFood(food)) {
                food = new Food();  // Create new food when the snake eats the current food
            }
            
            if (snake.atePowerup()) {
            	
            	displayPowerupText();
            	
               // powerupTime = System.currentTimeMillis();  // Record time of powerup consumption
            }

            // Display power-up text if a power-up was consumed recently
         //   if (System.currentTimeMillis() - powerupTime < POWERUP_DISPLAY_TIME) {
            //    displayPowerupText();
               
          //  }

            updateDrawing();  // Redraw the game components
        }
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.setFont(new java.awt.Font("Arial", java.awt.Font.PLAIN, 30));
        StdDraw.text(0.5, 0.7, "You Lose");
        StdDraw.show();
    }

    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) {
            return 1;  // Up
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_S)) {
            return 2;  // Down
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_A)) {
            return 3;  // Left
        } else if (StdDraw.isKeyPressed(KeyEvent.VK_D)) {
            return 4;  // Right
        } else {
            return -1;  // No key pressed
        }
    }

    /**
     * Clears the screen, draws the snake and food, pauses, and shows the content
     */
    private void updateDrawing() {
        StdDraw.clear();  // Clear the previous frame
        snake.draw();     // Draw the snake
        food.draw();      // Draw the food
        StdDraw.pause(70); // Pause for 70 milliseconds to control speed
        StdDraw.show();   // Show the updated frame
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();  // Start the game
    }

    private void displayPowerupText() {
    	
        StdDraw.setPenColor(StdDraw.BLACK);  // Set text color
        StdDraw.setFont(new java.awt.Font("Arial", java.awt.Font.BOLD, 30));  // Set font size and style
        StdDraw.text(0.5, 0.8, "Powerup " + pnum +" (+3)");  // Display "Powerup!" near the top
        StdDraw.show();  // Update the screen immediately to show the text
       
            // Keep the text on the screen for 500ms
        }
    }

