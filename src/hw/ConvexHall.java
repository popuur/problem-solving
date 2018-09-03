package hw;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Stack;
import java.util.StringTokenizer;

class Point {
	int x;
	int y;
	
	Point (int x, int y){
		this.x = x;
		this.y = y;
	}
}


public class ConvexHall {
	/*
	 * 볼록 껍질 
	 * https://www.acmicpc.net/problem/1708
	 */
	
	static int MINY;
	static int MINX;
	
	public static void main(String[] args) throws IOException {

		/*
		 * 1. 최하단, 좌측점을 기준
		 * 2. 점을 각도순으로 정렬
		 * 3. STACK과 CCW사용
		 * 3.2 양수 > 0 : STACK에 다음점을 넣고 PASS
		 * 3.3 음수 < 0 : STACK의 마지막 원소 제거, repeat
		 */
		
		
		System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
	
		int N = Integer.parseInt(br.readLine());
		ArrayList<Point> A = new ArrayList<Point>();
		
		StringTokenizer ST;
		MINY = 40001;
		MINX = 40001;
		for (int i = 1; i <= N; i++){
			ST = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(ST.nextToken());
			int y = Integer.parseInt(ST.nextToken());
			
			if (y <= MINY){
				MINY = y;
				if (x < MINX){
					MINX = x;
				}
			}
			
			A.add(new Point(x, y));
		}
		
		Collections.sort(A, new Comparator<Point>() {

			@Override
			public int compare(Point arg0, Point arg1) {
				int ret = ccw(MINX, MINY, arg0.x, arg0.y, arg1.x, arg1.y);
				if (ret > 0){
					return -1;
				} else if (ret < 0){
					return 1;
				}
				
				int a = dist(MINX, MINY, arg0.x, arg0.y);
				int b = dist(MINX, MINY, arg1.x, arg1.y);
				if (a < b){
					return -1;
				} else if (a > b){
					return 1;
				}				
				
				return 0;
			}
		});
		
		
		/*
		 * 3. STACK과 CCW사용
		 * 3.1 CCW(STACK의 마지막 두점, 다음점)
		 * 3.2 양수 > 0 : STACK에 다음점을 넣고 PASS
		 * 3.3 음수 < 0 : STACK의 마지막 원소 제거, repeat
		 */

		Stack<Point> CVH = new Stack<Point>();
		CVH.push(A.get(0));
		CVH.push(A.get(1));
		
		int index = 2;
		while(index < N){
			Point XY2 = CVH.pop();
			Point XY1 = CVH.pop();
			Point NEXT = A.get(index);
			
			
			int check = ccw(XY1.x, XY1.y, XY2.x, XY2.y, NEXT.x, NEXT.y);
			
			if (check <= 0){
				CVH.push(XY1);
				CVH.push(NEXT);
			} else if (check > 0){
				CVH.push(XY1);
				CVH.push(XY2);
				CVH.push(NEXT);
				
			}
			index++;
		}
		bw.write(CVH.size()+"\n");
			
		br.close();
		bw.flush();
		bw.close();
	}
	
	
	static int ccw(int x1, int y1, int x2, int y2, int x3, int y3){
		return (x1*y2+x2*y3+x3*y1)-(x3*y2+x2*y1+x1*y3);		
	}
	
	static int dist(int x1, int y1, int x2, int y2){
		return (x2-x1)*(x2-x1)+(y2-y1)*(y2-y1);
	}
}
