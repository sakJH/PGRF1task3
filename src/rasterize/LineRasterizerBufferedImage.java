package rasterize;

import raster.Raster;
import raster.RasterBufferedImage;

import java.awt.*;
import java.awt.image.BufferedImage;

public class LineRasterizerBufferedImage extends LineRasterizer {

    public LineRasterizerBufferedImage(Raster raster) {
        super.raster = raster;
    }

    @Override
    public void rasterize(int x1, int y1, int x2, int y2, int color) {
        BufferedImage img = ((RasterBufferedImage)raster).getImg();
        Graphics gr = img.getGraphics();
        gr.setColor(new Color(color));
        gr.drawLine(x1,y1,x2,y2);
    }
}
