package com.eomcs.lms.handler;

import java.util.Arrays;

import com.eomcs.lms.domain.Lesson;

public class LessonList {
	
	
	static final int LENGTH = 10;
	private Lesson[] list;
	private  int size = 0;

	
	
	public LessonList() {
		this.list = new Lesson[LENGTH];
	}

	public LessonList(int initalCapacity) {
		if(initalCapacity > LENGTH) {
			this.list = new Lesson[initalCapacity];

		}else {
			this.list = new Lesson[LENGTH];

		}
	}
	

	public Lesson[] toArray() {
		return Arrays.copyOf(list, size);
	}
	
	public void add(Lesson lesson) {
		if(size >= list.length) {
			int oldLength = list.length;
			int newCapacity = oldLength+ (int)(oldLength*0.5);
			list = Arrays.copyOf(list, newCapacity);
		}
		list[size++] = lesson;
		//size++;
	}

}
