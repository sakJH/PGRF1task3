package model3D;

import transforms.Point3D;

public class Diamond extends Solid{
    public Diamond() {

        vertexBuffer.add(new Point3D(-1,0,0));
        vertexBuffer.add(new Point3D(0,0,-1.5));
        vertexBuffer.add(new Point3D(1,0,0));
        vertexBuffer.add(new Point3D(0,0,0.7));
        vertexBuffer.add(new Point3D(0,-1,0));
        vertexBuffer.add(new Point3D(0,1,0));

        vertexBuffer.add(new Point3D(-0.75,0.75,0));
        vertexBuffer.add(new Point3D(-0.75,-0.75,0));
        vertexBuffer.add(new Point3D(0.75,-0.75,0));
        vertexBuffer.add(new Point3D(0.75,0.75,0));

        //10

        vertexBuffer.add(new Point3D(0,0.5,0.5));
        vertexBuffer.add(new Point3D(-0.5,0.5,0.5));
        vertexBuffer.add(new Point3D(-0.5,0,0.5));
        vertexBuffer.add(new Point3D(-0.5,-0.5,0.5));

        vertexBuffer.add(new Point3D(0,-0.5,0.5));
        vertexBuffer.add(new Point3D(0.5,-0.5,0.5));
        vertexBuffer.add(new Point3D(0.5,0,0.5));
        vertexBuffer.add(new Point3D(0.5,0.5,0.5));


        //indexBuffer.add(0);indexBuffer.add(3);
        indexBuffer.add(0);indexBuffer.add(1);

        indexBuffer.add(1);indexBuffer.add(2);
        indexBuffer.add(1);indexBuffer.add(4);
        indexBuffer.add(1);indexBuffer.add(5);

        //indexBuffer.add(2);indexBuffer.add(3);
/*
        indexBuffer.add(3);indexBuffer.add(4);
        indexBuffer.add(3);indexBuffer.add(5);*/

        //indexBuffer.add(6);indexBuffer.add(3);
        indexBuffer.add(6);indexBuffer.add(1);

        //indexBuffer.add(7);indexBuffer.add(3);
        indexBuffer.add(7);indexBuffer.add(1);

        //indexBuffer.add(8);indexBuffer.add(3);
        indexBuffer.add(8);indexBuffer.add(1);

        //indexBuffer.add(9);indexBuffer.add(3);
        indexBuffer.add(9);indexBuffer.add(1);

        indexBuffer.add(0);indexBuffer.add(7);
        indexBuffer.add(7);indexBuffer.add(4);
        indexBuffer.add(4);indexBuffer.add(8);
        indexBuffer.add(8);indexBuffer.add(2);
        indexBuffer.add(2);indexBuffer.add(9);
        indexBuffer.add(9);indexBuffer.add(5);
        indexBuffer.add(5);indexBuffer.add(6);
        indexBuffer.add(6);indexBuffer.add(0);

        //
        indexBuffer.add(0);indexBuffer.add(12);
        indexBuffer.add(2);indexBuffer.add(16);
        indexBuffer.add(4);indexBuffer.add(14);
        indexBuffer.add(5);indexBuffer.add(10);
        indexBuffer.add(6);indexBuffer.add(11);
        indexBuffer.add(7);indexBuffer.add(13);
        indexBuffer.add(8);indexBuffer.add(15);
        indexBuffer.add(9);indexBuffer.add(17);

        indexBuffer.add(10);indexBuffer.add(3);
        indexBuffer.add(11);indexBuffer.add(3);
        indexBuffer.add(12);indexBuffer.add(3);
        indexBuffer.add(13);indexBuffer.add(3);

        indexBuffer.add(14);indexBuffer.add(3);
        indexBuffer.add(15);indexBuffer.add(3);
        indexBuffer.add(16);indexBuffer.add(3);
        indexBuffer.add(17);indexBuffer.add(3);

        indexBuffer.add(10);indexBuffer.add(11);
        indexBuffer.add(11);indexBuffer.add(12);
        indexBuffer.add(12);indexBuffer.add(13);
        indexBuffer.add(13);indexBuffer.add(14);
        indexBuffer.add(14);indexBuffer.add(15);
        indexBuffer.add(15);indexBuffer.add(16);
        indexBuffer.add(16);indexBuffer.add(17);
        indexBuffer.add(17);indexBuffer.add(10);

        /*
        vertexBuffer.add(new Point3D(-1,0,0));
        vertexBuffer.add(new Point3D(0,0,-1.5));
        vertexBuffer.add(new Point3D(1,0,0));
        vertexBuffer.add(new Point3D(0,0,0.75));
        vertexBuffer.add(new Point3D(0,-1,0));
        vertexBuffer.add(new Point3D(0,1,0));

        vertexBuffer.add(new Point3D(-0.75,0.75,0));
        vertexBuffer.add(new Point3D(-0.75,-0.75,0));
        vertexBuffer.add(new Point3D(0.75,-0.75,0));
        vertexBuffer.add(new Point3D(0.75,0.75,0));


        indexBuffer.add(0);indexBuffer.add(3);
        indexBuffer.add(0);indexBuffer.add(1);

        indexBuffer.add(1);indexBuffer.add(2);
        indexBuffer.add(1);indexBuffer.add(4);
        indexBuffer.add(1);indexBuffer.add(5);

        indexBuffer.add(2);indexBuffer.add(3);

        indexBuffer.add(3);indexBuffer.add(4);
        indexBuffer.add(3);indexBuffer.add(5);

        indexBuffer.add(6);indexBuffer.add(3);
        indexBuffer.add(6);indexBuffer.add(1);

        indexBuffer.add(7);indexBuffer.add(3);
        indexBuffer.add(7);indexBuffer.add(1);

        indexBuffer.add(8);indexBuffer.add(3);
        indexBuffer.add(8);indexBuffer.add(1);

        indexBuffer.add(9);indexBuffer.add(3);
        indexBuffer.add(9);indexBuffer.add(1);

        indexBuffer.add(0);indexBuffer.add(7);
        indexBuffer.add(7);indexBuffer.add(4);
        indexBuffer.add(4);indexBuffer.add(8);
        indexBuffer.add(8);indexBuffer.add(2);
        indexBuffer.add(2);indexBuffer.add(9);
        indexBuffer.add(9);indexBuffer.add(5);
        indexBuffer.add(5);indexBuffer.add(6);
        indexBuffer.add(6);indexBuffer.add(0);*/

        setColor(0x11eda0);
    }



}
