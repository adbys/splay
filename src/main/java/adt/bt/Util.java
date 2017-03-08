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

		BSTNode parent = (BSTNode) node.getParent();
		
		parent.setRight(node.getLeft());
		node.getLeft().setParent(parent);
		node.setLeft(node.getParent());
		node.setParent(parent.getParent());
		parent.setParent(node);
		
		return node;

	}

	/**
	 * A rotacao a direita em node deve subir e retornar seu filho a esquerda
	 * 
	 * @param node
	 * @return
	 */
	public static <T extends Comparable<T>> BSTNode<T> rightRotation(BSTNode<T> node) {

		
		BSTNode parent = (BSTNode) node.getParent();
		
		parent.setLeft(node.getRight());
		node.getRight().setParent(parent);
		node.setRight(node.getParent());
		node.setParent(parent.getParent());
		parent.setParent(node);

		return node;

	}

	public static <T extends Comparable<T>> T[] makeArrayOfComparable(int size) {
		@SuppressWarnings("unchecked")
		T[] array = (T[]) new Comparable[size];
		return array;
	}
}