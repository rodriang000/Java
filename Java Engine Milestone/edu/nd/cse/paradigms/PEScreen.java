package edu.nd.cse.paradigms;

import java.awt.image.BufferedImage;

public class PEScreen
{
    private int width, height;
    private int bg;

    private BufferedImage image;
    private int[][] pixels;

    public PEScreen(int width, int height)
    {
        this.width = width;
        this.height = height;
        this.bg = 0x000000;
        
        this.pixels = new int[width][height];
        clear();
    }

    public void setPixel(int px, int py, int color)
    {
        if (inBounds(px, py))
        {
            this.pixels[px][py] = color;   
        }
    }

    public void clear()
    {
        for (int w = 0; w < this.width; w++)
        {
            for(int h = 0; h < this.height; h++)
            {
               setPixel(w, h, this.bg); 
            }
        }
    }

    public boolean inBounds(int px, int py)
    {
        /* Check boundries */
        if (((px < this.width) && (px >= 0)) && ((py >= 0) && (py < this.height)))
        {
            return true;
        }else{
            return false;
        }
    }

    public void renderWorldObject(PEWorldObject wo)
    {
	    wo.render(this);
    }

    public BufferedImage render()
    {
	/* Initizlize buffer image to RGB */
        image = new BufferedImage(width, height, BufferedImage.TYPE_INT_RGB);

        /* Loop through each pixel */
        for (int w = 0; w < this.width; w++)
        {
            for (int h = 0; h < this.height; h++)
            {
                image.setRGB(w, h, this.pixels[w][h]);
            }
        }

	/* Return the buffered image */
        return this.image;
    }
}

