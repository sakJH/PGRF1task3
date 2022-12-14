package render;

import model3D.Scene;
import model3D.Solid;
import rasterize.LineRasterizer;
import transforms.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class EdgeRenderer implements Renderer {
    private Mat4 model = new Mat4Identity(), view = new Mat4Identity(), proj = new Mat4Identity();
    private LineRasterizer lineRasterizer;

    @Override
    public void setModel(Mat4 model) {
        this.model = model;
    }

    @Override
    public void setView(Mat4 view) {
        this.view = view;
    }

    @Override
    public void setProjection(Mat4 proj) {
        this.proj = proj;
    }

    @Override
    public void render(Solid solid) {
        Mat4 trans = model.mul(view).mul(proj);

        for (int i = 0; i < solid.getIndexBuffer().size() - 1; i += 2) {
            int indexA = solid.getIndexBuffer().get(i);
            int indexB = solid.getIndexBuffer().get(i + 1);

            Point3D a = solid.getVertexBuffer().get(indexA)
                    .mul(trans);
            Point3D b = solid.getVertexBuffer().get(indexB)
                    .mul(trans);

            render(a, b, solid.getColor());
        }
    }

    @Override
    public void render(Scene solid) {

    }

    private boolean clip(Vec3D a) {
        // TODO: Add Z axis
        //−𝑤 ≤ 𝑥 ≤ 𝑤 ,−𝑤 ≤ 𝑦 ≤ 𝑤 a 0 ≤ 𝑧 ≤ w
        return a.getX() < -1 || a.getX() > 1 || a.getY() < -1 || a.getY() > 1;
    }

    private void render(Point3D a, Point3D b, int color){
        Vec3D va = new Vec3D();
        Vec3D vb = new Vec3D();

        if (a.dehomog().isPresent())
        {
            va = a.dehomog().get();
        }
        if (b.dehomog().isPresent())
        {
            vb = b.dehomog().get();
        }

        if(clip(va) || clip(vb))
            return;

        int width = lineRasterizer.getRaster().getWidth();
        int height = lineRasterizer.getRaster().getHeight();

        Vec3D pointA = va
                    .mul(new Vec3D(1,-1,1))
                    .add(new Vec3D(1,1,0))
                    .mul(new Vec3D((width - 1)/2.f, (height - 1)/2.f, 1));
        Vec3D pointB = vb
                    .mul(new Vec3D(1,-1,1))
                    .add(new Vec3D(1,1,0))
                    .mul(new Vec3D((width - 1)/2.f, (height - 1)/2.f, 1));

        //vykreslení - draw line
        lineRasterizer.rasterize(
                (int)pointA.getX(),
                (int)pointA.getY(),
                (int)pointB.getX(),
                (int)pointB.getY(),
                color
        );
    }

    public void setRasterizer(LineRasterizer lineRasterizer) {
        this.lineRasterizer = lineRasterizer;
    }


}
