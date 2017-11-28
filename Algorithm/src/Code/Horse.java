package Code;

import java.util.ArrayList;
import java.util.List;

public class Horse {
    public static void main(String[] args) {
        int[][] data = {
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {0, 0, 0, 0},
                {2, 0, 0, 0},
        };
        List<Vertice> verticeList = new ArrayList<>();
        for (int i = 0; i < data.length; i++) {
            for (int j = 0; j < data[i].length; j++) {
                if (data[i][j] == 2) {

                }
            }
        }
    }
    public class Vertice{
        int x;

        int y;

        public int getX() {
            return x;
        }

        public void setX(int x) {
            this.x = x;
        }

        public int getY() {
            return y;
        }

        public void setY(int y) {
            this.y = y;
        }
    }
}
