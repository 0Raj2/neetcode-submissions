class Solution {

    public String encode(List<String> strs) {

        String str = "";

        for(String s : strs){
            str = str+s+"`";
        }

        return str;

    }

    public List<String> decode(String str) {

        List<String> resList = new ArrayList<>();
        int start = 0;

        
        for(int i = 0; i < str.length(); i++){
            if(str.charAt(i) == '`'){
                resList.add(str.substring(start,i));
                start = i+1;
            }
        }

        return resList;

    }
}
