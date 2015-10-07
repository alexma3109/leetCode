class TrieNode {
	TrieNode[] children;
	boolean isWord;
	public TrieNode () {
		children = new TrieNode[26];
		isWord = false;
	}
}
public class WordDictionary {
	private TrieNode root;
	
	public WordDictionary(){
		root = new TrieNode();
	}
    // Adds a word into the data structure.
    public void addWord(String word) {
        TrieNode node = root;
		for(int i = 0 ; i < word.length() ; i++){
			int c = word.charAt(i) - 'a';
			if(node.children[i] == null){
				node.children[i] = new TrieNode();
			}
			node = node.children[i];
		}
		node.isWord = true;
    }

    // Returns if the word is in the data structure. A word could
    // contain the dot character '.' to represent any one letter.
    public boolean search(String word) {
        TrieNode node = root;
		return helper(node, word, 0);
    }
	public boolean helper(TrieNode node, String word, int pos){
		if(node == null || (pos == word.length() && !node.isWord)){
			return false;
		}
		if(pos == word.length() && node.isWord){
			return true;
		}
		if(word.charAt(pos) == '.'){
			for(int i = 0 ; i < 26 ; i++){
				if(helper(node.children[i], word, pos + 1)){
					return true;
				}
			}
			return false;
		}
		else{
			int c = word.charAt(pos) - 'a';
			return helper(node.children[c], word, pos + 1);			
		}
	}
}