

class Solution {
    public int myAtoi(String s) {
        int res ;
        int flag = 1;  //标记正负
        int i = 0;
        double d ;
        StringBuilder sb = new StringBuilder();
        s =s.trim();
        char[] med=s.toCharArray();
        for (char c:med){
            if (c == '-' && i == 0){
                flag = 0;
            }else if (Character.isDigit(c)){
                sb.append(c);
            }else if(!(i == 0 && c == '+')){
                break;
            }
            i++;
        }
        if(sb.length() == 0){
            return 0;
        }
        if(flag == 0) {
            sb.insert(0, '-');
        }
        d = Double.parseDouble(sb.toString());
        if (d < Integer.MIN_VALUE){
            res = Integer.MIN_VALUE;
        } else if(d > Integer.MAX_VALUE){
            res = Integer.MAX_VALUE;
        }else{
            res = Integer.parseInt(sb.toString());
        }
        return res;
    }


    public static void main(String[] args)  {
        Solution solution = new Solution();
        int n = solution.myAtoi(" 999999999999999879879789789789897 ");
        System.out.println("n = " + n);
    }

}