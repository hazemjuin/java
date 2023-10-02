import java.util.ArrayList;
import java.util.Random;

public class PuzzleJava {
    
    // Method to generate an ArrayList of 10 random numbers between 1 and 20 (inclusive)
    public ArrayList<Integer> getTenRolls() {
        ArrayList<Integer> randomRolls = new ArrayList<>();
        Random rand = new Random();
        for (int i = 0; i < 10; i++) {
            randomRolls.add(rand.nextInt(20) + 1);
        }
        return randomRolls;
    }
    
    // Method to get a random letter from the alphabet
    public char getRandomLetter() {
        Random rand = new Random();
        char randomLetter = (char) (rand.nextInt(26) + 'a');
        return randomLetter;
    }
    
    // Method to generate a random password of a specified length
    public String generatePassword(int length) {
        StringBuilder password = new StringBuilder();
        for (int i = 0; i < length; i++) {
            password.append(getRandomLetter());
        }
        return password.toString();
    }
    
    // Method to generate an ArrayList of random passwords of a specified length
    public ArrayList<String> getNewPasswordSet(int length, int count) {
        ArrayList<String> passwordSet = new ArrayList<>();
        for (int i = 0; i < count; i++) {
            passwordSet.add(generatePassword(length));
        }
        return passwordSet;
    }
    
    // Method to shuffle an ArrayList of integers
    public void shuffle(ArrayList<Integer> arrList) {
        Random rand = new Random();
        for (int i = arrList.size() - 1; i > 0; i--) {
            int j = rand.nextInt(i + 1);
            int temp = arrList.get(i);
            arrList.set(i, arrList.get(j));
            arrList.set(j, temp);
        }
    }
}
