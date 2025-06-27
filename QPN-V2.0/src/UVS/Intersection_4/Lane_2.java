package UVS.Intersection_4;

import java.util.ArrayList;
import Components.Activation;
import Components.LaneActivationParameter;
import Components.Condition;
import Components.GuardMapping;
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

public class Lane_2 {

	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Lane_2";
		pn.NetworkPort = 4082;
		float Ro = 1 / (float) Math.sqrt(2);

		// -------------Unitary Matrixes----------------

		DataUnitaryThetaMatrix constantValue1 = new DataUnitaryThetaMatrix();
		constantValue1.SetName("Rf");
		constantValue1.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c1"), // theta
																														// f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c1"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c1"), // theta f
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c1"))); // theta f
		pn.ConstantPlaceList.add(constantValue1);

		DataUnitaryThetaMatrix constantValue2 = new DataUnitaryThetaMatrix();
		constantValue2.SetName("Rr");
		constantValue2.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c2"), // theta
																														// r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c2"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c2"), // theta r
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c2"))); // theta r
		pn.ConstantPlaceList.add(constantValue2);

		DataUnitaryThetaMatrix constantValue3 = new DataUnitaryThetaMatrix();
		constantValue3.SetName("Rx");
		constantValue3.SetValue(
				new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c3"), // theta
																														// x
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c3"), // theta x
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c3"), // theta x
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c3"))); // theta x
		pn.ConstantPlaceList.add(constantValue3);

		// ---------------------Places----------------------

		DataQplace p1 = new DataQplace(); // x
		p1.SetName("p1");
		p1.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, Ro), new ComplexValue(0.0f, Ro))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(p1);

		DataQplace p_i1 = new DataQplace(); // ui
		p_i1.SetName("p_i1");
		p_i1.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, Ro), new ComplexValue(0.0f, Ro))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(p_i1);

		DataQplace p_csi = new DataQplace(); // split place for ui
		p_csi.SetName("p_csi1");
		p_csi.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, Ro), new ComplexValue(0.0f, Ro))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(p_csi);

		DataQplace p_f1 = new DataQplace(); // forward to go to the lane
		p_f1.SetName("p_f1");
		pn.PlaceList.add(p_f1);

		DataQplace p_r1 = new DataQplace(); // right to exit from the lane
		p_r1.SetName("p_r1");
		pn.PlaceList.add(p_r1);

		// op channel from p_r1 to another input lane of another intersection

		DataQplace p_i2 = new DataQplace(); // ui_2
		p_i2.SetName("p_i2");
		p_i2.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, Ro), new ComplexValue(0.0f, Ro))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(p_i2);

		DataQplace p_csi2 = new DataQplace(); // split place for ui
		p_csi2.SetName("p_csi2");
		p_csi2.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, Ro), new ComplexValue(0.0f, Ro))),
				QplacePrintSetting.Both));
		pn.ConstantPlaceList.add(p_csi2);

		DataQplace p_r2 = new DataQplace(); // right to go to the lane
		p_r2.SetName("p_r2");
		pn.PlaceList.add(p_r2);

		DataQplace p_f2 = new DataQplace(); // forward to exit from the lane
		p_f2.SetName("p_f2");
		pn.PlaceList.add(p_f2);

		// op channel from p_f2 to another input lane of another intersection

		DataQplace p2 = new DataQplace(); // x'
		p2.SetName("p2");
		pn.PlaceList.add(p2);

		DataQplace p3 = new DataQplace(); // x''
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		DataQplace p4 = new DataQplace(); // e
		p4.SetName("p4");
		pn.PlaceList.add(p4);

		DataTransfer p_o = new DataTransfer();
		p_o.SetName("p_o");
		p_o.Value = new TransferOperation("localhost", "4080", "p_i2");
		pn.PlaceList.add(p_o); // output channel to intersection

		DataQplace p_m = new DataQplace();
		p_m.SetName("p_m");
		pn.PlaceList.add(p_m);

		DataQplace p_c = new DataQplace(); // gamma
		p_c.SetName("p_c");
		p_c.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, Ro), new ComplexValue(0.0f, Ro))),
				QplacePrintSetting.Both));
		pn.ConstantPlaceList.add(p_c);

		DataTheta Th1 = new DataTheta(); // Theta forward
		Th1.SetName("p_c1");
		pn.ConstantPlaceList.add(Th1);

		DataTheta Th2 = new DataTheta(); // Theta right
		Th2.SetName("p_c2");
		pn.ConstantPlaceList.add(Th2);

		DataTheta p_c3 = new DataTheta(); // Theta x
		p_c3.SetName("p_c3");
		p_c3.SetValue(new Theta((float) Math.PI / 4));
		pn.ConstantPlaceList.add(p_c3);

		DataDigital p_cm = new DataDigital(); // Digital place {0, 1}
		p_cm.SetName("p_cm");
		p_cm.SetValue(new Digital(1));
		pn.PlaceList.add(p_cm);
		
		//Lane split output channels
				
				DataTransfer p_f2_o = new DataTransfer();
				p_f2_o.SetName("p_f2_o");
				p_f2_o.Value = new TransferOperation("localhost", "2082", "p_i2");
				pn.PlaceList.add(p_f2_o); 

		// -------------------Transitions----------------------

		// ti ------------------------------------------------
		PetriTransition ti = new PetriTransition(pn);
		ti.TransitionName = "ti";
		ti.InputPlaceName.add("p_i1");
		ti.InputPlaceName.add("p_csi1");

		Condition TiCt1 = new Condition(ti, "p_i1", TransitionCondition.NotNull);
		Condition TiCt2 = new Condition(ti, "p_csi1", TransitionCondition.NotNull);
		TiCt1.SetNextCondition(LogicConnector.AND, TiCt2);

		GuardMapping grdTi = new GuardMapping();
		grdTi.condition = TiCt1;

		ArrayList TioutputList = new ArrayList<LaneActivationParameter>();
		TioutputList.add(new LaneActivationParameter("p_i1","p_f1", "p_c1", "p_c"));
		TioutputList.add(new LaneActivationParameter("p_csi1","p_r1", "p_c2", "p_c"));

		// split function
		grdTi.Activations.add(new Activation(ti, TransitionOperation.LaneSplit, TioutputList));

		ti.GuardMappingList.add(grdTi);

		pn.Transitions.add(ti);

		// ti2 ------------------------------------------------
		PetriTransition ti2 = new PetriTransition(pn);
		ti2.TransitionName = "ti2";
		ti2.InputPlaceName.add("p_i2");
		ti2.InputPlaceName.add("p_csi2");

		Condition Ti2Ct1 = new Condition(ti2, "p_i2", TransitionCondition.NotNull);
		Condition Ti2Ct2 = new Condition(ti2, "p_csi2", TransitionCondition.NotNull);
		Ti2Ct1.SetNextCondition(LogicConnector.AND, Ti2Ct2);

		GuardMapping grdTi2 = new GuardMapping();
		grdTi2.condition = Ti2Ct1;

		ArrayList Ti2outputList = new ArrayList<LaneActivationParameter>();
		Ti2outputList.add(new LaneActivationParameter("p_i2","p_r2", "p_c1", "p_c"));
		Ti2outputList.add(new LaneActivationParameter("p_csi2","p_f2", "p_c2", "p_c"));

		// split function
		grdTi2.Activations.add(new Activation(ti2, TransitionOperation.LaneSplit, Ti2outputList));

		ti2.GuardMappingList.add(grdTi2);

		pn.Transitions.add(ti2);

		// t1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");
		t1.InputPlaceName.add("p_f1");

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "p_f1", TransitionCondition.NotNull);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;

		ArrayList T1inputList = new ArrayList<String>();
		T1inputList.add("p1");
		ArrayList T1ConstantList = new ArrayList<String>();
		T1ConstantList.add("Rf");
		grdT1.Activations
				.add(new Activation(t1, T1inputList, T1ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p2"));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// t2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p2");
		t2.InputPlaceName.add("p_r2");

		Condition T2Ct1 = new Condition(t2, "p2", TransitionCondition.NotNull);
		Condition T2Ct2 = new Condition(t2, "p_r2", TransitionCondition.NotNull);
		T2Ct1.SetNextCondition(LogicConnector.AND, T2Ct2);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;

		ArrayList T2inputList = new ArrayList<String>();
		T2inputList.add("p2");
		ArrayList T2ConstantList = new ArrayList<String>();
		T2ConstantList.add("Rr");

		grdT2.Activations
				.add(new Activation(t2, T2inputList, T2ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p3"));

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);

		// t3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p3");

		Condition T3Ct1 = new Condition(t3, "p3", TransitionCondition.NotNull);

		ArrayList T3inputList = new ArrayList<String>();
		T3inputList.add("p3");
		ArrayList T3ConstantList = new ArrayList<String>();
		T3ConstantList.add("Rx");

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;
		grdT3.Activations
				.add(new Activation(t3, T3inputList, T3ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p4"));

		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);

		// tm ------------------------------------------------
		PetriTransition tm = new PetriTransition(pn); // measurement
		tm.TransitionName = "tm";
		tm.InputPlaceName.add("p4");
		tm.InputPlaceName.add("p_cm");
		tm.IsReversible = true;

		Condition T4Ct1 = new Condition(tm, "p4", TransitionCondition.NotNull);
		Condition T4Ct2 = new Condition(tm, "p_cm", TransitionCondition.NotNull);
		T4Ct1.SetNextCondition(LogicConnector.AND, T4Ct2);

		GuardMapping grdTm = new GuardMapping();
		grdTm.condition = T4Ct1;
		grdTm.Activations.add(new Activation(tm, "p4", TransitionOperation.Measurement, "p_m")); // measurement, the
																									// result is put in
																									// alpha only

		tm.GuardMappingList.add(grdTm);

		pn.Transitions.add(tm);

		// t4 ------------------------------------------------
		PetriTransition t4 = new PetriTransition(pn);
		t4.TransitionName = "t4";
		t4.InputPlaceName.add("p4");

		Condition T5Ct1 = new Condition(t4, "p4", TransitionCondition.NotNull);

		GuardMapping grdT4 = new GuardMapping();
		grdT4.condition = T4Ct1;
		grdT4.Activations.add(new Activation(t4, "p4", TransitionOperation.SendOverNetwork, "p_o"));

		t4.GuardMappingList.add(grdT4);

		pn.Transitions.add(t4);
		
		// toutLanes ------------------------------------------------
		PetriTransition tout = new PetriTransition(pn);
		tout.TransitionName = "tout";
		tout.InputPlaceName.add("p_r1");
		tout.InputPlaceName.add("p_f2");

		Condition ToutCt1 = new Condition(tout, "p_r1", TransitionCondition.NotNull);
		Condition ToutCt2 = new Condition (tout, "p_f2", TransitionCondition.NotNull);
		ToutCt1.SetNextCondition(LogicConnector.AND, ToutCt2);

		GuardMapping grdTout = new GuardMapping();
		grdTout.condition = ToutCt1;
		grdTout.Activations.add(new Activation(tout, "p_f2", TransitionOperation.SendOverNetwork, "p_f2_o"));

		tout.GuardMappingList.add(grdTout);

		pn.Transitions.add(tout);

		// Start PN----------------------------------------------

		System.out.println("Quantum Lane_2_Intersection_4 started \n ------------------------------");
		pn.Delay = 1000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}

}
