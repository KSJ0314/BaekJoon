import java.util.*;
import java.io.*;

class Main {
	static class Node{
		int no;
		ArrayList<Node> childs = new ArrayList<>();
		
		public Node(int no) {
			this.no = no;
		}
	}
	static int N;
	static Node[] nodes;
	
    public static void main(String[] args) throws IOException {
        init();
        System.out.println(fn(0));
    }

	private static int fn(int idx) {
		List<Integer> list = new ArrayList<>();

	    for (Node child : nodes[idx].childs) {
	        list.add(fn(child.no));
	    }
	    list.sort(Collections.reverseOrder());
	    
	    int ret = 0;
	    for (int i = 0; i < list.size(); i++) {
	        ret = Math.max(ret, list.get(i) + i + 1);
	    }
		return ret;
	}

	public static void init() throws IOException {
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	String[] inputs;
    	
    	inputs = br.readLine().split(" ");
        N = Integer.parseInt(inputs[0]);
        
        nodes = new Node[N];
        nodes[0] = new Node(0);
        for (int i = 0; i < N; i++) {
			nodes[i] = new Node(i);
		}
        
        inputs = br.readLine().split(" ");
        for (int i = 1; i < N; i++) {
        	nodes[Integer.parseInt(inputs[i])].childs.add(nodes[i]);
		}
    }
}