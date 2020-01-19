package com.codewardev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/5672682212c8ecf83e000050/train/java

public class DoubleLinear {

	public static int dblLinear(int n) {

		List<Integer> uList = new ArrayList<Integer>();
		uList.add(1);
		getUList(uList, 1, n);
		uList = Arrays.stream(uList.toArray()).distinct().mapToInt(x->(Integer)x).boxed().collect(Collectors.toList());
		Collections.sort(uList);
		Iterator<Integer> iter = uList.iterator();
		while(iter.hasNext()) {
			System.out.println("Integer: "+iter.next());
		}
		return uList.get(n);
	}

	private static void getUList(List<Integer> uList, int lastInt, int n) {
		int y = 2*lastInt + 1;
		int z = 3*lastInt + 1;
		uList.add(y);
		uList.add(z);
		if(y<1000 || z < 1000) {
			getUList(uList, z, n);
			getUList(uList, y, n);
		}
		
	}

}
