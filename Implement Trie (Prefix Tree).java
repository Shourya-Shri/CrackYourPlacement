class Trie {
    private HashSet<String> data;
    private HashSet<String> prefs;

    public Trie() {
        data = new HashSet<>();
        prefs = new HashSet<>();
    }
    
    public void insert(String word) {
        StringBuilder cur = new StringBuilder();
        for (int i = 0; i < word.length(); i++) {
            cur.append(word.charAt(i));
            prefs.add(cur.toString());
        }
        data.add(word);
    }
    
    public boolean search(String word) {
        return data.contains(word);
    }
    
    public boolean startsWith(String prefix) {
        return prefs.contains(prefix);
    }
}
