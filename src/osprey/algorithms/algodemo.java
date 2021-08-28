package osprey.algorithms;

public class algodemo {

    public static void main(String[] args) {
        double[] myAlgoArray = {2, 3, 5, 6, 18, 8, 4, 1, 0};

        double searchElement = OspreyAlgorithms.linearSearch(myAlgoArray, 8, false);

        System.out.println(searchElement);

    }
}
