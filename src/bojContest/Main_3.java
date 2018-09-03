package bojContest;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_3 {
	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());
		
		
		long q = Long.parseLong(st.nextToken());
		long a = Long.parseLong(st.nextToken());
		
		/* (A+B)×(A-B)*/
		
		bw.write((q+a)*(q-a)+"\n");
		
		br.close();
		bw.flush();
		bw.close();
	}

}
