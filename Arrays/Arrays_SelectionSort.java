import java.util.*;

public class Arrays_SelectionSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int[] arr = new int[n];
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
		}
		selectionSort(arr, n);
		for (int i = 0; i < n; i++)
			System.out.println(arr[i]);
	}

	public static void selectionSort(int[] arr, int n) {
		for (int i = 0; i < n; i++) {
			for (int j = i + 1; j < n; j++) {
				if (arr[j] < arr[i]) {
					int u = arr[i];
					arr[i] = arr[j];
					arr[j] = u;
				}
			}

		}
	}

}
