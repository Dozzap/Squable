/**
 * @author Dhylan Usi
 * Word class
 * 
 */

public class Word{
    // declares head of linkedlist
    private LinearNode<Letter> firstLetter;

    /**
     * Constructor for the Word class
     * @param letters
     */
    public Word(Letter[] letters){
        this.firstLetter = new LinearNode<Letter>(letters[0]);
        LinearNode<Letter> object = this.firstLetter;
        LinearNode<Letter> temp;
        
        for(int i = 1; i < letters.length; i++) {
            temp = new LinearNode<Letter>(letters[i]);
            object.setNext(temp);
            object = object.getNext();
        }
    }
    /**
     * returns a string print of the class Word instances
     * @return String
     */
    public String toString(){
        String words = "Word: ";
        LinearNode<Letter> current = this.firstLetter;
        
        while (current != null){
            words += current.getElement().toString()+ " ";
            current = current.getNext();
        }
        return words;
    }
    /**
     * Labels each letter of guessWord after checking similiraties with mysteryWord
     * @param mystery
     * @return true or false
     */
    public boolean labelWord(Word mystery){
        LinearNode<Letter> mysteryWord = mystery.firstLetter;
        LinearNode<Letter> guessWord = this.firstLetter;
        //first checks if both words are the same
        //if they are, all letters will be set into correct and will return true
        if (mysteryWord.toString().equals(guessWord.toString())){
            mysteryWord = mystery.firstLetter;
            while (mysteryWord != null){
                guessWord.getElement().setCorrect();
                guessWord = guessWord.getNext();
                mysteryWord= mysteryWord.getNext();
            }
            return true;
        }
        //if not, it will go to this loop that iterates from each letter of guessWord against mysteryWord and set the letters into used
        //this will return false
        else{
            guessWord= this.firstLetter;
            while (guessWord != null){
                guessWord.getElement().setUnused();
            mysteryWord = mystery.firstLetter;
            while (mysteryWord != null){
                
                if (guessWord.getElement().equals(mysteryWord.getElement())){
                guessWord.getElement().setUsed();
                mysteryWord = mysteryWord.getNext();
                    }
                else{mysteryWord = mysteryWord.getNext();}
            }
            guessWord = guessWord.getNext();
        }
        //this will check if the letter of the guessWord is in the right and in the same order as the letter from mysteryWord and sets the letters to correct
        guessWord= this.firstLetter;
        mysteryWord = mystery.firstLetter;

            while(mysteryWord != null && guessWord != null){
                if (guessWord.getElement().equals(mysteryWord.getElement())){
                    guessWord.getElement().setCorrect();
                }
                guessWord = guessWord.getNext();
                mysteryWord = mysteryWord.getNext();
            }
        }
        return false;
    }
}