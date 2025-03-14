package DataOnly;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

public class Vvector implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public Vvector clone() throws CloneNotSupportedException {
		return (Vvector) super.clone();
	}

	public ArrayList<QBit> QBits = new ArrayList<QBit>();
	public Integer Size = 2;

	public Vvector(Integer size, QBit... qBits) {
		Size = size;
		for (QBit q : qBits) {
			QBits.add(q);
		}
	}

	public Vvector(Integer size, ArrayList<QBit> qBits) {
		Size = size;
		for (QBit q : qBits) {
			QBits.add(q);
		}
	}

	public String toString(boolean PrintImaginary) {
		ArrayList<String> temp1 = new ArrayList<String>();
		for (QBit c : QBits) {
			if (c == null)
				temp1.add("NULL");
			else
				temp1.add(c.toString(PrintImaginary));
		}

		return "(" + String.join(",", temp1) + ")";
	}

	public Psivector GetPsi() {
		ArrayList<ComplexValue> accumilitiveProd = new ArrayList<ComplexValue>();
		accumilitiveProd.add(QBits.get(0).Alpha);
		accumilitiveProd.add(QBits.get(0).Beta);

		for (int i = 1; i < QBits.size(); i++) {
			ArrayList<ComplexValue> temp = new ArrayList<ComplexValue>();
			for (int x = 0; x < accumilitiveProd.size(); x++) {
				temp.add(QBits.get(i).Alpha.Prod(accumilitiveProd.get(x)));
			}
			for (int x = 0; x < accumilitiveProd.size(); x++) {
				temp.add(QBits.get(i).Beta.Prod(accumilitiveProd.get(x)));
			}
			accumilitiveProd = temp;
		}
		double sz = Math.pow(2f, (double) QBits.size());
		return new Psivector((int) sz, accumilitiveProd);
	}
};
