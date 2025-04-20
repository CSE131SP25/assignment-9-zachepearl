package assignment9;

import java.util.LinkedList;

public class Snake {

    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;
    private boolean atePowerUp;

    public Snake() {
        segments = new LinkedList<>();
        segments.add(new BodySegment(0.5, 0.5, SEGMENT_SIZE));  // Starting at the center of the screen
        deltaX = 0;
        deltaY = 0;
        atePowerUp=false;
    }

    public void changeDirection(int direction) {
        if (direction == 1) { // up
            deltaY = MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 2) { // down
            deltaY = -MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 3) { // left
            deltaY = 0;
            deltaX = -MOVEMENT_SIZE;
        } else if (direction == 4) { // right
            deltaY = 0;
            deltaX = MOVEMENT_SIZE;
        }
    }

    /**
     * Moves the snake by updating the position of each of the segments
     * based on the current direction of travel
     */
    public void move() {
        BodySegment head = segments.getFirst();
        double newX = head.getX() + deltaX;
        double newY = head.getY() + deltaY;
        segments.addFirst(new BodySegment(newX, newY, SEGMENT_SIZE));
        segments.removeLast();
    }

    /**
     * Draws the snake by drawing each segment
     */
    public void draw() {
        for (BodySegment segment : segments) {
            segment.draw();
        }
    }

    /**
     * checks if the snake's head is close
     * @param f the food to be eaten
     * @return true if the snake successfully ate the food
     */
    public boolean eatFood(Food f) {
        BodySegment head = segments.getFirst();
        double distance = Math.pow (Math.pow(head.getX() - f.getX(), 2) + Math.pow(head.getY() - f.getY(), 2),0.5);
        if (distance < (SEGMENT_SIZE + Food.FOOD_SIZE)) {
            // Normal food: grow by 1 segment
            segments.addFirst(new BodySegment(head.getX(), head.getY(), SEGMENT_SIZE));

            // If it's a power-up food, grow by 3 segments
            if (f.isPowerup()) {
                segments.addFirst(new BodySegment(head.getX(), head.getY(), SEGMENT_SIZE));
                segments.addFirst(new BodySegment(head.getX(), head.getY(), SEGMENT_SIZE));
                segments.addFirst(new BodySegment(head.getX(), head.getY(), SEGMENT_SIZE));
                atePowerUp =true;
              
            }

            return true;
        }
        return false;
    }

    /**
     * Returns true if the head of the snake is in bounds
     * @return whether or not the head is in the bounds of the window
     */
    public boolean isInbounds() {
        BodySegment head = segments.getFirst();
        return head.getX() >= 0 && head.getX() <= 1 && head.getY() >= 0 && head.getY() <= 1;
    }
    
    public boolean atePowerup() {
        return atePowerUp;
    }
}
