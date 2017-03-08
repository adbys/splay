package adt.splaytree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

public class SplayTreeImpl<T extends Comparable<T>> extends BSTImpl<T>
		implements SplayTree<T> {
	
	@Override
	public void insert(T element) {
		super.insert(element);
		
	}

	private void splay(BSTNode<T> node) {
		
		if (node.getParent().equals(this.root)) { //ZIG
			if (node.getParent().getLeft().equals(node)) {
				node = Util.rightRotation(node);
			} else {
				node = Util.leftRotation(node);
			}
		}
		
		if (node.getParent().getLeft().equals(node)) { 
			if (node.getParent().getParent().equals(node.getParent())) { //ZIG ZIG Right
				node = Util.rightRotation((BSTNode<T>) node.getParent());
				node = Util.rightRotation((BSTNode<T>) node.getParent());
			}
		}
		
		while (!node.getParent().isEmpty()) {
			
				if (node.getParent().getLeft().equals(node)) {
					node = Util.leftRotation(node);
				} else {
					node = Util.rightRotation(node);
				}
		
			
		}
		
	}

	private void zigZigLeft(BSTNode<T> node) {
		// TODO Auto-generated method stub
		
	}

	private void zigZagLeftFirst(BSTNode<T> node) {
		// TODO Auto-generated method stub
		
	}

	private void zigZagRightFirst(BSTNode<T> node) {
		// TODO Auto-generated method stub
		
	}

	private void zigZigRight(BSTNode<T> node) {
		// TODO Auto-generated method stub
		
	}

	private void zig(BSTNode<T> node) {
		// TODO Auto-generated method stub
		
	}
}
