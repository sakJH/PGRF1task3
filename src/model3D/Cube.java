package model3D;

import transforms.Point3D;

public class Cube extends Solid {

    public Cube(){

        setColor(0xffff00);

        getVertexBuffer().add(new Point3D(1,1,-1));
        getVertexBuffer().add(new Point3D(-1,1,-1));
        getVertexBuffer().add(new Point3D(-1,-1,-1));
        getVertexBuffer().add(new Point3D(1,-1,-1));

        getVertexBuffer().add(new Point3D(1,1,1));
        getVertexBuffer().add(new Point3D(-1,1,1));
        getVertexBuffer().add(new Point3D(-1,-1,1));
        getVertexBuffer().add(new Point3D(1,-1,1));

        getIndexBuffer().add(0); getIndexBuffer().add(1);
        getIndexBuffer().add(0); getIndexBuffer().add(3);
        getIndexBuffer().add(0); getIndexBuffer().add(4);
        getIndexBuffer().add(1); getIndexBuffer().add(2);

        getIndexBuffer().add(1); getIndexBuffer().add(5);
        getIndexBuffer().add(2); getIndexBuffer().add(3);
        getIndexBuffer().add(2); getIndexBuffer().add(6);
        getIndexBuffer().add(3); getIndexBuffer().add(7);

        getIndexBuffer().add(5); getIndexBuffer().add(6);
        getIndexBuffer().add(4); getIndexBuffer().add(5);
        getIndexBuffer().add(4); getIndexBuffer().add(7);
        getIndexBuffer().add(6); getIndexBuffer().add(7);

    }

}

