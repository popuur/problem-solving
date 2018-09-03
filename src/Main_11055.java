

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Stack;
import java.util.StringTokenizer;

public class Main_11055 {
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int[N+1];
		int[] d = new int[N+1];
		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		for (int i = 1; i <= N; i++) {
			d[i] = a[i];
		
			for (int j = 1; j < i; j++) {
				if (a[i] > a[j]) {
					d[i] = Math.max(d[j] + a[i], d[i]);
		
				}	
			}
		}
		int max = 0;
		for (int  i = 1; i <= N; i++) {
			max = Math.max(max, d[i]);
		}
		
		
		
		bw.write(max+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
