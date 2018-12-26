import java.util.*;

public class Arrays_BinarySearch {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
	    for (int i = 0; i < n; i++)
	        arr[i] = scn.nextInt();
	    
	    int num= scn.nextInt();
		int result = binarySearch(arr, 0, n-1, num);
		if(result == -1) {
			System.out.println(-1);
		}else {
			System.out.println(result);
		}
	}
	// A iterative binary search function. It returns
	// location of x in given array arr[l..r] if present,
	// otherwise -1
	public static int binarySearch(int arr[], int l, int r, int x)
	{
		while (l <= r)
		{
			int m = l + (r-l)/2;

			// Check if x is present at mid
			if (arr[m] == x)
				return m;

			// If x greater, ignore left half
			if (arr[m] < x)
				l = m + 1;

			// If x is smaller, ignore right half
			else
				r = m - 1;
		}
		// if we reach here, then element was
		// not present
		return -1;
	}

}
