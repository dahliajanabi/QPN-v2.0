package DataOnly;

import java.io.Serializable;

import Enumerations.QplacePrintSetting;

public class Qplace implements Cloneable, Serializable {
	private static final long serialVersionUID = 1L;

	// Overriding clone() method of Object class
	public Qplace clone() throws CloneNotSupportedException {
		return (Qplace) super.clone();
	}

	public Psivector Psi;
	public Vvector V;
	public QplacePrintSetting PrintingSetting;

	public Qplace(Psivector Psi, QplacePrintSetting PrintingSetting) {
		this.Psi = Psi;
		this.PrintingSetting = PrintingSetting;
	}

	public Qplace(Vvector V, QplacePrintSetting PrintingSetting) {
		this.V = V;
		this.Psi = this.V.GetPsi();
		this.PrintingSetting = PrintingSetting;
	}
	
	public Qplace(Psivector Psi, Vvector V, QplacePrintSetting PrintingSetting) {
		this.V = V;
		this.Psi = Psi;
		this.PrintingSetting = PrintingSetting;
	}
	
	public String toString() {
		switch (PrintingSetting) {
		case Both:
			//return "V:" + V.toString(true);
			return "Psi:" + Psi.toString(true) + ", V:" + V.toString(true);	
		case PsiOnly:
			return "Psi:" + Psi.toString(true);
		case VOnly:
			return "V:" + V.toString(true);
		}
		return "";
	}
}
