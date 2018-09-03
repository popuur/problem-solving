import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class Main_11003_indexTree_2017 {

	public static void main(String[] args) throws IOException {
		//System.setIn(new FileInputStream("res/algo3/HW.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		
		
		int N = Integer.parseInt(br.readLine());
		
		
		
		int[] B = new int[N+1];
		int MAX = 0;
		StringTokenizer ST = new StringTokenizer(br.readLine());
		for (int i = 1; i <= N; i++){
			B[i] = Integer.parseInt(ST.nextToken());
			MAX = (MAX > B[i]) ? MAX:B[i];
		}
		int SZ = 1;
		for (SZ = 1; SZ <= MAX; SZ *= 2);
		SZ--;
		
		
		int[] A = new int[MAX*4];		
		for (int i = 1; i <= N; i++){
			MAX = 0;
			int l = 1+SZ;
			int r = B[i]+SZ-1;
			while (l <= r){
				if (l%2 == 1){
					MAX = (MAX > A[l]) ? MAX:A[l];
				}
				l = (l+1)/2;
				
				if (r%2 == 0){
					MAX = (MAX > A[r]) ? MAX:A[r];
				}
				r = (r-1)/2;
			}
			MAX = MAX + 1;
			
			int pos = B[i]+SZ;
			while (pos >= 1){
				A[pos] = (MAX > A[pos]) ? MAX : A[pos];
				pos /= 2;
			}
		}
		
		bw.write(A[1]+"\n");		
		
		br.close();
		bw.flush();
		bw.close();
	}
	
	

}
