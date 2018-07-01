public class Crypto {
    public static void main(String[] args){
        System.out.println(encryptString("This is some \"really\" great. (Text)!?", -5, 2));
    }

    public static String normalizeText(String baseText){
        String normalizedText = baseText.replaceAll("\\s+","");
        normalizedText = normalizedText.replaceAll("[.,:;'\"!?()]", "");
        normalizedText = normalizedText.toUpperCase();
        return normalizedText;
    }
    public static String caesarify(String normalizedOne, int num){
        int len = normalizedOne.length();
        String caesarifiedText = "";
        for (int cnt = 0; cnt < len; cnt++){
            char ch = normalizedOne.charAt(cnt);
            caesarifiedText = caesarifiedText + shiftFunc(ch, num);
        }
        return caesarifiedText;
    }
    public static char shiftFunc(char ch, int shift) {
        int modCh = (int) ch;
        modCh = modCh + shift;
        if (modCh > 90) {
            modCh = modCh - 26;
        } else if (modCh < 65) {
            modCh = modCh + 26;
        }
        char finalCh = (char) modCh;
        return finalCh;
    }

    public static String groupify(String caesarifiedText, int numLetters) {
        StringBuilder originalText = new StringBuilder(caesarifiedText);
        String modText = "";
        int remainder = originalText.length() % numLetters;
        int addX = numLetters - remainder;
        if (remainder != 0) {
            for (; addX > 0; addX = addX - 1){
                originalText.append("x");
            }
        }

        int startIdx = 0;
        int increment = numLetters;
        for (; increment <= originalText.length(); increment+=numLetters ){
            modText = modText + originalText.substring(startIdx, increment) + " ";
            startIdx = startIdx + numLetters;
        }

        return modText;
    }
    public static String encryptString(String text, int shift, int groupsSize){
        return groupify(caesarify(normalizeText(text), shift), groupsSize);
    }
}