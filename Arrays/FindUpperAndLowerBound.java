import java.util.*;

public class FindUpperAndLowerBound {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();

		int[] arr = new int[n + 1];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}

		int t = scn.nextInt();

		while (t > 0) {
			int num = scn.nextInt();

			int lowerBound = findLowerBound(num, arr, n);
			int upperBound = findUpperBound(num, arr, n);

			System.out.println(lowerBound + " " + upperBound);
			t-=1;
		}
	}

	public static int findLowerBound(int num, int a[], int n) {
		int lowerBound = -1;

		int s = 0;
		int e = n;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (a[mid] == num) {
				lowerBound = mid;
				e = mid - 1;
			} else if (a[mid] > num) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		return lowerBound;
	}

	public static int findUpperBound(int num, int a[], int n) {
		int upperBound = -1;

		int s = 0;
		int e = n;

		while (s <= e) {
			int mid = (s + e) / 2;
			if (a[mid] == num) {
				upperBound = mid;
				s = mid + 1;
			} else if (a[mid] > num) {
				e = mid - 1;
			} else {
				s = mid + 1;
			}
		}

		return upperBound;
	}

}
