//207199282_322530080
import java.awt.*;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
public class Ex2_1 {
    /**
     * this function get an array of Points, and return an Array with all the maximum Points.
     * @param points
     * @return maximum points
     */
    public static ArrayList<Point> maxima(Point[] points) {
        ArrayList<Point> ans = new ArrayList<>(); //create a new array
        Comparator<Point> comp = Comparator.comparing(Point::x); //create a comparator
        Arrays.sort(points, comp); //sort the array according to x value
        double currentXMaxY = Double.MIN_VALUE; // the maximum y value of the points with the same x value
        double currentX = points[points.length - 1].x();//the x value of the current point
        double maxY = points[points.length - 1].y();//the max y value of all the Points
        for (int i = points.length - 1; i >= 0; i--) { // go over all the points from the last to the first
            if (points[i].x() != currentX) {//check if the x is the same value as the current point
                currentX = points[i].x();
                currentXMaxY = maxY;
            }
            if (points[i].y() > currentXMaxY) {//check if the y value greater than the current x max y
                ans.add(points[i]);
            }
            if (points[i].y() > maxY) {// check if the y value grater than the max value until now
                maxY = points[i].y();
            }
        }
        return ans;
    }
    /**
     * test:
     */
    public static void main(String[] args) {
        Point p1 = new Point(7, 2);
        Point p2 = new Point(1, 4);
        Point p3 = new Point(2, 6);
        Point p4 = new Point(3, 1);
        Point p5 = new Point(5, 7);
        Point p6 = new Point(8, 6);
        Point p7 = new Point(9, 3);
        Point p8 = new Point(6, 9);
        Point p9 = new Point(4, 5);
        Point[] a = {p1, p2, p3, p4, p5, p6, p7, p8, p9};
        System.out.println(maxima(a));

        Point p12 = new Point(7, 2);
        Point p22 = new Point(1, 4);
        Point p32 = new Point(2, 6);
        Point p42 = new Point(3, 1);
        Point p52 = new Point(5, 7);
        Point p62 = new Point(8, 6);
        Point p72 = new Point(9, 3);
        Point p82 = new Point(6, 9);
        Point p92 = new Point(4, 5);
        Point p102= new Point(6,8);
        Point p112= new Point(6,2);
        Point p122= new Point(0,0);
        Point p132= new Point(9,4);
        Point[] b = {p12, p22, p32, p42, p52, p62, p72, p82, p92,p102,p112,p122,p132};
        System.out.println(maxima(b));

        Point p13 = new Point(7, 2);
        Point p23 = new Point(1, 4);
        Point p33 = new Point(2, 6);
        Point p43 = new Point(3, 1);
        Point p53 = new Point(5, 7);
        Point p63 = new Point(8, 6);
        Point p73 = new Point(9, 4);
        Point p83 = new Point(6, 8);
        Point p93 = new Point(4, 5);
        Point p103= new Point(6,2);
        Point p113= new Point(6,9);
        Point p123= new Point(0,0);
        Point p133= new Point(9,3);
        Point[] c = {p13, p23, p33, p43, p53, p63, p73, p83, p93,p103,p113,p123,p133};
        System.out.println(maxima(c));
    }

    //Points class
    record Point(double x, double y) {
        public String toString () {
            return " [" + this.x + "," + this.y + "]";
        }

        public boolean equals (Point p){
            return p.x == this.x && p.y == this.y;
        }
    }
}

