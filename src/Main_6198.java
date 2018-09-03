import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.StringTokenizer;
import java.util.TreeSet;

public class Main_6198 {
	/*
	 * 옥상 정원 꾸미기
	 * https://www.acmicpc.net/problem/6198
	 * index tree
	 * 인덱스 역순정렬
	 * 
	 */
	
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		
		int n = Integer.parseInt(br.readLine());
		
		Roof[] roof = new Roof[n+1];
		for (int i = 1; i <= n; i++) {
			int high = Integer.parseInt(br.readLine());
			roof[i] = new Roof(i, high);
		}
		
		Arrays.sort(roof, 1, n+1, new compDesc());
		long result = 0;
		
		
		IndexTree idxTree = new IndexTree(n);
		
		for (int i = 1; i <= n; i++) {
			result += idxTree.search(1, roof[i].idx);
			idxTree.set(roof[i].idx, 1);
		}
		
		bw.write(result+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static class compDesc implements Comparator<Roof> {

		@Override
		public int compare(Roof o1, Roof o2) {
			return o2.high-o1.high;
		}
		
	}
	
	static class Roof {
		
		int idx;
		int high;
		
		Roof (int idx, int high){
			this.idx = idx;
			this.high = high;
		}
	}
	
	static class IndexTree {
		
		int sz = 0;
		int[] tree;
		IndexTree (int n){
			for (sz = 1; sz <= n; sz*=2);
			tree = new int[sz*2];
			sz--;
		}
		
		void set (int idx, int val) {
			idx += sz;
			while (idx >= 1) {
				tree[idx] += val;
				idx /= 2;
			}
		}
		
		int search (int l, int r) {
			l = sz + l;
			r = sz + r;
			
			int result = 0;
			
			while (l <= r) {
				if (l%2 == 1) {
					result += tree[l];
				}
				l++;
				l/=2;
				
				if (r%2 == 0) {
					result += tree[r];
				}
				r--;
				r/=2;
			}
			return result;
		}
	}

}
