import java.util.ArrayList; // Add this import statement
import java.util.Random;

public class TestPuzzleJava {
    
    public static void main(String[] args) {
        PuzzleJava generator = new PuzzleJava();
        
        // Test the getTenRolls method
        ArrayList<Integer> randomRolls = generator.getTenRolls();
        System.out.println("Random Rolls: " + randomRolls);
        
        // Test the getRandomLetter method
        char randomLetter = generator.getRandomLetter();
        System.out.println("Random Letter: " + randomLetter);
        
        // Test the generatePassword method
        String password = generator.generatePassword(8); // Change the length as needed
        System.out.println("Generated Password: " + password);
        
        // Test the getNewPasswordSet method
        ArrayList<String> passwordSet = generator.getNewPasswordSet(8, 5); // Change length and count as needed
        System.out.println("Generated Password Set: " + passwordSet);
        
        // Test the shuffle method (assuming you have an ArrayList of integers)
        ArrayList<Integer> arrList = new ArrayList<>(randomRolls); // Copy the list to avoid modifying the original
        generator.shuffle(arrList);
        System.out.println("Shuffled List: " + arrList);
    }
}
