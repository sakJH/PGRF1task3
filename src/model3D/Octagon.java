package model3D;

import transforms.Point3D;

public class Octagon extends Solid{

    public Octagon(){
        getVertexBuffer().add(new Point3D(0,0,1));

        getVertexBuffer().add(new Point3D(-1,0,0));
        getVertexBuffer().add(new Point3D(-0.5,-0.5,0));
        getVertexBuffer().add(new Point3D(0,-1,0));
        getVertexBuffer().add(new Point3D(0.5,-0.5,0));

        getVertexBuffer().add(new Point3D(1,0,0));
        getVertexBuffer().add(new Point3D(0.5,0.5,0));
        getVertexBuffer().add(new Point3D(0,1,0));
        getVertexBuffer().add(new Point3D(-0.5,0.5,0));

        getIndexBuffer().add(0); getIndexBuffer().add(1);
        getIndexBuffer().add(0); getIndexBuffer().add(2);
        getIndexBuffer().add(0); getIndexBuffer().add(3);
        getIndexBuffer().add(0); getIndexBuffer().add(4);
        getIndexBuffer().add(0); getIndexBuffer().add(5);
        getIndexBuffer().add(0); getIndexBuffer().add(6);
        getIndexBuffer().add(0); getIndexBuffer().add(7);
        getIndexBuffer().add(0); getIndexBuffer().add(8);

        getIndexBuffer().add(1); getIndexBuffer().add(2);
        getIndexBuffer().add(2); getIndexBuffer().add(3);
        getIndexBuffer().add(3); getIndexBuffer().add(4);
        getIndexBuffer().add(4); getIndexBuffer().add(5);
        getIndexBuffer().add(5); getIndexBuffer().add(6);
        getIndexBuffer().add(6); getIndexBuffer().add(7);
        getIndexBuffer().add(7); getIndexBuffer().add(1);
    }
}
