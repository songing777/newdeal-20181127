package com.eomcs.lms.handler;

import java.util.Arrays;
import java.util.Scanner;

import com.eomcs.lms.domain.Lesson;
import com.eomcs.lms.domain.Member;

public class MemberList {
	static final int LENGTH = 10;
	Scanner keyboard;
	Member[] list = new Member[LENGTH];
	int size = 0;


	public Member[] toArray(){
		return Arrays.copyOf(list, size);
	}
	
	public void add(Member lesson) {
		if(size >= list.length) {
			int oldLength = list.length;
			int newCapacity = oldLength+ (int)(oldLength*0.5);
		}
		list[size++] = lesson;
		//size++;
	}
}
