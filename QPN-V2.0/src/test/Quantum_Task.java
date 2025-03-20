package test;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataDigital;
import DataObjects.DataPsivector;
import DataObjects.DataQplace;
import DataObjects.DataTheta;
import DataObjects.DataUnitaryMatrix;
import DataObjects.DataUnitaryThetaMatrix;
import DataOnly.ComplexValue;
import DataOnly.Psivector;
import DataOnly.Qplace;
import DataOnly.Theta;
import DataOnly.UnitaryMatrix;
import DataOnly.UnitaryThetaMatrix;
import DataOnly.UnitaryThetaMatrixValue;
import Enumerations.LogicConnector;
import Enumerations.QplacePrintSetting;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
import Enumerations.UnitaryThetaMatrixValueFuncType;
import DataOnly.Qplace;

public class Quantum_Task {
	
	public static void main (String [] args) {
		
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "One Axis Random Walker";
		pn.NetworkPort = 1080;
		
		//-------------Unitary Matrixes----------------
		
		float DivSqurt2 = (float) ((float) 1.0f/Math.sqrt(2));

		DataUnitaryMatrix constantValue1 = new DataUnitaryMatrix();
		constantValue1.SetName("H");
		constantValue1.SetValue(new UnitaryMatrix(2, 2,
				DivSqurt2, DivSqurt2, 
				DivSqurt2, -DivSqurt2));
		pn.ConstantPlaceList.add(constantValue1);
		
		DataUnitaryMatrix constantValue2 = new DataUnitaryMatrix();
		constantValue2.SetName("CNOT");
		constantValue2.SetValue(new UnitaryMatrix(4, 4,
				1.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 1.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 1.0f,
				0.0f, 0.0f, 1.0f, 0.0f));
		pn.ConstantPlaceList.add(constantValue2);
		
		DataUnitaryThetaMatrix constantValue3 = new DataUnitaryThetaMatrix();
		constantValue3.SetName("U2");
		constantValue3.SetValue(new UnitaryThetaMatrix(4, 4, 
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c0"), //theta 1
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c0"), //theta 1
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,0.0f),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,0.0f),
				
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c0"), //theta 1
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c0"), //theta 1
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,0.0f),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,0.0f),
				
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,0.0f), //theta 2
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,0.0f), //theta 2
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c2"),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c2"),
				
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,0.0f), //theta 2
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,0.0f), //theta 2
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c2"),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c2")));
		pn.ConstantPlaceList.add(constantValue3);
		
		DataUnitaryMatrix constantValue4 = new DataUnitaryMatrix();
		constantValue4.SetName("I");
		constantValue4.SetValue(new UnitaryMatrix(4, 4,
				1.0f, 0.0f, 0.0f, 0.0f,
				0.0f, 1.0f, 0.0f, 0.0f,
				0.0f, 0.0f, 1.0f, 0.0f,
				0.0f, 0.0f, 0.0f, 1.0f));
		pn.ConstantPlaceList.add(constantValue4);
		
		//---------------------Places----------------------
		
		DataQplace p0 = new DataQplace();
		p0.SetName("p0");
		p0.Value = new Qplace(
				new Psivector(4, new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f), 
				new ComplexValue(0.0f, 0.0f), new ComplexValue(0.0f, 0.0f))
				,QplacePrintSetting.PsiOnly);
			
		pn.ConstantPlaceList.add(p0);  //Stable Place 2 qubits
		
		DataQplace p1 = new DataQplace(); //1 qbit
		p1.SetName("p1");
		pn.PlaceList.add(p1);
		
		DataQplace p2 = new DataQplace(); //2 qbits
		p2.SetName("p2");
		pn.PlaceList.add(p2);
		
		DataQplace p3 = new DataQplace(); //2 qbits
		p3.SetName("p3");
		pn.PlaceList.add(p3);
		
		DataQplace p_i = new DataQplace(); //1 qbit
		p_i.SetName("p_i");
		pn.PlaceList.add(p_i);
		
		DataQplace p_o = new DataQplace(); //1 qbit
		p_o.SetName("p_o");
		pn.PlaceList.add(p_o);
		
		DataQplace p_m = new DataQplace(); //1 qbit
		p_m.SetName("p_m");
		pn.PlaceList.add(p_m);
		
		DataDigital p_cm = new DataDigital();  //Digital place {0, 1}
		p_m.SetName("p_cm");
		pn.PlaceList.add(p_cm);
		
		DataTheta Th1 = new DataTheta(); //Theta 1
		Th1.SetName("p_c0");
		Th1.SetValue(new Theta(45.0f));
		pn.ConstantPlaceList.add(Th1);
		
		DataTheta Th2 = new DataTheta();  //Theta 2
		Th2.SetName("p_c2");
		Th2.SetValue(new Theta(90.0f));
		pn.ConstantPlaceList.add(Th2);
		
		//-------------------Transitions----------------------
		
		//t0------------------------
		
		PetriTransition t0 = new PetriTransition(pn);
		t0.TransitionName = "t0";
		t0.InputPlaceName.add("p0");
		t0.InputPlaceName.add("p_c0");

		Condition T0Ct1 = new Condition(t0, "p0", TransitionCondition.NotNull);
		Condition T0Ct2 = new Condition(t0, "p_c0", TransitionCondition.NotNull);
		T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2); //linking the two conditions with AND

		GuardMapping grdT0 = new GuardMapping(); //Creating grd to add the 1st condition and mappings (Activations)
		grdT0.condition = T0Ct1;
		grdT0.Activations.add(new Activation(t0, "p0", "H", TransitionOperation.UnitaryMatrix, "p1")); //mapping using H matrix

		t0.GuardMappingList.add(grdT0); //adding the grd to the transition (the transitions can have more than one grd)

		pn.Transitions.add(t0); //adding the transition to the PN
		
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
		grdT1.Activations.add(new Activation(t1, "p_i", "p1", "CNOT", TransitionOperation.UnitaryMatrix, "p2"));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);
		
		// t2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p2");
		t2.InputPlaceName.add("p_c2"); 

		Condition T2Ct1 = new Condition(t1, "p2", TransitionCondition.NotNull);
		Condition T2Ct2 = new Condition(t1, "p_c2", TransitionCondition.NotNull);
		T2Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;
		grdT2.Activations.add(new Activation(t2, "p2", "U2", TransitionOperation.ThetaUnitaryMatrix, "p3"));

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);
		
		// t3 ------------------------------------------------
		PetriTransition t3 = new PetriTransition(pn); //gets 1st qbit!!!!!!!!!!!
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("p3");

		Condition T3Ct1 = new Condition(t1, "p3", TransitionCondition.NotNull);

		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;
		grdT3.Activations.add(new Activation(t3, "p3", "I", TransitionOperation.UnitaryMatrix, "p_o"));

		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);
		
		// tm ------------------------------------------------
		PetriTransition tm = new PetriTransition(pn); //gets 1st qbit!!!!!!!!!!!
		tm.TransitionName = "tm";
		tm.InputPlaceName.add("p3");
		tm.InputPlaceName.add("p_cm");

		Condition TmCt1 = new Condition(tm, "p3", TransitionCondition.NotNull);
		Condition TmCt2 = new Condition(tm, "p_cm", TransitionCondition.NotNull);
		TmCt1.SetNextCondition(LogicConnector.AND, TmCt2);

		GuardMapping grdTm = new GuardMapping();
		grdTm.condition = TmCt1;
		//grdTm.Activations.add(new Activation(tm, "p3", TransitionOperation.Move, "p_m")); //measurement!!!!!!!!!

		tm.GuardMappingList.add(grdTm);

		pn.Transitions.add(tm);
		
		//Start PN----------------------------------------------
		
		System.out.println("Quantum Task started \n ------------------------------");
		pn.Delay = 3000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}
	

}
