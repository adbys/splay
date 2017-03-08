package adt.splaytree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

public class SplayTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements SplayTree<T> {

	@Override
	public void insert(T element) {
		super.insert(element);

	}

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
}
