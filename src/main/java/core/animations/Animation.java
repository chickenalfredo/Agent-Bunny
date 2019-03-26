package core.animations;

import java.lang.Thread;

import core.external.entity.Enemy;
import core.external.entity.Hero;
import core.sprite.Sprite;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.geometry.Rectangle2D;

public class Animation {

    private ImageView imageView;
    private int row;
    private int column;
    private double offsetX;
    private double offsetY;
    private int numOfFrames;
    private int numOfRows;
    private int numOfColumns;
    private double width;
    private double height;
    private GraphicsContext gc;

    public Animation(Image image, Sprite actor, String action) {
        imageView = new ImageView(image);
        if (actor instanceof Hero) {
            this.numOfColumns = 8;
            this.numOfRows = 12;
            this.offsetX = 12;
            this.offsetY = 40;
            this.width = (actor.getWidth() - offsetX) / numOfColumns;
            this.height = (actor.getHeight() - offsetY) / numOfRows;
            if (action.equalsIgnoreCase("attack")) {
                this.row = 5;
                this.column = 5;
                this.numOfFrames = 8;
            }else if (action.equalsIgnoreCase("run")) {
                this.row = 1;
                this.column = 0;
                this.numOfFrames = 6;
            }else if (action.equalsIgnoreCase("jump")) {
                this.row = 1;
                this.column = 0;
                this.numOfFrames = 8;
            }}else if (action.equalsIgnoreCase("idle")) {
                this.row = 0;
                this.column = 0;
                this.numOfFrames = 4;
            
        } else if (actor instanceof Enemy) {}
        
        animationCycle();
    }

    public int getRow() {
        return row;
    }

    public void setRow(int aRow) {
        this.row = aRow;
    }

    public ImageView getImageView() {
        return imageView;
    }

    public void setImageView(ImageView aImageView) {
        this.imageView = aImageView;
    }

    protected void animationCycle() {
        for (int i = 0; i <= numOfFrames; i++) {
            // int index = (int) Math.round(fractionOfCycle * (numOfFrames-1));

            // check which row this index falls into based on the number of rows in the
            // image sprite

            // find the xcoordinate based on the width of each column with offsetX as the
            // xcoordinate for the first column
            double x = (column * width) + offsetX;

            // Similar computation for row and y coordinate.
            double y = (row * height) + offsetY;

            // indicate which part of the image should be displayed
            imageView.setViewport(new Rectangle2D(x, y, width, height));

            
            if (column == numOfColumns) {
                this.row += 1;
                column = 0;
            } else {
                this.column = this.column + 1; 
            }
            try {
                Thread.sleep(4000 / numOfFrames);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}