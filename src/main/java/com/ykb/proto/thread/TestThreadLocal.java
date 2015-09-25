package com.ykb.proto.thread;

import java.util.Arrays;

public class TestThreadLocal extends Thread {
	
	private Sequence sequence;

	public TestThreadLocal(Sequence sequence) {
		this.sequence = sequence;
	}
	
	public void run() {
		for (@SuppressWarnings("unused") Integer i:Arrays.asList(1,2,3)) {
			System.out.println(Thread.currentThread().getName()
					+ " => " + sequence.getNumber()
					+ " => " + sequence.getString());
		}
	}
	
	public static void main(String[] args) {
		Sequence sequence = new SequenceImpl();
		
		TestThreadLocal thread1 = new TestThreadLocal(sequence);
		TestThreadLocal thread2 = new TestThreadLocal(sequence);
		TestThreadLocal thread3 = new TestThreadLocal(sequence);
		
		thread1.start();
		thread2.start();
		thread3.start();
	}

}

class SequenceImpl implements Sequence {
	
	private static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};
	
	private static ThreadLocal<String> stringContainer = new ThreadLocal<String>();

	@Override
	public int getNumber() {
		numberContainer.set(numberContainer.get() + 1);
		return numberContainer.get();
	}
	
	public String getString() {
		stringContainer.set(stringContainer.get() + "@");
		return stringContainer.get();
	}
	
}

interface Sequence {
	int getNumber();
	String getString();
}