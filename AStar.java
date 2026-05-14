import java.util.*;

class Node implements Comparable<Node> {
    int x, y, g, h;
    public Node(int x, int y, int g, int h) {
        this.x = x;
        this.y = y;
        this.g = g;
        this.h = h;
    }

    int f() {
        return g + h;
    }

    @Override
    public int compareTo(Node other) {
        return Integer.compare(this.f(), other.f());
    }
}

class GameMap {
    int n, m;
    int[][] grid;

    public GameMap(int n, int m) {
        this.n = n;
        this.m = m;
        grid = new int[n][m];
    }

    void addObstacle(int x, int y) {
        grid[x][y] = 1;
    }

    void display() {
        System.out.println("\nGame Map (0=Free, 1=Obstacle):");
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                System.out.print(grid[i][j] + " ");
            }
            System.out.println();
        }
    }
    // manhattan distance
    private int heuristic(int x1, int y1, int x2, int y2) {
        return Math.abs(x1 - x2) + Math.abs(y1 - y2);
    }

    public void aStar(int sx, int sy, int gx, int gy) {
        PriorityQueue<Node> pq = new PriorityQueue<>();
        boolean[][] visited = new boolean[n][m];
        
        pq.add(new Node(sx, sy, 0, heuristic(sx, sy, gx, gy)));

        int[] dx = {-1, 1, 0, 0};
        int[] dy = {0, 0, -1, 1};

        System.out.println("Path Traversal (A*): ");


        while(!pq.isEmpty()) {
            Node curr = pq.poll();
            int x = curr.x;
            int y = curr.y;

            if(visited[x][y]) continue;

            visited[x][y] = true;

            System.out.println("(" + x + ", " + y + ")");

            // goal state check
            if(x == gx && y == gy) {
                System.out.println("Goal State Reached");
                return;
            }

            for(int i=0; i<4; i++) {
                int nx = x + dx[i];
                int ny = y + dy[i];

                // check if its in the bounds
                if(nx >= 0 && ny >= 0 && nx < n && ny < m && grid[nx][ny] == 0 && !visited[nx][ny]) {
                    int newG = curr.g + 1;
                    int newH = heuristic(nx, ny, gx, gy);
                    pq.add(new Node(nx, ny, newG, newH));
                }
            }
        }

        System.out.println("\nNo Path Found!");

    }
}

public class AStar {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter grid size (rows cols): ");
        int n = sc.nextInt();
        int m = sc.nextInt();

        GameMap game = new GameMap(n, m);
        int choice;

        do {
            System.out.println("\n===== GAME PATH MENU =====");
            System.out.println("1. Add Obstacle");
            System.out.println("2. Display Map");
            System.out.println("3. Find Path (A*)");
            System.out.println("4. Exit");
            System.out.print("Enter choice: ");
            choice = sc.nextInt();

            switch (choice) {
                case 1:
                    System.out.print("Enter obstacle position (x y): ");
                    int ox = sc.nextInt();
                    int oy = sc.nextInt();
                    game.addObstacle(ox, oy);
                    break;

                case 2:
                    game.display();
                    break;

                case 3:
                    System.out.print("Enter start (x y): ");
                    int sx = sc.nextInt();
                    int sy = sc.nextInt();
                    System.out.print("Enter goal (x y): ");
                    int gx = sc.nextInt();
                    int gy = sc.nextInt();
                    game.aStar(sx, sy, gx, gy);
                    break;

                case 4:
                    System.out.println("Exiting...");
                    break;

                default:
                    System.out.println("Invalid choice!");
            }
        } while (choice != 4);

        sc.close();
    }
}
