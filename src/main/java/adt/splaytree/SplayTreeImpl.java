package adt.splaytree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

public class SplayTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements SplayTree<T> {


	private void splay(BSTNode<T> node) {

		while (!node.getParent().isEmpty()) {

			if (node.getParent().equals(this.root)) { // ZIG
				if (node.getParent().getLeft().equals(node)) {
					node = Util.rightRotation(node);
				} else {
					node = Util.leftRotation(node);
				}
			}

			if (node.getParent().getLeft().equals(node)) {
				if (node.getParent().getParent().getLeft().equals(node.getParent())) { // ZIG
																						// ZIG
																						// Right
					node = Util.rightRotation((BSTNode<T>) node.getParent());
					node = Util.rightRotation((BSTNode<T>) node.getParent());
				} else { // ZIG ZAG
					node = Util.rightRotation(node);
					node = Util.leftRotation(node);
				}

			}

			if (node.getParent().getRight().equals(node)) {
				if (node.getParent().getParent().getRight().equals(node.getParent())) { // ZIG
																						// ZIG
																						// LEFT
					node = Util.leftRotation(node);
					node = Util.leftRotation(node);
				} else {
					node = Util.leftRotation(node);
					node = Util.rightRotation(node);
				}
			}

		}

	}
	
	@Override
	public void remove(T element) {
		BSTNode node = (BSTNode) super.search(element).getParent();
		
		if (!node.isEmpty())
			super.remove(element);
		this.splay((BSTNode<T>) node.getParent());

	}
	
	@Override
	public void insert(T element) {
		super.insert(element);
		this.search(element);
	}

	
	@Override
	public BSTNode<T> search(T element) {
		BSTNode node = super.search(element);
		
		if (node.isEmpty())
			this.splay((BSTNode<T>) node.getParent());
		else
			this.splay(node);
		
		return node;

	}
	

}
