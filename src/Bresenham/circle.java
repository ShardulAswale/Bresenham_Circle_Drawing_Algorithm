package bresenham;

import javax.media.opengl.GL;
import javax.media.opengl.GLAutoDrawable;
import javax.media.opengl.GLCanvas;
import javax.media.opengl.GLCapabilities;
import javax.media.opengl.GLEventListener;
import javax.media.opengl.glu.GLU;
import javax.swing.JFrame;

class ThirdGLEventListener implements GLEventListener {
    private GLU glu;
    @Override
    public void init(GLAutoDrawable gld) {
        GL gl = gld.getGL();
        glu = new GLU();
        gl.glClearColor(1.0f, 1.0f, 1.0f, 1.0f);
        gl.glViewport(0, 0, 640, 480);
        gl.glMatrixMode(GL.GL_PROJECTION);
        gl.glLoadIdentity();
        glu.gluOrtho2D(0, 640, 0, 480);
    }
    @Override
    public void display(GLAutoDrawable drawable) {
        GL gl = drawable.getGL();
        gl.glClear(GL.GL_COLOR_BUFFER_BIT);
        gl.glTranslatef(300f, 300f, 0f);
        BresenhamCircle(0, 0, 100, gl);
        gl.glTranslatef(-40f, 30f, 0f);
        BresenhamCircle(0, 0, 20, gl);
        gl.glTranslatef(80f, 0f, 0f);
        BresenhamCircle(0, 0, 20, gl);
        gl.glTranslatef(-40f, -40f, 0f);
        BresenhamEllipse(0, 0, 15, 25, gl);
        gl.glTranslatef(0f, -40f, 0f);
        BresenhamHalfEllipse(0, 0, 35, 22, gl);
        
    }
    @Override
    public void reshape(GLAutoDrawable drawable, int x, int y, int width,int height) {
    }
    @Override
    public void displayChanged(GLAutoDrawable drawable,
            boolean modeChanged, boolean deviceChanged) {
    }
    private void BresenhamCircle(int x1, int y1, int R, GL gl) {

        int x, y, di, d1, d2, limit = 0;
        gl.glColor3f(0.0f, 0.0f, 0.0f);

        x = x1;
        y = y1+R;
        di = 2 * (1 - R);

        while (y >= limit) {
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2f(x, y);
            gl.glVertex2f(-x, y);
            gl.glVertex2f(x, -y);
            gl.glVertex2f(-x, -y);
            gl.glEnd();
            if (di < 0) {
                d1 = 2 * di + 2 * y - 1;

                if (d1 < 0) {
                    x = x + 1;
                    di = di + 2 * x + 1;
                } else {
                    x = x + 1;
                    y = y - 1;
                    di = di + 2 * x - 2 * y + 2;
                }
            } else if (di > 0) {
                d2 = 2 * di - 2 * x - 1;

                if (d2 < 0) {
                    x = x + 1;
                    y = y - 1;
                    di = di + 2 * x - 2 * y + 2;
                } else {
                    y = y - 1;
                    di = di - 2 * y + 1;
                }
            }
            if (di == 0) {
                x = x + 1;
                y = y - 1;
                di = di + 2 * x - 2 * y + 2;
            }

        }

    }

    private void BresenhamEllipse(int x1, int y1, int a, int b, GL gl) {

        int x, y, di, d1, d2, limit = 0;
        gl.glColor3f(0.0f, 0.0f, 0.0f);

        x = x1;
        y = b;
        di = b * b - 2 * a * a * b + a * a;

        while (y >= limit) {
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2f(x, y);
            gl.glVertex2f(-x, y);
            gl.glVertex2f(x, -y);
            gl.glVertex2f(-x, -y);
            gl.glEnd();
            if (di < 0) {
                d1 = 2 * di + 2 * y * a * a - a * a;
                if (d1 < 0) {
                    x = x + 1;
                    di = di + 2 * x * b * b + b * b;
                } else {
                    x = x + 1;
                    y = y - 1;
                    di = di + 2 * x * b * b - 2 * y * a * a + a * a + b * b;
                }
            } else if (di > 0) {
                d2 = 2 * di - 2 * x * b * b - b * b;
                if (d2 < 0) {
                    x = x + 1;
                    y = y - 1;
                    di = di + 2 * x * b * b - 2 * y * a * a + a * a + b * b;
                } else {
                    y = y - 1;
                    di = di - 2 * y * a * a + a * a;
                }
            }
            if (di == 0) {
                x = x + 1;
                y = y - 1;
                di = di + 2 * x * b * b - 2 * y * a * a + a * a + b * b;
            }
        }
    }

    private void BresenhamHalfEllipse(int x1, int y1, int a, int b, GL gl) {

        int x, y, di, d1, d2, limit = 0;
        gl.glColor3f(0.0f, 0.0f, 0.0f);

        x = x1;
        y = b;
        di = b * b - 2 * a * a * b + a * a;

        while (y >= limit) {
            gl.glBegin(GL.GL_POINTS);
            gl.glVertex2f(x, -y);
            gl.glVertex2f(-x, -y);
            gl.glEnd();
            if (di < 0) {
                d1 = 2 * di + 2 * y * a * a - a * a;

                if (d1 < 0) {
                    x = x + 1;
                    di = di + 2 * x * b * b + b * b;
                } else {
                    x = x + 1;
                    y = y - 1;
                    di = di + 2 * x * b * b - 2 * y * a * a + a * a + b * b;
                }
            } else if (di > 0) {
                d2 = 2 * di - 2 * x * b * b - b * b;

                if (d2 < 0) {
                    x = x + 1;
                    y = y - 1;
                    di = di + 2 * x * b * b - 2 * y * a * a + a * a + b * b;
                } else {
                    y = y - 1;
                    di = di - 2 * y * a * a + a * a;
                }
            }
            if (di == 0) {
                x = x + 1;
                y = y - 1;
                di = di + 2 * x * b * b - 2 * y * a * a + a * a + b * b;
            }

        }

    }

    public void dispose(GLAutoDrawable arg0) {
    }
}

public class circle {

    public static void main(String args[]) {      //getting the capabilities object of GL2 profile
        //final GLProfile profile=GLProfile.get(GLProfile.GL);
        GLCapabilities capabilities = new GLCapabilities();
        // The canvas
        final GLCanvas glcanvas = new GLCanvas(capabilities);
        ThirdGLEventListener b = new ThirdGLEventListener();
        glcanvas.addGLEventListener(b);
        glcanvas.setSize(400, 400);
        //creating frame
        final JFrame frame = new JFrame("Basic frame");
        //adding canvas to frame
        frame.add(glcanvas);
        frame.setSize(640, 480);
        frame.setVisible(true);
    }
}
