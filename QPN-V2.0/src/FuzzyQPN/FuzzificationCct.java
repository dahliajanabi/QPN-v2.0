package FuzzyQPN;

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
import DataOnly.Psivector;
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

public class FuzzificationCct {

	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Quantum Task";
		pn.NetworkPort = 1080;

		// -------------Unitary Matrixes----------------

		DataUnitaryMatrix constantValue3 = new DataUnitaryMatrix();
		constantValue3.SetName("Toffoli");
		constantValue3.SetValue(new UnitaryMatrix(4, 4, 1.0f, 0.0f, 0.0f, 0.0f,
													   0.0f, 1.0f, 0.0f, 0.0f,
													   0.0f, 0.0f, 0.0f, 1.0f,
													   0.0f, 0.0f, 1.0f, 0.0f));
		pn.ConstantPlaceList.add(constantValue3);
		
		
		DataUnitaryThetaMatrix constantValue4 = new DataUnitaryThetaMatrix();
		constantValue4.SetName("K");
		constantValue4.SetValue(
				new UnitaryThetaMatrix(4, 4, 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c0"), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c0"), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue, 0.0f), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue, 0.0f),
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c0"), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c0"),
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue, 0.0f), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue, 0.0f),
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue, 0.0f), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue, 0.0f),
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c0"), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "p_c0"), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue, 0.0f), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue, 0.0f),
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "p_c0"), 
						new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "p_c0")
						)); 
		
		
		pn.ConstantPlaceList.add(constantValue4);

	
		// ---------------------Places----------------------

		DataQplace p1 = new DataQplace(); //add only 2 qbits here
		p1.SetName("p1");
		p1.SetValue(new Qplace(new Vvector (2, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f)), 
				new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f))),
				QplacePrintSetting.Both));

		pn.PlaceList.add(p1); 
		
		DataQplace p1Psi = new DataQplace(); //add only 2 qbits here
		p1Psi.SetName("p1Psi");
		p1Psi.SetValue (new Qplace(
				new Psivector(p1.Value.V.GetPsi()),QplacePrintSetting.PsiOnly));
		pn.PlaceList.add(p1Psi); 

		DataQplace p2 = new DataQplace(); //A1
		p2.SetName("p2");
		p2.SetValue(new Qplace(new Vvector (2, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 0.0f)), 
				new QBit(new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
				QplacePrintSetting.Both));
		pn.PlaceList.add(p2);
		
		DataQplace p2Psi = new DataQplace(); //add only 2 qbits here
		p2Psi.SetName("p2Psi");
		p2Psi.SetValue (new Qplace(
				new Psivector(p2.Value.V.GetPsi()),QplacePrintSetting.PsiOnly));
		pn.PlaceList.add(p2Psi); 
		
		DataQplace p3 = new DataQplace(); //miu prime
		p3.SetName("p3");
		pn.PlaceList.add(p3);
		
		DataQplace p4= new DataQplace(); //miu corrected
		p4.SetName("p4");
		pn.PlaceList.add(p4);

		DataTheta Th1 = new DataTheta(); // Theta 1 //take the info of q3?
		Th1.SetName("p_c0");
		Th1.SetValue(new Theta((float) Math.PI / 4));
		pn.ConstantPlaceList.add(Th1);


		// -------------------Transitions----------------------

		// t0------------------------

		PetriTransition t0 = new PetriTransition(pn);
		t0.TransitionName = "t0";
		t0.InputPlaceName.add("p1Psi");
		t0.InputPlaceName.add("p2Psi");
		

		Condition T0Ct1 = new Condition(t0, "p1Psi", TransitionCondition.NotNull);
		Condition T0Ct2 = new Condition(t0, "p2Psi", TransitionCondition.NotNull);
		T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2); 
		GuardMapping grdT0 = new GuardMapping(); 
		grdT0.condition = T0Ct1;
		
		grdT0.Activations.add(new Activation(t0,"p1Psi","p2Psi", "Toffoli", TransitionOperation.UnitaryMatrixJoin2by1, "p3")); 
		t0.GuardMappingList.add(grdT0); 

		pn.Transitions.add(t0); 

		// t1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p3");

		Condition T1Ct1 = new Condition(t1, "p3", TransitionCondition.NotNull);
		

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;

		grdT1.Activations.add(new Activation(t1, "p3", "K", TransitionOperation.UnitaryMatrix, "p4"));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// Start PN----------------------------------------------

		System.out.println("Quantum Task started \n ------------------------------");
		pn.Delay = 1000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}

}
