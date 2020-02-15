package wwcnyc;

public class Pig {

    public static String pigtranslator(String string){
        String ans="";
        String[] words = string.split(" ");

        for (int i = 0; i < words.length; i++) {
            ans += word(words[i]) + " ";
        }

        return ans;
    }

    private static String word (String word) {
        String ans = "";
        String vovel = "aeiou";
            if ("aeiou".indexOf(word.charAt(0)) > - 1)
                return  word + "way";

            int i = 0;

            while ( i != word.length() && vovel.indexOf(word.charAt(i)) < 0 ) i++;

            if (i == word.length()) return word + "ay";

            return word.substring(i, word.length())
                    + word.substring(0,i) + "ay";
    }

    public static void main(String[] args) {
        String s = "Enter the English text here that you want translated into\n" +
                "Pig Latin. This is accomplished via this HTML document and\n" +
                "accompanying JavaScript program. Note that";
        System.out.print(pigtranslator(s));
    }

}
