package treeClasses;

import java.util.ArrayList;
import java.util.Iterator;

import treeInterfaces.Position;

public class ElementsIterator<E> implements Iterator<E> { 
	private ArrayList<Position<E>> list = new ArrayList<>();   // its iterator will be used here...
	private Iterator<Position<E>> iter; 
	private Position<E> lastPosition = null; 
	private LinkedBinaryTree<E> t;                  // the tree to iterate on

	public ElementsIterator(LinkedBinaryTree<E> t) { 
		this.t = t;
		if(!t.isEmpty()) this.fillArrayList(t.root());
		iter = list.iterator();
	} 

	private void fillArrayList(Position<E> r) {  // Once the ArrayList is properly filled
		if (t.numChildren(r) == 1)                 // we can just use its iterator, which is 
			list.add(r);                            // a forward iterator. Many other
		if (t.hasLeft(r))                          //  alternatives are possible using          
			fillArrayList(t.left(r));               // ideas from other lab activities.
		if (t.hasRight(r)) 
			fillArrayList(t.right(r));
	} 

	public boolean hasNext() { 
		return iter.hasNext(); 
	} 

	public E next() { 
		lastPosition = iter.next();    // takes care of the exception
		return lastPosition.getElement();  
	} 

	public void remove() { 
		if (lastPosition == null) throw new IllegalStateException("Invalid to remove"); 
        t.remove(lastPosition); 
	} 
}
