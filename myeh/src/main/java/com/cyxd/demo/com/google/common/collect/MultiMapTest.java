package com.cyxd.demo.com.google.common.collect;

import java.util.HashMap;
import java.util.Map;

import org.junit.Test;

import com.google.common.collect.ArrayListMultimap;
import com.google.common.collect.Multimap;

/**
 * @author cyxd
 *
 */
public class MultiMapTest {

	@Test
	public void testMultiMap() throws Exception {
		Multimap<String, String> multimap = ArrayListMultimap.create();
		multimap.put("a", "1q2421412");
		multimap.put("a", "af");
		multimap.put("a", "af");
		multimap.put("a", "14sdf");
		multimap.put("a", "23dfsad");
		multimap.put("a", "hsdfg23");
		multimap.put(null, null);
		multimap.put(null, null);
		multimap.put(null, null);
		multimap.put(null, null);

		for (String str : multimap.get("a")) {
			System.out.println(str);
		}

		for (String str : multimap.get(null)) {
			System.out.println(str);
		}

		Map<String, String> map = new HashMap<String, String>();

		map.put(null, "a");
		map.put(null, "c");
		map.put(null, "b");

		for (String str : map.keySet()) {
			System.out.println(map.get(str));
		}

	}

}
