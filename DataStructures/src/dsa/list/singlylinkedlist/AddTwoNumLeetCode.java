package dsa.list.singlylinkedlist;
import dsa.list.singlylinkedlist.SinglyLinkedList.Node;
public class AddTwoNumLeetCode {
	public static void main(String[] args) {
		AddTwoNumLeetCode ex=new AddTwoNumLeetCode();
		SinglyLinkedList l1=new SinglyLinkedList();
		SinglyLinkedList l2=new SinglyLinkedList();
		l1.add(9);
		l2.add(1);l2.add(9);l2.add(9);l2.add(9);l2.add(9);l2.add(9);l2.add(9);l2.add(9);l2.add(9);
		l2.add(9);
		SinglyLinkedList l3=ex.addTwoNum(l1, l2);
		System.out.println(l3);
	}
	public SinglyLinkedList addTwoNum(SinglyLinkedList l1,SinglyLinkedList l2) {
		StringBuilder s1=new StringBuilder();
		StringBuilder s2=new StringBuilder();
		Node t1=l1.head;
		Node t2=l2.head;
		while(t1!=null) {
			s1.append(t1.data);
			t1=t1.next;
		}
		while(t2!=null) {
			s2.append(t2.data);
			t2=t2.next;
		}
		s1=s1.reverse();
		s2=s2.reverse();
		long sum=(Long.parseLong(s1.toString())+Long.parseLong(s2.toString()));
		System.out.println(sum);
		SinglyLinkedList l3=new SinglyLinkedList();
		if(sum==0) {
			l3.add(0);
			return l3;
		}
		long k=10;
		while(sum!=0) {
			l3.add((int)(sum%k));
			System.out.print(sum%10+" ");
			sum=sum/10;
		}
		return l3;
	}

}
