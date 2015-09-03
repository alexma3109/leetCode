public class TrieNode {
	boolean isWord;////String word;////
	TrieNode[] children;
	
	public TrieNode(){
		isWord = false;////word = "";////
		children = new TrieNode[26];
	}
}

public class Trie {
	TrieNode root;
	
	public Trie(){
		root = new TrieNode();
	}
	
	public void insert (String word) {
		TrieNode node = root;
		for(int i = 0 ; i < word.length() ; i++){
			int pos = word.charAt(i) - 'a';
			if(node.children[pos] == null){
				node.children[pos] = new TrieNode();
			}
			node = node.children[pos];
		}
		node.isWord = true;////node.word = word;////
	}
	
	public boolean search(String word){
		TrieNode node = root;
		for(int i = 0 ; i < word.length() ; i++){
			int pos = word.charAt(i) - 'a';
			if(node.children[pos] == null){
				return false;
			}
			node = node.children[pos];
		}
		return node.isWord;////node.word.equals(word);////
	}
	
	public boolean startWith(String prefix){
		TrieNode node = root;
		for(int i = 0 ; i < prefix.length() ; i++){
			int pos = prefix.charAt(i) - 'a';
			if(node.children[pos] == null){
				return false;
			}
			node = node.children[pos];
		}
		return true;
	}
}