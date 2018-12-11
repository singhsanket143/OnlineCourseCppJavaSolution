import java.util.*;

class MikeAndHashTrick {

	public static void main(String[] args) {
		HashMap<Integer, Integer> last = new HashMap();
		Scanner scn = new Scanner(System.in);
		int n = scn.nextInt();
		int arr[] = new int[n];
		for(int i=0;i<n;i++) {
			arr[i] = scn.nextInt();
		}
		ArrayList<Integer> vec = new ArrayList<Integer>();
		Set<Integer> s = new HashSet();
		for(int i=0;i<n;i++) {
			if(!s.contains(arr[i])) {
				vec.add(arr[i]);
				s.add(arr[i]);
			}
			last.put(arr[i], i);
		}
		Collections.sort(vec, (a, b) -> last.get(a).compareTo(last.get(b)));
		for(int i=0;i<vec.size();i++) {
			System.out.println(vec.get(i)+" ");
		}
	}
}