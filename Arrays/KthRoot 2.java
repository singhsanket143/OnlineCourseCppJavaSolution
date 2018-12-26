import java.util.*;

public class KthRoot {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		while (t > 0) {
			long n = scn.nextLong();
			int k = scn.nextInt();
			if (k == 1) {
				System.out.println(n);
				continue;
			}
			long l = 1, r = 1000000, mid;
			while (l < r) {
				mid = l + r + 1 >> 1;
				boolean flag = true;
				long tmp = 1;
				for (int i = 1; i <= k; i++) {
					tmp *= mid;
					if (tmp > n) {
						flag = false;
						break;
					}
				}
				if (flag == true)
					l = mid;
				else
					r = mid - 1;
			}
			System.out.println(r);
			t-=1;
		}
	}
}
