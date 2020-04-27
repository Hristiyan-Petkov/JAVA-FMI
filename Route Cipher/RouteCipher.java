package cipher;

import javax.imageio.ImageTranscoder;
import java.util.Scanner;

public class RouteCipher {
    private int key;

    public RouteCipher(int key) {
        setKey(key);
    }

    public int getKey() {
        return key;
    }

    public void setKey(int key) {
        if (key == 0) {                                 //check if the key is 0, if it is, we print proper message to the console
            System.out.println("Invalid key! ");
        } else {
            this.key = key;
        }
    }

    String encrypt(String plainText) {
        char[] cipherTextChars = removeWhiteSpace(plainText);
        return encryptedString(cipherTextChars);
    }

    String decrypt(String cryptedText){
        char[] cipherTextChars = cryptedText.toCharArray();
        return decryptedString(cipherTextChars);
    }

    String decryptedString(char[] cipherTextChars){
        int columns = Math.abs(key);                      //initializing the columns using the absolute value of the key
        int rows = cipherTextChars.length / columns;      //in this array there are no white spaces so we know exactly the size of the array and the number of rows

        char[][] tmpMatrix = new char[rows][columns];
        char[][] matrixDecypher = new char[rows][columns];

        //determine how we will decrypt the message according to the key
        if(key > 0){
            matrixDecypher = spiralDecryption(tmpMatrix, cipherTextChars, 0, rows, columns, 0);           //if the key is bigger than 0 we start from the top left element
        } else if(key < 0){
            matrixDecypher = secondSpyralDectription(tmpMatrix, cipherTextChars, 0, rows, columns, 0);    //if it is smaller than 0 we start from the bottom right element
        }


        String decrypted = new String();
        decrypted = toString(matrixDecypher, rows, columns);
        return decrypted;
    }

    //decrypting when the key is positive
    char[][] spiralDecryption(char[][] a, char[] array, int x, int rows, int columns, int charPos){
        int i;

        //down
        for(i = x; i < rows - x; i++){
            a[i][x] = array[charPos];
            charPos++;
            if(charPos == array.length){                //check if there are more elements in the one demensional array
                return a;
            }
        }

        //right
        for(i = x + 1; i < columns - x; i++){
            a[rows - 1 - x][i] = array[charPos];
            charPos++;
            if(charPos == array.length){
                return a;
            }
        }

        //up
        for(i = rows - 2 - x; i >= x; i--) {
            a[i][columns - 1 - x] = array[charPos];
            charPos++;
            if(charPos == array.length){
                return a;
            }
        }

        //left
        for(i = columns - 2 - x; i >= x + 1; i--) {
            a[x][i] = array[charPos];
            charPos++;
            if (charPos == array.length) {
                return a;
            }
        }

        return spiralDecryption(a, array, x + 1, rows, columns, charPos);
    }

    //decrypting when the key is negative
    char[][] secondSpyralDectription(char[][] a, char[] array, int x, int rows, int columns, int charPos){
        int i;

        //up
        for(i = rows - 1 -x; i >= x; i--) {
            a[i][columns - 1 - x] = array[charPos];
            charPos++;
            if (charPos == array.length) {                  //check if there are more elements in the one demensional array
                return a;
            }
        }

        //left
        for(i = columns - 2 - x; i >= x; i--) {
            a[x][i] = array[charPos];
            charPos++;
            if (charPos == array.length) {
                return a;
            }
        }

        //down
        for(i = x + 1; i < rows - x; i++) {
           a[i][x] = array[charPos];
           charPos++;
           if (charPos == array.length) {
               return a;
           }
        }

        //right
        for(i = x + 1; i < columns - 1 - x; i++) {
            a[rows - 1 - x][i] = array[charPos];
            charPos++;
            if (charPos == array.length) {
                return a;
            }
        }

        return secondSpyralDectription(a, array, x + 1, rows, columns, charPos);
    }

    String encryptedString(char[] cipherTextChars){
        int columns = Math.abs(key);
        int rows = determingTheNumberOfRows(cipherTextChars);
        int charPosition = 0;                                                      //counter to see on which position we are in the one demensional array

        char[][] matrixCipher = new char[rows][columns];

        //transfering from array to matrix
        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < columns; j++) {
                if (charPosition != cipherTextChars.length) {
                    matrixCipher[i][j] = cipherTextChars[charPosition];
                    charPosition++;
                } else {
                    matrixCipher[i][j] = 'X';                                //if there is more space in the matrix but no more elements in the array we put X in the matrix
                }
            }
        }

        String text = new String();
        if(key > 0){                                                                                 //if the key is bigger than 0 we start from the top left
            return spiral(matrixCipher, 0, rows, columns, columns * rows, text);
        } else if (key < 0){                                                                         //if it is smaller from the bottom right
            return secondSpiral(matrixCipher, 0, rows, columns, columns * rows, text);
        }
        return null;
    }

    int determingTheNumberOfRows(char[] array){
        int rows = 0;
        if (array.length % Math.abs(key) == 0) {            //we must have a perfect matrix so if the elements are less
            rows = array.length / Math.abs(key);            //we create more space and put X in it
        } else {
            rows = array.length / Math.abs(key) + 1;
        }

        return rows;
    }

    char[] removeWhiteSpace(String plainText){
        char[] cipherTextChars = plainText.toCharArray(); //transfering the infromation from the string to char array
        int newArraySize= determingSizeOfArray(cipherTextChars); //the size of the array without white spacing

        char[] withoutWhiteSpace = new char[newArraySize];

        int charPos = 0; // counter to track on which position we are in the new string

        for(int i = 0; i < cipherTextChars.length; i++){
            if((cipherTextChars[i] >= 'A' && cipherTextChars[i] <= 'Z') || (cipherTextChars[i] >= 'a' && cipherTextChars[i] <= 'z')){     //we put only letters in our new array
                withoutWhiteSpace[charPos] = cipherTextChars[i];
                charPos++;
            }
        }
        return withoutWhiteSpace;
    }

    int determingSizeOfArray(char[] cipherTextChars){
        int newArraySize = 0;

        //determing the size of our new array without white spacing
        for(int i = 0; i< cipherTextChars.length; i++){
            if((cipherTextChars[i] >= 'A' && cipherTextChars[i] <= 'Z') || (cipherTextChars[i] >= 'a' && cipherTextChars[i] <= 'z')){
                newArraySize++;
            }
        }
        return newArraySize;
    }

    String spiral(char a[][],int x, int rows, int columns, int counter, String tmp){
        int i;
        //from top left element
        //down
        for(i = x; i < rows - x; i++){
            tmp += a[i][x];
            counter--;
            if(counter == 0){
                return tmp;
            }
        }

        //right
        for(i = x + 1; i < columns - x; i++){
            tmp += a[rows - 1 - x][i];
            counter--;
            if(counter == 0){
                return tmp;
            }
        }

        //up
        for(i = rows - 2 - x; i >= x; i--){
            tmp += a[i][columns - 1 - x];
            counter--;
            if(counter == 0){
                return tmp;
            }
        }

        //left
        for(i = columns - 2 - x; i >= x + 1; i--){
            tmp += a[x][i];
            counter--;
            if(counter == 0){
                return tmp;
            }
        }

        return spiral(a,x+1, rows, columns, counter, tmp);
    }

   String secondSpiral(char a[][],int x, int rows, int columns, int counter, String tmp){
        int i;

        //from bottom right element
        //up
        for(i = rows - 1 -x; i >= x; i--){
            tmp += a[i][columns - 1 - x];
            counter--;
            if(counter == 0){
                return tmp;
            }
        }

        //left
        for(i = columns - 2 - x; i >= x; i--){
            tmp += a[x][i];
            counter--;
            if(counter == 0){
                return tmp;
            }
        }

        //down
        for(i = x + 1; i < rows - x; i++){
            tmp += a[i][x];
            counter--;
            if(counter == 0){
                return tmp;
            }
        }

        //right
        for(i = x + 1; i < columns - 1 - x; i++){
            tmp += a[rows - 1 - x][i];
            counter--;
            if(counter == 0){
                return tmp;
            }
        }

        return secondSpiral(a, x + 1, rows, columns, counter, tmp);
   }

   String toString(char[][]a, int rows, int columns){
        String string = new String();
        for(int i = 0; i < rows; i++){
            for(int j = 0; j < columns; j++){
                string += a[i][j];
            }
        }
        return string;
   }

}
