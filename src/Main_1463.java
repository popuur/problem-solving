
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_1463 {

	public static void main(String[] args) throws IOException {

		// System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine());
		long[] D = new long[N + 1];

		D[1] = 0;
		if (N >= 2) {
			D[2] = 1;
			if (N >= 3) {
				D[3] = 1;
				if (N >= 4) {
					for (int i = 4; i <= N; i++) {
						long res1 = Long.MAX_VALUE;
						long res2 = Long.MAX_VALUE;
						long res3 = Long.MAX_VALUE;

						if (i % 3 == 0) {
							int temp1 = i / 3;
							res1 = 1 + D[temp1];
						}
						if (i % 2 == 0) {
							int temp2 = i / 2;
							res2 = 1 + D[temp2];
						}

						int temp3 = i - 1;
						res3 = 1 + D[temp3];

						long min1 = Math.min(res1, res2);
						long min2 = Math.min(res2, res3);

						long min = Math.min(min1, min2);
						D[i] = min;
					}
				}

			}

		}

		bw.write(D[N] + "\n");

		br.close();
		bw.flush();
		bw.close();
	}

}
