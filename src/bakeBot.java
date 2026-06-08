import java.util.Scanner;

public class bakeBot {

    public static String respond(String userInput) {
        userInput = userInput.toLowerCase();

        if (userInput.contains("cookie")) {
            return "To make cookies, you will need flour, sugar, butter, and chocolate chips.\n Baking tip: Chill the dough for 30 minutes before baking for thicker cookies.";
        }
        else if (userInput.contains("cake")) {
            return "To make a cake, you will need flour, sugar, eggs, butter, and baking powder.\n Baking tip: Chill the cake before frosting.";
        }
        else if (userInput.contains("bread")) {
            return "To make bread, you will need flour, yeast, water, and salt.\n Baking tip: Let the dough rise in a warm place for the best texture.";
        }
        else if (userInput.contains("brownie")) {
            return "To make brownie, you will need cocoa powder, oil, eggs, water, vanilla extract and powdered sugar.\n Baking tip: Do not overbake because brownies should still be slightly soft in the center.";
        }
        else if (userInput.contains("pie")) {
            return "To make a pie, you will need a pie crust and your favorite filling.\n Baking tip: Chill the pie crust before baking to help it stay flaky.";
        }
        else {
            return "I can help with cookies, cakes, bread, and pies.";
        }
    }

    public static String getInstructions(String instruction) {
        instruction = instruction.toLowerCase();
        if (instruction.contains("cookies")) {
            return "how to";
        }
        else if (instruction.contains("cake")) {
            return "how";
        }
        else if (instruction.contains("bread")) {
            return "how";
        }
        else if (instruction.contains("brownie")) {
            return "how";
        }
        else if (instruction.contains("pie")) {
            return "how";
        }
        return "No instructions aviable";
    }

    public static void main(String[] args) {

        Scanner keyboard = new Scanner(System.in);

        System.out.println("Welcome to BakeBot!");
        System.out.println("Ask me about a baked good.");

        System.out.print("Choice of baking recipe: ");
        String question = keyboard.nextLine();

        String answer = respond(question);

        System.out.println();
        System.out.println("BakeBot: " + answer);

        System.out.println("\nWould you like recipe instructions?");
        System.out.println("1. Yes");
        System.out.println("2. No");
        System.out.print("Select an option: ");

        int choice = keyboard.nextInt();

        if (choice == 1) {
            System.out.println("\nRecipe Instructions:");
            System.out.println(getInstructions(question));
        }

        keyboard.close();
    }
}
