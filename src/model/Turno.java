package model;

public class Turno {
	
	private int value;
	private int timesCalled;
	private Turno next;
	private Turno previous;
	
	public Turno(int value) {
		this.value = value;
		this.timesCalled = 0;
	}
	
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}


	public Turno getNext() {
		return next;
	}

	public void setNext(Turno next) {
		this.next = next;
	}

	public Turno getPrevious() {
		return previous;
	}

	public void setPrevious(Turno previous) {
		this.previous = previous;
	}
	
	public void call() {
		this.timesCalled++;
	}

	public int getTimesCalled() {
		return timesCalled;
	}

}
