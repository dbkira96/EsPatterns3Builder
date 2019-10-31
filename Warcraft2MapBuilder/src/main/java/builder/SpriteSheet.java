package builder;
/**
 * <p>Title: SpriteSheet</p>
 *
 * <p>Description: makes loading sprite sheets a breeze</p>
 *
 * <p>Copyright: Copyright (c) 2007</p>
 *
 * <p>Company: </p>
 *
 * @author John carlyle
 * @version 1.0
 */

import java.awt.*;
import java.awt.image.BufferedImage;
import java.util.*;

public class SpriteSheet {

    private BufferedImage sheet, workArea;
    private int xOffset = 0, yOffset = 0, xDel = 0, yDel = 0;
    private Point size;

    /**
     *
     * Makes a new sprite sheet
     *
     * @param img BufferedImage the image of the sprite sheet
     * @param xo int distance of the first sprite row from the left edge
     * @param yo int distance of the first sprite column from the top edge
     * @param xd int size of delimiting space between sprites on the x-axis
     * @param yd int size of delimiting space between sprites on the y-axis
     * @param size Point height/width respectivly of the sprite frames you are ripping
     */
    public SpriteSheet(BufferedImage img,
                       int xo,
                       int yo,
                       int xd,
                       int yd,
                       Point size) {
        sheet = img;
        workArea = sheet;
        xOffset = xo;
        yOffset = yo;
        xDel = xd;
        yDel = yd;
        this.size = size;
    }

    public void setSheet(BufferedImage img) {
        sheet = img;
    }

   
    public BufferedImage getSheet() {
        return sheet;
    }

   
    public void setSpriteSize(Point s) {
        size.setLocation(s);
    }

   
    public Point getSpriteSize() {
        return size;
    }

    public void setYOffset(int y) {
        yOffset = y;
    }
   
    public int getYOffset() {
        return yOffset;
    }

    
    public void setXOffset(int x) {
        xOffset = x;
    }
   
    public int getXOffset() {
        return xOffset;
    }

    /**
     *
     * Distance between sprites on the y-axis
     *
     * @param y int new delimiter
     */
    public void setYDel(int y) {
        yDel = y;
    }

   
    public int getYDel() {
        return yDel;
    }

    /**
     *
     * distance between sprites on the x-axis
     *
     * @param x int new delimiter
     */
    public void setXDel(int x) {
        xDel = x;
    }
   
    public int getXDel() {
        return xDel;
    }

    /**
     *
     * sets the area of the sheet you are working in
     * (rectangle)
     * Note: uses the rest of the sheet as the height and width
     *
     * @param x int x location of new area
     * @param y int y location of new area
     */

    public void setWorkArea(int x, int y) {
        setWorkArea(x, y, sheet.getWidth() - x, sheet.getHeight() - y);
    }

    public void setWorkArea(int x, int y, int w, int h) {
        workArea = sheet.getSubimage(x, y, w, h);
    }

    
    /**
     *
     * simpler method that returns a single image from a sprite sheet
     * (good for portraits)
     *
     * @param p Point the location of the image in row/column form
     * @return BufferedImage the image that was cut out
     */
    public BufferedImage getImageFor(Point p) {

        int x = xOffset;
        x += xDel * p.x;
        x += size.x * p.x;

        int y = yOffset;
        y += yDel * p.y;
        y += size.y * p.y;

        return workArea.getSubimage(x, y, size.x, size.y);
    }
}