package Work.Workshop12.calc;

public class test {

    public String caesar(String s, int k) {
        String result = "";
        for (char c : s.toCharArray()) {
            if(c>='A'&&c<='Z') {
                result +=(char)('A'+(c -'A'+k)%26);
            } else if (c>='a'&& c<='z') {
                result +=(char)('a'+(c -'a'+k)%26);
            }
            else {
                result +=c;
            }

        }
        return result;
    }


    public static void main(String[] args) {

    }
}
