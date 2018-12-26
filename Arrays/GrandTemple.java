import java.util.*;

public class GrandTemple {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		GrandTemple a = new GrandTemple();
		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		pair[] arr = new pair[n];
		pair1[] arr2 = new pair1[n];
		for (int i = 0; i < n; i++) {
			int x = scn.nextInt();
			int y = scn.nextInt();
			arr[i] = a.new pair(x, y);
			arr2[i] = a.new pair1(x, y);
		}
		Arrays.sort(arr);
		Arrays.sort(arr2);
		int max_diff_y = 0;
		int A = 0;
		for(int i=0;i<n-1;i++){
	        if(Math.abs(arr2[i].y-arr2[i+1].y)>max_diff_y){
	        max_diff_y=Math.abs(arr2[i].y-arr2[i+1].y);
	        }
	    }
		for(int i=0;i<n-1;i++){
	        if((Math.abs(arr[i].x-arr[i+1].x)-1)*(max_diff_y-1)>A)
	        A=(Math.abs(arr[i].x-arr[i+1].x)-1)*(max_diff_y-1);
	    }

		
		System.out.println(A);
	}

	private class pair implements Comparable<pair> {
		int x;
		int y;

		pair(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pair o) {
			return this.x - o.x;
		}
	}

	private class pair1 implements Comparable<pair1> {
		int x;
		int y;

		pair1(int x, int y) {
			this.x = x;
			this.y = y;
		}

		@Override
		public int compareTo(pair1 o) {
			return this.y - o.y;
		}
	}

}
