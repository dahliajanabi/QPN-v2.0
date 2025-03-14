package DataObjects;

import java.io.Serializable;
import java.util.ArrayList;

import DataOnly.ComplexValue;
import DataOnly.Psivector;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;

public class DataPsivector implements Interfaces.PetriObject, Cloneable, Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Override
	public void Execute() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Start() {
		// TODO Auto-generated method stub

	}

	@Override
	public void Stop() {
		// TODO Auto-generated method stub

	}

	@Override
	public PetriObjectType GetType() {
		return PetriObjectType.DataPsivector;
	}

	public Psivector Value;

	@Override
	public Object GetValue() {
		return Value;
	}

	@Override
	public void SetValue(Object value) {
		if (value == null) {
			Value = null;
			SetToken(false);
		}
		if (value instanceof Psivector) {
			Value = (Psivector) value;
			SetToken(true);
		}
	}

	// Overriding clone() method of Object class
	public PetriObject clone() throws CloneNotSupportedException {
		DataPsivector result = new DataPsivector();
		result.SetName(name);
		
		ArrayList<ComplexValue> ComplexArray = new ArrayList<ComplexValue>();
		for (ComplexValue c : Value.ComplexArray) {
			ComplexArray.add(new ComplexValue(c.Real,c.Imaginary));
		}
		Psivector cv = new Psivector(Value.Size,
				ComplexArray);
		result.SetValue(cv);
		return result;
		//return (DataComplexVector) super.clone();
	}

	public boolean Printable = true;

	@Override
	public boolean IsPrintable() {
		return Printable;
	}

	public String toString() {
		if (Value != null) {
			return GetName() + "|" +"["+ Value.toString() +"]"+ "|";
		} else {
			return GetName() + "(Null)";
		}
	}

	private String name = "";

	@Override
	public String GetName() {
		return name;
	}

	@Override
	public void SetName(String name) {
		this.name = name;
	}

	@Override
	public void AddElement(Object value) {

	}

	private boolean token;

	@Override
	public void SetToken(boolean token) {
		this.token = token;
	}

	@Override
	public boolean GetToken() {
		return this.token;
	}

	@Override
	public String ToStringWithParam(boolean b) {
		if (Value != null) {
			return GetName() + "|" +"["+ Value.toString(b) +"]"+ "|";
		} else {
			return GetName() + "(Null)";
		}
	}
}
