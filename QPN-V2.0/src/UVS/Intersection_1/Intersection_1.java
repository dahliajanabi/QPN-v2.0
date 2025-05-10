package UVS.Intersection_1;

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

public class Intersection_1 {

	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Intersection_1";
		pn.NetworkPort = 1080;

		// -------------Unitary Matrixes----------------
		// RF matrixes-----------------------------------
		DataUnitaryThetaMatrix constantValue11 = new DataUnitaryThetaMatrix();
		constantValue11.SetName("Rf1");
		constantValue11.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c11"), // theta
																														// f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c11"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c11"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c11"))); // theta f
		pn.ConstantPlaceList.add(constantValue11);

		DataUnitaryThetaMatrix constantValue12 = new DataUnitaryThetaMatrix();
		constantValue12.SetName("Rf2");
		constantValue12.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c12"), // theta
																														// f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c12"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c12"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c12"))); // theta f
		pn.ConstantPlaceList.add(constantValue12);

		DataUnitaryThetaMatrix constantValue13 = new DataUnitaryThetaMatrix();
		constantValue13.SetName("Rf3");
		constantValue13.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c13"), // theta
																														// f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c13"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c13"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c13"))); // theta f
		pn.ConstantPlaceList.add(constantValue13);

		DataUnitaryThetaMatrix constantValue14 = new DataUnitaryThetaMatrix();
		constantValue14.SetName("Rf4");
		constantValue14.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c14"), // theta
																														// f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c14"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c14"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c14"))); // theta f
		pn.ConstantPlaceList.add(constantValue14);

		// Rr matrixes-------------------------------------
		DataUnitaryThetaMatrix constantValue21 = new DataUnitaryThetaMatrix();
		constantValue21.SetName("Rr1");
		constantValue21.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c21"), // theta
																														// r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c21"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c21"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c21"))); // theta r
		pn.ConstantPlaceList.add(constantValue21);

		DataUnitaryThetaMatrix constantValue22 = new DataUnitaryThetaMatrix();
		constantValue22.SetName("Rr2");
		constantValue22.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c22"), // theta
																														// r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c22"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c22"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c22"))); // theta r
		pn.ConstantPlaceList.add(constantValue22);

		DataUnitaryThetaMatrix constantValue23 = new DataUnitaryThetaMatrix();
		constantValue23.SetName("Rr3");
		constantValue23.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c23"), // theta
																														// r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c23"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c23"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c23"))); // theta r
		pn.ConstantPlaceList.add(constantValue23);

		DataUnitaryThetaMatrix constantValue24 = new DataUnitaryThetaMatrix();
		constantValue24.SetName("Rr4");
		constantValue24.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c24"), // theta
																														// r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c24"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c24"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c24"))); // theta r
		pn.ConstantPlaceList.add(constantValue24);

		DataUnitaryMatrix constantValue3 = new DataUnitaryMatrix();
		constantValue3.SetName("I");
		constantValue3.SetValue(new UnitaryMatrix(2, 2, 1.0f, 0.0f, 0.0f, 1.0f));
		pn.ConstantPlaceList.add(constantValue3);

		// ---------------------Places----------------------

		DataQplace pi1 = new DataQplace(); // input form lane 1 (1 qbit)
		pi1.SetName("p_i1");
		pi1.SetValue(new Qplace(
				new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(pi1);

		DataQplace pi2 = new DataQplace(); // input from lane 2 (1 qbit)
		pi2.SetName("p_i2");
		pi2.SetValue(new Qplace(
				new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(pi2);

		DataQplace pi3 = new DataQplace(); // input from lane 3 (1 qbit)
		pi3.SetName("p_i3");
		pi3.SetValue(new Qplace(
				new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(pi3);

		DataQplace pi4 = new DataQplace(); // input from lane 4 (1 qbit)
		pi4.SetName("p_i4");
		pi4.SetValue(new Qplace(
				new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(pi4);

		DataQplace p0 = new DataQplace(); // current state of all lanes
		p0.SetName("p0");
		p0.SetValue(new Qplace(
				new Vvector(4, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
						new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
						new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
						new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(p0);

		DataQplace p1 = new DataQplace(); // U*
		p1.SetName("p1");
		pn.PlaceList.add(p1);

		DataQplace p2 = new DataQplace(); // x
		p2.SetName("p2");
		pn.PlaceList.add(p2);

		DataQplace p3 = new DataQplace(); // U'
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		DataQplace p4 = new DataQplace(); // x'
		p4.SetName("p4");
		pn.PlaceList.add(p4);

		DataQplace p5 = new DataQplace(); // x''
		p5.SetName("p5");
		pn.PlaceList.add(p5);

		DataQplace p6 = new DataQplace(); // E
		p6.SetName("p6");
		pn.PlaceList.add(p6);

		DataQplace pe = new DataQplace(); // Em
		pe.SetName("p_e");
		pn.PlaceList.add(pe);

		DataDigital pc0 = new DataDigital();
		pc0.SetName("p_c0");
		pc0.SetValue(new Digital(1));
		pn.PlaceList.add(pc0);

		DataQplace pc1 = new DataQplace(); // S (4 qbits)
		pc1.SetName("p_c1");
		pc1.SetValue(new Qplace(
				new Vvector(4, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
						new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
						new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f)),
						new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.ConstantPlaceList.add(pc1);

		DataQplace pc2 = new DataQplace(); // Gamma 1
		pc2.SetName("p_c2");
		pc2.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.ConstantPlaceList.add(pc2);

		DataQplace pc3 = new DataQplace(); // Gamma 2
		pc3.SetName("p_c3");
		pc3.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.ConstantPlaceList.add(pc3);

		DataDigital pc4 = new DataDigital();
		pc4.SetName("p_c4");
		pc4.SetValue(new Digital(1));
		pn.PlaceList.add(pc4);

		DataDigital pcm = new DataDigital();
		pcm.SetName("p_cm");
		pcm.SetValue(new Digital(1));
		pn.PlaceList.add(pcm);

		DataQplace po = new DataQplace();
		po.SetName("p_o");
		pn.PlaceList.add(po);

		// split places
		DataQplace ps1 = new DataQplace();
		ps1.SetName("p_s1");
		pn.PlaceList.add(ps1);

		DataQplace ps2 = new DataQplace();
		ps2.SetName("p_s2");
		pn.PlaceList.add(ps2);

		DataQplace ps3 = new DataQplace();
		ps3.SetName("p_s3");
		pn.PlaceList.add(ps3);

		DataQplace ps4 = new DataQplace();
		ps4.SetName("p_s4");
		pn.PlaceList.add(ps4);

		// op channels to other lanes in other intersections
		DataTransfer p_o1_out = new DataTransfer();
		p_o1_out.SetName("p_o1_out");
		p_o1_out.Value = new TransferOperation("localhost", "3084", "p_i1"); // to intersection 3 lane 4
		pn.PlaceList.add(p_o1_out);

		DataTransfer p_o2_out = new DataTransfer();
		p_o2_out.SetName("p_o2_out");
		p_o2_out.Value = new TransferOperation("localhost", "2081", "p_i1"); // to intersection 2 lane 1
		pn.PlaceList.add(p_o2_out);

		// ------------Theta Values---------------------------
		// Theta forward---------------------------------------
		DataTheta Th11 = new DataTheta();
		Th11.SetName("p_c11");
		pn.ConstantPlaceList.add(Th11);

		DataTheta Th12 = new DataTheta();
		Th12.SetName("p_c12");
		pn.ConstantPlaceList.add(Th12);

		DataTheta Th13 = new DataTheta();
		Th13.SetName("p_c13");
		pn.ConstantPlaceList.add(Th13);

		DataTheta Th14 = new DataTheta();
		Th14.SetName("p_c14");
		pn.ConstantPlaceList.add(Th14);

		// Theta right-----------------------------------------
		DataTheta Th21 = new DataTheta();
		Th21.SetName("p_c21");
		pn.ConstantPlaceList.add(Th21);

		DataTheta Th22 = new DataTheta();
		Th22.SetName("p_c22");
		pn.ConstantPlaceList.add(Th22);

		DataTheta Th23 = new DataTheta();
		Th23.SetName("p_c23");
		pn.ConstantPlaceList.add(Th23);

		DataTheta Th24 = new DataTheta();
		Th24.SetName("p_c24");
		pn.ConstantPlaceList.add(Th24);

		// -------------------Transitions----------------------

		// ti ------------------------------------------------
		PetriTransition ti = new PetriTransition(pn);
		ti.TransitionName = "ti";
		ti.InputPlaceName.add("p_i1");// 1qbit
		ti.InputPlaceName.add("p_i2");// 1qbit
		ti.InputPlaceName.add("p_i3");// 1qbit
		ti.InputPlaceName.add("p_i4");// 1qbit
		//ti.InputPlaceName.add("p_c1");// 4qbit

		Condition TiCt1 = new Condition(ti, "p_i1", TransitionCondition.NotNull);
		Condition TiCt2 = new Condition(ti, "p_i2", TransitionCondition.NotNull);
		Condition TiCt3 = new Condition(ti, "p_i3", TransitionCondition.NotNull);
		Condition TiCt4 = new Condition(ti, "p_i4", TransitionCondition.NotNull);
		Condition TiCt5 = new Condition(ti, "p_c1", TransitionCondition.NotNull);
		TiCt4.SetNextCondition(LogicConnector.AND, TiCt5);
		TiCt3.SetNextCondition(LogicConnector.AND, TiCt4);
		TiCt2.SetNextCondition(LogicConnector.AND, TiCt3);
		TiCt1.SetNextCondition(LogicConnector.AND, TiCt2);

		GuardMapping grdTi = new GuardMapping();
		grdTi.condition = TiCt1;

		IntersectionActivationParameter param = new IntersectionActivationParameter();
		param.QbitU1 = "p_i1";
		param.QbitU2 = "p_i2";
		param.QbitU3 = "p_i3";
		param.QbitU4 = "p_i4";
		param.QbitSList = "p_c1";
		param.QbitGammaName1 = "p_c2";
		param.QbitGammaName2 = "p_c3";
		param.QbitLaneName1 = "p1";
		param.QbitLaneName2 = "p3";
		param.ThetaConstantNames = new ArrayList<String>();
		param.ThetaConstantNames.add("p_c11");
		param.ThetaConstantNames.add("p_c12");
		param.ThetaConstantNames.add("p_c13");
		param.ThetaConstantNames.add("p_c14");
		param.ThetaConstantNames.add("p_c21");
		param.ThetaConstantNames.add("p_c22");
		param.ThetaConstantNames.add("p_c23");
		param.ThetaConstantNames.add("p_c24");
		// split function
		grdTi.Activations.add(new Activation(ti, TransitionOperation.IntersectionSplit, param));
		ti.GuardMappingList.add(grdTi);

		pn.Transitions.add(ti);

		// t0 ------------------------------------------------
		PetriTransition t0 = new PetriTransition(pn);
		t0.TransitionName = "t0";
		t0.InputPlaceName.add("p0");
		//t0.InputPlaceName.add("p_c0");

		Condition T0Ct1 = new Condition(t0, "p0", TransitionCondition.NotNull);
		Condition T0Ct2 = new Condition(t0, "p_c0", TransitionCondition.NotNull);
		T0Ct2.SetNextCondition(LogicConnector.AND, T0Ct2);

		GuardMapping grdT0 = new GuardMapping();
		grdT0.condition = T0Ct1;

		ArrayList T0inputList = new ArrayList<String>();
		T0inputList.add("p0");
		ArrayList T0ConstantList = new ArrayList<String>();
		T0ConstantList.add("I");
		T0ConstantList.add("I");
		T0ConstantList.add("I");
		T0ConstantList.add("I");
		
		grdT0.Activations
				.add(new Activation(t0, T0inputList, T0ConstantList, TransitionOperation.UnitaryMatrixV, "p2"));
		t0.GuardMappingList.add(grdT0);

		pn.Transitions.add(t0);

		// t1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1"); // 4 qbit
		t1.InputPlaceName.add("p2"); // 4 qbit

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "p2", TransitionCondition.NotNull);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;

		ArrayList T1inputList = new ArrayList<String>();
		T1inputList.add("p2");

		ArrayList T1ConstantList = new ArrayList<String>();
		T1ConstantList.add("Rf1");
		T1ConstantList.add("Rf2");
		T1ConstantList.add("Rf3");
		T1ConstantList.add("Rf4");

		grdT1.Activations
				.add(new Activation(t1, T1inputList, T1ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p4"));
		// move 2nd 4 qbits from p1 to p3
		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// t2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p3"); // 4 qbit the unused from p1
		t2.InputPlaceName.add("p4"); // 4 qbit

		Condition T2Ct1 = new Condition(t2, "p3", TransitionCondition.NotNull);
		Condition T2Ct2 = new Condition(t2, "p4", TransitionCondition.NotNull);
		T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;

		ArrayList T2inputList = new ArrayList<String>();
		T2inputList.add("p4");
		ArrayList T2ConstantList = new ArrayList<String>();
		T2ConstantList.add("Rr1");
		T2ConstantList.add("Rr2");
		T2ConstantList.add("Rr3");
		T2ConstantList.add("Rr4");

		grdT2.Activations
				.add(new Activation(t2, T2inputList, T2ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p5")); 

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);

		// t3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p5"); // 4 qbit
		t3.InputPlaceName.add("p_c4");

		Condition T3Ct1 = new Condition(t3, "p5", TransitionCondition.NotNull);
		Condition T3Ct2 = new Condition(t3, "p_c4", TransitionCondition.NotNull);
		T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;

		ArrayList T3inputList = new ArrayList<String>();
		T3inputList.add("p5");
		ArrayList T3ConstantList = new ArrayList<String>();
		T3ConstantList.add("I");
		T3ConstantList.add("I");
		T3ConstantList.add("I");
		T3ConstantList.add("I");

		grdT3.Activations
				.add(new Activation(t3, T3inputList, T3ConstantList, TransitionOperation.UnitaryMatrixV, "p6"));

		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);

		// tm ------------------------------------------------
		PetriTransition tm = new PetriTransition(pn); // measurement
		tm.TransitionName = "tm";
		tm.InputPlaceName.add("p6"); // 4qbit
		tm.InputPlaceName.add("p_cm");
		tm.IsReversible = true;

		Condition TmCt1 = new Condition(tm, "p6", TransitionCondition.NotNull);
		Condition TmCt2 = new Condition(tm, "p_cm", TransitionCondition.NotNull);
		TmCt1.SetNextCondition(LogicConnector.AND, TmCt2);

		GuardMapping grdTm = new GuardMapping();
		grdTm.condition = TmCt1;
		grdTm.Activations.add(new Activation(tm, "p6", TransitionOperation.Measurement, "p_e")); // measurement, the
																									// result is put in
																									// alpha only

		tm.GuardMappingList.add(grdTm);

		pn.Transitions.add(tm);

		// t4 ------------------------------------------------
		PetriTransition t4 = new PetriTransition(pn);
		t4.TransitionName = "t4";
		t4.InputPlaceName.add("p6"); // 4 qbit

		Condition T4Ct1 = new Condition(t4, "p6", TransitionCondition.NotNull);

		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition = T4Ct1;

		ArrayList T4inputList = new ArrayList<String>();
		T4inputList.add("p6");
		ArrayList T4ConstantList = new ArrayList<String>();
		T4ConstantList.add("I");
		T4ConstantList.add("I");
		T4ConstantList.add("I");
		T4ConstantList.add("I");

		grdT4.Activations
				.add(new Activation(t4, T4inputList, T4ConstantList, TransitionOperation.UnitaryMatrixV, "p_o"));

		t4.GuardMappingList.add(grdT4);

		pn.Transitions.add(t4);

		// t4 split-----------------------------------------------------
		PetriTransition t4split = new PetriTransition(pn);
		t4split.TransitionName = "t4split";
		t4split.InputPlaceName.add("p_o");

		Condition T4sCt1 = new Condition(t4split, "p_o", TransitionCondition.NotNull);

		GuardMapping grdT4s = new GuardMapping();
		grdT4s.condition = T4sCt1;

		grdT4s.Activations.add(new Activation(t4split, "p_o", 0, TransitionOperation.SplitQbit, "P_s1"));
		grdT4s.Activations.add(new Activation(t4split, "p_o", 1, TransitionOperation.SplitQbit, "P_s2"));
		grdT4s.Activations.add(new Activation(t4split, "p_o", 2, TransitionOperation.SplitQbit, "P_s3"));
		grdT4s.Activations.add(new Activation(t4split, "p_o", 3, TransitionOperation.SplitQbit, "P_s4"));

		pn.Transitions.add(t4split);

		// t4 out-----------------------------------------------------
		PetriTransition t4out = new PetriTransition(pn); 
		t4out.TransitionName = "t4out";
		t4out.InputPlaceName.add("p_s1");
		t4out.InputPlaceName.add("p_s2");
		t4out.InputPlaceName.add("p_s3");
		t4out.InputPlaceName.add("p_s4");

		Condition T4outCt1 = new Condition(t4, "p_s1", TransitionCondition.NotNull);
		Condition T4outCt2 = new Condition(t4, "p_s2", TransitionCondition.NotNull);
		Condition T4outCt3 = new Condition(t4, "p_s3", TransitionCondition.NotNull);
		Condition T4outCt4 = new Condition(t4, "p_s4", TransitionCondition.NotNull);
		T4outCt3.SetNextCondition(LogicConnector.AND, T4outCt4);
		T4outCt2.SetNextCondition(LogicConnector.AND, T4outCt3);
		T4outCt1.SetNextCondition(LogicConnector.AND, T4outCt2);

		GuardMapping grdT4out = new GuardMapping();
		grdT4out.condition = T4outCt1;

		grdT4out.Activations.add(new Activation(t4out, "P_s2",TransitionOperation.SendOverNetwork, "p_o1_out"));  
		grdT4out.Activations.add(new Activation(t4out, "P_s3",TransitionOperation.SendOverNetwork, "p_o2_out"));  

		// the two other outputs are just exits from model (consumed)

		// Start PN----------------------------------------------

		System.out.println("Quantum Split_1 started \n ------------------------------");
		pn.Delay = 1000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}

}
