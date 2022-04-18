package osprey.geometry.geo2D.shapes.calc;

/**
 * Automatic Generation Project - Author
 * Project Name: mathosp
 * Author: ARCHISMAN NATH on 4/17/2022 in 9:57 PM
 */
public final class ShapeIdentity {

    private ShapeIdentity() {}

    public static String typeOfQuadrilateral(double SideOne, double SideTwo, double SideThree, double SideFour){
        if(SideOne < 0 || SideTwo < 0 || SideThree < 0 || SideFour < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        } else {
            if((SideOne == SideTwo) && (SideTwo == SideThree) && (SideThree == SideFour)){
                return "This is a Square";
            }else if((SideOne == SideThree) && (SideTwo == SideFour) && (SideThree !=  SideTwo)){
                return "This is a Rectangle";
            }else if((SideOne == SideTwo) && (SideThree == SideFour) && (SideFour !=  SideTwo)){
                return "This is a Rectangle";
            }else if((SideOne == SideFour) && (SideTwo == SideThree) && (SideFour !=  SideTwo)){
                return "This is a Rectangle";
            }else{
                return "This is a general quadrilateral";
            }
        }

    }

    public static String typeOfTriangle(double SideOne, double SideTwo, double SideThree) {
        if(SideOne < 0 || SideTwo < 0 || SideThree < 0) {
            throw new IllegalArgumentException("Values cannot be negative");
        } else {
            if(SideOne == SideTwo && SideOne == SideThree) {
                return"Your Triangle is an Equilateral Triangle";
            } else if((SideOne == SideTwo) || (SideOne == SideThree) || (SideTwo == SideThree)) {
                return"Your Triangle is an Isosceles Triangle";
            } else {
                return"Your triangle is a Scalene Triangle";
            }
        }
    }
}
