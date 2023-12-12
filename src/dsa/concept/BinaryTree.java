package dsa.concept;

import java.util.Scanner;

public class BinaryTree {

	public static void main(String[] args) {
		Node root=makeTree();
		System.out.println(root);
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
		String out="";
		if(this.left==null && this.right!=null)out="  "+data+"\n"+"/"+"    "+"\\"+"\n"+"Nan"+"       "+right.data;
		else if(this.right==null && this.left!=null)out="  "+data+"\n"+"/"+"    "+"\\"+"\n"+left.data+"       "+"Nan";
		else if(this.left==null && this.right==null)out="  "+data+"\n"+"/"+"    "+"\\"+"\n"+"Nan"+"       "+"Nan";
		else out="  "+data+"\n"+"/"+"    "+"\\"+"\n"+left.data+"       "+right.data;
		return out;
	}
}
