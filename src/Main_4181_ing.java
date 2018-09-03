

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;

class Point2 {
	long x;
	long y;
	
	Point2 (long x, long y){
		this.x = x;
		this.y = y;
	}
}

public class Main_4181_ing {
	/*
	 * Convex Hull (ing....)
	 * https://www.acmicpc.net/problem/4181
	 */
	
	public static void main(String[] args) throws IOException {
		
		System.setIn(new FileInputStream("res/test.txt"));
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer ST;
		
		
		ArrayList<Point2> Point2s = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			ST = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(ST.nextToken());
			int y = Integer.parseInt(ST.nextToken());
			String c = ST.nextToken();
			
			if (c.equals("Y")) {
				Point2s.add(new Point2(x, y));	
			}		
		}
		ArrayList<Point2> cvh = convexHull(Point2s);
		
		bw.write(cvh.size()+"\n");
		for (int i = 0; i < cvh.size(); i++) {
			bw.write(cvh.get(i).x+" "+cvh.get(i).y+"\n");
		}
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	public static Point2 root;

	static ArrayList<Point2> convexHull(ArrayList<Point2> input){
		
		
		root = new Point2(Long.MAX_VALUE, Long.MAX_VALUE);
		for(int i = 0; i < input.size(); i++) {
			if (input.get(i).x < root.x) {
				root = input.get(i);
			} else if (input.get(i).x == root.x) {
				if (input.get(i).y < root.y) {
					root = input.get(i);
				}
			}
		}
		
		
		input.sort(new Comparator<Point2>() {

			@Override
			public int compare(Point2 o1, Point2 o2) {

				int result = ccw(root, o1, o2);
				
				if(result > 0) return -1;
				if(result < 0) return 1;
				
				if(result == 0) {
					
					long dist1 = dist(root, o1);
					long dist2 = dist(root, o2);
					
					if (dist1 > dist2) {
						return 1;
					}
					
					
					if (o1.x == o2.x) {
						if (o1.y <= o2.y) {
							return 1;
						}
					} 
					
					if (o1.y == o2.y) {
						if(o1.x <= o2.x) {
							return -1;
						}
					}
				
				}
				return -1;
			}
		});
		
		return input;
		
	}
	
	
	static int ccw(Point2 a, Point2 b, Point2 c) {
		long result = (a.x*b.y+b.x*c.y+c.x*a.y) - (b.x*a.y+c.x*b.y+a.x*c.y);
		if (result > 0) return 1;
		if (result < 0) return -1;
		return 0;
	}
	
	static long dist(Point2 a, Point2 b) {
		return (b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y);
	}
}
