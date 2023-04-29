/**
 * @author Dhylan Usi
 * Describe word linked list
 * 
 */
public class WordLL {
    //Declares the variables mysteryWord and history
    private Word mysteryWord;
    private LinearNode<Word> history;
    /**
     * constructor for WordLl
     * @param mystery
     */
    public WordLL(Word mystery){
        history = new LinearNode<Word>();
        this.mysteryWord = mystery;
    }
    /**
     * checks if the letters of guess are in mysteryWord, returns a boolean
     * updates the history linked list
     * @param guess
     * @return true or false
     */
    public boolean tryWord(Word guess){
        guess.labelWord(mysteryWord);
        LinearNode<Word> guessWord = new LinearNode<Word>();
        guessWord.setElement(guess);

        LinearNode <Word> temp = history.getNext();
        history.setNext(guessWord);
        guessWord.setNext(temp);

        return guess.labelWord(mysteryWord);

    }
    /**
     * returns a string consists of the values of the history linkedlist
     * @return String
     */
    public String toString(){
        
        String words = "";
        LinearNode <Word> history1 = history.getNext();
        while (history1 != null){
            words = words + (history1.getElement()).toString() + '\n';
            history1 = history1.getNext();

        }
        
        return words;
    }
}
