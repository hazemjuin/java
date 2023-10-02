public class AlfredQuotes {
    public static void guestGreeting(String name) {
        System.out.println("Hello, " + name + ". How may I assist you today?");
    }

    public static void dateAnnouncement() {
        System.out.println("Today is " + java.time.LocalDate.now());
    }

    public static void answeringBeforeAlexis(String question) {
        if (question.toLowerCase().contains("alexis")) {
            System.out.println("I'm sorry, I can't answer that question.");
        } else {
            System.out.println("Sure! Here's your answer.");
        }
    }

    // NINJA BONUS: Implement your own method here
    public static void customMethod() {
        System.out.println("I'm a ninja! I can do this!");
    }
}
