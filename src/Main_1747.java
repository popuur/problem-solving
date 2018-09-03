

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1747 {
	/*
	 * 소수&팰린드롬
	 * https://www.acmicpc.net/problem/1747
	 */
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		
		int max = 4000000;
		boolean[] prime = new boolean[max+1]; //false : 소수, true : 정수
		
		prime[1] = true;
		for (int i = 2; i <= max; i++) {
			if(prime[i] == true) continue;
			for (int j = 1; i*j <= max; j++) {
				if (prime[i*j] == true) continue;
				if (j == 1) continue;
				prime[i*j] = true;
			}
		}
		
		
		int N = Integer.parseInt(br.readLine());
		int result = 0;
		for (int i = N; i <= max; i++) {
			if (prime[i] == false) {
				if(checkReverse(i)) {
					result = i;
					break;
				} 
			}
		}
		
		bw.write(result+"\n");
		br.close();
		bw.flush();
		bw.close();
	}

	static boolean checkReverse (int i) {
		
		String str = Integer.toString(i);
		int l = 0;
		int r = str.length()-1;
		boolean result = true;
		while (l <= r) {
			if (str.charAt(l) == str.charAt(r)) {
				l++;
				r--;
			} else {
				result = false;
				break;
			}
		}
		
		return result;
		
	}
}
