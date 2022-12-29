package dsa.list.circularlsinglylinkedlist;
public class CircularSinglyLinkedList {
	private class Node{
		private int data;
		private Node next;
		public Node(int data) {
			this.data = data;
		}
	}
	Node last;
	Node head;
	int length;
	public CircularSinglyLinkedList() {
		this.last = null;
		this.head=null;
		this.length =0;
	}
	public boolean isEmpty() {
		return length==0;
	}
	public int size() {
		return length;
	}
	public void add(int data) {
		Node node=new Node(data);
		if(isEmpty()) {
			head=last=node;
			last.next=head;
			length++;
			return;
			}
	node.next=head;
	last.next=node;
	last=node;
	length++;
	}
	public String toString() {
		String st="[";
		Node temp=head;
		while(temp!=last) {
			st=st+temp.data+" ";
			temp=temp.next;
		}
	st=st+temp.data+"]";
		return st;
	}
	public static void main(String[] args) {
		CircularSinglyLinkedList csll=new CircularSinglyLinkedList();
		csll.add(5);
		csll.add(2);
		csll.add(7);
		System.out.println(csll);
	}
}
