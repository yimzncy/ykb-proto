package com.ykb.proto.thread;

import java.util.Arrays;

public class TestThreadLocal implements Runnable {
	
	private Sequence sequence;

	public TestThreadLocal(Sequence sequence) {
		this.sequence = sequence;
	}
	
	public void run() {
		for (@SuppressWarnings("unused") Integer i:Arrays.asList(1,2,3)) {
//			printStackTrace();
			System.out.println(Thread.currentThread().getName()
					+ " => " + sequence.getNumber()
					+ " => " + sequence.getString());
		}
	}
	
	public static void printStackTrace() {
		StackTraceElement[] stackTraceElements = Thread.currentThread().getStackTrace();
		for (StackTraceElement stackTraceElement:stackTraceElements) {
			System.out.println("---" + stackTraceElement.getClassName() 
					+ "---" + stackTraceElement.getFileName()
					+ "---" + stackTraceElement.getMethodName()
					+ "---" + stackTraceElement.getLineNumber()
					+ "---");
		}
	}
	
	public static void main(String[] args) {
		Sequence sequence = new SequenceImpl();
		
		TestThreadLocal tl = new TestThreadLocal(sequence);
		
		Thread t1 = new Thread(tl);
		Thread t2 = new Thread(tl);
		Thread t3 = new Thread(tl);
		
		try {
			t1.start();
			t1.join();
			t2.start();
			t2.join();
			t3.start();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

}

class SequenceImpl implements Sequence {
	
	private static ThreadLocal<Integer> numberContainer = new ThreadLocal<Integer>() {
		@Override
		protected Integer initialValue() {
			return 0;
		}
	};
	
	// 必须初始化，否则为null
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