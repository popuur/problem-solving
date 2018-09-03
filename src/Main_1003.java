

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1003 {
	/*
	 * 피보나치 함수 
	 * 
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		
		int[][] dp = new int[41][2];

		
		dp[0][0] = 1;
		dp[1][1] = 1;
		dp[2][0] = 1;
		dp[2][1] = 1;
		
		for (int i = 3; i <= 40; i++) {
			dp[i][0] = dp[i-1][0]+dp[i-2][0];
			dp[i][1] = dp[i-1][1]+dp[i-2][1];
			
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine());
			bw.write(dp[n][0]+" "+dp[n][1]+"\n");
		}
		
			
		
		br.close();
		bw.flush();
		bw.close();
	}

}
