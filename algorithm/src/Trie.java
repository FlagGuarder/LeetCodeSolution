class TreeNode{
    private TreeNode[] links;

    private final int R = 26;

    private boolean isEnd;

    public TreeNode() {
        links = new TreeNode[26];
    }

    public boolean containsKey(char ch){
        return links[ch - 'a'] != null;
    }

    public TreeNode get(char ch){
        return links[ch - 'a'];
    }

    public void put(char ch, TreeNode node){
        links[ch - 'a'] = node;
    }

    public void setEnd(){
        isEnd = true;
    }

    public boolean isEnd(){
        return isEnd;
    }
}
public class Trie {
    private TreeNode root;

    public Trie() {
        root = new TreeNode();
    }

    public void insert(String word){
        TreeNode node = root;
        for (int i = 0;i < word.length();i++){
            char ch = word.charAt(i);
            if (!node.containsKey(ch))
                node.put(ch,new TreeNode());
            node = node.get(ch);
        }
        node.setEnd();
    }

    private TreeNode searchPrefix(String word){
        TreeNode node = root;
        char ch;
        for (int i = 0;i < word.length();i++ ){
            ch = word.charAt(i);
            if (!node.containsKey(ch)){
                return null;
            }else
                node = node.get(ch);

        }
        return node;
    }

    public boolean search(String word){
        TreeNode node = searchPrefix(word);
        return node != null && node.isEnd();
    }

    public boolean startWith(String word){
        return searchPrefix(word) != null;
    }


}
