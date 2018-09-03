package bojContest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_6 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		/*
		 * 재성이가 재혁이를 때린 날수 N과 재성이가 변덕을 부린 날의 개수 Q1, 재혁이가 얼마나 맞았는지 궁금한 날의 구간 Q2가 주어진다. (1 ≤ N ≤ 1,000,000, 1 ≤ Q1, Q2 ≤ 10,000)
			그 다음줄엔 재혁이가 i번째 날에 맞았던 충격이 ai가 주어진다.(1 ≤ ai ≤ 1,500,000)
			그 다음 Q1+Q2 줄에는 다음과 같은 쿼리가 주어진다.
				1 n m : 재혁이가 n일부터 m일까지 맞은 양을 출력한다. 이 1번 쿼리는 Q2개 주어진다.(1 ≤ n, m ≤ N)
				2 s e l : 재성이가 s일에서 e일까지로 돌아가서 l의 파워를 더해서 때릴 수 있다. 이 2번쿼리는 Q1개 주어진다.(-1,000 ≤ l ≤ 1,000, 1 ≤ s, e ≤ N)

				4 1 2 #N Q1 Q2
				
				1 2 3 4 #ai 
				
				1 1 4	#1 출력
				2 1 4 5 #2 update
				1 1 4
		 */
		
		StringTokenizer st;
		st = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(st.nextToken());
		int Q1 = Integer.parseInt(st.nextToken());
		int Q2 = Integer.parseInt(st.nextToken());
		
		IndexTree it = new IndexTree(N);
		
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			long ai = Long.parseLong(st.nextToken());
			it.set(i, ai);
		}
		for (int i = 1; i <= Q1+Q2; i++) {
			st = new StringTokenizer(br.readLine());
			int q = Integer.parseInt(st.nextToken());
			
			if (q == 1) { //출력
				int n = Integer.parseInt(st.nextToken());
				int m = Integer.parseInt(st.nextToken());
				bw.write(it.search(n, m)+"\n");
			} else {	// 저장
				int s = Integer.parseInt(st.nextToken());
				int e = Integer.parseInt(st.nextToken());
				long l = Long.parseLong(st.nextToken());
				
				for (int j = s; j <= e; j++) {
					it.set(j, l);
				}
			}
			
		}
				
		br.close();
		bw.flush();
		bw.close();
	}
	
	static class IndexTree {
		
		int sz = 0;
		long[] tree;
		
		IndexTree(int n){
			for (sz = 1; sz <= n; sz*=2);
			tree = new long[sz*2];
			sz--;
		}
		
		void set (int idx, long val) {
			idx += sz;
			while(idx >= 1) {
				tree[idx] += val;
				idx /= 2;
			}
		}
		
		long search (int l, int r) {
			
			l += sz;
			r += sz;
			long result = 0;
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
