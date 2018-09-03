package bojContest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_2 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		long q = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		
		if (q == a) {
			bw.write("1\n");
		} else {
			bw.write("0\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}

}
