package algorithms.curated170.medium;

public class AddBoldTaginString {

    public String addBoldTag(String s, String[] dict) {
        StringBuilder sb = new StringBuilder();
        boolean arr[] = new boolean[s.length()];
        for(String d : dict){
            int start = s.indexOf(d);
            while(start != -1){
                int length = start+ d.length();
                for(int i = start; i < length; i++){
                    arr[i] = true;
                }
                start = s.indexOf(d, start + 1);
            }
        }
        boolean startB = false;
        for(int i = 0; i < arr.length; i++){
            if(arr[i]){
                if(!startB){
                    startB = true;
                    sb.append("<b>");
                }
            }else{
                if(startB){
                    startB = false;
                    sb.append("</b>");
                }
            }
            sb.append(s.charAt(i));
        }
        if(startB){
            sb.append("</b>");
        }
        return sb.toString();
    }
}
