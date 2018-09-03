package bojContest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_5 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		int N = Integer.parseInt(br.readLine());
		int[] a = new int [N+1];
		StringTokenizer st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++) {
			a[i] = Integer.parseInt(st.nextToken());
		}
		
		
		int cnt = 1;
		int result = 0;
		for (int i = 1; i <= N; i++) {
			if (a[i] == a[1]+(cnt-1)) {
				cnt++;
				result++;
			}
		}
		bw.write(cnt-1+"\n");
		
		
		br.close();
		bw.flush();
		bw.close();
	}

}
