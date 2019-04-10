package treeClasses;

public class Pair<E, F> {
	private E first;
	private F second;
	
	public Pair() {
		first = null;
		second = null;
	}
	
	public Pair(E first) {
		this.first = first;
		this.second = null;
	}
	
	public Pair(E first, F second) {
		this.first = first;
		this.second = second;
	}

	@Override
	public String toString() {
		return "(" + first + "," + second + ")";
	}
	
	public E first() {return first;}
	public void setFirst(E newFirst) {this.first = newFirst;}

	public F second() {return second;}
	public void setSecond(F newSecond) {this.second = newSecond;}
	
}
