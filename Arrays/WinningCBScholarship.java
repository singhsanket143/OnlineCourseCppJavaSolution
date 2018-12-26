import java.util.*;

public class WinningCBScholarship {
	static long n;
	static long m;
	static long x;
	static long y;

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner scn = new Scanner(System.in);
		int t = 1;
		while (t > 0) {
			n = scn.nextLong();
			m = scn.nextLong();
			x = scn.nextLong();
			y = scn.nextLong();

			long lo = 0;
			long hi = n;
			long ans = 0;
			while (lo <= hi) {
				long mid = lo + hi;
				mid >>= 1;
				if (solve(mid)) {
					lo = mid + 1;
					ans = mid;
				} else
					hi = mid - 1;
			}
			System.out.println(ans);
			t-=1;
		}
	}

	public static boolean solve(long pok) {
		return (pok * x <= m + (n - pok) * y);
	}

}
