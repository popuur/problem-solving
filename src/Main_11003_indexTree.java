

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.StringTokenizer;

public class Main_11003_indexTree {
	/*
	 * 가장 긴 증가하는 부분 수열 (LIS)
	 * https://www.acmicpc.net/problem/11053
	 * 인덱스트리, index tree
	 */
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
				
		int n = Integer.parseInt(br.readLine());
		
		Line[] line = new Line[n+1];
		
		st = new StringTokenizer(br.readLine());
		line[0] = new Line(0, 0);
		for (int i = 1; i <= n; i++) {
			int val = Integer.parseInt(st.nextToken());
			line[i] = new Line(i, val);
		}
		Arrays.sort(line, 1, n+1, new compAsc());
		
		int cnt = 0;
		for (int i = 1; i <= n; i++) {
			
			if (line[i].val != line[i-1].val) {
				cnt++;
			}
			line[i].relabel = cnt;
		}
		
		
		IndexTree it = new IndexTree(n);
		
		int result = 0;
		for (int i = 1; i <= n; i++) {
			int idx = it.search(1, line[i].idx-1);
			idx += 1;
			result = Math.max(result, idx);
			
			it.set(line[i].idx, line[i].idx);
		}
		
		bw.write(result+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static class Line {
		int idx;
		int val;
		int relabel;
		
		Line (int idx, int val){
			this.idx = idx;
			this.val = val;
		}	
	}
	
	static class compAsc implements Comparator<Line> {

		@Override
		public int compare(Line o1, Line o2) {
			return o1.val - o2.val;
		}
	}
	
	static class IndexTree {
		
		int sz = 0;
		int[] tree;
		IndexTree(int n){
			
			for (sz = 1; sz <= n; sz *= 2);
			tree = new int[sz*2];
			sz--;
		}
		
		
		int search (int l, int r) {
			int result = 0;
			
			l = sz + l;
			r = sz + r;
			
			while (l <= r) {
				if (l%2 == 1) {
					result = Math.max(tree[l], result);
				}
				l++;
				l/=2;
				
				if (r%2 == 0) {
					result = Math.max(tree[r], result);
				}
				r--;
				r/=2;
			}
			return result;
		}
		
		void set (int idx, int val) {
			idx += sz;
			while (idx >= 1) {
				tree[idx] = Math.max(tree[idx], val);
				idx /= 2;
			}
		}
	}

}
