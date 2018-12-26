import java.util.*;

public class CountingSort {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		Scanner scn = new Scanner(System.in);

		int n = scn.nextInt();
		int[] arr = new int[n];
		int max = 0;
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			if (arr[i] > max) {
				max = arr[i];
			}
		}
		int[] freq = new int[max + 1];
		for (int i = 0; i < n; i++) {
			freq[arr[i]]++;
		}

		int j = 0;
		for (int i = 0; i < max + 1; i++) {
			if (freq[i] != 0) {
				while (freq[i] > 0) {
					arr[j] = i;
					freq[i]--;
					j++;
				}
			}
		}
		for (int i = 0; i < n; i++) {
			System.out.print(arr[i] + " ");
		}
	}

}
