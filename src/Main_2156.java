import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class Main_2156 {
	/*
	 * 포도주 시식
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] w = new int[N+1];
		for (int i = 1; i <= N; i++) {
			w[i] = Integer.parseInt(br.readLine());
		}
		
		int[]d = new int[N+1];
		
		if (N == 1) {
			d[1] = w[1];
		} else if (N == 2) {
			d[2]= w[2]+w[1];			
			
		} else {
			d[1] = w[1];
			d[2]= w[2]+w[1];
			
			for (int i = 3; i <= N; i++) {
				d[i] = Math.max(d[i-1], Math.max(w[i]+d[i-2], w[i]+w[i-1]+d[i-3]));
			}
		}
		
		bw.write(d[N]+"\n");	
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
