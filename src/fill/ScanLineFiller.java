package fill;

import model.Point;
import raster.Raster;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ScanLineFiller extends Filler {
    private List<BorderLine> polygon;

    public ScanLineFiller(Raster raster) {
        super(raster);
    }

    @Override
    public void fill() {

    }

    public void setPolygon(List<Point> points){
        polygon = new ArrayList<>();
        int yLow=Integer.MAX_VALUE;
        int yHigh=Integer.MIN_VALUE;

        for(int i = 0; i < points.size()-1; i++){

            int x1 = points.get(i).getX();
            int y1 = points.get(i).getY();
            int idx = (i+1) % points.size();
            int x2 = points.get(idx).getX();
            int y2 = points.get(idx).getY();
            BorderLine line = new BorderLine(x1, y1, x2, y2);
            if(!line.isHorizontal()) {
                line.orientate();

                if(line.y1<yLow){
                    yLow=line.y1;
                }
                if(line.y2>yHigh){
                    yHigh=line.y2;
                }
                
                polygon.add(line);
            }
        }
        for(int y = yLow;y <= yHigh;y++)
        {
            List <Integer> intersections = new ArrayList<>();

            //najdi vsechny pruseciky pro dane Y
            for(BorderLine line : polygon) {
                //metoda pro dané y - existuje prusečík?
                if(line.isIntersection(y)) {
                    int x = line.getIntersection(y);
                    intersections.add(x);
                }
            }
            // seradit podle X souradnic
            Collections.sort(intersections);
            //implementovat!!
            for(int i=0; i<intersections.size();i+=2)
            {
                int x1,x2;
                x1 = intersections.get(i);
                x2 = intersections.get(i+1);
                for(int x = x1;x<=x2;x++)
                {
                    raster.setPixel(x,y,0xffffff);
                }
            }
            // spojit sudy s lichym
        }
    }
    private class BorderLine {
         int x1, y1,x2,y2;

        public BorderLine(int x1, int y1, int x2, int y2) {
            this.x1 = x1;
            this.y1 = y1;
            this.x2 = x2;
            this.y2 = y2;
        }

        public boolean isHorizontal (){
            return y1 == y2;
        }

        public void orientate(){
            if (y1 > y2){
                int temp = y1;
                y1 = y2;
                y2 = temp;

                temp = x1;
                x1 = x2;
                x2 = temp;
            }
        }

        public boolean isIntersection(int y) {
            return (y >= y1 && y <= y2);
        }

        public int getIntersection(int y){
            return(0);
        }
    }
}
