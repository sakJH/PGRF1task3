package model3D;

import transforms.Cubic;
import transforms.Mat4;
import transforms.Point3D;

import java.awt.*;
import java.util.ArrayList;
import java.util.List;

public class Cubic3D extends Solid {

    public Cubic3D(Cubic cubic) {
        setColor(0xff0000);
        List<Cubic> cubicList = new ArrayList<Cubic>();

        cubicList.add(cubic);

        for(Cubic c : cubicList) {
            for(double i = 0; i <= 1; i+=0.1) {
                Point3D p = c.compute(i);
                vertexBuffer.add(p);
            }
        }

        for(int i = 0; i < vertexBuffer.size() - 1; i++) {
            indexBuffer.add(i);
            indexBuffer.add(i+1);
        }
    }
}