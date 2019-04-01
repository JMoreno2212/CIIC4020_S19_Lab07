package testerClasses;

import labUtils.Utils;
import treeClasses.LinkedBinaryTree;
import treeInterfaces.Position;

public class MyBinaryCloneTester {
	public static void main(String[] args) throws CloneNotSupportedException {
		LinkedBinaryTree<Integer> t = new LinkedBinaryTree<>();
		LinkedBinaryTree<Integer> t1  = t.clone();
		Utils.displayTree("Original Empty Tree: ", t);
		Utils.displayTree("Copied empty Tree: ", t1);
		
		System.out.println("");
		System.out.println("Adding elements to the list...");
		
		t.addRoot(4);
		Position<Integer> rootLeft = t.addLeft(t.root(), 9);
		t.addLeft(rootLeft, 7);
		t.addRight(rootLeft, 10);
		Position<Integer> rootRight = t.addRight(t.root(), 20);
		Position<Integer> leftOFRootRight = t.addLeft(rootRight, 15);
		t.addLeft(leftOFRootRight, 12);
		Position<Integer> lastOfLeft = t.addRight(leftOFRootRight, 17);
		t.addLeft(lastOfLeft, 19);
		Position<Integer> rightOFRootRight = t.addRight(rootRight, 21);
		Position<Integer> lastOfRight = t.addLeft(rightOFRootRight, 40);
		t.addLeft(lastOfRight, 30);
		t.addRight(lastOfRight, 45);		
		
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
		t.addRight(lastOfLeft, 50);
		Utils.displayTree("Original Tree after adding the 50", t);
		Utils.displayTree("Cloned Tree after adding element 50 to the original one", t1);
	}
}
