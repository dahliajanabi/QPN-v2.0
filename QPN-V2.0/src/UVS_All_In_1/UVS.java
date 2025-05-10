package UVS_All_In_1;

import java.util.ArrayList;

import Components.Activation;
import Components.LaneActivationParameter;
import Components.Condition;
import Components.GuardMapping;
import Components.IntersectionActivationParameter;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataDigital;
import DataObjects.DataQplace;
import DataObjects.DataTheta;
import DataObjects.DataTransfer;
import DataObjects.DataUnitaryMatrix;
import DataObjects.DataUnitaryThetaMatrix;
import DataOnly.ComplexValue;
import DataOnly.Digital;
import DataOnly.Qplace;
import DataOnly.Theta;
import DataOnly.TransferOperation;
import DataOnly.UnitaryMatrix;
import DataOnly.UnitaryThetaMatrix;
import DataOnly.UnitaryThetaMatrixValue;
import DataOnly.Vvector;
import DataOnly.QBit;
import Enumerations.LogicConnector;
import Enumerations.QplacePrintSetting;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
import Enumerations.UnitaryThetaMatrixValueFuncType;

public class UVS {

	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Intersection_1";
		pn.NetworkPort = 1080;

		// --------constants---------------------------
		float Ro = (float) Math.sqrt(2) / 2;

		// -------------Unitary Matrixes----------------
		// RF matrixes-----------------------------------
		DataUnitaryThetaMatrix constantValue101 = new DataUnitaryThetaMatrix();
		constantValue101.SetName("Rf01");
		constantValue101.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c101"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c101"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c101"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c101"))); // theta f
		pn.ConstantPlaceList.add(constantValue101);

		DataUnitaryThetaMatrix constantValue102 = new DataUnitaryThetaMatrix();
		constantValue102.SetName("Rf02");
		constantValue102.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c102"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c102"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c102"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c102"))); // theta f
		pn.ConstantPlaceList.add(constantValue102);

		DataUnitaryThetaMatrix constantValue103 = new DataUnitaryThetaMatrix();
		constantValue103.SetName("Rf03");
		constantValue103.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c103"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c103"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c103"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c103"))); // theta f
		pn.ConstantPlaceList.add(constantValue103);

		DataUnitaryThetaMatrix constantValue104 = new DataUnitaryThetaMatrix();
		constantValue104.SetName("Rf04");
		constantValue104.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c104"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c104"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c104"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c104"))); // theta f
		pn.ConstantPlaceList.add(constantValue104);

		DataUnitaryThetaMatrix constantValue105 = new DataUnitaryThetaMatrix();
		constantValue105.SetName("Rf05");
		constantValue105.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c105"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c105"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c105"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c105"))); // theta f
		pn.ConstantPlaceList.add(constantValue105);

		DataUnitaryThetaMatrix constantValue106 = new DataUnitaryThetaMatrix();
		constantValue106.SetName("Rf06");
		constantValue106.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c106"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c106"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c106"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c106"))); // theta f
		pn.ConstantPlaceList.add(constantValue106);

		DataUnitaryThetaMatrix constantValue107 = new DataUnitaryThetaMatrix();
		constantValue107.SetName("Rf07");
		constantValue107.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c107"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c107"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c107"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c107"))); // theta f
		pn.ConstantPlaceList.add(constantValue107);

		DataUnitaryThetaMatrix constantValue108 = new DataUnitaryThetaMatrix();
		constantValue108.SetName("Rf08");
		constantValue108.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c108"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c108"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c108"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c108"))); // theta f
		pn.ConstantPlaceList.add(constantValue108);

		DataUnitaryThetaMatrix constantValue109 = new DataUnitaryThetaMatrix();
		constantValue109.SetName("Rf09");
		constantValue109.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c109"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c109"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c109"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c109"))); // theta f
		pn.ConstantPlaceList.add(constantValue109);

		DataUnitaryThetaMatrix constantValue110 = new DataUnitaryThetaMatrix();
		constantValue110.SetName("Rf10");
		constantValue110.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c110"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c110"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c110"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c110"))); // theta f
		pn.ConstantPlaceList.add(constantValue110);

		DataUnitaryThetaMatrix constantValue111 = new DataUnitaryThetaMatrix();
		constantValue111.SetName("Rf11");
		constantValue111.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c111"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c111"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c111"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c111"))); // theta f
		pn.ConstantPlaceList.add(constantValue111);

		DataUnitaryThetaMatrix constantValue112 = new DataUnitaryThetaMatrix();
		constantValue112.SetName("Rf12");
		constantValue112.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c112"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c112"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c112"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c112"))); // theta f
		pn.ConstantPlaceList.add(constantValue112);

		DataUnitaryThetaMatrix constantValue113 = new DataUnitaryThetaMatrix();
		constantValue113.SetName("Rf13");
		constantValue113.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c113"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c113"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c113"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c113"))); // theta f
		pn.ConstantPlaceList.add(constantValue113);

		DataUnitaryThetaMatrix constantValue114 = new DataUnitaryThetaMatrix();
		constantValue114.SetName("Rf14");
		constantValue114.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c114"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c114"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c114"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c114"))); // theta f
		pn.ConstantPlaceList.add(constantValue114);

		DataUnitaryThetaMatrix constantValue115 = new DataUnitaryThetaMatrix();
		constantValue115.SetName("Rf15");
		constantValue115.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c115"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c115"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c115"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c115"))); // theta f
		pn.ConstantPlaceList.add(constantValue115);

		DataUnitaryThetaMatrix constantValue116 = new DataUnitaryThetaMatrix();
		constantValue116.SetName("Rf16");
		constantValue116.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c116"), //theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c116"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c116"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c116"))); // theta f
		pn.ConstantPlaceList.add(constantValue116);

		// Rr matrixes-------------------------------------
		DataUnitaryThetaMatrix constantValue201 = new DataUnitaryThetaMatrix();
		constantValue201.SetName("Rr01");
		constantValue201.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c201"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c201"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c201"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c201"))); // theta r
		pn.ConstantPlaceList.add(constantValue201);

		DataUnitaryThetaMatrix constantValue202 = new DataUnitaryThetaMatrix();
		constantValue202.SetName("Rr02");
		constantValue202.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c202"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c202"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c202"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c202"))); // theta r
		pn.ConstantPlaceList.add(constantValue202);

		DataUnitaryThetaMatrix constantValue203 = new DataUnitaryThetaMatrix();
		constantValue203.SetName("Rr03");
		constantValue203.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c203"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c203"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c203"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c203"))); // theta r
		pn.ConstantPlaceList.add(constantValue203);

		DataUnitaryThetaMatrix constantValue204 = new DataUnitaryThetaMatrix();
		constantValue204.SetName("Rr04");
		constantValue204.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c204"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c204"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c204"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c204"))); // theta r
		pn.ConstantPlaceList.add(constantValue204);

		DataUnitaryThetaMatrix constantValue205 = new DataUnitaryThetaMatrix();
		constantValue205.SetName("Rr05");
		constantValue205.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c205"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c205"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c205"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c205"))); // theta r
		pn.ConstantPlaceList.add(constantValue205);

		DataUnitaryThetaMatrix constantValue206 = new DataUnitaryThetaMatrix();
		constantValue206.SetName("Rr06");
		constantValue206.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c206"), //thet r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c206"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c206"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c206"))); // theta r
		pn.ConstantPlaceList.add(constantValue206);

		DataUnitaryThetaMatrix constantValue207 = new DataUnitaryThetaMatrix();
		constantValue207.SetName("Rr07");
		constantValue207.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c207"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c207"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c207"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c207"))); // theta r
		pn.ConstantPlaceList.add(constantValue207);

		DataUnitaryThetaMatrix constantValue208 = new DataUnitaryThetaMatrix();
		constantValue208.SetName("Rr08");
		constantValue208.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c208"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c208"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c208"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c208"))); // theta r
		pn.ConstantPlaceList.add(constantValue208);

		DataUnitaryThetaMatrix constantValue209 = new DataUnitaryThetaMatrix();
		constantValue209.SetName("Rr09");
		constantValue209.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c209"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c209"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c209"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c209"))); // theta r
		pn.ConstantPlaceList.add(constantValue209);

		DataUnitaryThetaMatrix constantValue210 = new DataUnitaryThetaMatrix();
		constantValue210.SetName("Rr10");
		constantValue210.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c210"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c210"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c210"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c210"))); // theta r
		pn.ConstantPlaceList.add(constantValue210);

		DataUnitaryThetaMatrix constantValue211 = new DataUnitaryThetaMatrix();
		constantValue211.SetName("Rr11");
		constantValue211.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c211"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c211"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c211"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c211"))); // theta r
		pn.ConstantPlaceList.add(constantValue211);

		DataUnitaryThetaMatrix constantValue212 = new DataUnitaryThetaMatrix();
		constantValue212.SetName("Rr12");
		constantValue212.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c212"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c212"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c212"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c212"))); // theta r
		pn.ConstantPlaceList.add(constantValue212);

		DataUnitaryThetaMatrix constantValue213 = new DataUnitaryThetaMatrix();
		constantValue213.SetName("Rr13");
		constantValue213.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c213"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c213"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c213"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c213"))); // theta r
		pn.ConstantPlaceList.add(constantValue213);

		DataUnitaryThetaMatrix constantValue214 = new DataUnitaryThetaMatrix();
		constantValue214.SetName("Rr14");
		constantValue214.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c214"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c214"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c214"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c214"))); // theta r
		pn.ConstantPlaceList.add(constantValue214);

		DataUnitaryThetaMatrix constantValue215 = new DataUnitaryThetaMatrix();
		constantValue215.SetName("Rr15");
		constantValue215.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c215"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c215"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c215"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c215"))); // theta r
		pn.ConstantPlaceList.add(constantValue215);

		DataUnitaryThetaMatrix constantValue216 = new DataUnitaryThetaMatrix();
		constantValue216.SetName("Rr16");
		constantValue216.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c216"), //theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c216"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c216"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c216"))); // theta r
		pn.ConstantPlaceList.add(constantValue216);

		// R theta x------------------------------------------
		DataUnitaryThetaMatrix constantValue3 = new DataUnitaryThetaMatrix();
		constantValue3.SetName("Rx");
		constantValue3.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c3"), //theta x
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c3"), // theta x
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c3"), // theta x
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c3"))); // theta x
		pn.ConstantPlaceList.add(constantValue3);

		// Identity matrix------------------------------------
		DataUnitaryMatrix constantValue4 = new DataUnitaryMatrix();
		constantValue4.SetName("I");
		constantValue4.SetValue(new UnitaryMatrix(2, 2, 1.0f, 0.0f, 0.0f, 1.0f));
		pn.ConstantPlaceList.add(constantValue4);

		// ---------------------Places----------------------

		DataQplace piplus = new DataQplace(); // External input
		piplus.SetName("p_i_plus");
		piplus.SetValue(new Qplace(new Vvector(8, new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f))), QplacePrintSetting.Both));
		pn.PlaceList.add(piplus);

		DataQplace p1 = new DataQplace(); // X
		p1.SetName("p1");
		p1.SetValue(new Qplace(new Vvector(16, new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f))), QplacePrintSetting.Both));
		pn.PlaceList.add(p1);

		DataQplace p2 = new DataQplace(); // X'
		p2.SetName("p2");
		pn.PlaceList.add(p2);

		DataQplace p3 = new DataQplace(); // X''
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		DataQplace p4 = new DataQplace();
		p4.SetName("p4");
		pn.PlaceList.add(p4);

		DataQplace p5 = new DataQplace(); // U_i and E
		p5.SetName("p5");
		pn.PlaceList.add(p5);

		DataQplace p6 = new DataQplace(); // Uf and Ur
		p6.SetName("p6");
		pn.PlaceList.add(p6);

		DataQplace pm1 = new DataQplace(); // Em //2nd shot to p1
		pm1.SetName("p_m1");
		pn.PlaceList.add(pm1);

		DataQplace pm2 = new DataQplace(); // Um //2nd shot to gammas pc1 pc2
		pm2.SetName("p_m2");
		pn.PlaceList.add(pm2);
		
		DataQplace puf = new DataQplace(); // Uf from p5
		puf.SetName("p_uf");
		pn.PlaceList.add(puf);
		
		DataQplace pur = new DataQplace(); // Ur from p5
		pur.SetName("p_ur");
		pn.PlaceList.add(pur);

		DataQplace pc1 = new DataQplace(); // Gamma 1 (16 qbits)
		pc1.SetName("p_c1");
		pc1.SetValue(new Qplace(new Vvector(16, new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f))), QplacePrintSetting.Both));
		pn.ConstantPlaceList.add(pc1);

		DataQplace pc2 = new DataQplace(); // Gamma 2 (16 qbits)
		pc2.SetName("p_c2");
		pc2.SetValue(new Qplace(new Vvector(16, new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f))), QplacePrintSetting.Both));
		pn.ConstantPlaceList.add(pc2);

		DataTheta pc3 = new DataTheta(); // Theta x
		pc3.SetName("p_c3");
		pc3.SetValue(new Theta((float) Math.PI / 4));
		pn.ConstantPlaceList.add(pc3);

		DataDigital pme = new DataDigital(); // Digital place {0, 1}
		pme.SetName("p_me");
		pme.SetValue(new Digital(1));
		pn.PlaceList.add(pme);

		DataDigital pmu = new DataDigital(); // Digital place {0, 1}
		pmu.SetName("p_mu");
		pmu.SetValue(new Digital(1));
		pn.PlaceList.add(pmu);

		DataQplace p4s = new DataQplace(); // takes 8 qbits from p4
		p4s.SetName("p_4s");
		pn.PlaceList.add(p4s);

		DataQplace p_cs = new DataQplace(); // split place
		p_cs.SetName("p_cs");
		p_cs.SetValue(new Qplace(new Vvector(16, new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f)),
				new QBit(new ComplexValue(Ro, 0.0f), new ComplexValue(Ro, 0.0f))), QplacePrintSetting.Both));
		pn.ConstantPlaceList.add(p_cs);

		// ------------Theta Values---------------------------
		// Theta forward---------------------------------------
		DataTheta Th101 = new DataTheta();
		Th101.SetName("p_c101");
		Th101.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(0).Beta.Real * pc1.Value.V.QBits.get(0).Beta.Real)));
		pn.ConstantPlaceList.add(Th101);

		DataTheta Th102 = new DataTheta();
		Th102.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(1).Beta.Real * pc1.Value.V.QBits.get(1).Beta.Real)));
		Th102.SetName("p_c102");
		pn.ConstantPlaceList.add(Th102);

		DataTheta Th103 = new DataTheta();
		Th103.SetName("p_c103");
		Th103.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(2).Beta.Real * pc1.Value.V.QBits.get(2).Beta.Real)));
		pn.ConstantPlaceList.add(Th103);

		DataTheta Th104 = new DataTheta();
		Th104.SetName("p_c104");
		Th104.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(3).Beta.Real * pc1.Value.V.QBits.get(3).Beta.Real)));
		pn.ConstantPlaceList.add(Th104);

		DataTheta Th105 = new DataTheta();
		Th105.SetName("p_c105");
		Th105.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(4).Beta.Real * pc1.Value.V.QBits.get(4).Beta.Real)));
		pn.ConstantPlaceList.add(Th105);

		DataTheta Th106 = new DataTheta();
		Th106.SetName("p_c106");
		Th106.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(5).Beta.Real * pc1.Value.V.QBits.get(5).Beta.Real)));
		pn.ConstantPlaceList.add(Th106);

		DataTheta Th107 = new DataTheta();
		Th107.SetName("p_c107");
		Th107.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(6).Beta.Real * pc1.Value.V.QBits.get(6).Beta.Real)));
		pn.ConstantPlaceList.add(Th107);

		DataTheta Th108 = new DataTheta();
		Th108.SetName("p_c108");
		Th108.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(7).Beta.Real * pc1.Value.V.QBits.get(7).Beta.Real)));
		pn.ConstantPlaceList.add(Th108);

		DataTheta Th109 = new DataTheta();
		Th109.SetName("p_c109");
		Th109.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(8).Beta.Real * pc1.Value.V.QBits.get(8).Beta.Real)));
		pn.ConstantPlaceList.add(Th109);

		DataTheta Th110 = new DataTheta();
		Th110.SetName("p_c110");
		Th110.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(9).Beta.Real * pc1.Value.V.QBits.get(9).Beta.Real)));
		pn.ConstantPlaceList.add(Th110);

		DataTheta Th111 = new DataTheta();
		Th111.SetName("p_c111");
		Th111.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(10).Beta.Real * pc1.Value.V.QBits.get(10).Beta.Real)));
		pn.ConstantPlaceList.add(Th111);

		DataTheta Th112 = new DataTheta();
		Th112.SetName("p_c112");
		Th112.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(11).Beta.Real * pc1.Value.V.QBits.get(11).Beta.Real)));
		pn.ConstantPlaceList.add(Th112);

		DataTheta Th113 = new DataTheta();
		Th113.SetName("p_c113");
		Th113.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(12).Beta.Real * pc1.Value.V.QBits.get(12).Beta.Real)));
		pn.ConstantPlaceList.add(Th113);

		DataTheta Th114 = new DataTheta();
		Th114.SetName("p_c114");
		Th114.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(13).Beta.Real * pc1.Value.V.QBits.get(13).Beta.Real)));
		pn.ConstantPlaceList.add(Th114);

		DataTheta Th115 = new DataTheta();
		Th115.SetName("p_c115");
		Th115.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(14).Beta.Real * pc1.Value.V.QBits.get(14).Beta.Real)));
		pn.ConstantPlaceList.add(Th115);

		DataTheta Th116 = new DataTheta();
		Th116.SetName("p_c116");
		Th116.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(15).Beta.Real * pc1.Value.V.QBits.get(15).Beta.Real)));
		pn.ConstantPlaceList.add(Th116);

		// Theta right-----------------------------------------
		DataTheta Th201 = new DataTheta();
		Th201.SetName("p_c201");
		Th201.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(0).Beta.Real * pc1.Value.V.QBits.get(0).Alpha.Real)));
		pn.ConstantPlaceList.add(Th201);

		DataTheta Th202 = new DataTheta();
		Th202.SetName("p_c202");
		Th202.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(1).Beta.Real * pc1.Value.V.QBits.get(1).Alpha.Real)));
		pn.ConstantPlaceList.add(Th202);

		DataTheta Th203 = new DataTheta();
		Th203.SetName("p_c203");
		Th203.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(2).Beta.Real * pc1.Value.V.QBits.get(2).Alpha.Real)));
		pn.ConstantPlaceList.add(Th203);

		DataTheta Th204 = new DataTheta();
		Th204.SetName("p_c204");
		Th204.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(3).Beta.Real * pc1.Value.V.QBits.get(3).Alpha.Real)));
		pn.ConstantPlaceList.add(Th204);

		DataTheta Th205 = new DataTheta();
		Th205.SetName("p_c205");
		Th205.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(4).Beta.Real * pc1.Value.V.QBits.get(4).Alpha.Real)));
		pn.ConstantPlaceList.add(Th205);

		DataTheta Th206 = new DataTheta();
		Th206.SetName("p_c206");
		Th206.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(5).Beta.Real * pc1.Value.V.QBits.get(5).Alpha.Real)));
		pn.ConstantPlaceList.add(Th206);

		DataTheta Th207 = new DataTheta();
		Th207.SetName("p_c207");
		Th207.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(6).Beta.Real * pc1.Value.V.QBits.get(6).Alpha.Real)));
		pn.ConstantPlaceList.add(Th207);

		DataTheta Th208 = new DataTheta();
		Th208.SetName("p_c208");
		Th208.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(7).Beta.Real * pc1.Value.V.QBits.get(7).Alpha.Real)));
		pn.ConstantPlaceList.add(Th208);

		DataTheta Th209 = new DataTheta();
		Th209.SetName("p_c209");
		Th209.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(8).Beta.Real * pc1.Value.V.QBits.get(8).Alpha.Real)));
		pn.ConstantPlaceList.add(Th209);

		DataTheta Th210 = new DataTheta();
		Th210.SetName("p_c210");
		Th210.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(9).Beta.Real * pc1.Value.V.QBits.get(9).Alpha.Real)));
		pn.ConstantPlaceList.add(Th210);

		DataTheta Th211 = new DataTheta();
		Th211.SetName("p_c211");
		Th211.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(10).Beta.Real * pc1.Value.V.QBits.get(10).Alpha.Real)));
		pn.ConstantPlaceList.add(Th211);

		DataTheta Th212 = new DataTheta();
		Th212.SetName("p_c212");
		Th212.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(11).Beta.Real * pc1.Value.V.QBits.get(11).Alpha.Real)));
		pn.ConstantPlaceList.add(Th212);

		DataTheta Th213 = new DataTheta();
		Th213.SetName("p_c213");
		Th213.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(12).Beta.Real * pc1.Value.V.QBits.get(12).Alpha.Real)));
		pn.ConstantPlaceList.add(Th213);

		DataTheta Th214 = new DataTheta();
		Th214.SetName("p_c214");
		Th214.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(13).Beta.Real * pc1.Value.V.QBits.get(13).Alpha.Real)));
		pn.ConstantPlaceList.add(Th214);

		DataTheta Th215 = new DataTheta();
		Th215.SetName("p_c215");
		Th215.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(14).Beta.Real * pc1.Value.V.QBits.get(14).Alpha.Real)));
		pn.ConstantPlaceList.add(Th215);

		DataTheta Th216 = new DataTheta();
		Th216.SetName("p_c216");
		Th216.SetValue(new Theta(
				(float) Math.acos(1 * p1.Value.V.QBits.get(15).Beta.Real * pc1.Value.V.QBits.get(15).Alpha.Real)));
		pn.ConstantPlaceList.add(Th216);

		// -------------------Transitions----------------------

		// t1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1"); // 16 qbit

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;

		ArrayList T1inputList = new ArrayList<String>();
		T1inputList.add("p1");

		ArrayList T1ConstantList = new ArrayList<String>(); //
		T1ConstantList.add("Rf01");
		T1ConstantList.add("Rf02");
		T1ConstantList.add("Rf03");
		T1ConstantList.add("Rf04");
		T1ConstantList.add("Rf05");
		T1ConstantList.add("Rf06");
		T1ConstantList.add("Rf07");
		T1ConstantList.add("Rf08");
		T1ConstantList.add("Rf09");
		T1ConstantList.add("Rf10");
		T1ConstantList.add("Rf11");
		T1ConstantList.add("Rf12");
		T1ConstantList.add("Rf13");
		T1ConstantList.add("Rf14");
		T1ConstantList.add("Rf15");
		T1ConstantList.add("Rf16");

		grdT1.Activations
				.add(new Activation(t1, T1inputList, T1ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p2"));
		// move 2nd 4 qbits from p1 to p3
		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// t2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p2"); // 16 qbit

		Condition T2Ct1 = new Condition(t2, "p2", TransitionCondition.NotNull);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;

		ArrayList T2inputList = new ArrayList<String>();
		T2inputList.add("p2");
		ArrayList T2ConstantList = new ArrayList<String>();
		T2ConstantList.add("Rr01");
		T2ConstantList.add("Rr02");
		T2ConstantList.add("Rr03");
		T2ConstantList.add("Rr04");
		T2ConstantList.add("Rr05");
		T2ConstantList.add("Rr06");
		T2ConstantList.add("Rr07");
		T2ConstantList.add("Rr08");
		T2ConstantList.add("Rr09");
		T2ConstantList.add("Rr10");
		T2ConstantList.add("Rr11");
		T2ConstantList.add("Rr12");
		T2ConstantList.add("Rr13");
		T2ConstantList.add("Rr14");
		T2ConstantList.add("Rr15");
		T2ConstantList.add("Rr16");

		grdT2.Activations
				.add(new Activation(t2, T2inputList, T2ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p3"));

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);

		// t3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p3"); // 16 qbit

		Condition T3Ct1 = new Condition(t3, "p3", TransitionCondition.NotNull);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;

		ArrayList T3inputList = new ArrayList<String>();
		T3inputList.add("p3");
		ArrayList T3ConstantList = new ArrayList<String>();
		for (int i = 0; i < 16; i++)
			T3ConstantList.add("Rx");

		grdT3.Activations
				.add(new Activation(t3, T3inputList, T3ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p4"));

		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);

		// tme ------------------------------------------------
		PetriTransition tme = new PetriTransition(pn); // measurement
		tme.TransitionName = "tme";
		tme.InputPlaceName.add("p4"); // 16qbit
		tme.InputPlaceName.add("p_me");
		tme.IsReversible = true;

		Condition TmCt1 = new Condition(tme, "p4", TransitionCondition.NotNull);
		Condition TmCt2 = new Condition(tme, "p_me", TransitionCondition.NotNull);
		TmCt1.SetNextCondition(LogicConnector.AND, TmCt2);

		ArrayList TmeinputList = new ArrayList<String>();
		TmeinputList.add("p4");
		ArrayList TmeConstantList = new ArrayList<String>();
		for (int i = 0; i < 16; i++)
			TmeConstantList.add("I");

		GuardMapping grdTme = new GuardMapping();
		grdTme.condition = TmCt1;
		grdTme.Activations
				.add(new Activation(tme, TmeinputList, TmeConstantList, TransitionOperation.UnitaryMatrixV, "p_m1")); 																					

		tme.GuardMappingList.add(grdTme);

		pn.Transitions.add(tme);

		// t5-----------------------------------------------------
		PetriTransition t5 = new PetriTransition(pn);
		t5.TransitionName = "t5";
		t5.InputPlaceName.add("p4");

		Condition T5Ct1 = new Condition(t5, "p4", TransitionCondition.NotNull);

		GuardMapping grdT5 = new GuardMapping();
		grdT5.condition = T5Ct1;
		grdT5.Activations.add(new Activation(t5, "p4", 0, 8, TransitionOperation.SplitRangeQbit, "p_4s"));//takes the first 8 qbits
		t5.GuardMappingList.add(grdT5);
		pn.Transitions.add(t5);

		// t4 ------------------------------------------------
		PetriTransition t4 = new PetriTransition(pn);
		t4.TransitionName = "t4";
		t4.InputPlaceName.add("p_i_plus");// 8qbit
		t4.InputPlaceName.add("p_4s");// 8qbit

		Condition T4Ct1 = new Condition(t4, "p_i_plus", TransitionCondition.NotNull);
		Condition T4Ct2 = new Condition(t4, "p_4s", TransitionCondition.NotNull);

		T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition = T4Ct1;

		ArrayList T4inputList = new ArrayList<String>();
		T4inputList.add("p_i_plus");
		T4inputList.add("p_4s");
		ArrayList T4ConstantList = new ArrayList<String>();
		for (int i = 0; i < 16; i++)
			T4ConstantList.add("I");

		grdT4.Activations
				.add(new Activation(t4, T4inputList, T4ConstantList, TransitionOperation.UnitaryMatrixV, "p5"));
		t4.GuardMappingList.add(grdT4);

		pn.Transitions.add(t4);

		// ts ------------------------------------------------
		PetriTransition ts = new PetriTransition(pn);
		ts.TransitionName = "ts";
		ts.InputPlaceName.add("p5"); // 16 qbit
		ts.InputPlaceName.add("p_cs"); // 16 qbit

		Condition TsCt1 = new Condition(ts, "p5", TransitionCondition.NotNull);

		GuardMapping grdTs = new GuardMapping();
		grdTs.condition = TsCt1;

		ArrayList TsoutputList = new ArrayList<LaneActivationParameter>();
		TsoutputList.add(new LaneActivationParameter("p5","p_uf", "", ""));
		TsoutputList.add(new LaneActivationParameter("p_cs","p_ur", "", ""));

		// split function
		grdTs.Activations.add(new Activation(ts, TransitionOperation.LaneSplitWithoutOutputThetas, TsoutputList));

		ts.GuardMappingList.add(grdTs);

		pn.Transitions.add(ts);
		
		// tufr ------------------------------------------------
		PetriTransition tufr = new PetriTransition(pn);
		tufr.TransitionName = "tufr";
		tufr.InputPlaceName.add("p_uf");// 16qbit
		tufr.InputPlaceName.add("p_ur");// 16qbit

		Condition TufrCt1 = new Condition(tufr, "p_uf", TransitionCondition.NotNull);
		Condition TufrCt2 = new Condition(tufr, "p_ur", TransitionCondition.NotNull);

		TufrCt1.SetNextCondition(LogicConnector.AND, TufrCt2);

		GuardMapping grdTufr = new GuardMapping();
		grdTufr.condition = TufrCt1;

		ArrayList TufrinputList = new ArrayList<String>();
		TufrinputList.add("p_uf");
		TufrinputList.add("p_ur");
		ArrayList TufrConstantList = new ArrayList<String>();
		for (int i = 0; i < 32; i++)
			TufrConstantList.add("I");

		grdTufr.Activations
						.add(new Activation(tufr, TufrinputList, TufrConstantList, TransitionOperation.UnitaryMatrixV, "p6"));
		tufr.GuardMappingList.add(grdTufr);

		pn.Transitions.add(tufr);

		// tmu ------------------------------------------------
		PetriTransition tmu = new PetriTransition(pn); // measurement
		tmu.TransitionName = "tmu";
		tmu.InputPlaceName.add("p6"); // 32qbit
		tmu.InputPlaceName.add("p_mu");


		Condition TmuCt1 = new Condition(tmu, "p6", TransitionCondition.NotNull);
		Condition TmuCt2 = new Condition(tmu, "p_mu", TransitionCondition.NotNull);
		TmuCt1.SetNextCondition(LogicConnector.AND, TmuCt2);

		ArrayList TmuinputList = new ArrayList<String>();
		TmuinputList.add("p6");
		ArrayList TmuConstantList = new ArrayList<String>();
		for (int i = 0; i < 32; i++)
			TmuConstantList.add("I");

		GuardMapping grdTmu = new GuardMapping();
		grdTmu.condition = TmuCt1;
		grdTmu.Activations
				.add(new Activation(tmu, TmuinputList, TmuConstantList, TransitionOperation.UnitaryMatrixV, "p_m2")); 
		tmu.GuardMappingList.add(grdTmu);

		pn.Transitions.add(tmu);
		
		// Tout ---------------------------------------------																												// 2
		PetriTransition tout = new PetriTransition(pn); // measurement
		tout.TransitionName = "tout";
		tout.InputPlaceName.add("p_m1"); // 16qbit
		tout.InputPlaceName.add("p_m2"); // 32qbit

		Condition ToutCt1 = new Condition(tout, "p_m1", TransitionCondition.NotNull);
		Condition ToutCt2 = new Condition(tout, "p_m2", TransitionCondition.NotNull);
		ToutCt1.SetNextCondition(LogicConnector.AND, ToutCt2);

		ArrayList liststringwithinputplaces = new ArrayList<String>();
		liststringwithinputplaces.add("p_m1");
		liststringwithinputplaces.add("p_m2");
		

		GuardMapping grdTout = new GuardMapping();
		grdTout.condition = ToutCt1;
		grdTout.Activations
		.add(new Activation(tout, liststringwithinputplaces , TransitionOperation.WriteToFile, "D:\\PetriInputData\\uvsOutput.txt")); // the
		tout.GuardMappingList.add(grdTout);
		
		pn.Transitions.add(tout);

		// Start PN----------------------------------------------

		System.out.println("Quantum Split_1 started \n ------------------------------");
		pn.Delay = 10;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}

}
