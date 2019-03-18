import java.util.HashMap;

public class Trie {

    public TrieNode root;

    public Trie() {
        root = new TrieNode();
    }

    // insert the characters from the string one by one
    public void insert(String word) {
        // this line is for getting the TrieNode
        HashMap<Character, TrieNode> children = root.children;

        for(int i = 0; i < word.length(); i++) {
            char ch = word.charAt(i);
            TrieNode t;
            if(children.containsKey(ch)) {
                t = children.get(ch);
            }else { //  if the character does not exists
                t = new TrieNode(ch);
                children.put(ch, t);
            }

            children  = t.children;
            if(i == word.length() - 1) {
                t.isEnd = true;
            }
        }
    }

    public boolean search(String word) {
        TrieNode t = searchNode(word);

        if(t != null && t.isEnd) {
            return true;
        }
        return  false;
    }

    public TrieNode searchNode(String word) {
        HashMap<Character, TrieNode> children = root.children;
        TrieNode t = null;
        for(int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if(children.containsKey(c)) {
                t = children.get(c);
                children = t.children;
            }else {
                return null;
            }
        }
        return t;
    }

    public static void main(String[] args) {
        Trie ts = new Trie();
        ts.insert("Biplab");
        ts.search("Biplab");
    }

}
