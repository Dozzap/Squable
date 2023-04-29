/**
 * @author Dhylan Usi
 * Letter class
 * 
 */
public class Letter{

    //sets up private variables
    private char letter;
    private int label;
    private int UNSET = 0;
    private int UNUSED = 1;
    private int USED = 2;
    private int CORRECT = 3;
    
    /**
     *@param c
     */
    public Letter(char c){
        label = UNSET;
        letter = c;
    }

    /**
     * @param otherObject
     * @return true or false
     */
    public boolean equals(Object otherObject){
        if (otherObject instanceof Object){
            if(this.letter == ((Letter)otherObject).letter){
                return true;
            }
            else{
                return false;
            }   
        }
        else{
            return false;
        }
    }
    /**
     * @return a string symbol depending on which label equals to, ex. +, - , ! or " "
     */
    public String decorator() {
        if (this.label == USED) {
            return "+";
            
        }else if (this.label == UNUSED){
            return "-";
            
        }else if (this.label == CORRECT) {
            return "!";
            
        }else{
            return " ";
     
        }
    }   
    /**
     * Returns a string print of a letter object
     * @return String
     */
    public String toString(){
        return decorator() + this.letter + decorator(); 
    }
    /**
     * sets label to UNUSED
     */
    public void setUnused(){
        this.label = UNUSED;
    }
    /**
     * sets label to USED
     */
    public void setUsed(){
        this.label = USED;
    }
    /**
     * sets label to CORRECT
     */
    public void setCorrect(){
        this.label = CORRECT;
    }
    /**
     * checks if label is used or not
     * @return true of false
     */
    public boolean isUnused(){
        if (this.label == UNUSED){
            return true;
        }
        return false;
    }
    /**
     * turns a string into an array of letter object instances
     * @param s
     * @return arrOfCharacters, an array of letter objects
     */
    public static Letter[] fromString(String s) {
         Letter[] arrOfCharacters = new Letter[s.length()];
         for (int i = 0; i< s.length(); i++){
             arrOfCharacters[i] = new Letter(s.charAt(i));
         }
         return arrOfCharacters;
    }
}