package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedTree;
import treeInterfaces.Position;

public class MyCloneTester {
	public static void main(String[] args) throws CloneNotSupportedException {
		LinkedTree<Integer> t = new LinkedTree<>();
		LinkedTree<Integer> t1  = t.clone();
		Utils.displayTree("Original Empty Tree: ", t);
		Utils.displayTree("Copied empty Tree: ", t1);
		
		System.out.println("");
		System.out.println("Adding elements to the list...");
		
		t.addRoot(4);
		Position<Integer> rootChild1 = t.addChild(t.root(), 9);
		t.addChild(rootChild1, 7);
		t.addChild(rootChild1, 10);
		Position<Integer> rootChild2 = t.addChild(t.root(), 20);
		Position<Integer> son1OfRootChild2 = t.addChild(rootChild2, 15);
		t.addChild(son1OfRootChild2, 12);
		Position<Integer> lastOfLeft = t.addChild(son1OfRootChild2, 17);
		t.addChild(lastOfLeft, 19);
		Position<Integer> son2OfRootChild2 = t.addChild(rootChild2, 21);
		Position<Integer> lastOfRight = t.addChild(son2OfRootChild2, 40);
		t.addChild(lastOfRight, 30);
		t.addChild(lastOfRight, 45);
		
		Utils.displayTree("Original Tree filled with elements: ", t);
		t1 = t.clone();
		Utils.displayTree("Cloned Tree after adding elements: ", t1);
		
		
		System.out.println("");
		
		// Are they the same tree?
		boolean diffTree = t != t1;
		System.out.println("The tree and its clone are different trees: "  + diffTree);
		System.out.println("");
		System.out.println("Verifying...");
		System.out.println("Adding an element 50 to the original tree");
		System.out.println("Element 50 added after element 19");
		t.addChild(lastOfLeft, 50);
		Utils.displayTree("Original Tree after adding the 50", t);
		Utils.displayTree("Cloned Tree after adding element 50 to the original one", t1);
	}
}
