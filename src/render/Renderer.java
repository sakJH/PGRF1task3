package render;

import model3D.Scene;
import model3D.Solid;
import transforms.Mat4;

public interface Renderer {
    void setModel(Mat4 model);
    void setView(Mat4 view);
    void setProjection(Mat4 proj);
    void render(Solid solid);
    void render(Scene solid);
}
