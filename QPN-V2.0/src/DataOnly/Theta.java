package DataOnly;

import java.io.Serializable;

public class Theta implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public Theta clone() throws CloneNotSupportedException {
		return (Theta) super.clone();
	}
	
	public Float Angle = 0.0f;
	public Theta(Float angle) {
		Angle= angle;
	}
	
	public String toString() {
		return "Angle = (" + Angle + ")";
	}
};
