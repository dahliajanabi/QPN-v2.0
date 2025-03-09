package DataOnly;

import java.io.Serializable;

public class ComplexValue implements Cloneable, Serializable {

	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public ComplexValue clone() throws CloneNotSupportedException {
		return (ComplexValue) super.clone();
	}

	public Float Real;
	public Float Imaginary;

	public ComplexValue(Float real, Float imaginary) {
		this.Real = real;
		this.Imaginary = imaginary;
	}

	public String toString(boolean PrintImaginary) {
		if (Real == 0) {
			Real = Math.abs(Real);
		}
		if (Imaginary == 0) {
			Imaginary = Math.abs(Imaginary);
		}
		if (PrintImaginary) {
			return Real + " + i " + Imaginary;
		} else {
			return Real.toString();
		}
	}

	public ComplexValue Prod(ComplexValue v) {
		return new ComplexValue((Real * v.Real) - (Imaginary * v.Imaginary),
				(Real * v.Imaginary) + (Imaginary * v.Real));
	}
}
