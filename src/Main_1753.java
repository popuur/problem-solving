

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

class Edge implements Comparable<Edge>{
	int a;
	int b;
	int w;
	
	Edge (int a, int b, int w){
		this.a = a;
		this.b = b;
		this.w = w;
	}

	@Override
	public int compareTo(Edge o) {
		if (this.w < o.w) {
			return -1;
		} else if (this.w > o.w) {
			return 1;
		} else {
			return 0;
		}
	}
		
}

public class Main_1753 {
	/*
	 * 최단경로
	 * https://www.acmicpc.net/problem/1753
	 * Dijkstra
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken());	//정점의 개수 v
		int e = Integer.parseInt(st.nextToken());	//간선의 개수 e		
		int k = Integer.parseInt(br.readLine());	//시작점 k
		
		
		ArrayList<Edge>[] adjList = new ArrayList[v+1];
		for (int i = 1; i <= v; i++) {
			adjList[i] = new ArrayList<Edge>();
		}
		
		for (int i = 1; i<= e; i++) {
			st = new StringTokenizer(br.readLine());
			
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int w = Integer.parseInt(st.nextToken());

			adjList[a].add(new Edge(a, b ,w));
			//adjList[b].add(new Edge(b, a ,w));		
		}
		
		
		int[] d = new int[v+1];
		Arrays.fill(d, Integer.MAX_VALUE);
		
		PriorityQueue<Edge> pq = new PriorityQueue<>();
		pq.add(new Edge(0, k, 0));
		d[k] = 0;
		
		while(!pq.isEmpty()) {
			Edge cur = pq.poll();
			for (Edge next : adjList[cur.b]) {
				if (d[next.b] > d[cur.b]+next.w) {
					d[next.b] =  d[cur.b]+next.w;
					pq.add(next);
				}
			}	
		}
		
		for (int i = 1; i <= v; i++) {
			if(d[i] == Integer.MAX_VALUE) {
				bw.write("INF\n");
			} else {
				bw.write(d[i]+"\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
