import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Main_11505 {
	/*
	 * 구간 곱 구하기
	 * https://www.acmicpc.net/problem/11505	 * 
	 */
	static long MOD = 1000000007;
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		/*
		 * 5 2 2
			1
			2
			3
			4
			5
			1 3 6
			2 2 5
			1 5 2
			2 3 5
		 */
		
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());	//M은 수의 변경이 일어나는 회수이고
		int K = Integer.parseInt(st.nextToken());	//K는 구간의 곱을 구하는 회수
		
		IndexTree it = new IndexTree(N);
		long[] a = new long[N+1];
		for (int i = 1; i <= N; i++) {
			a[i] = Long.parseLong(br.readLine());
			it.set(i, a[i]);	//초기값
		}
		
		for (int i = 1; i <= M+K; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int c = Integer.parseInt(st.nextToken());
			if (q == 1) {	//값 변경
				it.set(b, c);
			}
			if (q == 2) {	//값 출력
				long ans = it.search(b, c);
				bw.write(ans+"\n");
			}
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	static class IndexTree {
		
		long[] tree;
		int sz = 0;
		
		IndexTree(int n){
			for (sz = 1; sz <= n; sz*=2);
			tree = new long[sz*2];
			sz--;
		}
			
		void set (int idx, long val) {
			idx += sz;
			tree[idx] = val;
			
			while (idx > 1) {
				idx /= 2;
				tree[idx] = tree[idx*2]* tree[idx*2+1]%MOD;
				tree[idx] %= MOD;
			}
		}
		
		long search (int l, int r) {
			l += sz;
			r += sz;
			long result = 1;
			while(l <= r) {
				if (l%2 == 1) {
					result = (result*tree[l])%MOD;
				}
				l++;
				l /= 2;
				
				if (r%2 == 0) {
					result = (result*tree[r])%MOD;
				}
				r--;
				r /= 2;
			}
			return result;
		}
	}

}
