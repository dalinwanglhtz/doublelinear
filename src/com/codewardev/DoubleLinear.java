package com.codewardev;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

// https://www.codewars.com/kata/5672682212c8ecf83e000050/train/java

public class DoubleLinear {

	private static final int yMAX = 13;
	private static final int zMAX = 12;
	
	public static int dblLinear(int n) {
		List<Integer> uList = new ArrayList<Integer>();
		uList.add(1);
		updateUList(uList, 1, n);
		uList = Arrays.stream(uList.toArray()).distinct().mapToInt(x->(Integer)x).boxed().collect(Collectors.toList());
		Collections.sort(uList);

		return uList.get(n);
	}

	private static void updateUList(List<Integer> uList, int lastInt, int n) {
		int y = 2*lastInt + 1;
		int z = 3*lastInt + 1;
		uList.add(y);
		uList.add(z);
		if(y<n*yMAX || z < n*zMAX) {
			updateUList(uList, y, n);
			updateUList(uList, z, n);
		}
		
	}

}
