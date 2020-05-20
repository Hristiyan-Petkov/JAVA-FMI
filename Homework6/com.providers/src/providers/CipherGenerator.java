package providers;

import services.Cipherable;

public class CipherGenerator {
    public static Result countDistinct(Cipherable cipher, int seed){
        char[] array = cipher.getSecretChars(seed);
        int count = 0;
        int finalCount = 0;

        for(int i = 0; i < array.length; i++){
            for(int j = 0; j < array.length; j++){
                if(array[i] == array[j]){
                    count++;
                }
            }
            if(count == 1){
                finalCount++;
            }
            count = 0;
        }

        Result result = new Result(finalCount, array);
        return result;
    }
}
