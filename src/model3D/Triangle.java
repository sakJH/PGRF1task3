package model3D;

import transforms.Point3D;

public class Triangle extends Solid{

    public Triangle(){

        setColor(0xff0000);

        getVertexBuffer().add(new Point3D(1,1,1));
        getVertexBuffer().add(new Point3D(-1,-1,1));
        getVertexBuffer().add(new Point3D(-1,1,-1));
        getVertexBuffer().add(new Point3D(1,-1,-1));

        getIndexBuffer().add(0);
        getIndexBuffer().add(1);
        getIndexBuffer().add(2);

        getIndexBuffer().add(0);
        getIndexBuffer().add(2);
        getIndexBuffer().add(3);

        getIndexBuffer().add(0);
        getIndexBuffer().add(3);
        getIndexBuffer().add(1);

        getIndexBuffer().add(3);
        getIndexBuffer().add(2);
        getIndexBuffer().add(1);
    }
}
