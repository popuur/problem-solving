

import java.io.BufferedReader;

import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.StringTokenizer;

public class Main_9753 {
	/*
	 * 짝 곱
	 * https://www.acmicpc.net/problem/9753
	 */
	
	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;
		/*
		 * 정수 K (1 ≤ K ≤ 100,000)
		 * K보다 크거나 같은 서로 다른 소수의 곱 중에서 가장 작은 곱
		 * 첫째 줄에 테스트 케이스의 개수 T (1 ≤ T ≤ 20)이 주어진다. 다음 T개 줄에는 K가 한 줄에 하나씩 주어진다. 
		 */
		
		int N = 100001;
		int[] prime = new int[N+1];
		int[] primeMul = new int[N+1];
		int[] primeMul2 = new int[N+1];
		for (int i = 2; i <= N; i++) {
			prime[i] = 1;
			primeMul[i] = 0;
			primeMul2[i] = 0;
		}
		
		ArrayList<Integer> primeList = new ArrayList<Integer>();
		for (int i = 2; i <= N; i++) {
			if(prime[i] == 0) continue;
			primeList.add(i);
			for (int j = 1; i*j <= N; j++) {
				if (prime[i*j] == 0) continue;
				if (j == 1) continue;
				prime[i*j] = 0;	
			}
		}
		if (primeList.contains(49999)) {
			System.out.println("yo!");
		}
		
		for (int i = 2; i <= N; i++) {
			if (prime[i] == 0) continue;
			for (int j = i; i*j <= N; j++) {
				if (j > N) continue;
				if (prime[j] == 0) continue;
				if (i == j) continue;
				if (i*j < 0 || i*j > N) continue;
				
				if (i*j == 99998) {
					System.out.println("p1 "+i+" "+j+" "+i*j);
				}
				primeMul[i*j] = 1;
			}
		}
		
		int T = Integer.parseInt(br.readLine());
		for (int ti = 1; ti <= T; ti++) {
			try {
				int k = Integer.parseInt(br.readLine());
				int min = 100001;
				for (int i : primeList) {
					for (int j : primeList) {
						if (i == j)
							continue;
						if (i * j >= k) {
							if (i*j == 99998) {
								System.out.println("p2 "+i+" "+j+" "+i*j);
							}
							min = Math.min(min, i * j);
							primeMul2[min] = 1;
							break;
						}
					}
				}
				bw.write(min + "\n");
			} catch (NumberFormatException e) {
				bw.write("100001\n");
			}
		}
		
		for (int i = 1; i <= N; i++) {
			if (primeMul[i] == primeMul2[i]) continue;
			bw.write(i+" "+primeMul[i]+" "+primeMul2[i]+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();
	}
}
