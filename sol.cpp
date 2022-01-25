#include <bits/stdc++.h>

using namespace std;

struct Idler {
	int chosen;
	int time;
};

int main() {
	ios::sync_with_stdio(false);
	cin.tie(0);
	int n, k;
	cin >> n >> k;
	vector<Idler> a(n);
	for (int i = 0; i < n; i++) {
		cin >> a[i].chosen;
	}
	for (int i = 0; i < n; i++) {
		int b;
		cin >> b;
		// connect the time (value) to its corresponding idler (using a struct)
		a[i].time = b;
	}
	// sort the sequence in non-increasing order (based on their time)
	sort(a.begin(), a.end(), [](const Idler& a, const Idler& b) {
		return a.time > b.time;	
	});
	// remove distinct idlers with high total minutes
	// note: don't forget to decrease the value of k 
	// (it means the jobs are decreasing) and mark the idlers
	set<int> s;
	vector<bool> visited(n, false);
	for (int i = 0; i < n && k > 0; i++) {
		if (s.find(a[i].chosen) == s.end()) {
			visited[i] = true;
			s.insert(a[i].chosen);
			k--;
		}
	}
	// decrease the remaining jobs using the idlers with low total minutes
	// (we need to start at the end of the sequence)
	long long ans = 0;
	for (int i = n - 1; i >= 0; i--) {
		if (!visited[i] && k > 0) {
			k--;
			ans += a[i].time;
		}
	}
	cout << ans << '\n';
	return 0;
}
