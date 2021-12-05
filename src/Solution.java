

class Solution {
    public int myAtoi(String s) {
        int res=0 ;
        final int len = s.length();
        int flag = 1;  //标记正负
        int index = 0;
        char[] chars =s.toCharArray();
        while(index < len && chars[index] == ' ' ){
            index++;
        }
        if(index == len){
            return 0;
        }
        if(chars[index] == '-'){
            flag = -flag;
            index++;
        }else if(chars[index] == '+'){
            index++;
        }
        while (index < len){
            char currChar = chars[index];
            if(currChar < '0' || currChar > '9'){
                break;
            }
            if(res > Integer.MAX_VALUE / 10 || (res == Integer.MAX_VALUE / 10 && (currChar - '0') > Integer.MAX_VALUE % 10)){
                return Integer.MAX_VALUE;
            }else if(res < Integer.MIN_VALUE / 10 || (res == Integer.MIN_VALUE / 10 && (currChar - '0') > -(Integer.MIN_VALUE % 10))){
                return Integer.MIN_VALUE;
            }
            res = res * 10 + flag * (currChar - '0');
            index++;
        }
        return res;
    }


    public static void main(String[] args)  {
        Solution solution = new Solution();
        int n = solution.myAtoi("2147483648");
        System.out.println("n = " + n);
    }

}