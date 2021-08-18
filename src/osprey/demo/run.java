package osprey.demo;

import osprey.base.NumberTheoryOperations;

import java.util.List;

public class run {
    public static void main(String[] args) {
        List<Long> factors = NumberTheoryOperations.factorize(20);
        System.out.println(factors);
    }
}
