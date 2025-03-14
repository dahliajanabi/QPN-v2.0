package DataOnly;

import Enumerations.UnitaryThetaMatrixValueFuncType;

public class UnitaryThetaMatrixValue {

	public Float Value;
	public UnitaryThetaMatrixValueFuncType Func;

	public UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType func, Float val) {
		Func = func;
		Value = val;
	}
	
	public UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType func) {
		Func = func;
	}
}
