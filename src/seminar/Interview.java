package seminar;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.StringTokenizer;


/*
 * [2강 6번] 면접
 * http://koitp.org/problem/SDS_2_6/read/
 */
public class Interview {

	public static void main(String[] args) throws IOException {

		
		File fp = new File("res/test.txt");
		BufferedReader br = new BufferedReader(new FileReader(fp));
				
		//BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		StringTokenizer ST = new StringTokenizer(br.readLine());
		
		int N = Integer.parseInt(ST.nextToken()); //방의 갯수 1 ≤ N ≤ 100,000
		int M = Integer.parseInt(ST.nextToken()); //면접자 수 1 ≤ M ≤ 1,000,000,000
		
		long[] ROOM = new long[N];
		long[] VAL = new long[N];
		for (int i = 0; i < N; i++){
			ROOM[i] = Integer.parseInt(br.readLine());
			VAL[i] = 0;
		}
		
		//걸리는 시간 소팅
		Arrays.sort(ROOM);
		
		long MIN = ROOM[0]; //초기 최소값
		long MAX = ROOM[N-1] * M; //초기 최대값
		
		while (true) {

			long MID = (long) Math.ceil(((double)MIN + MAX) / 2); // Parametric Search
			long result = 0;

			// 비교값 더하기
			long val = 0;
			for (int i = 0; i < N; i++) {
				if (ROOM[i] * M < MID) {
					result += M;
					VAL[i] = ROOM[i] * M;
				} else {
					val = (MID / ROOM[i]);
					VAL[i] = ROOM[i] * val;
					
					if (i>0 && VAL[i-1] == VAL[i]){
						result += (val-1);
					}else {
						result += val;
					}
					
				}
			}

			if (result > M) {
				MAX = MID;
			} else if (result < M) {
				MIN = MID;
			} else if (result == M){
				Arrays.sort(VAL);
				break;
			}

		}
		
		bw.write(VAL[N-1]+"\n");
		br.close();
		bw.flush();
		bw.close();
	}

}
