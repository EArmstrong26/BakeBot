import java.util.Scanner;

public class bakeBot {

    public static String respond(String userInput) {
        userInput = userInput.toLowerCase();

        if (userInput.contains("cookie")) {
            return "To make cookies, you will need flour, sugar, butter, and chocolate chips.";
        }
        else if (userInput.contains("cake")) {
            return "To make a cake, you will need flour, sugar, eggs, butter, and baking powder.";
        }
        else if (userInput.contains("bread")) {
            return "To make bread, you will need flour, yeast, water, and salt.";
        }
        else if (userInput.contains("pie")) {
            return "To make a pie, you will need a pie crust and your favorite filling.";
        }
        else {
            return "I can help with cookies, cakes, bread, and pies.";
        }
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to BakeAgent!");
        System.out.println("Ask me about a baked good.");

        System.out.print("You: ");
        String question = keyboard.nextLine();

        String answer = respond(question);

        System.out.println();
        System.out.println("BakeAgent: " + answer);

        keyboard.close();
    }
}
