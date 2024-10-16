LEETCODE 1405;


class pair{
    int first;
    char second;
    pair(int first,char second){
        this.first=first;
        this.second=second;
    }
}

class Solution {
    public String longestDiverseString(int a, int b, int c) {
        PriorityQueue<pair> pq=new PriorityQueue<>((pair a1,pair b1)-> b1.first-a1.first);
        if(a>0){
            pq.add(new pair(a,'a'));
        }
        if(b>0){
            pq.add(new pair(b,'b'));
        }
        if(c>0){
            pq.add(new pair(c,'c'));
        }

        String s="";

        while(!pq.isEmpty()){
            pair it=pq.remove();
            int freq=it.first;
            char curr=it.second;
             if(s.length()>=2 && s.charAt(s.length()-1)==curr && s.charAt(s.length()-2)==curr){

                if(pq.isEmpty()){
                    break;
                }

                pair next=pq.remove();
                int cnt=next.first;
                char ch=next.second;

                s+=ch;
                cnt--;
                if(cnt>0){
                    pq.add(new pair(cnt,ch));
                }
             }
             else{
                s+=curr;
                freq--;
               
             }
              if(freq>0){
                    pq.add(new pair(freq,curr));
                }


        }
        return s;
        
    }
}
