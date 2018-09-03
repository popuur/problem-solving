import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_12867 {
	/*
	 * N차원 여행
	 * https://www.acmicpc.net/problem/12867
	 */

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
	
		long N = Long.parseLong(br.readLine());
		int M = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		int[] idx = new int[M+1];
		char[] delta = new char[M+1];
		
		String d = br.readLine();
		
		for (int i = 1; i <= M; i++) {
			idx[i] = Integer.parseInt(st.nextToken());
			delta[i] = d.charAt(i-1);
		}
		
		ArrayList<String> travel = new ArrayList<String>();
		
		StringBuilder sb = new StringBuilder();
		for (long i = 1; i <= N; i++) {
			sb.append('0');
		}
		String str = sb.toString();
		travel.add(str);
		int result = 1;
		
		for (int i = 1; i <= M; i++) {
			if (delta[i] == '+') {
				str = str.substring(0, idx[i]-1)+"1"+str.substring(idx[i]);
			} else {
				str = str.substring(0, idx[i]-1)+"0"+str.substring(idx[i]);
			}
			
			if (!travel.contains(str)) {
				travel.add(str);
			} else {
				result = 0;
				break;
			}
		}
		bw.write(result +"\n");
		
		
		br.close();
		bw.flush();
		bw.close();

	}
}
