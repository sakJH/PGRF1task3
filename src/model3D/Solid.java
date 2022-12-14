package model3D;

import transforms.Point3D;
import transforms.Vec3D;

import java.util.ArrayList;
import java.util.List;

public class Solid {

    public void setIndexBuffer(List<Integer> indexBuffer) {
        this.indexBuffer = indexBuffer;
    }

    public void setVertexBuffer(List<Point3D> vertexBuffer) {
        this.vertexBuffer = vertexBuffer;
    }

    protected List<Integer> indexBuffer;
    protected List<Point3D> vertexBuffer;


    private int color;

    public Solid() {
        indexBuffer = new ArrayList<>();
        vertexBuffer = new ArrayList<>();
    }

    public List<Integer> getIndexBuffer() {
        return indexBuffer;
    }

    public List<Point3D> getVertexBuffer() {
        return vertexBuffer;
    }

    public void setColor(int color) {
        this.color = color;
    }

    public int getColor() {
        return color;
    }

    public void cleanSolids()
    {
        indexBuffer.clear();
        vertexBuffer.clear();
    }
}
