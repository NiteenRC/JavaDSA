package programs.companies;

public class AccoliteDigital {
    public static void main(String[] args) {
        String s = "I Work At Accolite Digital";
        StringBuilder output = new StringBuilder();
        for(char ch : s.toCharArray()){
            if(ch >= 65 && ch <= 90){
                 output.append(Character.toLowerCase(ch));
            } else if (ch >= 97 && ch <= 122){
                output.append(Character.toUpperCase(ch));
            } else {
               output.append(ch);
            }
        }
        System.out.println(output);
    }
}
