

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1546 {
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		int max = -1;
		
		int[] val = new int[N+1];
		
		for (int i = 1; i <= N; i++) {
			val[i] = Integer.parseInt(st.nextToken());
			max = Math.max(max, val[i]);
		}
		
		float[] avg = new float[N+1];
		
		float accVal = 0;
		for (int i = 1; i <= N; i++) {
			avg[i] = (float)val[i]/max*100;
			
			accVal += avg[i];
		}
		System.out.printf("%.2f", (accVal/N));

		br.close();
		bw.flush();
		bw.close();
	}

}
