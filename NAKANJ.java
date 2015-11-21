import java.util.*;

//full disclosure: took cues from solution by cormacpayne
//https://github.com/cormacpayne/SPOJ/blob/master/NAKANJ/NAKANJ.java

public class Main {
    public static int[] dx = {2, 1, -1, -2, -2, -1, 1, 2};
    public static int[] dy = {1, 2, 2, 1, -1, -2, -2, -1};

    public static void main(String[] args) {

        Scanner stdin = new Scanner(System.in);
        int t = Integer.parseInt(stdin.next());
        int x1,y1,x2,y2;

        while (t > 0) {
            String s = stdin.next();
            String e = stdin.next();
            x1= Character.getNumericValue(s.charAt(0))-10;
            y1= Character.getNumericValue(s.charAt(1)) - 1;
            x2= Character.getNumericValue(e.charAt(0))-10;
            y2= Character.getNumericValue(e.charAt(1)) -1;
            System.out.println(bfs(x1,y1,x2,y2));
            t--;
        }

        stdin.close();
    }

    public static int bfs(int x1, int y1, int x2, int y2) {

        LinkedList<Pair> q = new LinkedList<Pair>();
        int best = Integer.MAX_VALUE;
        boolean[][] visited = new boolean [8][8];
        Pair tmp = null;
        q.push(new Pair(0, x1, y1));

        while (!q.isEmpty()) {
            tmp = q.pop();

            if(tmp.x == x2 && tmp.y == y2) {
                break;
            }

            for (int i = 0; i < 8; i++) {
                int x = tmp.x + dx[i];
                int y = tmp.y + dy[i];

                if (x >= 0 && x < 8 && y >= 0 && y < 8 && !visited[x][y]) {
                    visited[x][y] = true;
                    q.add(new Pair(tmp.l + 1, x, y));
                }
            }

        }
        return tmp.l;
    }

    public static class Pair {
        public int l;
        public int x;
        public int y;
        public Pair(int l, int x, int y) {this.l = l; this.x = x; this.y = y;};
    }
}
