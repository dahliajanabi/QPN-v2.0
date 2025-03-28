package test;

import java.util.ArrayList;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataDigital;
import DataObjects.DataQplace;
import DataObjects.DataTheta;
import DataObjects.DataUnitaryMatrix;
import DataObjects.DataUnitaryThetaMatrix;
import DataOnly.ComplexValue;
import DataOnly.Digital;
import DataOnly.Qplace;
import DataOnly.Theta;
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

public class Quantum_Task_V_Level {

	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "One Axis Random Walker";
		pn.NetworkPort = 1080;

		// -------------Unitary Matrixes----------------

		float DivSqurt2 = (float) ((float) 1.0f / Math.sqrt(2));

		DataUnitaryMatrix constantValue1 = new DataUnitaryMatrix();
		constantValue1.SetName("H");
		constantValue1.SetValue(new UnitaryMatrix(2, 2, DivSqurt2, DivSqurt2, DivSqurt2, -DivSqurt2));
		pn.ConstantPlaceList.add(constantValue1);

		DataUnitaryMatrix constantValue2 = new DataUnitaryMatrix();
		constantValue2.SetName("I");
		constantValue2.SetValue(new UnitaryMatrix(2, 2, 1.0f, 0.0f, 0.0f, 1.0f));
		pn.ConstantPlaceList.add(constantValue2);

		DataUnitaryMatrix constantValue3 = new DataUnitaryMatrix();
		constantValue3.SetName("NOT");
		constantValue3.SetValue(new UnitaryMatrix(2, 2, 0.0f, 1.0f, 1.0f, 0.0f));
		pn.ConstantPlaceList.add(constantValue3);

		DataUnitaryThetaMatrix constantValue4 = new DataUnitaryThetaMatrix();
		constantValue4.SetName("U21");
		constantValue4.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c0"), // theta
																														// 1
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c0"), // theta 1
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c0"), // theta 1
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c0"))); // theta 1
		pn.ConstantPlaceList.add(constantValue4);

		DataUnitaryThetaMatrix constantValue5 = new DataUnitaryThetaMatrix();
		constantValue5.SetName("U22");
		constantValue5.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c2"), // theta
																														// 2
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c2"), // theta2
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c2"), // theta 2
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c2"))); // theta 2
		pn.ConstantPlaceList.add(constantValue5);

		// ---------------------Places----------------------

		DataQplace p0 = new DataQplace();
		p0.SetName("p0");
		p0.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));

		pn.PlaceList.add(p0); // Stable Place 2 qubits

		DataQplace p1 = new DataQplace();
		p1.SetName("p1");
		pn.PlaceList.add(p1);

		DataQplace p2 = new DataQplace();
		p2.SetName("p2");
		pn.PlaceList.add(p2);

		DataQplace p3 = new DataQplace();
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		DataQplace p_i = new DataQplace();
		p_i.SetName("p_i");
		p_i.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(p_i);

		DataQplace p_o = new DataQplace();
		p_o.SetName("p_o");
		pn.PlaceList.add(p_o);

		DataQplace p_oIntermediate = new DataQplace();
		p_oIntermediate.SetName("p_oIntermediate");
		pn.PlaceList.add(p_oIntermediate);

		DataQplace p_m = new DataQplace();
		p_m.SetName("p_m");
		pn.PlaceList.add(p_m);

		DataQplace p_mIntermediate = new DataQplace();
		p_mIntermediate.SetName("p_mIntermediate");
		pn.PlaceList.add(p_mIntermediate);

		DataDigital p_cm = new DataDigital(); // Digital place {0, 1}
		p_cm.SetName("p_cm");
		p_cm.SetValue(new Digital(1));
		pn.PlaceList.add(p_cm);

		DataTheta Th1 = new DataTheta(); // Theta 1
		Th1.SetName("p_c0");
		Th1.SetValue(new Theta((float) Math.PI / 4));
		pn.ConstantPlaceList.add(Th1);

		DataTheta Th2 = new DataTheta(); // Theta 2
		Th2.SetName("p_c2");
		Th2.SetValue(new Theta((float) -Math.PI / 4));
		pn.ConstantPlaceList.add(Th2);

		// -------------------Transitions----------------------

		// t0------------------------

		PetriTransition t0 = new PetriTransition(pn);
		t0.TransitionName = "t0";
		t0.InputPlaceName.add("p0");
		//t0.InputPlaceName.add("p_c0");
		t0.IsReversible = true; //the input places will not be null (they stay as they are after the transition is executed)

		Condition T0Ct1 = new Condition(t0, "p0", TransitionCondition.NotNull);
//		Condition T0Ct2 = new Condition(t0, "p_c0", TransitionCondition.NotNull);
//		T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2); // linking the two conditions with AND

		GuardMapping grdT0 = new GuardMapping(); // Creating grd to add the 1st condition and mappings (Activations)
		grdT0.condition = T0Ct1;

		ArrayList T0inputList = new ArrayList<String>(); //creating an arraylist for the input places
		T0inputList.add("p0");
		ArrayList T0ConstantList = new ArrayList<String>(); //creating an arraylist for the unitary matrixes
		T0ConstantList.add("H");
		grdT0.Activations
				.add(new Activation(t0, T0inputList, T0ConstantList, TransitionOperation.UnitaryMatrixV, "p1")); //mapping
		t0.GuardMappingList.add(grdT0); // adding the grd to the transition (the transitions can have more than one grd)

		pn.Transitions.add(t0); // adding the transition to the PN

		// t1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");
		t1.InputPlaceName.add("p_i");

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "p_i", TransitionCondition.NotNull);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;

		ArrayList T1inputList = new ArrayList<String>();
		T1inputList.add("p_i"); //the place and the unitary matirx that is added to the same index are multiplied with each other
		T1inputList.add("p1");
		ArrayList T1ConstantList = new ArrayList<String>();
		T1ConstantList.add("I"); //is multiplied with p_i
		T1ConstantList.add("NOT"); //is multiplied with p1
		grdT1.Activations
				.add(new Activation(t1, T1inputList, T1ConstantList, TransitionOperation.UnitaryMatrixV, "p2"));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// t2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p2");
		//t2.InputPlaceName.add("p_c2");

		Condition T2Ct1 = new Condition(t1, "p2", TransitionCondition.NotNull);
//		Condition T2Ct2 = new Condition(t1, "p_c2", TransitionCondition.NotNull);
//		T2Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;

		ArrayList T2inputList = new ArrayList<String>();
		T2inputList.add("p2");
		ArrayList T2ConstantList = new ArrayList<String>();
		T2ConstantList.add("U21");
		T2ConstantList.add("U22");
		grdT2.Activations
				.add(new Activation(t2, T2inputList, T2ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p3")); //unitary matrix with equations

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);

		// t3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn); // gets 2nd qbit!!!!!!!!!!!
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p3");
		t3.IsReversible = true;

		Condition T3Ct1 = new Condition(t3, "p3", TransitionCondition.NotNull);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;
		grdT3.Activations.add(new Activation(t3, "p3", 1, TransitionOperation.SplitQbit, "p_oIntermediate"));//get the qbit from index 1 (2nd qbit)

		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);

		// t4 ------------------------------------------------
		PetriTransition t4 = new PetriTransition(pn); //extra transition addd after t3 to multiply the split qbit with unitary matrix I
		t4.TransitionName = "t4";
		t4.InputPlaceName.add("p_oIntermediate");
		t4.IsReversible = true;
		Condition T4Ct1 = new Condition(t1, "p_oIntermediate", TransitionCondition.NotNull);

		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition = T4Ct1;

		ArrayList T4inputList = new ArrayList<String>();
		T4inputList.add("p_oIntermediate");
		ArrayList T4ConstantList = new ArrayList<String>();
		T4ConstantList.add("I");

		grdT4.Activations
				.add(new Activation(t4, T4inputList, T4ConstantList, TransitionOperation.UnitaryMatrixV, "p_o"));

		t4.GuardMappingList.add(grdT4);

		pn.Transitions.add(t4);

		// t5 ------------------------------------------------
		PetriTransition t5 = new PetriTransition(pn); // gets 1st qbit!!!!!!!!!!!
		t5.TransitionName = "t5";
		t5.InputPlaceName.add("p3");
		t5.IsReversible = true;

		Condition T5Ct1 = new Condition(t5, "p3", TransitionCondition.NotNull);

		GuardMapping grdT5 = new GuardMapping();
		grdT5.condition = T5Ct1;
		grdT5.Activations.add(new Activation(t5, "p3", 0, TransitionOperation.SplitQbit, "p_mIntermediate")); //gets the qbit in index 0 (the first qbit)

		t5.GuardMappingList.add(grdT5);

		pn.Transitions.add(t5);

		// tm ------------------------------------------------
		PetriTransition tm = new PetriTransition(pn); // measurement of the 1st qbit
		tm.TransitionName = "tm";
		tm.InputPlaceName.add("p_mIntermediate");
		tm.InputPlaceName.add("p_cm");

		Condition TmCt1 = new Condition(tm, "p_mIntermediate", TransitionCondition.NotNull);
		Condition TmCt2 = new Condition(tm, "p_cm", TransitionCondition.NotNull);
		TmCt1.SetNextCondition(LogicConnector.AND, TmCt2);

		GuardMapping grdTm = new GuardMapping();
		grdTm.condition = TmCt1;
		grdTm.Activations.add(new Activation(tm, "p_mIntermediate", TransitionOperation.Measurement,"p_m")); //measurement, the result is put in alpha only

		tm.GuardMappingList.add(grdTm);

		pn.Transitions.add(tm);

		// Start PN----------------------------------------------

		System.out.println("Quantum Task started \n ------------------------------");
		pn.Delay = 1000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}

}
