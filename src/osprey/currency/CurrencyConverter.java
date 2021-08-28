package osprey.currency;

import java.awt.*;
import java.net.URL;

public abstract class CurrencyConverter {

    public static void openConverter() {
        try {
            System.out.println("Starting servers... ");
            Thread.sleep(2000);
            System.out.println("Getting Resources... ");
            Thread.sleep(1600);
            System.out.println("Synchronizing databases... ");
            Thread.sleep(1200);
            System.out.println("Linking... ");
            Thread.sleep(1000);
            System.out.println("Connected... ");
            Desktop.getDesktop().browse(new URL("https://www.xe.com").toURI());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
