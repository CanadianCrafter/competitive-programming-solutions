import java.util.*;
import java.io.*;
public class VM7WC15C4P3GChainRule {
    static BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    static PrintWriter pr = new PrintWriter(new BufferedWriter(new OutputStreamWriter(System.out)));
    static StringTokenizer st;
    public static void main(String[] args) throws IOException {
    	int N = readInt();
    	int M = readInt();
    	int dis[] = new int[N+1];
    	Arrays.fill(dis,Integer.MAX_VALUE);
    	int dis2[] = new int[N+1];
    	Arrays.fill(dis2,Integer.MAX_VALUE);
    	ArrayList<Node> adj[] = new ArrayList [N];
    	for(int i =0;i<N;i++)
    		adj[i] = new ArrayList<Node>();
    	
    	PriorityQueue<Node> pq = new PriorityQueue();
    	PriorityQueue<Node> pq2 = new PriorityQueue();
    	
    	for(int i =0;i<M;i++) {
    		int u = readInt();
    		int v = readInt();
    		int w = readInt();
    		adj[u].add(new Node(v,w));
    		adj[v].add(new Node(u,w));
    		
    	}
    	pq.add(new Node(0,0));
    	dis[0]=0;
    	while(!pq.isEmpty()) {
    		Node cur = pq.poll();
    		if(cur.w>dis[cur.v]) continue;
    		for(Node node:adj[cur.v]) {
    			if(dis[node.v]>dis[cur.v]+node.w) {
    				dis[node.v]=dis[cur.v]+node.w;
    				pq.add(new Node(node.v,dis[node.v]));
    			}
    		}
    	}
    	
    	pq2.add(new Node(N-1,0));
    	dis2[N-1]=0;
    	while(!pq2.isEmpty()) {
    		Node cur = pq2.poll();
    		if(cur.w>dis2[cur.v]) continue;
    		for(Node node:adj[cur.v]) {
    			if(dis2[node.v]>dis2[cur.v]+node.w) {
    				dis2[node.v]=dis2[cur.v]+node.w;
    				pq2.add(new Node(node.v,dis2[node.v]));
    			}
    		}
    	}
    	
    	int max =0;
    	for(int i =0;i<N;i++) {
    		max = Math.max(max,dis2[i]+dis[i]);
    	}
    	System.out.println(max);
    }
    static String next () throws IOException {
        while (st == null || !st.hasMoreTokens())
            st = new StringTokenizer(br.readLine().trim());
        return st.nextToken();
    }
    static long readLong () throws IOException {
        return Long.parseLong(next());
    }
    static int readInt () throws IOException {
        return Integer.parseInt(next());
    }
    static double readDouble () throws IOException {
        return Double.parseDouble(next());
    }
    static char readCharacter () throws IOException {
        return next().charAt(0);
    }
    static String readLine () throws IOException {
        return br.readLine().trim();
    }
    
    static class Node implements Comparable<Node>{
    	int v;
    	int w;
    	public Node(int v, int w) {
    		this.v=v;
    		this.w=w;
    	}
		@Override
		public int compareTo(Node x) {
			return Integer.compare(w, x.w);
		}
    	
    	
    }
    
}


