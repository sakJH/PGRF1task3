package model3D.axes;

import model3D.Solid;
import transforms.Point3D;

public class YAxis extends Solid {
    public YAxis() {
        vertexBuffer.add(new Point3D(0,0,0));
        vertexBuffer.add(new Point3D(0,1,0));

        indexBuffer.add(0);
        indexBuffer.add(1);

        setColor(0x00ff00);
    }
}