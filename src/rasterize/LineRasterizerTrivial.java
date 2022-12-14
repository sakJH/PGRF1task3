package rasterize;

import model.Line;
import raster.Raster;

public class LineRasterizerTrivial extends LineRasterizer {

    public LineRasterizerTrivial(Raster raster) {
        super.raster = raster;
        //setRaster(raster);
    }
    //public void setRaster(Raster raster){
    //    this.raster = raster;
    //}

    @Override
    public void rasterize(int x1, int y1, int x2, int y2, int color) {
        float k,q;

        k=((float)(y2-y1)/(x2-x1))  ;
        q=y1-(k*x1);
        for (int x = x1; x <= x2; x++){
            float y= (k*x)+q;
            raster.setPixel(x, (int)y, color);
        }
    }
}
