package adt.bt;

import adt.bst.BSTNode;

public class Util {

	/**
	 * A rotacao a esquerda em node deve subir e retornar seu filho a direita
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> leftRotation(BSTNode<T> node) {

		BTNode<T> parent = node.getParent();
		BSTNode<T> right = (BSTNode<T>) node.getRight();


		right.setParent(node.getParent());
		node.setRight(right.getLeft());
		right.getLeft().setParent(node);
		right.setLeft(node);
		node.setParent(right);

		if (!parent.isEmpty()) {
			if (parent.getLeft().equals(node))
				parent.setLeft(node.getParent());
			else if (parent.getRight().equals(node))
				parent.setRight(node.getParent());
		}

		return right;

	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {

		BTNode<T> parent = node.getParent();
		BSTNode<T> left = (BSTNode<T>) node.getLeft();

		left.setParent(node.getParent());
		node.setLeft(left.getRight());
		left.getRight().setParent(node);
		left.setRight(node);
		node.setParent(left);
		
		if (!parent.isEmpty()) {
			if (parent.getLeft().equals(node))
				parent.setLeft(node.getParent());
			else if (parent.getRight().equals(node))
				parent.setRight(node.getParent());
		}

		return left;

	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}