

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_9095 {
	public static void main(String[] args) throws IOException {

		//System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer ST;
		
		int[] d = new int[12];
		
		d[1] = 1;
		d[2] = 2;
		d[3] = 4;
		
		for (int i = 4; i <= 11;i++) {
			d[i] = d[i-1]+d[i-2]+d[i-3];
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int i = 1; i <= T; i++) {
			int n = Integer.parseInt(br.readLine());
			
			bw.write(d[n]+"\n");
			
			
			
		}

		
		br.close();
		bw.flush();
		bw.close();
	}

}
