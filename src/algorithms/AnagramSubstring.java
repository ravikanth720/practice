import java.util.HashMap;
import java.util.Map;
class AnagramSubstring {
  
  public boolean isAnagramSubstring(String s1, String s2){
    Map<Character, Integer> charFrequency1 = calculateCharFrequency(s1.toCharArray());
    Map<Character, Integer> charFrequency2 = calculateCharFrequency(s2.toCharArray());
    return charFrequency1.equals(charFrequency2);
    
    /*if (charFrequency1 == null) {
      return true;
    } else if (charFrequency2 == null) {
      return false;
    } else {
      for (char key: charFrequency1.keySet()) {
        if (charFrequency2.containsKey(key)) {
          if (charFrequency2.get(key) - charFrequency1.get(key) < 0) {
            return false;
          }
        } else {
          return false;
        }
      }
      return true;
    }*/
  }
  
  public Map<Character, Integer> calculateCharFrequency(char[] charArray){
    Map<Character, Integer> charFrequency = null;
    if(charArray != null && charArray.length > 0) {
      charFrequency = new HashMap<Character, Integer>();
      for (int i = 0; i < charArray.length; i++) {
        if (charFrequency.containsKey(charArray[i])) {
          charFrequency.put(charArray[i], charFrequency.get(charArray[i]) + 1);
        } else {
          charFrequency.put(charArray[i], 1);
        }
      }
    }
    return charFrequency;
  }
  
  public static void main(String[] args){
    AnagramSubstring as = new AnagramSubstring();
    System.out.println(as.isAnagramSubstring("", "ravikanth"));
  }
}