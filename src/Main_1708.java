

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.StringTokenizer;



public class Main_1708 {
	/*
	 * 볼록 껍질
	 * https://www.acmicpc.net/problem/1708
	 */
	static class Point {
		long x;
		long y;
		
		Point (long x, long y){
			this.x = x;
			this.y = y;
		}
	}
	
	public static void main(String[] args) throws IOException {
		
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer ST;
		
		
		ArrayList<Point> points = new ArrayList<>();
		int N = Integer.parseInt(br.readLine());
		for (int i = 1; i <= N; i++) {
			ST = new StringTokenizer(br.readLine());
			int x = Integer.parseInt(ST.nextToken());
			int y = Integer.parseInt(ST.nextToken());
			
			
			points.add(new Point(x, y));			
		}
		
		ArrayList<Point> cvh = convexHull(points);
		
		bw.write(cvh.size()+"\n");
		
		br.close();
		bw.flush();
		bw.close();

	}
	
	public static Point root;

	static ArrayList<Point> convexHull(ArrayList<Point> input){
		root = new Point(Long.MAX_VALUE, Long.MAX_VALUE);
		for(int i = 0; i < input.size(); i++) {
			if (input.get(i).y < root.y) {
				root = input.get(i);
			} else if (input.get(i).y == root.y) {
				if (input.get(i).x < root.x) {
					root = input.get(i);
				}
			}
		}
		
		
		input.sort(new Comparator<Point>() {

			@Override
			public int compare(Point o1, Point o2) {

				int result = ccw(root, o1, o2);
				
				if(result > 0) return -1;
				if(result < 0) return 1;
				
				if(result == 0) {
					long result1 = dist(root, o1);
					long result2 = dist(root, o2);
				
					if (result1 > result2) return 1;
				}
				return -1;
			}
		});
		
		
		ArrayList<Point> cvh = new ArrayList<>();
		cvh.add(root);
		
		
		for (int i = 1; i < input.size(); i++) {
			
			while(cvh.size() > 1 && ccw(cvh.get(cvh.size()-2), cvh.get(cvh.size()-1), input.get(i)) <= 0) {
				cvh.remove(cvh.size()-1);
			}
			cvh.add(input.get(i));
		}
		
		return cvh;
		
	}
	
	
	static int ccw(Point a, Point b, Point c) {
		long result = (a.x*b.y+b.x*c.y+c.x*a.y) - (b.x*a.y+c.x*b.y+a.x*c.y);
		if (result > 0) return 1;
		if (result < 0) return -1;
		return 0;
	}
	
	static long dist(Point a, Point b) {
		return (b.x-a.x)*(b.x-a.x)+(b.y-a.y)*(b.y-a.y);
	}
}
