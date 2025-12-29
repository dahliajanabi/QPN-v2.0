package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;

public class Psivector implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public Psivector clone() throws CloneNotSupportedException {
		return (Psivector) super.clone();
	}

	public ArrayList<ComplexValue> ComplexArray = new ArrayList<ComplexValue>();
	public Integer Size = 2;

	public Psivector(Integer size, ComplexValue... complexs) {
		Size = size;
		for (ComplexValue complexValue : complexs) {
			ComplexArray.add(complexValue);
		}
	}
	
	public Psivector(Integer size, ArrayList<ComplexValue> complexArray) {
		Size = size;
		for (ComplexValue complexValue : complexArray) {
			ComplexArray.add(complexValue);
		}
	}
	
	public Psivector(Psivector psivector) {
		this.ComplexArray = psivector.ComplexArray;
		this.Size = psivector.Size;
	}
	
	public Psivector(ArrayList<ComplexValue> ComplexArray) {
		this.ComplexArray = ComplexArray;
		this.Size = ComplexArray.size();
	}

	public String toString(boolean PrintImaginary) {
		ArrayList<String> temp1 = new ArrayList<String>();
		for (ComplexValue c : ComplexArray) {
			if (c == null)
				temp1.add("NULL");
			else
				temp1.add(c.toString(PrintImaginary));
		}

		return "(" + String.join(" , ", temp1) + ")";
	}
};
