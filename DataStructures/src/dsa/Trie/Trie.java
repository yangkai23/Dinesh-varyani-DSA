package dsa.Trie;
import java.util.*;

import org.omg.CORBA.Current;
public class Trie {
	private TrieNode root;
	public Trie() {
		this.root = new TrieNode(' ');
	}
	private class TrieNode{
		char data;
		boolean end;
		LinkedList<TrieNode> childlist;
		public TrieNode(char c) {
			this.data = c;
			this.end = false;
			this.childlist = new LinkedList<Trie.TrieNode>();
		}
		private TrieNode getChild(char c) {
			if(childlist!=null) {
				for(TrieNode child:childlist) {
					if(child.data==c)
						return child;
				}
			}		
			return null;
		}
	}
	public void insert(String word) {
		TrieNode current=root;
		for (int i = 0; i <word.length() ; i++) {
			TrieNode node=current.getChild(word.charAt(i));
			if(node!=null) {
				current=node;
			}
			else {
				current.childlist.add(new TrieNode(word.charAt(i)));
				current=current.getChild(word.charAt(i));
			}
		}
		current.end=true;
	}
	public boolean search(String word) {
		TrieNode current=root;
		for(char ch:word.toCharArray()) {
			if(current.getChild(ch)!=null) {
				current=current.getChild(ch);
			}
			else
				return false;
		}
		if(current.end)
			return true;
		return false;
	}
	public boolean remove(String word) {
		if(!search(word))
			return false;
		return remove(root,word,0);
	}
	private boolean remove(TrieNode root, String word,int k) {
		TrieNode node=root;
		if(node.end) {
			node.end=false;
			return true;
		}
		if(node.getChild(word.charAt(k))!=null) {
			node=node.getChild(word.charAt(k));
			remove(node, word,k+1);
			node.end=false;	
		}
		return true;
	}
	public void display(TrieNode root,String s) {
		TrieNode current=root;
		if(current.childlist==null||root.childlist.size()==0) 
			return;
		Iterator<TrieNode> itr=current.childlist.iterator();
		while(itr.hasNext()) {
			TrieNode node=itr.next();
			s+=node.data;
			display(node, s);
			if(node.end) {
				System.out.print(s+" ");
				s=s.substring(0, s.length()-1);
			}
			else
				s=s.substring(0, s.length()-1);
		}
	}
	public static void main(String[] args) {
		Trie trie=new Trie();
		trie.insert("Anirudh");
		trie.insert("son");
		trie.insert("hi");
		trie.insert("hiii");
		System.out.println(trie.search("Ani"));
		System.out.println(trie.remove("son"));
		System.out.println(trie.remove("Ani"));
		trie.display(trie.root, "");
	}
}