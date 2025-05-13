package DataOnly;

import java.util.ArrayList;

import Enumerations.UnitaryThetaMatrixValueFuncType;

public class UnitaryThetaMatrixValue {

	public Float Value;
	public UnitaryThetaMatrixValueFuncType Func;
	public String ThetaPlaceName;

	public UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType func, Float val) {
		Func = func;
		Value = val;
	}

	public UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType func, String thetaPlaceName) {
		Func = func;
		ThetaPlaceName = thetaPlaceName;
	}

	public String toString() {
		return "{" + ThetaPlaceName + " " + Func + " " + Value + "}";
	}
}
