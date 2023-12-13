package dsa.concept;

import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		Node node=makeTree();
		inorder(node);
		System.out.println();
		preorder(node);
		System.out.println();
		postorder(node);
		System.out.println();
		System.out.print("height :"+height(node));
	}
	
	static void inorder(Node root) {
		if(root==null)return;
		inorder(root.left);
		System.out.print(root.data+" ");
		inorder(root.right);
	}
	
	static void preorder(Node root) {
		if(root==null)return;
		System.out.print(root.data+" ");
		inorder(root.left);
		inorder(root.right);
	}
	
	static void postorder(Node root) {
		if(root==null)return;
		inorder(root.left);
		inorder(root.right);
		System.out.print(root.data+" ");
	}
	static Node makeTree() {
		Node root;
		Scanner scan=new Scanner(System.in);
		System.out.println("Enter the data");
		int data=scan.nextInt();
		if(data==-1) {
			return null;
		}
		else root=new Node(data);
		System.out.println("Enter left : ");
		root.left=makeTree();
		System.out.println("Enter right : ");
		root.right=makeTree();
		return root;
	}
	
	static int height(Node root) {
		if(root==null)return 0;
		if(root.left==null && root.right==null)return 1;
		return 1+Math.max(height(root.left), height(root.right));
	}
}

class Node{
	int data=-1;
	Node left;
	Node right;
	Node (int data){
		this.data=data;
	}
	@Override
	public String toString() {
		return "Node [data=" + data + ", left=" + left + ", right=" + right + "]";
	}
	
	
}
