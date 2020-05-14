package ktp_lab5;
import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;


public class Tricorn  extends FractalGenerator {
	/**Константа с максимальным количеством итераций **/
	public static final int MAX_ITERATIONS = 2000;	
	private Complex z = new Complex(0, 0);
	private Complex c = new Complex(0, 0);

	/**Метод numIterations(double, double) реализует итеративную функцию для фрактала Мандельброта **/
	public int numIterations(double x, double y) {
		   z.real = 0; z.imag = 0; c.real = x; c.imag = y;
	       for (int IterNum = 0; IterNum < MAX_ITERATIONS; IterNum++) {
	    	   z = z.sopr().times(z.sopr()).sum(c);
	           if (z.abs() > 4) return IterNum;
	       }
	       return -1;
	}
	/**метод должен установить начальный диапазон в (-2, - 2) - (2,2)**/

	public void getInitialRange(Rectangle2D.Double range) {
	    range.setRect(-2, -2, 4,4);
	}
	 @Override
	    public String toString() {
	        return "Tricorn";
	    }
}
