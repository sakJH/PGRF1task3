package model3D.axes;

import model3D.Solid;
import transforms.Point3D;

public class XAxis extends Solid {
    public XAxis() {
        vertexBuffer.add(new Point3D(0,0,0));
        vertexBuffer.add(new Point3D(1,0,0));

        indexBuffer.add(0);
        indexBuffer.add(1);

        setColor(0xff0000);
    }
}
