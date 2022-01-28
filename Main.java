import java.io.*;
import java.util.*;

public class Main {
	public static void main(String[] args) {
        FastReader in = new FastReader();
        int n = in.nextInt();
        int k = in.nextInt();
        int[] a = new int[n];
        for (int i = 0; i < n; i++) {
        	a[i] = in.nextInt();
        }
        int[] b = new int[n];
        for (int i = 0; i < n; i++) {
        	b[i] = in.nextInt();
        }
        Idler[] arr = new Idler[n];
        for (int i = 0; i < n; i++) {
        	arr[i] = new Idler(); // don't forget to create an object (per index)
        	arr[i].setChosen(a[i]);
        	arr[i].setTime(b[i]);
        }
        Arrays.sort(arr, (x, y) -> y.time - x.time);
        Set<Integer> s = new HashSet<Integer>();
        boolean[] visited = new boolean[n];
        for (int i = 0; i < n && k > 0; i++) {
        	if (!s.contains(arr[i].chosen)) {
        		visited[i] = true;
        		s.add(arr[i].chosen);
        		k--;
        	}
        }
        long ans = 0;
        for (int i = n - 1; i >= 0; i--) {
        	if (!visited[i] && k > 0) {
        		ans += arr[i].time;
        		k--;
        	}
        }
        System.out.println(ans);
    }
	
	static class Idler {
		private int chosen;
		private int time;
		
		public void setChosen(int chosen) {
			this.chosen = chosen;
		}
		
		public void setTime(int time) {
			this.time = time;
		}
		
		public int getChosen() {
			return this.chosen;
		}
		
		public int getTime() {
			return this.time;
		}
	}
    
    static class FastReader {
        BufferedReader br;
        StringTokenizer st;
        
        public FastReader() {
            br = new BufferedReader(new InputStreamReader(System.in));
        }
        
        String next() {
            while (st == null || !st.hasMoreElements()) {
                try {
                    st = new StringTokenizer(br.readLine());
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
            return st.nextToken();
        }
        
        int nextInt() {
            return Integer.parseInt(next());
        }
        
        long nextLong() {
            return Long.parseLong(next());
        }
        
        double nextDouble() {
            return Double.parseDouble(next());
        }
        
        String nextLine() {
            String str = "";
            try {
                str = br.readLine();
            } catch (IOException e) {
                e.printStackTrace();
            }
            return str;
        }
    }
}
