package bojContest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_4 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		//자연수 K가 주어진다.(1 ≤ K ≤ 500,000)
		
		int n = 10000000;
		long[] prime = new long[n+1];
		
		prime[1] = 1;
		for (int i = 2; i <= n ;i++) {
			for (int j = 1; i*j <= n; j++) {
				if (j == 1) continue;
				if (prime[i*j] == 1) continue;
				prime[i*j] = 1;
			}
		}
		

		int k = Integer.parseInt(br.readLine());
		int cnt = 0;
		int result = 0;
		for (int i = 2; i <= n; i++) {
			if (prime[i] == 0) {
				cnt++;
			}
			if (cnt == k) {
				result = i;
				break;
			}
		}
		
		bw.write(result+"\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
