package providers;

import services.Cipherable;

import java.util.Random;

public class Wrapper {
    private int size;

    public Wrapper(int size){
        setSize(size);
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        if(size < 0){
            this.size = 0;
        }

        else {
            this.size = size;
        }
    }

    private class FixedRandom implements Cipherable {
        @Override
        public char[] getSecretChars(int  seed){
            Random random = new Random(seed);
            char[] array = new char[size];

            for(int i = 0; i < size; i++){
               array[i] = (char)(random.nextInt('Z' - 'A') + 'A');
            }
            return array;
        }
    }

    public Cipherable makeFixedSelection(){
        return new FixedRandom();
    }

    private class FixedSelection implements Cipherable {
        public char[] getSecretChars(int seed){
            Random random = new Random();
            char[] array = new char[size];

            for(int i = 0; i < size; i++){
                array[i] = (char)(random.nextInt('Z' - 'A') + 'A');
            }
            return array;
        }
    }

    public Cipherable makeFixedRandom(){
        return new FixedSelection();
    }
}
