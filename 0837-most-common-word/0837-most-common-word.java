class Solution {
    public String mostCommonWord(String paragraph, String[] banned) {
        Set<String> bannedSet = new HashSet<>(Arrays.asList(banned));

        String normalize = paragraph.replaceAll("[!?',;\\.]", " ").toLowerCase();

        String[] words = normalize.split("\\s+");

        Map<String, Integer> freqMap = new HashMap<>();
        for(String word: words){
            if(!bannedSet.contains(word) && word.length() > 0){
                freqMap.put(word, freqMap.getOrDefault(word, 0) + 1);
            }
        }

        String res = "";
        int maxCnt = 0;
        for(Map.Entry<String, Integer> entry: freqMap.entrySet()){
            if(entry.getValue() > maxCnt){
                maxCnt = entry.getValue();
                res = entry.getKey();
            }
        }
        return res;
    }
}