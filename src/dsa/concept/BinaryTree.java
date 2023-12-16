package dsa.concept;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
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
		System.out.println();
		System.out.print("size :"+size(node));
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
	
	static int size(Node node) {
		if(node==null)return 0;
		return 1+size(node.left)+size(node.right);
	}
	
	static void leftView(Node node,ArrayList<Integer> list,int level) {
		if(node==null)return;
		if(list.size()==level)list.add(node.data);
		leftView(node.left, list, level+1);
		leftView(node.right, list, level+1);
	}
	
	static void levelPrint(Node node) {
		Queue<Node> q=new LinkedList<Node>();
		q.offer(node);
		while(!q.isEmpty()) {
			Node curr=q.poll();
			System.out.println(curr.data);
			q.offer(node.left);
			q.offer(node.right);
		}
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
