
/*Q. Given an English word, write a function to check whether it's possible to 
reduce the word a character at a time so that the resulting word is also English.
Ex: cart - art - at - a
Ex: best - bet -  be

boolen isEnglish(String word);
*/
public List<String> findEnglishWords(String word) {
    
    if(word == null) {
        return null;
    }
    
    List<String> result = new LinkedList<String>();
    List<String> partialResult = new LinkedList<String>();
    partialResult.add(word);
    int len = word.length();
    int depth = 0;
    // Two stacks for keeping the state for back tracking
    Stack<Integer> deletion = new Stack<Integer>();
    Stack<String> strStack = new Stack<String>();
    // Initialize the stacks, so that when stack is empty event the top level word is handled
    deletion.push(0);
    strStack.push(word);

    int i = 0;
    //Loop for each level of string after deletions
    while(len > 0) {
        boolean wordFound = false;
        // loop for deleting the character (value of i is controlled below for backtracking)
        for(i; i<len; i++) {
            String newWord = word;
            if(isEnglish(newWord.deleteCharAt(i))) {
                // Save state for backtracking
                deletion.push(i);
                strStack.push(newWord)

                partialResult.add(newWord);
                len--;
                word = newWord;
                wordFound = true;
                break;
            }
            
            if (!wordFound) {
              // Deletions did not find an english word
                if(result.size() < partialResult.size()) {
                  // Update result if this is better
                    result = partialResult;
                }
                if (len > 0) { // It did not go all the way
                    if(deletion.pop().isEmpty() || strStack.isEmpty()){
                        break;
                    } else {
                        //Reset all the state to backtrack
                        i = deletion.pop() + 1;
                        word = strStack.pop();
                        // Loop for backtracking
                        while (i > word.length() && !(strStack.isEmpty() && deletion.isEmpty())) {
                            word = strStack.pop();
                            i = deletion.pop() + 1;
                        }
                    }
                } else {
                    // Reached the end and found the solution
                    result = partialResult;
                    break;
                }
            } else {
                //reset the for loop to start from beginning
                i = 0;
            }
        }
    }
}