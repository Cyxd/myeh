package com.cyxd.demo.com.google.common.collect;

import org.junit.Test;

import com.google.common.collect.HashMultiset;
import com.google.common.collect.Multiset;

public class MultiSetTest {

	@Test
	public void testMultiSetTest() throws Exception {
		Multiset<String> mset = HashMultiset.create();

		mset.add("sdf");
		mset.add("sdf");

		System.out.println(mset.count("sdf"));

	}

	@Test
	public void testMultiSetTest2() throws Exception {
		Multiset<String> mset = HashMultiset.create();

		mset.add("sdf");
		mset.add("sdf");
		mset.add("dfd", 1);
		mset.add("dfd", 3);
		mset.add("sdf");

		for (String str : mset) {
			System.out.println(str);
		}

		System.out.println(mset.count("dfd"));

	}

}
