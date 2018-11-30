package com.eomcs.util;

public class QueueIterator<E> implements Iterator<E>{
	
	Queue<E> queue;
	int count;
	int size;
	public QueueIterator(Queue<E> queue) {
		this.queue = queue;
		this.size = queue.size();
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
		return queue.poll();
	}

}
