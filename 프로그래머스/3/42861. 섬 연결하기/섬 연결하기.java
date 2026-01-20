import java.util.*;

class Solution {
    public class Edge implements Comparable<Edge>{
        int a, b, dist;
        
        public Edge(int a, int b, int dist){
            this.a = a;
            this.b = b;
            this.dist = dist;
        }
        
        public int compareTo(Edge o){
            return Integer.compare(this.dist, o.dist);
        }
    }
    
    int[] parents;
    ArrayList<Edge> edges;
    
    public int solution(int n, int[][] costs) {
        edges = new ArrayList<>();
        for (int[] cost : costs){
            edges.add(new Edge(cost[0], cost[1], cost[2]));
        }
        Collections.sort(edges);
        
        parents = new int[n];
        makeUnion();
        
        int cnt = n, sum = 0;
        while (cnt > 0){
            for (Edge edge : edges){
                if (!union(edge.a, edge.b)) {
                    sum += edge.dist;
                    break;
                }
            }
            cnt--;
        }
        
        return sum;
    }
    
    public void makeUnion(){
        for (int i = 0; i < parents.length; i++){
            parents[i] = i;
        }
    }
    
    public boolean union(int a, int b){
        int aR = find(a);
        int bR = find(b);
        if (aR == bR) return true;
        parents[bR] = aR;
        return false;
    }
    
    public int find(int a){
        if (a == parents[a]) return a;
        return parents[a] = find(parents[a]);
    }
}