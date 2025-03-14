package DataOnly;

import java.io.Serializable;

public class Digital implements Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public Digital clone() throws CloneNotSupportedException {
		return (Digital) super.clone();
	}

	public Integer DigitalPlace = 0;

	public Digital(Integer digitalPlace) {
		DigitalPlace = digitalPlace;
	}

	public String toString() {
		return "DigitalPlace = (" + DigitalPlace + ")";
	}
};
