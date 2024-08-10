class Solution {
    public String reorganizeString(String s) {
        Map<Character, Integer> count = new HashMap();
        for(char c: s.toCharArray())
            count.put(c, count.getOrDefault(c, 0)+1);
            
        PriorityQueue<Character> pq= new PriorityQueue<>((a, b)->count.get(b)-count.get(a));
        pq.addAll(count.keySet());
        StringBuilder sb = new StringBuilder();
        while(pq.size()>1){
            char current = pq.poll();
            char next = pq.poll();
            sb.append(current);
            sb.append(next);
            count.put(current, count.getOrDefault(current,0)-1);
            count.put(next, count.getOrDefault(next,0)-1);
            if (count.get(current)>0)
                pq.offer(current);
            if (count.get(next)>0)
                pq.offer(next);
        }
        if (pq.size()>0){
            char remaining = pq.poll();
            if (count.get(remaining)>1)
                return "";
            else
                sb.append(remaining);
        }
        return sb.toString();

    }
}
