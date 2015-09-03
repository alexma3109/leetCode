public class Solution {
    public List<String> findWords(char[][] board, String[] words) {
		List<String> res = new ArrayList<String>();
		Trie trie = new Trie();
		for(String word : words){
			trie.insert(word);
		}
		boolean[][] visited = new boolean[board.length][board[0].length];
		for(int i = 0 ; i < board.length ; i++){
			for(int j = 0 ; j < board[0].length ; j++){
				searchHelper(board, visited, res, trie, "", i, j);
			}
		}
		return res;
    }
	public void searchHelper(char[][] board, boolean[][] visited, List<String> res, Trie trie, String str, int i, int j){
		int m = board.length;
		int n = board[0].length;
		if(i < 0 || i >= m || j < 0 || j >= n){
			return;
		}
		if(!trie.startWith(word)){
			return;
		}
		if(visited[i][j]){
			return;
		}
		str = str + board[i][j];
		if(trie.search(str) && !res.contains(str)){
			res.add(str);
		}
		visited[i][j] = true;
		searchHelper(board, visited, res, trie, str, i + 1, j);
		searchHelper(board, visited, res, trie, str, i - 1, j);
		searchHelper(board, visited, res, trie, str, i, j + 1);
		searchHelper(board, visited, res, trie, str, i, j - 1);
		visited[i][j] = false;
	}
}

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