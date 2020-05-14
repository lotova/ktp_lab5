package ktp_lab5;

import java.awt.geom.Rectangle2D;
import java.awt.geom.Rectangle2D.Double;

public class Mandelbrot   extends FractalGenerator {
	/**Константа с максимальным количеством итераций **/
	public static final int MAX_ITERATIONS = 2000;	
	private Complex z = new Complex(0, 0);
	private Complex c = new Complex(0, 0);
	private class Complex {
	    private double real, imag;
	    private Complex(double real, double imag) {
	        this.real = real;
	        this.imag = imag;
	    }
	    private double abs() { return real * real + imag * imag; }
	    
	    private Complex sum(Complex c) {
	        return new Complex(this.real + c.real, this.imag + c.imag);
	    }
	    
	    private Complex times(Complex c) {
	        double real = this.real * c.real - this.imag * c.imag;
	        double imag = this.real * c.imag + this.imag * c.real;
	        return new Complex(real,imag);
	    }
	}
	/**Метод numIterations(double, double) реализует итеративную функцию для фрактала Мандельброта **/
	public int numIterations(double x, double y) {
		   z.real = 0; z.imag = 0; c.real = x; c.imag = y;
	       for (int IterNum = 0; IterNum < MAX_ITERATIONS; IterNum++) {
	           z = z.times(z).sum(c);
	           if (z.abs() > 4) return IterNum;
	       }
	       return -1;
	}
	/**метод должен установить начальный диапазон в (-2 - 1.5i) - (1 + 1.5i)**/

	public void getInitialRange(Rectangle2D.Double range) {
	    range.setRect(-2, -1.5, 3,3);
	}
	@Override
    public String toString() {
        return "Mandelbrot";
	}
}
