import java.util.*;
public class FamilyTree {
    Map<String, List<String>> adj = new HashMap<>();

    Set<String> visited = new HashSet<>();

    Queue<String> que = new LinkedList<>();
    
    void addRelation(String s1, String s2) {
        adj.putIfAbsent(s1, new ArrayList<>());
        adj.putIfAbsent(s2, new ArrayList<>());
        adj.get(s1).add(s2);
        adj.get(s2).add(s1);
    }

    void dfs(String start) {
        visited.add(start);
        System.out.println(start);

        for(String adjNode : adj.get(start)) {
           if(!visited.contains(adjNode)) {
                dfs(adjNode);
           }
        }
    }

    void bfs(String start) {
        que.add(start);
        visited.add(start);
        while(!que.isEmpty()) {
            String node = que.poll();
            System.out.println(node);
            for(String adjNode : adj.get(node)) {
                if(!visited.contains(adjNode)) {
                    que.add(adjNode);
                    visited.add(adjNode);
                }
            }
        }
    }

    public static void main(String[] args) {
        FamilyTree tree = new FamilyTree();

        tree.addRelation("Grandfather", "Father");
        tree.addRelation("Grandfather", "Uncle");
        tree.addRelation("Father", "Son");
        tree.addRelation("Father", "Daughter");
        
        System.out.println("BFS: ");
        tree.bfs("Grandfather");
        System.out.println("DFS: ");
        tree.dfs("Grandfather");
    }
}
