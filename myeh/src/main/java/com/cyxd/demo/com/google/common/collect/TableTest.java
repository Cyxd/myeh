package com.cyxd.demo.com.google.common.collect;

import java.util.Map;

import org.junit.Test;

import com.google.common.collect.HashBasedTable;
import com.google.common.collect.Table;

public class TableTest {

	/**
	 * @Title: testTable @Description: TODO Two juzhen @param @throws
	 * Exception @return void @throws
	 */
	@Test
	public void testTable() throws Exception {

		Table<Integer, Integer, String> table = HashBasedTable.create();

		table.put(0, 1, "0-1");
		table.put(0, 2, "0-2");
		table.put(0, 3, "0-3");
		table.put(1, 1, "1-1");
		table.put(1, 2, "1-2");
		table.put(1, 3, "1-3");

		for (String str : table.values()) {
			// System.out.println(str);
		}
		Map<Integer, Map<Integer, String>> map1 = table.rowMap();
		for (Integer rowId : map1.keySet()) {
			System.out.print("rowId==" + rowId);
			System.out.println(map1.get(rowId));
		}

	}

}
