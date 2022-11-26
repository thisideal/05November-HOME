package november_12;

import java.awt.*;
import java.io.IOException;
import java.util.Random;

public class Game {
    public Random r;
    public Turtle t;
    public TurtlePath tp;

    int xLimit = 250;
    int yLimit = 250;
    int iterations = 50;
    Color[] colors = { Color.RED, Color.GREEN, Color.BLUE, Color.YELLOW, Color.MAGENTA, Color.CYAN };

    public Game() {
        t = new Turtle();
        r = new Random();
        tp = new TurtlePath();
    }

    public  void generate(int iterations) {
        for (int i = 0; i < iterations; i++) {
            int x = r.nextInt(2*xLimit) - xLimit;
            int y = r.nextInt(2*xLimit) -yLimit;
            int color = r.nextInt(colors.length);
            tp.add(x, y, color);
        }
    }

    public void gogo() {
        for (int i = 0; i < tp.getLen(); i++) {
            t.penColor(colors[tp.getColor(i)]);
            t.setPosition(tp.getX(i), tp.getY(i));
        }
    }

    @SuppressWarnings("unused")
    public static void main(String[] args) throws IOException {
        Game g = new Game();

        g.t.speed(1);
        g.t.width(1);

//        for (int i = 0; i < iterations; i++) {
//            int new_color = g.r.nextInt(colors.length-1);
//            g.t.penColor(colors[new_color]);
//            int x = g.r.nextInt(xLimit*2) - xLimit;
//            int y = g.r.nextInt(yLimit*2) - yLimit;
//            g.t.setPosition(x, y);
//
//            g.tp.add(x, y, new_color);
//        }
//        g.tp.save("src/november_12/path.txt");

        g.generate(1200);
        g.gogo();
        g.tp.save("src\\november_12\\path.txt");

    }
}
