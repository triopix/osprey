package osprey.geometry.geo2D.trig;

public class TrigDemo {

    public static void main(String[] args) {

        System.out.println(BaseTrigFunctions.sinRad(20));
        System.out.println(BaseTrigFunctions.sinDeg(20));
        System.out.println(BaseTrigFunctions.sinGrad(20));

        System.out.println("------------------------------------");

        System.out.println(BaseTrigFunctions.cosRad(20));
        System.out.println(BaseTrigFunctions.cosDeg(20));
        System.out.println(BaseTrigFunctions.cosGrad(20));

        System.out.println("------------------------------------");

        System.out.println(BaseTrigFunctions.tanRad(20));
        System.out.println(BaseTrigFunctions.tanDeg(20));
        System.out.println(BaseTrigFunctions.tanGrad(20));

        System.out.println("------------------------------------");

        System.out.println(BaseTrigFunctions.secRad(20));
        System.out.println(BaseTrigFunctions.secDeg(20));
        System.out.println(BaseTrigFunctions.secGrad(20));

        System.out.println("------------------------------------");

        System.out.println(BaseTrigFunctions.cscRad(20));
        System.out.println(BaseTrigFunctions.cscDeg(20));
        System.out.println(BaseTrigFunctions.cscGrad(20));

        System.out.println("------------------------------------");

        System.out.println(BaseTrigFunctions.cotRad(20));
        System.out.println(BaseTrigFunctions.cotDeg(20));
        System.out.println(BaseTrigFunctions.cotGrad(20));


        System.out.println("-------------------------------------");
        System.out.println(InverseTrigFunctions.arcSinRad(0.5)); //return the value in radians
        System.out.println(InverseTrigFunctions.arcSinDeg(0.5)); //return the value in degrees
        System.out.println(InverseTrigFunctions.arcSinGrad(0.5)); //return the value in gradians



    }
}
