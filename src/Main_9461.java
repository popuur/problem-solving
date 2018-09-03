

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9461 {
	/*
	 * 파도반 수열
	 * https://www.acmicpc.net/problem/9461
	 */
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer ST;
		
		long[] d = new long[101];
		
		d[1] = 1;
		d[2] = 1;
		d[3] = 1;
		for (int i = 4; i <= 100; i++) {
			d[i] = d[i-2]+d[i-3];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= T; ti++) {
			int N = Integer.parseInt(br.readLine());
			bw.write(d[N]+"\n");
		}
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
