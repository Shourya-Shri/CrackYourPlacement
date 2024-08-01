class WordDictionary {

    private List<String> wordsList;

    public WordDictionary() {
        wordsList=new ArrayList<>();
    }
    
    public void addWord(String word) {
        wordsList.add(word);
    }
    
    public boolean search(String word) {
        for(String savedWord: wordsList){
            if(savedWord.length() != word.length()){
                continue;
            }
            boolean wordsMatch=true;
            for(int i=0;i<word.length();i++){
                if(word.charAt(i)!='.' && savedWord.charAt(i)!=word.charAt(i)){
                    wordsMatch=false;
                    break;
                }
            }
            if(wordsMatch){
                return true;
            }
        }
        return false;
    }
}

/**
 * Your WordDictionary object will be instantiated and called as such:
 * WordDictionary obj = new WordDictionary();
 * obj.addWord(word);
 * boolean param_2 = obj.search(word);
 */
