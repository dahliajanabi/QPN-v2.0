package Components;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import DataObjects.DataUnitaryMatrix;
import DataObjects.DataUnitaryThetaMatrix;
import DataObjects.DataQplace;
import DataObjects.DataTheta;
import DataOnly.UnitaryMatrix;
import DataOnly.Vvector;
import DataOnly.ComplexValue;
import DataOnly.Qplace;
import DataOnly.Psivector;
import DataOnly.QBit;
import DataOnly.Theta;
import DataObjects.DataTransfer;
import Enumerations.QplacePrintSetting;
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
	public ArrayList<String> ConstantValues;
	public String OutputPlaceName;
	public ArrayList<String> OutputPlaceNames;
	public TransitionOperation Operation;
	public Functions util;
	public String ConstantValueName1;
	public String ConstantValueName2;
	public int QbitIndex = 0;

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

	public Activation(PetriTransition Parent, String InputPlaceName, int qbitIndex, TransitionOperation Condition,
			String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.QbitIndex = qbitIndex;
	}

	public Activation(PetriTransition Parent, ArrayList<String> InputPlaceNames, TransitionOperation Condition,
			String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceNames = InputPlaceNames;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, ArrayList<String> InputPlaceNames, ArrayList<String> ConstantValues,
			TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceNames = InputPlaceNames;
		this.ConstantValues = ConstantValues;
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

		if (Operation == TransitionOperation.UnitaryMatrix)
			UnitaryMatrix();

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

		if (Operation == TransitionOperation.UnitaryMatrixV)
			UnitaryMatrixV();

		if (Operation == TransitionOperation.ThetaUnitaryMatrixV)
			ThetaUnitaryMatrixV();

		if (Operation == TransitionOperation.SplitQbit)
			SplitQbit();

		if (Operation == TransitionOperation.Measurement)
			Measurement();
	}

	private void UnitaryMatrixV() throws CloneNotSupportedException {
		// extract qbits in an ordered list
		ArrayList<QBit> QBitCollection = new ArrayList<>();
		for (int i = 0; i < InputPlaceNames.size(); i++) {
			PetriObject input = util.GetFromListByName(InputPlaceNames.get(i), Parent.TempMarking);
			if (input == null && !(input instanceof DataQplace)) {
				continue;
			}
			QBitCollection.addAll(((DataQplace) input).Value.V.QBits);
		}
		// result qplace that collect all the qbits after the operation
		DataQplace result = new DataQplace();
		ArrayList<QBit> QBitResultCollection = new ArrayList<>();

		// perform operation with matrixes (product)
		for (int x = 0; x < QBitCollection.size(); x++) {

			PetriObject constantValue = util.GetFromListByName(ConstantValues.get(x), Parent.Parent.ConstantPlaceList);
			if (constantValue == null && !(constantValue instanceof DataUnitaryMatrix)) {
				throw new Error("Did not find the corresponding unitery matrix");
			}

			DataUnitaryMatrix A = (DataUnitaryMatrix) constantValue;

			// Qplace resD = new Qplace(new Vvector(1, ), resC.PrintingSetting);

			ArrayList<ComplexValue> sm = new ArrayList<ComplexValue>();
			for (int i = 0; i < A.Value.Matrix.length; i++) {
				ComplexValue sum = new ComplexValue(0.0F, 0.0F);
				ComplexValue cv1 = QBitCollection.get(x).Alpha;
				Float real = A.Value.Matrix[i][0] * cv1.Real;
				Float imaginary = A.Value.Matrix[i][0] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
				// -----------------------------------------------------------
				ComplexValue cv3 = QBitCollection.get(x).Beta;
				real = A.Value.Matrix[i][0] * cv3.Real;
				imaginary = A.Value.Matrix[i][0] * cv3.Imaginary;
				ComplexValue cv4 = new ComplexValue(real, imaginary);
				sum.Real += cv4.Real;
				sum.Imaginary += cv4.Imaginary;
				sm.add(sum);
				// resD.Psi.ComplexArray.set(i, sum);
			}
			QBitResultCollection.add(new QBit(sm.get(0), sm.get(1)));
		}

		result.SetName(OutputPlaceName);
		result.SetValue(
				new Qplace(new Vvector(QBitResultCollection.size(), QBitResultCollection), QplacePrintSetting.Both));
		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void ThetaUnitaryMatrixV() throws CloneNotSupportedException {
		// extract qbits in an ordered list
		ArrayList<QBit> QBitCollection = new ArrayList<>();
		for (int i = 0; i < InputPlaceNames.size(); i++) {
			PetriObject input = util.GetFromListByName(InputPlaceNames.get(i), Parent.TempMarking);
			if (input == null && !(input instanceof DataQplace)) {
				continue;
			}
			QBitCollection.addAll(((DataQplace) input).Value.V.QBits);
		}
		// result qplace that collect all the qbits after the operation
		DataQplace result = new DataQplace();
		ArrayList<QBit> QBitResultCollection = new ArrayList<>();

		// perform operation with matrixes (product)
		for (int x = 0; x < QBitCollection.size(); x++) {

			PetriObject constantValue = util.GetFromListByName(ConstantValues.get(x), Parent.Parent.ConstantPlaceList);
			if (constantValue == null && !(constantValue instanceof DataUnitaryThetaMatrix)) {
				throw new Error("Did not find the corresponding unitery matrix");
			}

			DataUnitaryThetaMatrix A = (DataUnitaryThetaMatrix) constantValue;

			for (int i = 0; i < A.Value.Matrix[0].length; i++)
				for (int j = 0; j < A.Value.Matrix[1].length; j++) {

					if (A.Value.Matrix[i][j].Func != UnitaryThetaMatrixValueFuncType.ConstantValue) {
						PetriObject input2 = util.GetFromListByName(A.Value.Matrix[i][j].ThetaPlaceName,
								Parent.Parent.ConstantPlaceList);
						if (input2 == null && !(input2 instanceof DataTheta)) {
							return;
						}
						switch (A.Value.Matrix[i][j].Func) {
						case Cos:
							A.Value.Matrix[i][j].Value = (float) Math.cos(((Theta) input2.GetValue()).Angle);
							break;
						case Sin:
							A.Value.Matrix[i][j].Value = (float) Math.sin(((Theta) input2.GetValue()).Angle);
							break;
						case Tan:
							A.Value.Matrix[i][j].Value = (float) Math.tan(((Theta) input2.GetValue()).Angle);
							break;
						case MinusCos:
							A.Value.Matrix[i][j].Value = (float) -Math.cos(((Theta) input2.GetValue()).Angle);
							break;
						case MinusSin:
							A.Value.Matrix[i][j].Value = (float) -Math.sin(((Theta) input2.GetValue()).Angle);
							break;
						case MinusTan:
							A.Value.Matrix[i][j].Value = (float) -Math.tan(((Theta) input2.GetValue()).Angle);
							break;
						default:
							break;
						}
					}
				}

			ArrayList<ComplexValue> sm = new ArrayList<ComplexValue>();
			for (int i = 0; i < A.Value.Matrix.length; i++) {
				ComplexValue sum = new ComplexValue(0.0F, 0.0F);
				ComplexValue cv1 = QBitCollection.get(x).Alpha;
				Float real = A.Value.Matrix[i][0].Value * cv1.Real;
				Float imaginary = A.Value.Matrix[i][0].Value * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
				// -----------------------------------------------------------
				ComplexValue cv3 = QBitCollection.get(x).Beta;
				real = A.Value.Matrix[i][0].Value * cv3.Real;
				imaginary = A.Value.Matrix[i][0].Value * cv3.Imaginary;
				ComplexValue cv4 = new ComplexValue(real, imaginary);
				sum.Real += cv4.Real;
				sum.Imaginary += cv4.Imaginary;
				sm.add(sum);
				// resD.Psi.ComplexArray.set(i, sum);
			}
			QBitResultCollection.add(new QBit(sm.get(0), sm.get(1)));
		}

		result.SetName(OutputPlaceName);
		result.SetValue(
				new Qplace(new Vvector(QBitResultCollection.size(), QBitResultCollection), QplacePrintSetting.Both));
		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void UnitaryMatrix() throws CloneNotSupportedException {

		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataQplace)) {
			return;
		}

		PetriObject constantValue = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue == null && !(constantValue instanceof DataUnitaryMatrix)) {
			return;
		}
		DataUnitaryMatrix A = (DataUnitaryMatrix) constantValue;
		DataQplace result = (DataQplace) ((DataQplace) input).clone();
		Qplace resC = (Qplace) result.GetValue();
		Qplace resD = new Qplace(new Psivector(resC.Psi.Size, resC.Psi.ComplexArray), resC.PrintingSetting);

		for (int i = 0; i < A.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < A.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.Psi.ComplexArray.get(j);
				Float real = A.Value.Matrix[i][j] * cv1.Real;
				Float imaginary = A.Value.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.Psi.ComplexArray.set(i, sum);
		}
		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void ThetaUnitaryMatrix() throws CloneNotSupportedException {

		PetriObject input = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input == null && !(input instanceof DataQplace)) {
			return;
		}

		PetriObject constantValue = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue == null && !(constantValue instanceof DataUnitaryThetaMatrix)) {
			return;
		}

		DataUnitaryThetaMatrix A = (DataUnitaryThetaMatrix) constantValue;

		for (int i = 0; i < A.Value.Matrix[0].length; i++)
			for (int j = 0; j < A.Value.Matrix[1].length; j++) {

				if (A.Value.Matrix[i][j].Func != UnitaryThetaMatrixValueFuncType.ConstantValue) {
					PetriObject input2 = util.GetFromListByName(A.Value.Matrix[i][j].ThetaPlaceName,
							Parent.Parent.ConstantPlaceList);
					if (input2 == null && !(input2 instanceof DataTheta)) {
						return;
					}
					switch (A.Value.Matrix[i][j].Func) {
					case Cos:
						A.Value.Matrix[i][j].Value = (float) Math.cos(((Theta) input2.GetValue()).Angle);
						break;
					case Sin:
						A.Value.Matrix[i][j].Value = (float) Math.sin(((Theta) input2.GetValue()).Angle);
						break;
					case Tan:
						A.Value.Matrix[i][j].Value = (float) Math.tan(((Theta) input2.GetValue()).Angle);
						break;
					case MinusCos:
						A.Value.Matrix[i][j].Value = (float) -Math.cos(((Theta) input2.GetValue()).Angle);
						break;
					case MinusSin:
						A.Value.Matrix[i][j].Value = (float) -Math.sin(((Theta) input2.GetValue()).Angle);
						break;
					case MinusTan:
						A.Value.Matrix[i][j].Value = (float) -Math.tan(((Theta) input2.GetValue()).Angle);
						break;
					default:
						break;
					}
				}
			}

		DataQplace result = (DataQplace) ((DataQplace) input).clone();
		Qplace resC = (Qplace) result.GetValue();
		Qplace resD = new Qplace(new Psivector(resC.Psi.Size, resC.Psi.ComplexArray), resC.PrintingSetting);

		for (int i = 0; i < A.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < A.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.Psi.ComplexArray.get(j);
				Float real = A.Value.Matrix[i][j].Value * cv1.Real;
				Float imaginary = A.Value.Matrix[i][j].Value * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.Psi.ComplexArray.set(i, sum);
		}
		result.SetName(OutputPlaceName);
		result.SetValue(resD);

		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void UnitaryMatrixJoin2by1() throws CloneNotSupportedException {

		PetriObject input1 = util.GetFromListByName(InputPlaceName1, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataQplace)) {
			return;
		}

		PetriObject input2 = util.GetFromListByName(InputPlaceName2, Parent.TempMarking);
		if (input2 == null && !(input2 instanceof DataQplace)) {
			return;
		}

		PetriObject constantValue = util.GetFromListByName(ConstantValueName1, Parent.Parent.ConstantPlaceList);
		if (constantValue == null && !(constantValue instanceof DataUnitaryMatrix)) {
			return;
		}

		DataUnitaryMatrix A = (DataUnitaryMatrix) constantValue;
		DataQplace result = (DataQplace) ((DataQplace) input1).clone();
		Qplace resC = (Qplace) result.GetValue();
		resC.Psi.ComplexArray.addAll(((DataQplace) input2).Value.Psi.ComplexArray);
		Qplace resD = new Qplace(new Psivector(resC.Psi.Size * 2, resC.Psi.ComplexArray), resC.PrintingSetting);

		for (int i = 0; i < A.Value.Matrix.length; i++) {
			ComplexValue sum = new ComplexValue(0.0F, 0.0F);

			for (int j = 0; j < A.Value.Matrix[0].length; j++) {
				ComplexValue cv1 = resC.Psi.ComplexArray.get(j);
				Float real = A.Value.Matrix[i][j] * cv1.Real;
				Float imaginary = A.Value.Matrix[i][j] * cv1.Imaginary;
				ComplexValue cv2 = new ComplexValue(real, imaginary);
				sum.Real += cv2.Real;
				sum.Imaginary += cv2.Imaginary;
			}
			resD.Psi.ComplexArray.set(i, sum);
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

		if (temp instanceof DataQplace) {
			result.SetValue((PetriObject) ((DataQplace) temp).clone());
		}
	}

	private void SplitQbit() throws CloneNotSupportedException {
		PetriObject input1 = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataQplace)) {
			return;
		}

		DataQplace result = (DataQplace) ((DataQplace) input1).clone();
		result.SetName(OutputPlaceName);
		QBit q = ((DataQplace) input1).Value.V.QBits.get(QbitIndex);
		result.SetValue(new Qplace(new Vvector(1, q), QplacePrintSetting.Both));
		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void Measurement() throws CloneNotSupportedException {
		PetriObject input1 = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataQplace)) {
			return;
		}

		DataQplace result = (DataQplace) ((DataQplace) input1).clone();
		result.SetName(OutputPlaceName);
		QBit q = ((DataQplace) input1).Value.V.QBits.get(0).clone();
		q.Alpha = util.Power2(q.Alpha);
		q.Beta = util.Power2(q.Beta);

		q.Alpha = util
				.sqrt(new ComplexValue(q.Alpha.Real + q.Beta.Real, q.Alpha.Imaginary + q.Beta.Imaginary));
		result.SetValue(new Qplace(new Vvector(1, q), QplacePrintSetting.Both));
		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}
}
