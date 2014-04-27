package com.sjsu.pojo;

public class Testtree {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Node newnode = new Node('e');
		newnode.left = new Node('y');
		newnode.right = new Node('r');
		newnode.right.right = new Node('k');
		newnode.left.left = new Node('b');
		newnode.left.right = new Node('a');
		newnode.left.right.right = new Node('c');
		newnode.left.right.right.left = new Node('t');
		newnode.left.right.right.right = new Node('d');
		Node ret = findLowestCommonAncestor(newnode.left.left,newnode.right.right, newnode);
		System.out.println(ret.data);
	}

	static Node findLowestCommonAncestor(Node a, Node b, Node root) { // pass in b, t, b
	     if (root == null)
	        return null;
	    if (root.equals(a) || root.equals(b)){
	        return root;
	    }
	    Node le = findLowestCommonAncestor(a,b,root.left); 
	    Node ri = findLowestCommonAncestor(a,b,root.right);
	    
	    if (le != null && ri != null)
	        return root;
	        
	    if (le != null)
	    	return le;
	    else
	    	return ri;
	    
	    
	}
}
