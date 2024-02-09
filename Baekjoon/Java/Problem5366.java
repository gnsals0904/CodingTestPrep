package problem;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Problem5366 {
	public static void main(String[] args) throws IOException {
		Map<String, Integer> hashMap = new LinkedHashMap<String, Integer>();
		InputStreamReader ir = new InputStreamReader(System.in);
		BufferedReader br = new BufferedReader(ir);
		StringBuilder sb = new StringBuilder();
		int temp = 0;
		while(true) {
			String s = br.readLine();
			if(s.equals("0")) {
				break;
			}
			if(!hashMap.containsKey(s)) {
				hashMap.put(s, 1);
			}
			else {
				hashMap.put(s, hashMap.get(s) + 1);
			}
		}
		Set<String> set = hashMap.keySet();
		Iterator<String> iter = set.iterator();
		for(String s : hashMap.keySet()){
			int v = hashMap.get(s);
			temp += v;
			sb.append(s).append(": ").append(v).append("\n");
		}
		sb.append("Grand Total: ").append(temp);
		System.out.println(sb);
	}
}
