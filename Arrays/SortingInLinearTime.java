import java.util.*;

public class SortingInLinearTime {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		sort012(arr, n);
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}

	}

	public static void sort012(int arr[], int n) {
		int lo = 0;
		int hi = n - 1;
		int mid = 0, temp = 0;
		while (mid <= hi) {
			switch (arr[mid]) {
			case 0: {
				temp = arr[lo];
				arr[lo] = arr[mid];
				arr[mid] = temp;
				lo++;
				mid++;
				break;
			}
			case 1:
				mid++;
				break;
			case 2: {
				temp = arr[mid];
				arr[mid] = arr[hi];
				arr[hi] = temp;
				hi--;
				break;
			}
			}
		}
	}

}
