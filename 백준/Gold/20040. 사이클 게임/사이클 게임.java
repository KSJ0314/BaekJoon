import java.io.*;
import java.util.*;

public class Main {
    static int[] parent;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        parent = new int[n];
        for (int i = 0; i < n; i++) parent[i] = i;

        int result = 0;

        for (int i = 1; i <= m; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            if (!union(a, b)) {
                result = i;
                break;
            }
        }

        System.out.println(result);
    }

    static int find(int x) {
        if (parent[x] == x) return x;
        return parent[x] = find(parent[x]);
    }

    static boolean union(int a, int b) {
        int pa = find(a);
        int pb = find(b);

        if (pa == pb) return false;

        parent[pb] = pa;
        return true;
    }
}