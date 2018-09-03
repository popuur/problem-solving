package hw;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class Dictionary {

	/*
	 * 사전
	 * https://www.acmicpc.net/problem/1256
	 */
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/algo2/HW.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		int n = Integer.parseInt(ST.nextToken()); //a개
		int m = Integer.parseInt(ST.nextToken()); //z개
		int k = Integer.parseInt(ST.nextToken()); //2번째
		
		int N = n+m;
		int K = m;
		
		long[][] D = new long[N+1][K+1];
		for (int i = 1; i <= N; i++){
			for (int j = 0; j <= Math.min(i,  K); j++){
				if (j == 0 || i == j){
					D[i][j] = 1;
				} else {
					D[i][j] = (D[i-1][j]+ D[i-1][j-1]);
				}
				
			}
		}
		
		
		D[N][K] = Math.min(D[N][K], 1000000001);
		char[] C = new char[N+1];
		if (D[N][K] < k) {
			bw.write("-1\n");
		} else {
			/*
			Arrays.fill(C, 'a');
			for (int i = K; i >= 1; i--){
				outout : for (int j = 1; j <= N; j++){
					if (k <= D[j][i]){
						if (k == 1){
							C[j] = 'z';
						} else {
							C[j] = 'z';
							k -= D[j-1][i];
						}
						break outout;
					}
				}
			}
			*/
			int idx = K;
			for (int j = 1; j <= N; j++){
				if (k > D[n+m-1][m]){
					//C[j] = 'z';
					//bw.write("z");
					System.out.print("z");
					k -= D[n+m-1][m];
					
					m--;
				} else {
					//bw.write("a");
					System.out.print("a");
					n--;
					
				}
			}
			
			/*
			for (int i = N; i >= 1; i--){
				bw.write(C[i]);
			}
			*/
			//bw.write("\n");
			System.out.println("");
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
