import java.util.HashMap;

public class TrieNode {

    public char c;
    HashMap<Character, TrieNode> children = new HashMap<>();
    boolean isEnd;

    public TrieNode() {

    }

    public TrieNode(char charc) {
        c = charc;
    }
}
