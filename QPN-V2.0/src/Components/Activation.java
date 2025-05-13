package Components;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;

import com.google.gson.Gson;

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
import java.nio.file.Files;

public class Activation implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetriTransition Parent;
	float Ro = (float) (1 / Math.sqrt(2));

	public String InputPlaceName;
	public ArrayList<UnitaryMatrixParameter> UnitaryMatrixParameters;
	public String InputPlaceName1;
	public String InputPlaceName2;
	public ArrayList<String> InputPlaceNames;
	public ArrayList<String> ConstantValues;
	public String OutputPlaceName;
	public ArrayList<String> OutputPlaceNames;
	public ArrayList<LaneActivationParameter> ActivationParameters;
	public ArrayList<Integer> Indexes;
	public IntersectionActivationParameter IntersectionParameter;
	public TransitionOperation Operation;
	public Functions util;
	public String ConstantValueName1;
	public String ConstantValueName2;
	public int QbitIndex = 0;
	public int SplitRange = 1;

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

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.Operation = Condition;
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

	public Activation(PetriTransition Parent, String InputPlaceName, int qbitIndex, int splitRange,
			TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.QbitIndex = qbitIndex;
		this.SplitRange = splitRange;
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

	public Activation(CustomUnitaryMatrixParameter CustomUnitaryMatrixParameter) {
		util = new Functions();
		this.Parent = CustomUnitaryMatrixParameter.Parent;
		this.ConstantValues = CustomUnitaryMatrixParameter.ConstantValues;
		this.OutputPlaceName = CustomUnitaryMatrixParameter.OutputPlaceName;
		this.Operation = CustomUnitaryMatrixParameter.Condition;
		this.UnitaryMatrixParameters = CustomUnitaryMatrixParameter.UnitaryMatrixParameters;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, TransitionOperation Condition,
			ArrayList<String> OutputPlaceNames) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceNames = OutputPlaceNames;
		this.Operation = Condition;
	}

//	public Activation(PetriTransition Parent, ArrayList<String> InputPlaceNames, TransitionOperation Condition,
//			ArrayList<ActivationParameter> OutputPlaceParameters) {
//		util = new Functions();
//		this.Parent = Parent;
//		this.InputPlaceNames = InputPlaceNames;
//		this.ActivationParameters = OutputPlaceParameters;
//		this.Operation = Condition;
//	}

	public Activation(PetriTransition Parent, TransitionOperation Condition,
			ArrayList<LaneActivationParameter> ActivationParameters) {
		util = new Functions();
		this.Parent = Parent;
		this.ActivationParameters = ActivationParameters;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, TransitionOperation Condition,
			IntersectionActivationParameter IntersectionParameter) {
		util = new Functions();
		this.Parent = Parent;
		this.IntersectionParameter = IntersectionParameter;
		this.Operation = Condition;
	}

	public Activation(PetriTransition Parent, String InputPlaceName, ArrayList<Integer> Indexes,
			TransitionOperation Condition, String OutputPlaceName) {
		util = new Functions();
		this.Parent = Parent;
		this.InputPlaceName = InputPlaceName;
		this.OutputPlaceName = OutputPlaceName;
		this.Operation = Condition;
		this.Indexes = Indexes;
	}

	public void Activate() throws CloneNotSupportedException, IOException {

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

		if (Operation == TransitionOperation.CustomUnitaryMatrixV)
			CustomUnitaryMatrixV();

		if (Operation == TransitionOperation.ThetaUnitaryMatrixV)
			ThetaUnitaryMatrixV();

		if (Operation == TransitionOperation.SplitQbit)
			SplitQbit();

		if (Operation == TransitionOperation.SplitRangeQbit)
			SplitRangeQbit();

		if (Operation == TransitionOperation.SplitIndexesQbit)
			SplitIndexesQbit();

		if (Operation == TransitionOperation.Measurement)
			Measurement();

		if (Operation == TransitionOperation.LaneSplit)
			LaneSplit();

		if (Operation == TransitionOperation.IntersectionSplit)
			IntersectionSplit();

		if (Operation == TransitionOperation.WriteToFile)
			WriteToFile();

		if (Operation == TransitionOperation.LaneSplitWithoutOutputThetas)
			LaneSplitWithoutOutputThetas();

		if (Operation == TransitionOperation.Throughput)
			Throughput();
	}

	private void Throughput() throws CloneNotSupportedException {
		// input place, indexes, output place
		// Indexes.size = QPlace size
		PetriObject input1 = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataQplace)) {
			return;
		}
		DataQplace result = (DataQplace) ((DataQplace) input1).clone();

		for (int i = 0; i < result.Value.V.Size; i++) {
			Parent.Parent.Throughput += result.Value.V.QBits.get(i).Alpha.Real;
		}
		System.out.println("Throughput = "+ Parent.Parent.Throughput);
		Parent.Parent.StopFlag = true;
	}

	private void SplitIndexesQbit() throws CloneNotSupportedException {
		// input place, indexes, output place
		// Indexes.size = QPlace size
		PetriObject input1 = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataQplace)) {
			return;
		}
		DataQplace result = (DataQplace) ((DataQplace) input1).clone();
		result.SetName(OutputPlaceName);

		int limit = Indexes.size();
		ArrayList<QBit> range = new ArrayList<QBit>();
		for (int i = QbitIndex; i < limit; i++) {
			QBit q = ((DataQplace) input1).Value.V.QBits.get(Indexes.get(i));
			range.add(q);
		}
		result.SetValue(new Qplace(new Vvector(limit, range), QplacePrintSetting.Both));
		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void LaneSplitWithoutOutputThetas() {
		// inputs:
		// 1st: U
		PetriObject U = util.GetFromListByName(ActivationParameters.get(0).QbitInput, Parent.TempMarking);
		if (U == null && !(U instanceof DataQplace)) {
			throw new Error("U is not DataQplace");
		}
		DataQplace U_DataQplace = (DataQplace) U;
		// 2nd: S
		PetriObject S = util.GetFromListByName(ActivationParameters.get(1).QbitInput, Parent.Parent.ConstantPlaceList);
		if (S == null && !(S instanceof DataQplace)) {
			throw new Error("S is not DataQplace");
		}
		DataQplace S_DataQplace = (DataQplace) S;

		PetriObject firstoutput = util.GetFromListByName(ActivationParameters.get(0).QbitLaneName,
				Parent.Parent.PlaceList);
		if (firstoutput == null && !(firstoutput instanceof DataQplace)) {
			throw new Error("firstoutput is not DataQplace");
		}
		DataQplace firstoutput_DataQplace = (DataQplace) firstoutput;

		PetriObject secondoutput = util.GetFromListByName(ActivationParameters.get(1).QbitLaneName,
				Parent.Parent.PlaceList);
		if (secondoutput == null && !(secondoutput instanceof DataQplace)) {
			throw new Error("secondoutput is not DataQplace");
		}
		DataQplace secondoutput_DataQplace = (DataQplace) secondoutput;

		ArrayList<QBit> qlist = new ArrayList<QBit>();
		for (int i = 0; i < U_DataQplace.Value.V.Size; i++) {
			// first output:
			// beta = bu.bs
			Float beta = U_DataQplace.Value.V.QBits.get(i).Beta.Real * S_DataQplace.Value.V.QBits.get(i).Beta.Real;
			double theta = Math.acos((double) beta);
			double alpha = Math.sin(theta);
			qlist.add(new QBit(new ComplexValue((float) alpha, 0.0f), new ComplexValue(beta, 0.0f)));
		}

		// theta = arcos (bu.bs)
		// alpha = sin (theta 1st output)
		firstoutput_DataQplace.SetValue(new Qplace(new Vvector(qlist.size(), qlist), QplacePrintSetting.Both));

		ArrayList<QBit> qlist2 = new ArrayList<QBit>();

		for (int i = 0; i < U_DataQplace.Value.V.Size; i++) {

			// second output:
			// beta = bu(bs-1)
			Float beta2 = U_DataQplace.Value.V.QBits.get(i).Beta.Real
					* (S_DataQplace.Value.V.QBits.get(i).Beta.Real - 1);
			double theta2 = Math.acos((double) beta2);
			double alpha2 = Math.sin(theta2);
			qlist2.add(new QBit(new ComplexValue((float) alpha2, 0.0f), new ComplexValue(beta2, 0.0f)));

		}
		// theta 2 = arcos(bu.(bs-1))
		// alpha = sin (theta 2nd output)
		secondoutput_DataQplace.SetValue(new Qplace(new Vvector(qlist2.size(), qlist2), QplacePrintSetting.Both));
	}

	private void WriteToFile() throws IOException {
		File file = new File(OutputPlaceName);
		Files.deleteIfExists(file.toPath());
		FileWriter fw = new FileWriter(file.getPath());
		ArrayList<DataQplace> toSerialize = new ArrayList<DataQplace>();
		for (int i = 0; i < InputPlaceNames.size(); i++) {
			PetriObject input = util.GetFromListByName(InputPlaceNames.get(i), Parent.TempMarking);
			if (input == null && !(input instanceof DataQplace)) {
				continue;
			}
			toSerialize.add(((DataQplace) input));
			// fw.write(((DataQplace) input).Value.toString());
		}

		Gson gson = new Gson();
		String json = gson.toJson(toSerialize);
		fw.write(json);
		fw.close();
	}

	private void IntersectionSplit() {
		// first 4 qbits used with the unitary matrix, the 2nd 4 are moved to another
		// place

		PetriObject U1 = util.GetFromListByName(IntersectionParameter.QbitU1, Parent.TempMarking);
		if (U1 == null && !(U1 instanceof DataQplace)) {
			throw new Error("U1 is not DataQplace");
		}
		DataQplace U1_DataQplace = (DataQplace) U1;

		PetriObject U2 = util.GetFromListByName(IntersectionParameter.QbitU2, Parent.TempMarking);
		if (U2 == null && !(U2 instanceof DataQplace)) {
			throw new Error("U2 is not DataQplace");
		}
		DataQplace U2_DataQplace = (DataQplace) U2;

		PetriObject U3 = util.GetFromListByName(IntersectionParameter.QbitU3, Parent.TempMarking);
		if (U3 == null && !(U3 instanceof DataQplace)) {
			throw new Error("U3 is not DataQplace");
		}
		DataQplace U3_DataQplace = (DataQplace) U3;

		PetriObject U4 = util.GetFromListByName(IntersectionParameter.QbitU4, Parent.TempMarking);
		if (U4 == null && !(U4 instanceof DataQplace)) {
			throw new Error("U4 is not DataQplace");
		}
		DataQplace U4_DataQplace = (DataQplace) U4;

		PetriObject SList = util.GetFromListByName(IntersectionParameter.QbitSList, Parent.Parent.ConstantPlaceList);
		if (SList == null && !(SList instanceof DataQplace)) {
			throw new Error("S is not DataQplace");
		}
		DataQplace S_DataQplace = (DataQplace) SList;

		PetriObject QbitLaneName1 = util.GetFromListByName(IntersectionParameter.QbitLaneName1,
				Parent.Parent.PlaceList);
		if (QbitLaneName1 == null && !(QbitLaneName1 instanceof DataQplace)) {
			throw new Error("QbitLaneName1 is not DataQplace");
		}
		DataQplace QbitLaneName1_DataQplace = (DataQplace) QbitLaneName1;

		PetriObject QbitLaneName2 = util.GetFromListByName(IntersectionParameter.QbitLaneName2,
				Parent.Parent.PlaceList);
		if (QbitLaneName2 == null && !(QbitLaneName2 instanceof DataQplace)) {
			throw new Error("QbitLaneName2 is not DataQplace");
		}
		DataQplace QbitLaneName2_DataQplace = (DataQplace) QbitLaneName2;

		ArrayList<DataTheta> DataThetaList = new ArrayList<>();
		for (int i = 0; i < IntersectionParameter.ThetaConstantNames.size(); i++) {
			PetriObject firstconstantoutput = util.GetFromListByName(IntersectionParameter.ThetaConstantNames.get(i),
					Parent.Parent.ConstantPlaceList);
			if (firstconstantoutput == null && !(firstconstantoutput instanceof DataTheta)) {
				throw new Error("IntersectionParameter at position " + i + " is not DataTheta");
			}
			DataThetaList.add((DataTheta) firstconstantoutput);
		}

		PetriObject QbitGammaName1 = util.GetFromListByName(IntersectionParameter.QbitGammaName1,
				Parent.Parent.ConstantPlaceList);
		if (QbitGammaName1 == null && !(QbitGammaName1 instanceof DataQplace)) {
			throw new Error("QbitGammaName1 is not DataQplace");
		}
		DataQplace QbitGammaName1_DataQplace = (DataQplace) QbitGammaName1;

		PetriObject QbitGammaName2 = util.GetFromListByName(IntersectionParameter.QbitGammaName2,
				Parent.Parent.ConstantPlaceList);
		if (QbitGammaName2 == null && !(QbitGammaName2 instanceof DataQplace)) {
			throw new Error("QbitGammaName2 is not DataQplace");
		}
		DataQplace QbitGammaName2_DataQplace = (DataQplace) QbitGammaName2;

		// first output:
		// beta = bu.bs
		Float beta1 = U1_DataQplace.Value.V.QBits.get(0).Beta.Real * S_DataQplace.Value.V.QBits.get(0).Beta.Real;
		double theta1 = Math.acos((double) beta1);
		double alpha1 = Math.sin(theta1);

		Float beta2 = U2_DataQplace.Value.V.QBits.get(0).Beta.Real * S_DataQplace.Value.V.QBits.get(1).Beta.Real;
		double theta2 = Math.acos((double) beta2);
		double alpha2 = Math.sin(theta2);

		Float beta3 = U3_DataQplace.Value.V.QBits.get(0).Beta.Real * S_DataQplace.Value.V.QBits.get(2).Beta.Real;
		double theta3 = Math.acos((double) beta3);
		double alpha3 = Math.sin(theta3);

		Float beta4 = U4_DataQplace.Value.V.QBits.get(0).Beta.Real * S_DataQplace.Value.V.QBits.get(3).Beta.Real;
		double theta4 = Math.acos((double) beta4);
		double alpha4 = Math.sin(theta4);

		// second output:
		// beta = bu(bs-1)
		Float beta1M = U1_DataQplace.Value.V.QBits.get(0).Beta.Real * (S_DataQplace.Value.V.QBits.get(0).Beta.Real - 1);
		double theta1M = Math.acos((double) beta1M);
		double alpha1M = Math.sin(theta1M);

		Float beta2M = U2_DataQplace.Value.V.QBits.get(0).Beta.Real * (S_DataQplace.Value.V.QBits.get(1).Beta.Real - 1);
		double theta2M = Math.acos((double) beta2M);
		double alpha2M = Math.sin(theta2M);

		Float beta3M = U3_DataQplace.Value.V.QBits.get(0).Beta.Real * (S_DataQplace.Value.V.QBits.get(2).Beta.Real - 1);
		double theta3M = Math.acos((double) beta3M);
		double alpha3M = Math.sin(theta3M);

		Float beta4M = U4_DataQplace.Value.V.QBits.get(0).Beta.Real * (S_DataQplace.Value.V.QBits.get(3).Beta.Real - 1);
		double theta4M = Math.acos((double) beta4M);
		double alpha4M = Math.sin(theta4M);

		// theta = arcos (bu.bs)
		// alpha = sin (theta 1st output)
		QbitLaneName1_DataQplace.SetValue(new Qplace(
				new Vvector(4, new QBit(new ComplexValue((float) alpha1, 0.0f), new ComplexValue(beta1, 0.0f)),
						new QBit(new ComplexValue((float) alpha1M, 0.0f), new ComplexValue(beta1M, 0.0f)),
						new QBit(new ComplexValue((float) alpha2, 0.0f), new ComplexValue(beta2, 0.0f)),
						new QBit(new ComplexValue((float) alpha2M, 0.0f), new ComplexValue(beta2M, 0.0f))),
				QplacePrintSetting.Both));

		QbitLaneName2_DataQplace.SetValue(new Qplace(
				new Vvector(4, new QBit(new ComplexValue((float) alpha3, 0.0f), new ComplexValue(beta3, 0.0f)),
						new QBit(new ComplexValue((float) alpha3M, 0.0f), new ComplexValue(beta3M, 0.0f)),
						new QBit(new ComplexValue((float) alpha4, 0.0f), new ComplexValue(beta4, 0.0f)),
						new QBit(new ComplexValue((float) alpha4M, 0.0f), new ComplexValue(beta4M, 0.0f))),
				QplacePrintSetting.Both));

		DataThetaList.get(0)
				.SetValue(new Theta((float) Math.acos(1 * QbitLaneName1_DataQplace.Value.V.QBits.get(0).Beta.Real
						* QbitGammaName1_DataQplace.Value.V.QBits.get(0).Beta.Real)));

		DataThetaList.get(1)
				.SetValue(new Theta((float) Math.acos(1 * QbitLaneName1_DataQplace.Value.V.QBits.get(1).Beta.Real
						* QbitGammaName1_DataQplace.Value.V.QBits.get(0).Beta.Real)));

		DataThetaList.get(2)
				.SetValue(new Theta((float) Math.acos(1 * QbitLaneName1_DataQplace.Value.V.QBits.get(2).Beta.Real
						* QbitGammaName1_DataQplace.Value.V.QBits.get(0).Beta.Real)));

		DataThetaList.get(3)
				.SetValue(new Theta((float) Math.acos(1 * QbitLaneName1_DataQplace.Value.V.QBits.get(3).Beta.Real
						* QbitGammaName1_DataQplace.Value.V.QBits.get(0).Beta.Real)));

		DataThetaList.get(4)
				.SetValue(new Theta((float) Math.acos(1 * QbitLaneName1_DataQplace.Value.V.QBits.get(0).Beta.Real
						* QbitGammaName2_DataQplace.Value.V.QBits.get(0).Alpha.Real)));

		DataThetaList.get(5)
				.SetValue(new Theta((float) Math.acos(1 * QbitLaneName2_DataQplace.Value.V.QBits.get(1).Beta.Real
						* QbitGammaName2_DataQplace.Value.V.QBits.get(0).Alpha.Real)));

		DataThetaList.get(6)
				.SetValue(new Theta((float) Math.acos(1 * QbitLaneName2_DataQplace.Value.V.QBits.get(2).Beta.Real
						* QbitGammaName2_DataQplace.Value.V.QBits.get(0).Alpha.Real)));

		DataThetaList.get(7)
				.SetValue(new Theta((float) Math.acos(1 * QbitLaneName2_DataQplace.Value.V.QBits.get(3).Beta.Real
						* QbitGammaName2_DataQplace.Value.V.QBits.get(0).Alpha.Real)));

	}

	private void LaneSplit() {
		// inputs:
		// 1st: U
		PetriObject U = util.GetFromListByName(ActivationParameters.get(0).QbitInput, Parent.TempMarking);
		if (U == null && !(U instanceof DataQplace)) {
			throw new Error("U is not DataQplace");
		}
		DataQplace U_DataQplace = (DataQplace) U;
		// 2nd: S
		PetriObject S = util.GetFromListByName(ActivationParameters.get(1).QbitInput, Parent.Parent.ConstantPlaceList);
		if (S == null && !(S instanceof DataQplace)) {
			throw new Error("S is not DataQplace");
		}
		DataQplace S_DataQplace = (DataQplace) S;

		PetriObject firstoutput = util.GetFromListByName(ActivationParameters.get(0).QbitLaneName,
				Parent.Parent.PlaceList);
		if (firstoutput == null && !(firstoutput instanceof DataQplace)) {
			throw new Error("firstoutput is not DataQplace");
		}
		DataQplace firstoutput_DataQplace = (DataQplace) firstoutput;

		PetriObject secondoutput = util.GetFromListByName(ActivationParameters.get(1).QbitLaneName,
				Parent.Parent.PlaceList);
		if (secondoutput == null && !(secondoutput instanceof DataQplace)) {
			throw new Error("secondoutput is not DataQplace");
		}
		DataQplace secondoutput_DataQplace = (DataQplace) secondoutput;

		PetriObject firstconstantoutput = util.GetFromListByName(ActivationParameters.get(0).ThetaConstantName,
				Parent.Parent.ConstantPlaceList);
		if (firstconstantoutput == null && !(firstconstantoutput instanceof DataTheta)) {
			throw new Error("firstconstantoutput is not DataTheta");
		}
		DataTheta firstconstantoutput_DataTheta = (DataTheta) firstconstantoutput;

		PetriObject secondconstantoutput = util.GetFromListByName(ActivationParameters.get(1).ThetaConstantName,
				Parent.Parent.ConstantPlaceList);
		if (secondconstantoutput == null && !(secondconstantoutput instanceof DataTheta)) {
			throw new Error("secondconstantoutput is not DataTheta");
		}
		DataTheta secondconstantoutput_DataTheta = (DataTheta) secondconstantoutput;

		PetriObject firstoutputGamma = util.GetFromListByName(ActivationParameters.get(0).QbitGammaName,
				Parent.Parent.ConstantPlaceList);
		if (firstoutputGamma == null && !(firstoutputGamma instanceof DataQplace)) {
			throw new Error("firstoutputGamma is not DataQplace");
		}
		DataQplace firstoutputGamma_DataQplace = (DataQplace) firstoutputGamma;

		PetriObject secondoutputGamma = util.GetFromListByName(ActivationParameters.get(1).QbitGammaName,
				Parent.Parent.ConstantPlaceList);
		if (secondoutputGamma == null && !(secondoutputGamma instanceof DataQplace)) {
			throw new Error("secondoutputGamma is not DataQplace");
		}
		DataQplace secondoutputGamma_DataQplace = (DataQplace) secondoutputGamma;

		// first output:
		// beta = bu.bs
		Float beta = U_DataQplace.Value.V.QBits.get(0).Beta.Real * S_DataQplace.Value.V.QBits.get(0).Beta.Real;
		double theta = Math.acos((double) beta);
		double alpha = Math.sin(theta);

		// theta = arcos (bu.bs)
		// alpha = sin (theta 1st output)
		firstoutput_DataQplace.SetValue(new Qplace(
				new Vvector(1, new QBit(new ComplexValue((float) alpha, 0.0f), new ComplexValue(beta, 0.0f))),
				QplacePrintSetting.Both));

		// second output:
		// beta = bu(bs-1)
		Float beta2 = U_DataQplace.Value.V.QBits.get(0).Beta.Real * (S_DataQplace.Value.V.QBits.get(0).Beta.Real - 1);
		double theta2 = Math.acos((double) beta2);
		double alpha2 = Math.sin(theta2);

		// theta 2 = arcos(bu.(bs-1))
		// alpha = sin (theta 2nd output)
		secondoutput_DataQplace.SetValue(new Qplace(
				new Vvector(1, new QBit(new ComplexValue((float) alpha2, 0.0f), new ComplexValue(beta2, 0.0f))),
				QplacePrintSetting.Both));

		firstconstantoutput_DataTheta
				.SetValue(new Theta((float) Math.acos(1 * firstoutput_DataQplace.Value.V.QBits.get(0).Beta.Real
						* firstoutputGamma_DataQplace.Value.V.QBits.get(0).Beta.Real)));

		secondconstantoutput_DataTheta
				.SetValue(new Theta((float) Math.acos(1 * secondoutput_DataQplace.Value.V.QBits.get(0).Beta.Real
						* secondoutputGamma_DataQplace.Value.V.QBits.get(0).Alpha.Real)));
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
//		if (Parent.TransitionName == "tmu") {
//			System.out.println("--------------STOP-------------tmu");
//		}
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

//		System.out.println("-------------------" + OutputPlaceName);
//		if (OutputPlaceName == "p6") {
//			System.out.println("--------STOP-----------" + OutputPlaceName);
//		}
//
//		if (OutputPlaceName == "p5") {
//			System.out.println("--------STOP-----------" + OutputPlaceName);
//		}
		result.SetName(OutputPlaceName);
		result.SetValue(
				new Qplace(new Vvector(QBitResultCollection.size(), QBitResultCollection), QplacePrintSetting.Both));
		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}

	private void CustomUnitaryMatrixV() throws CloneNotSupportedException {
		// extract qbits in an ordered list
		ArrayList<QBit> QBitCollection = new ArrayList<>();
		for (int i = 0; i < UnitaryMatrixParameters.size(); i++) {
			PetriObject input = util.GetFromListByName(UnitaryMatrixParameters.get(i).PlaceName, Parent.TempMarking);
			if (input == null && !(input instanceof DataQplace)) {
				continue;
			}
			QBitCollection.add(((DataQplace) input).Value.V.QBits.get(UnitaryMatrixParameters.get(i).Index));
		}

		// result qplace that collect all the qbits after the operation
		DataQplace result = new DataQplace();
		ArrayList<QBit> QBitResultCollection = new ArrayList<>();
//		if (Parent.TransitionName == "tmu") {
//			System.out.println("--------------STOP-------------tmu");
//		}
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

//		System.out.println("-------------------" + OutputPlaceName);
//		if (OutputPlaceName == "p6") {
//			System.out.println("--------STOP-----------" + OutputPlaceName);
//		}
//
//		if (OutputPlaceName == "p5") {
//			System.out.println("--------STOP-----------" + OutputPlaceName);
//		}
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
				throw new Error("Did not find the corresponding unitary matrix");
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

	private void SplitRangeQbit() throws CloneNotSupportedException {
		PetriObject input1 = util.GetFromListByName(InputPlaceName, Parent.TempMarking);
		if (input1 == null && !(input1 instanceof DataQplace)) {
			return;
		}
		DataQplace result = (DataQplace) ((DataQplace) input1).clone();
		result.SetName(OutputPlaceName);
		int limit = QbitIndex + SplitRange;
		ArrayList<QBit> range = new ArrayList<QBit>();
		for (int i = QbitIndex; i < limit; i++) {
			QBit q = ((DataQplace) input1).Value.V.QBits.get(i);
			range.add(q);
		}
		result.SetValue(new Qplace(new Vvector(SplitRange, range), QplacePrintSetting.Both));
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

		q.Alpha = util.sqrt(new ComplexValue(q.Alpha.Real + q.Beta.Real, q.Alpha.Imaginary + q.Beta.Imaginary));
		result.SetValue(new Qplace(new Vvector(1, q), QplacePrintSetting.Both));
		util.SetToListByName(OutputPlaceName, Parent.Parent.PlaceList, result);
	}
}
