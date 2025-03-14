package Components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import DataObjects.DataUnitaryMatrix;
import DataObjects.DataUnitaryThetaMatrix;
import DataObjects.DataPsivector;
import DataObjects.DataTheta;
import DataOnly.UnitaryMatrix;
import DataOnly.ComplexValue;
import DataOnly.Psivector;
import DataOnly.Theta;
import DataObjects.DataTransfer;
import Enumerations.Orientation;
import Enumerations.TransitionOperation;
import Enumerations.UnitaryThetaMatrixValueFuncType;
import Interfaces.PetriObject;
import Utilities.Functions;
import java.lang.Math;

public class Activation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetriTransition Parent;
	float Ro = (float) (1 / Math.sqrt(2));

	public String InputPlaceName;

	public String InputPlaceName1;
	public String InputPlaceName2;
	public ArrayList<String> InputPlaceNames;
	public String OutputPlaceName;
	public ArrayList<String> OutputPlaceNames;
	public TransitionOperation Operation;
	public Functions util;
	public String ConstantValueName1;
	public String ConstantValueName2;

	public Activation(PetriTransition Parent) {
		util = new Functions();
	}

	public Activation(PetriTransition Parent, TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, String ConstantValueName,
			TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.ConstantValueName1 = ConstantValueName;
	}

	public Activation(PetriTransition Parent, String InputPlaceName1, String InputPlaceName2, String ConstantValueName,
			TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName1 = InputPlaceName1;
		this.InputPlaceName2 = InputPlaceName2;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.ConstantValueName1 = ConstantValueName;
	}

	public Activation(PetriTransition Parent, String InputPlaceName1, String InputPlaceName2, String ConstantValueName1,
			String ConstantValueName2, TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName1 = InputPlaceName1;
		this.InputPlaceName2 = InputPlaceName2;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.ConstantValueName1 = ConstantValueName1;
		this.ConstantValueName2 = ConstantValueName2;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, ArrayList<String> InputPlaceNames, TransitionOperation Condition,
			String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceNames = InputPlaceNames;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			ArrayList<String> OutputPlaceNames) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceNames = OutputPlaceNames;
		this.Operation = Condition;
	}

	public void Activate() throws CloneNotSupportedException {

		if (Operation == TransitionOperation.Move)
			Move();

		if (Operation == TransitionOperation.UnitaryMatrix)
			UnitaryMatrix(0);

		if (Operation == TransitionOperation.ThetaUnitaryMatrix)
			ThetaUnitaryMatrix();

		if (Operation == TransitionOperation.UnitaryMatrixJoin2by1)
			UnitaryMatrixJoin2by1();

		if (Operation == TransitionOperation.SendOverNetwork)
			SendOverNetwork();

		if (Operation == TransitionOperation.StopPetriNet)
			Parent.Parent.Stop();

		if (Operation == TransitionOperation.MakeNull)
			MakeNull();
	}

	private void Move() throws CloneNotSupportedException {

		PetriObject temp = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (temp == null) {
			temp = util.GetFromListByName(InputPlaceName, Parent.Parent.ConstantPlaceList);
		}
		PetriObject result = null;

		if (temp instanceof DataUnitaryMatrix) {
			result = (PetriObject) ((DataUnitaryMatrix) temp).clone();
		}

		if (temp instanceof DataPsivector) {
			result = (PetriObject) ((DataPsivector) temp).clone();
		}

		if (result == null) {
			return;
		}

		if (OutputPlaceName.contains("-")) {
			result.SetName(OutputPlaceName.split("-")[1]);
		} else {
			result.SetName(OutputPlaceName);
		}

		result.SetValue(temp.GetValue());

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void UnitaryMatrix(int orientation) throws CloneNotSupportedException {

		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataPsivector)) {
			return;
		}

		PetriObject constantValue = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue == null && !(constantValue instanceof DataUnitaryMatrix)) {
			return;
		}
		DataUnitaryMatrix A = (DataUnitaryMatrix) constantValue;
		DataPsivector result = (DataPsivector) ((DataPsivector) input).clone();
		Psivector resC = (Psivector) result.GetValue();
		Psivector resD = new Psivector(resC.Size, resC.ComplexArray);

		for (int i = 0; i < A.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < A.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = A.Value.Matrix[i][j] * cv1.Real;
				Float imaginary = A.Value.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}
		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void ThetaUnitaryMatrix() throws CloneNotSupportedException {

		PetriObject input = util.GetFromListByName(InputPlaceName1, Parent.TempMarking);
		if (input == null && !(input instanceof DataPsivector)) {
			return;
		}

		PetriObject input2 = util.GetFromListByName(InputPlaceName2, Parent.Parent.ConstantPlaceList);
		if (input2 == null && !(input2 instanceof DataTheta)) {
			return;
		}

		PetriObject constantValue = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue == null && !(constantValue instanceof DataUnitaryMatrix)) {
			return;
		}

		DataUnitaryThetaMatrix A = (DataUnitaryThetaMatrix) constantValue;

		for (int i = 0; i < A.Value.Matrix[0].length; i++)
			for (int j = 0; j < A.Value.Matrix[1].length; j++) {

				if( A.Value.Matrix[i][j].Func!= UnitaryThetaMatrixValueFuncType.ConstantValue)
				{
					switch (A.Value.Matrix[i][j].Func) {
					case  Cos:
						A.Value.Matrix[i][j].Value= (float) Math.cos(((Theta)input2.GetValue()).Angle);
						break;
					case  Sin:
						A.Value.Matrix[i][j].Value= (float) Math.sin(((Theta)input2.GetValue()).Angle);
						break;
					case  Tan:
						A.Value.Matrix[i][j].Value= (float) Math.tan(((Theta)input2.GetValue()).Angle);
						break;
					case  MinusCos:
						A.Value.Matrix[i][j].Value=(float) - Math.cos(((Theta)input2.GetValue()).Angle);
						break;
					case  MinusSin:
						A.Value.Matrix[i][j].Value=(float) - Math.sin(((Theta)input2.GetValue()).Angle);
						break;
					case  MinusTan:
						A.Value.Matrix[i][j].Value = (float) -Math.tan(((Theta) input2.GetValue()).Angle);
						break;
					default:
						break;
					}
				}
			}

		DataPsivector result = (DataPsivector) ((DataPsivector) input).clone();
		Psivector resC = (Psivector) result.GetValue();
		Psivector resD = new Psivector(resC.Size, resC.ComplexArray);

		for (int i = 0; i < A.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < A.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = A.Value.Matrix[i][j].Value * cv1.Real;
				Float imaginary = A.Value.Matrix[i][j].Value * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}
		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void UnitaryMatrixJoin2by1() throws CloneNotSupportedException {

		PetriObject input1 = util.GetFromListByName(InputPlaceName1, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataPsivector)) {
			return;
		}

		PetriObject input2 = util.GetFromListByName(InputPlaceName2, Parent.TempMarking);
		if (input2 == null && !(input2 instanceof DataPsivector)) {
			return;
		}

		PetriObject constantValue = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue == null && !(constantValue instanceof DataUnitaryMatrix)) {
			return;
		}

		DataUnitaryMatrix A = (DataUnitaryMatrix) constantValue;
		DataPsivector result = (DataPsivector) ((DataPsivector) input1).clone();
		Psivector resC = (Psivector) result.GetValue();
		resC.ComplexArray.addAll(((DataPsivector) input2).Value.ComplexArray);
		Psivector resD = new Psivector(resC.Size * 2, resC.ComplexArray);

		for (int i = 0; i < A.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < A.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.ComplexArray.get(j);
				Float real = A.Value.Matrix[i][j] * cv1.Real;
				Float imaginary = A.Value.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.ComplexArray.set(i, sum);
		}

		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void MakeNull() throws CloneNotSupportedException {
		PetriObject temp = util.GetFromListByName(OutputPlaceName, Parent.Parent.PlaceList);
		if (temp == null) {
			util.SetNullToListByName(OutputPlaceName, Parent.Parent.ConstantPlaceList);
		} else {
			util.SetNullToListByName(OutputPlaceName, Parent.Parent.PlaceList);
		}
	}

	private void SendOverNetwork() throws CloneNotSupportedException {
		PetriObject output = util.GetPetriObjectByName(OutputPlaceName, Parent.Parent.PlaceList);

		PetriObject temp;
		Integer inputIndex = util.GetIndexByName(InputPlaceName, Parent.TempMarking);
		if (inputIndex == -1) {
			temp = util.GetFromListByName(InputPlaceName, Parent.Parent.ConstantPlaceList);
		} else {
			temp = Parent.TempMarking.get(inputIndex);
		}

		if (temp == null) {
			return;
		}
		PetriObject result = null;
		if (output instanceof DataTransfer) {
			result = (PetriObject) ((DataTransfer) output).clone();
		}

		if (temp instanceof DataPsivector) {
			result.SetValue((PetriObject) ((DataPsivector) temp).clone());
		}
	}

}
