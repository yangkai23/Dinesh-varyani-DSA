package dsa.hashing;
public class HashTable {
	private HashNode bucket[];
	private int num_of_buckets;
	private int size;

	public HashTable(int capacity) {
		this.bucket = new HashNode[capacity];
		this.num_of_buckets = capacity;
		size=0;
	}
	private class HashNode{
		private Integer key;
		private String value;
		private HashNode next;
		public HashNode(Integer key, String value) {
			this.key = key;
			this.value = value;
		}
	}
	public int size() {
		return size;
	}
	public boolean isEmpty() {
		return size==0;
	}
	public int hashFn(Integer key) {
		return key%num_of_buckets;
	}
	public void put(Integer key,String value) {
		int index=hashFn(key);
		System.out.println(index);
		HashNode current=bucket[index];
		while(current!=null) {
			if(current.key.equals(key)) {
				current.value=value;
				return;	
			}
			current=current.next;
		}
		current=bucket[index];
		HashNode hn=new HashNode(key, value);
		hn.next=current;
		size++;
		bucket[index]=hn;
	}
	public String get(Integer key) {
		int index=hashFn(key);
		HashNode head=bucket[index];
		while(head!=null) {
			if(head.key.equals(key))
				return head.value;
			head=head.next;
		}
		return null;
	}
	public String remove(Integer key) {
		int index=hashFn(key);
		HashNode head=bucket[index];
		if(head==null) {
			System.out.println("no key found");
		}
		HashNode previous=null;
		while(head!=null) {
			if(head.key.equals(key))
				break;
			previous=head;
			head=head.next;
		}
		if(previous!=null) {
			previous.next=head.next;
			return head.value;
		}
		else {
			bucket[index]=null;
			return head.value;
		}
	}
	public String toString() {
		String st="{";
		for (int i = 0; i < bucket.length; i++) {
			HashNode head=bucket[i];
			if(head!=null) {
				while(head!=null) {
					st=st+head.key+"="+head.value;
					head=head.next;
					st=st+" ";
				}
			}	
		}
		return st.trim()+"}";
	}
	public static void main(String[] args) {
		HashTable ht=new HashTable(100);
		ht.put(131, "Anirudh");
		ht.put(111, "vishnu");
		ht.put(109, "karthik");
		ht.put(69, "hrushi");
		ht.put(131, "Shanmukha");
		ht.put(231, "parker");
		System.out.println(ht);
		System.out.println(ht.get(131));
		System.out.println(ht.remove(69));
		System.out.println(ht);
	}
}
