package november_12;

import java.io.IOException;
//import java.io.InputStream;
//import java.io.Reader;
//import java.io.StringReader;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;

public class TurtlePath {
    List<Integer> x = new ArrayList<>();
    List<Integer> y = new ArrayList<>();
    List<Integer> color = new ArrayList<>();

//    public void load(String path) {
//        Path p = Paths.get(path);
//
//        String result = "";
//        try {
//            for (String line : Files.readAllLines(p)) {
//                result += line;
//            }
//        } catch (IOException ignored) {
//        }
//
//        result = result.replace(" ", "");
//        Scanner s = new Scanner(new StringReader(result));
//
//        x.clear();
//        y.clear();
//        color.clear();
//
//        int i = 0;
//        while(s.hasNext("\\d,\\d,\\d")) {
//            x.add(s.nextInt());
//            s.next(",");
//            y.add(s.nextInt());
//            s.next(",");
//            color.add(s.nextInt());
//            System.out.printf("it %d\n", i++);
//        }
//
//    }

    public void load(String path) throws IOException {
        Path p = Paths.get(path);
        ArrayList<String> result;
        result  = new ArrayList<String>(Files.readAllLines(p));

        for(String s : result)
        {
            String[] part = s.replace(" ", "").split(",");
            int _x = Integer.parseInt(part[0]);
            int _y = Integer.parseInt(part[1]);
            int _color = Integer.parseInt(part[2]);

            x.add(_x);
            y.add(_y);
            color.add(_color);
        }
    }

    public void save(String path) {
        Path p = Paths.get(path);

        StringBuilder result = new StringBuilder();
        for (int i = 0; i < x.size(); i++) {
            result.append(String.format("%d, %d, %d\n", x.get(i), y.get(i), color.get(i)));
        }

        byte[] bytes = result.toString().getBytes();
        try {
            Files.write(p, bytes);
        } catch (IOException ignored) {
        }
    }

    public void add(int x, int y, int color)
    {
        this.x.add(x);
        this.y.add(y);
        this.color.add(color);
    }

    public  int getLen() { return x.toArray().length; }

    public int getX(int i) {return x.get(i);}
    public int getY(int i) {return y.get(i);}
    public int getColor(int i) {return color.get(i);}
}
