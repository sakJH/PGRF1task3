
import fill.SeedFiller;
import model.Line;
import model3D.*;
import model3D.axes.XAxis;
import model3D.axes.YAxis;
import model3D.axes.ZAxis;
import raster.Raster;
import raster.RasterBufferedImage;
import rasterize.LineRasterizer;
import rasterize.LineRasterizerBufferedImage;
import render.EdgeRenderer;
import transforms.*;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.*;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.WindowConstants;


/**
 * trida pro kresleni na platno: zobrazeni pixelu, ovladani mysi
 * 
 * @author PGRF FIM UHK
 * @version 2020
 */
public class App {

	private JPanel panel;
	private Raster raster;
	private LineRasterizer lineRasterizer;
	private SeedFiller seedFiller;
	private Mat3 trans= new Mat3Identity();
	private Mat4 model = new Mat4Identity();
	int x1;
	int y1;
	int deltaX, deltaY; double zenith, azimuth;
	Point3D cubicPoint1, cubicPoint2, cubicPoint3, cubicPoint4;



	Camera camera = new Camera()
			.withPosition(new Vec3D(0,0,0))
			.withAzimuth(Math.toRadians(-90))
			.withZenith(Math.toRadians(-20))
			.withFirstPerson(false)
			.withRadius(5);


	//test

	Solid solid = new Cube();
	Solid cubicSolid;
	List<Solid> solids = new ArrayList<>();


	private boolean orthoProjection = false;


	EdgeRenderer edgeRenderer = new EdgeRenderer();



	public App(int width, int height) {
		JFrame frame = new JFrame();

		frame.setLayout(new BorderLayout());
		frame.setTitle("UHK FIM PGRF : " + this.getClass().getName());
		frame.setResizable(false);
		frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);

		raster = new RasterBufferedImage(width, height);
		lineRasterizer = new LineRasterizerBufferedImage(raster);
		seedFiller = new SeedFiller(raster);



		panel = new JPanel() {
			private static final long serialVersionUID = 1L;

			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				present(g);
			}
		};
		panel.setPreferredSize(new Dimension(width, height));

		frame.add(panel);
		frame.pack();
		frame.setVisible(true);

		solids.add(new XAxis());
		solids.add(new YAxis());
		solids.add(new ZAxis());


		setProjection(false);
		edgeRenderer.setRasterizer(lineRasterizer);

		/*
		cubicPoint1 = new Point3D(-2, 1.5, 0);
		cubicPoint2 = new Point3D(-0.5, 2, 0);
		cubicPoint3 = new Point3D(1, 3, 0);
		cubicPoint4 = new Point3D(2, -0.5, 0);*/
		cubicPoint1 = new Point3D(1,1,-1);
		cubicPoint2 = new Point3D(-1,-1,-1);
		cubicPoint3 = new Point3D(1, 3, 0);
		cubicPoint4 = new Point3D(2, -0.5, 0);

		cubicSolid = new Cubic3D(new Cubic(Cubic.COONS, cubicPoint1, cubicPoint2, cubicPoint3, cubicPoint4));

		panel.addMouseListener(new MouseAdapter() {
			@Override
			public void mousePressed(MouseEvent e) {
				if (e.getButton() == MouseEvent.BUTTON1) {
					x1 = e.getX();
					y1 = e.getY();
				}
				panel.repaint();
			}
		});

		panel.addMouseMotionListener(new MouseAdapter() {
			@Override
			public void mouseDragged(MouseEvent e) {
				super.mouseDragged(e);
				clear();

				deltaX = x1 - e.getX();
				deltaY = y1 - e.getY();
				zenith += (Math.PI * deltaY) / raster.getHeight();
				azimuth += (Math.PI * deltaX) / raster.getWidth();

				camera = camera.withAzimuth(azimuth).withZenith(zenith);

				x1 = e.getX();
				y1 = e.getY();

				reDraw();
			}
		});

		panel.addKeyListener(new KeyAdapter() {

			@Override
			public void keyPressed(KeyEvent e) {
				double step = 0.1;
				super.keyPressed(e);

				//Cleaner
				if (e.getKeyCode() == KeyEvent.VK_C)
				{
					clear();
					raster.clear();
					panel.repaint();
				}

				//Solids
				//EdgeRenderer edgeRenderer = new EdgeRenderer();
				if (e.getKeyCode() == KeyEvent.VK_1)
				{
					System.out.println("Cube");
					solid = new Cube();
				}
				if (e.getKeyCode() == KeyEvent.VK_2)
				{
					solid = new Triangle();
					System.out.println("Triangle");
				}
				if (e.getKeyCode() == KeyEvent.VK_3)
				{
					solid = new Pyramid();
					System.out.println("Pyramid");

				}
				if (e.getKeyCode() == KeyEvent.VK_4)
				{
					solid = new Octagon();
					System.out.println("Octagon");
				}
				if (e.getKeyCode() == KeyEvent.VK_5)
				{
					solid = new Diamond();
					System.out.println("Diamond");
				}

				//Cubic
				if(e.getKeyCode() == KeyEvent.VK_B)
				{
					cubicSolid = new Cubic3D(new Cubic(Cubic.BEZIER, cubicPoint1, cubicPoint2, cubicPoint3, cubicPoint4));
					System.out.println("Bezier cubic");
				}
				if(e.getKeyCode() == KeyEvent.VK_N)
				{
					cubicSolid = new Cubic3D(new Cubic(Cubic.COONS, cubicPoint1, cubicPoint2, cubicPoint3, cubicPoint4));
					System.out.println("Coons cubic");
				}
				if(e.getKeyCode() == KeyEvent.VK_M)
				{
					cubicSolid = new Cubic3D(new Cubic(Cubic.FERGUSON, cubicPoint1, cubicPoint2, cubicPoint3, cubicPoint4));
					System.out.println("Ferguson cubic");
				}

				// Controlls
				if (e.getKeyCode() == KeyEvent.VK_LEFT)
					camera = camera.left(step);

				if (e.getKeyCode() == KeyEvent.VK_RIGHT)
					camera = camera.right(step);

				if (e.getKeyCode() == KeyEvent.VK_UP)
					camera = camera.up(step);

				if (e.getKeyCode() == KeyEvent.VK_DOWN)
					camera = camera.down(step);

				if (e.getKeyCode() == KeyEvent.VK_T)
					model = model.mul(new Mat4RotX(0.01));
				if (e.getKeyCode() == KeyEvent.VK_Z)
					model = model.mul(new Mat4RotY(0.01));
				if (e.getKeyCode() == KeyEvent.VK_U)
					model = model.mul(new Mat4RotZ(0.01));

				if (e.getKeyCode() == KeyEvent.VK_X)
					model = model.mul(new Mat4Scale(1.1,1.1,1.1));
				if (e.getKeyCode() == KeyEvent.VK_Y)
					model = model.mul(new Mat4Scale(0.9,0.9,0.9));


				if (e.getKeyCode() == KeyEvent.VK_P){
					if (orthoProjection)
					{
						orthoProjection = false;
						setProjection(true);
						System.out.println("Pers");
					}
					else {
						orthoProjection = true;
						setProjection(false);
						System.out.println("Ortho");
					}

				}

				clear();
				reDraw();
				System.out.println("ReDraw");
			}
		});
		panel.requestFocus();
		panel.requestFocusInWindow();


	}

	public void clear() {
		raster.clear();
	}

	private void setProjection(boolean ortho) {
		if(ortho) {
			edgeRenderer.setProjection(new Mat4OrthoRH(raster.getWidth() / 100.f, raster.getHeight() / 100.f, 0.05f,30));
			return;
		}
		edgeRenderer.setProjection(new Mat4PerspRH(
				Math.PI / 3,
				raster.getHeight() / (float) raster.getWidth(),
				0.05f,
				30
		));
	}

	public void reDraw(){
		edgeRenderer.setView(camera.getViewMatrix());

		edgeRenderer.setModel(model);
		edgeRenderer.render(solid);

		edgeRenderer.setModel(new Mat4Transl(0,0,0));
		for(Solid solid : solids) {
			edgeRenderer.render(solid);
		}
		edgeRenderer.render(cubicSolid);

		panel.repaint();
	}

	public void present(Graphics graphics) {
		((RasterBufferedImage)raster).present(graphics);
	}

	public void start() {
		clear();
		//img.getGraphics().drawString("Use mouse buttons", 5, img.getHeight() - 5);
		panel.repaint();
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> new App(800, 600).start());
	}

}
