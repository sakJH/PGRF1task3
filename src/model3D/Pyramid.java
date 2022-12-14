package model3D;

import transforms.Point3D;

public class Pyramid extends Solid{
    public Pyramid(){
        setColor(0x013e7e);

        vertexBuffer.add(new Point3D(-1,0,0));
        vertexBuffer.add(new Point3D(0,1,0));
        vertexBuffer.add(new Point3D(1,0,0));
        vertexBuffer.add(new Point3D(0,-1,0));
        vertexBuffer.add(new Point3D(0,0,1.5));

        indexBuffer.add(0);indexBuffer.add(1);
        indexBuffer.add(1);indexBuffer.add(2);
        indexBuffer.add(2);indexBuffer.add(3);
        indexBuffer.add(3);indexBuffer.add(0);

        indexBuffer.add(0);indexBuffer.add(4);
        indexBuffer.add(1);indexBuffer.add(4);
        indexBuffer.add(2);indexBuffer.add(4);
        indexBuffer.add(3);indexBuffer.add(4);
    }
}
