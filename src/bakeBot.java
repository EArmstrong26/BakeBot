import java.io.IOException;
import java.io.OutputStream;
import java.net.InetSocketAddress;
import java.net.URLDecoder;
import java.nio.charset.StandardCharsets;
import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.HttpExchange;

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
            return "To make a pie, you will need a pie crust and your favorite filling. Eggs, water, sugar, and vanilla extract.\n Baking tip: Chill the pie crust before baking to help it stay flaky.";
        }
        else if (userInput.contains("gluten-free")) {
            return "To make a gluten-free fudge cake, you will need eggs, cocoa powder, sugar, oil, water, and vanilla extract.\n Baking tip: ";
        }
        else {
            return "I can help with cookies, cakes, bread, and pies.";
        }
    }

    public static String getInstructions(String instruction) {
        instruction = instruction.toLowerCase();

        if (instruction.contains("cookies")) {
            return "Instructions\n" +
                    "Preheat your oven to 350°F (175°C).\n" +
                    "In a bowl, mix the butter and sugar until smooth.\n" +
                    "Stir in the flour until a dough forms.\n" +
                    "Fold in the chocolate chips.\n" +
                    "Roll the dough into small balls (about 1 tablespoon each) and place them on a baking sheet.\n" +
                    "Flatten each ball slightly with your hand or a fork.\n" +
                    "Bake for 12–15 minutes, or until the edges are lightly golden.\n" +
                    "Let the cookies cool on the baking sheet for 5 minutes, then transfer to a wire rack.";
        }
        else if (instruction.contains("cake")) {
            return "Preheat the oven to 350°F (175°C).\n" +
                    "Grease a small cake pan or loaf pan.\n" +
                    "In a bowl, whisk together the eggs, oil, water, and vanilla.\n" +
                    "Add the powdered sugar and mix until smooth.\n" +
                    "Stir in the flour, cocoa powder, and baking powder until just combined.\n" +
                    "Pour the batter into the pan.\n" +
                    "Bake for 25–30 minutes, or until a toothpick inserted in the center comes out clean.\n" +
                    "Let the cake cool for 10–15 minutes before removing it from the pan.";
        }
        else if (instruction.contains("bread")) {
            return "Instructions\n" +
                    "Mix the warm water and yeast in a large bowl. Let sit for 5–10 minutes until foamy.\n" +
                    "Stir in the salt and flour until a shaggy dough forms.\n" +
                    "Knead the dough on a floured surface for about 8–10 minutes, until smooth and elastic.\n" +
                    "Place the dough in a lightly oiled bowl, cover, and let rise for about 1 hour, or until doubled in size.\n" +
                    "Punch down the dough and shape it into a loaf or round ball.\n" +
                    "Place on a baking sheet or in a loaf pan, cover, and let rise again for 30–45 minutes.\n" +
                    "Preheat the oven to 425°F (220°C).\n" +
                    "Bake for 25–30 minutes, until golden brown and the loaf sounds hollow when tapped on the bottom.\n" +
                    "Let cool before slicing.";
        }
        else if (instruction.contains("brownie")) {
            return "Preheat oven to 350°F (175°C).\n" +
                    "Lightly grease a small baking dish or loaf pan.\n" +
                    "In a bowl, whisk together the eggs, oil, vanilla, and water.\n" +
                    "Add the powdered sugar and cocoa powder. Stir until smooth and well combined.\n" +
                    "Pour the batter into the prepared pan and spread evenly.\n" +
                    "Bake for 18–22 minutes, until the top looks set and a toothpick inserted near the center comes out with a few moist crumbs.\n" +
                    "Let cool for at least 15 minutes before slicing.";
        }
        else if (instruction.contains("pie")) {
            return "Instructions\n" +
                    "\n" +
                    "Preheat oven to 375°F (190°C).\n" +
                    "Place the pie crust in a pie dish.\n" +
                    "In a bowl, whisk together the eggs, powdered sugar, water, and vanilla until smooth.\n" +
                    "Pour the mixture into the pie crust.\n" +
                    "Bake for 30–35 minutes, until the center is mostly set.\n" +
                    "Let cool before slicing.";
        }
        else if (instruction.contains("gluten-free")) {
            return "Instructions\n" +
                    "\n" +
                    "Preheat the oven to 350°F (175°C).\n" +
                    "Grease a small baking dish or line it with parchment paper.\n" +
                    "In a bowl, whisk the eggs until combined.\n" +
                    "Add the oil, water, vanilla, and powdered sugar. Mix until smooth.\n" +
                    "Stir in the cocoa powder until no lumps remain.\n" +
                    "Pour the batter into the prepared dish.\n" +
                    "Bake for 18–22 minutes, until the edges are set and the center is slightly soft.\n" +
                    "Let cool for at least 15 minutes before serving.";
        }

        return "No instructions available";
    }

    public static void main(String[] args) throws IOException {

        HttpServer server = HttpServer.create(new InetSocketAddress(8000), 0);

        server.createContext("/", (HttpExchange exchange) -> {

            String question = "";
            String answer = "";
            String instructions = "";

            String query = exchange.getRequestURI().getQuery();

            if (query != null) {
                if (query.contains("recipe=")) {
                    question = query.replace("recipe=", "");
                    question = URLDecoder.decode(question, StandardCharsets.UTF_8);

                    answer = respond(question);
                    instructions = getInstructions(question);
                }
            }

            String page = "<html>" +
                    "<head>" +
                    "<title>BakeBot</title>" +

                    "<style>" +
                    "body { background-color: lightyellow; font-family: Arial; }" +
                    "h1 { color: brown; }" +
                    ".box { background-color: white; padding: 20px; margin: 40px; border: 2px solid brown; }" +
                    "input { width: 300px; padding: 8px; }" +
                    "button { padding: 8px; background-color: brown; color: white; }" +
                    "pre { background-color: #eeeeee; padding: 10px; white-space: pre-wrap; }" +
                    "</style>" +

                    "</head>" +
                    "<body>" +

                    "<div class='box'>" +
                    "<h1>Welcome to BakeBot!</h1>" +
                    "<p>Ask me about a baked good.</p>" +

                    "<form method='get'>" +
                    "<p>Choice of baking recipe:</p>" +
                    "<input type='text' name='recipe' value='" + question + "'>" +
                    "<button type='submit'>Submit</button>" +
                    "</form>" +

                    "<h2>BakeBot:</h2>" +
                    "<pre>" + answer + "</pre>" +

                    "<h2>Recipe Instructions:</h2>" +
                    "<pre>" + instructions + "</pre>" +

                    "</div>" +

                    "</body>" +
                    "</html>";

            exchange.sendResponseHeaders(200, page.getBytes().length);

            OutputStream output = exchange.getResponseBody();
            output.write(page.getBytes());
            output.close();
        });

        server.start();

        System.out.println("Welcome to BakeBot!");
        System.out.println("Go to http://localhost:8000");
    }
}