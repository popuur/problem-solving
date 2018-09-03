

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11726 {
	/*
	 * 2×n 타일링
	 */
	static int MOD = 10007;
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine());
		
		int[] dp = new int[N+1];
		dp[1] = 1;
		if (N > 1) {
			dp[2] = 2;
			
			for (int i = 3; i <= N; i++) {
				dp[i] = dp[i-1]+dp[i-2];
				dp[i] %= MOD;
			}
		}
		
		bw.write(dp[N]+"\n");
		
		
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
