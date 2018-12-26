import java.util.*;

public class Arrays_BubbleSort {

	public static void main(String args[]) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < n - 1; j++) {
				if (arr[j] > arr[j + 1]) {
					int k = arr[j + 1];
					arr[j + 1] = arr[j];
					arr[j] = k;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.println(arr[i]);
		}

	}

}
