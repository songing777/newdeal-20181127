package com.eomcs.util;

public class StackIterator<E> implements Iterator<E>{
	
	Stack<E> stack;
	int count;
	int size;
	public StackIterator(Stack<E> stack) {
		this.stack = stack;
		this.size = stack.size();
	}
	
	@Override
	public boolean hasNext() {
		// TODO Auto-generated method stub
		return this.count < this.size;
	}

	@Override
	public E next() {
		// TODO Auto-generated method stub
		this.count++;
		return stack.pop();
	}

}
