package DataOnly;

import java.io.Serializable;

public class QBit implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public QBit clone() throws CloneNotSupportedException {
		return (QBit) super.clone();
	}

	public ComplexValue Alpha;
	public ComplexValue Beta;

	public QBit(ComplexValue alpha, ComplexValue beta) {
		this.Alpha = alpha;
		this.Beta = beta;
	}

	public String toString(boolean PrintImaginary) {
		return "Alpha:"+ Alpha.toString() +", Beta:"+Beta.toString();
	}
}
