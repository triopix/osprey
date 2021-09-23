package osprey.currency;

import java.awt.*;
import java.net.URL;

public abstract class CurrencyConverter {
    
    //didnt want to spend a whole lot of time with currency - so this just does some cool console animation and opens up a webpage! (With the most accurate uptodate currency converter)
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
