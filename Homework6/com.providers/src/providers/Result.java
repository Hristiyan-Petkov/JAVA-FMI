package providers;

public class Result {
    private char[] chars;
    int data;


    Result(int newData, char[] newChars) {
        setChars(newChars);
        setData(newData);
    }

    public int getData() {
        return data;
    }

    //uslovieto ne kazva dali data trqbva da bude samo polojitelno za tova nqma proverka
    public void setData(int data) {
        this.data = data;
    }

    public void setChars(char[] chars) {
        this.chars = chars.clone();
    }

    public char[] getChars() {
        char[] newChars = new char[this.chars.length];
        System.arraycopy(this.chars, 0, newChars, 0, chars.length);

        return newChars;
    }

    public String toString() {
        String tmp = "Chars: " + chars.toString() + ",   " + "Data: " + data;
        return tmp;
    }
}
