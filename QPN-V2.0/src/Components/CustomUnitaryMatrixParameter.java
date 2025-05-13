package Components;

import java.util.ArrayList;

import Enumerations.TransitionOperation;

public class CustomUnitaryMatrixParameter {
	public PetriTransition Parent;
	public ArrayList<UnitaryMatrixParameter> UnitaryMatrixParameters;
	public ArrayList<String> ConstantValues;
	public TransitionOperation Condition;
	public String OutputPlaceName;
}
