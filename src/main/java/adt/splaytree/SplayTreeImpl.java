package adt.splaytree;

import adt.bst.BSTImpl;
import adt.bst.BSTNode;
import adt.bt.Util;

public class SplayTreeImpl<T extends Comparable<T>> extends BSTImpl<T> implements SplayTree<T> {


	private void splay(BSTNode<T> node) {
		if (node == null || this.root.equals(node) || node.getParent() == null)
            return;

		while (!node.getParent().isEmpty()) {

			if (node.getParent().equals(this.root)) { // ZIG
				if (node.getParent().getLeft().equals(node)) {
					node = Util.rightRotation(node);
					this.root = node;
				} else {
					node = Util.leftRotation(node);
					this.root = node;
				}
			} else {
				
				if (node.getParent().getLeft().equals(node)) {
					if (node.getParent().getParent().getLeft().equals(node.getParent())) { // ZIG
						// ZIG
						// Right
						Util.rightRotation((BSTNode<T>) node.getParent());

						if (node.getParent().getRight().equals(this.root))
							this.root = node;
						Util.rightRotation(node);
						
						if (node.getRight().equals(this.root))
							this.root = node;
					} else { // ZIG ZAG
						Util.rightRotation((BSTNode<T>) node.getParent());
						
						if (node.getParent().getRight().equals(this.root))
							this.root = node;
						
						Util.leftRotation(node);
					
						if (node.getLeft().equals(this.root))
							this.root = node;
					
					}
					
				} else {
					
					
					
					
					if (node.getParent().getRight().equals(node)) {
						if (node.getParent().getParent().getRight().equals(node.getParent())) { // ZIG
							// ZIG
							// LEFT
							Util.leftRotation((BSTNode<T>) node.getParent());
							if (node.getParent().getLeft().equals(this.root))
								this.root = node;
							
							Util.leftRotation(node);
							
							if (node.getLeft().equals(this.root))
								this.root = node;
							
						} else {
							Util.leftRotation((BSTNode<T>) node.getParent());

							if (node.getParent().getLeft().equals(this.root))
								this.root = node;
							
							Util.rightRotation(node);
						
							if (node.getRight().equals(this.root))
								this.root = node;
						}
					}
					
					
					
				}
				
				
				
				
				
			}



		}

	}
	
	@Override
	public void remove(T element) {
		BSTNode node = (BSTNode) super.search(element);
		
		if (node.equals(this.root)) {
			this.root = new BSTNode.Builder().build();
			return;
		}
		
		node = (BSTNode) node.getParent();
		
		if (!node.isEmpty())
			super.remove(element);
		this.splay((BSTNode<T>) node);

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
