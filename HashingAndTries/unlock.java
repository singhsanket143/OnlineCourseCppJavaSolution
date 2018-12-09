import java.util.HashMap;
import java.util.Scanner;

public class unlock {

	public static void main(String[] args) {

		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int k=scn.nextInt();
		int[] arr = new int[n];
		HashMap<Integer, Integer> map = new HashMap();
		for (int i = 0; i < n; i++) {
			arr[i] = scn.nextInt();
			map.put(arr[i], i);
		}
		int num=n;
		int m=0;
		while(m<n && k>0) {
			int hold = map.get(num-m);
			if(hold==n-num+m) {
				m++;
				continue;
			} else {
				int temp=arr[m];
				arr[m]=arr[hold];
				arr[hold]=temp;
                map.put(arr[hold], hold);
                map.put(arr[m],m);
				m++;
				k--;
			}
		}
		for(int i=0;i<arr.length;i++) {
			System.out.print(arr[i]+" ");
		}
	}

}

