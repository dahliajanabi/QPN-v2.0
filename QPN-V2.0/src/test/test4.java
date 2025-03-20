package test;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataUnitaryThetaMatrix;
import DataObjects.DataPsivector;
import DataObjects.DataTheta;
import DataOnly.UnitaryMatrix;
import DataOnly.UnitaryThetaMatrix;
import DataOnly.UnitaryThetaMatrixValue;
import DataOnly.ComplexValue;
import DataOnly.Psivector;
import DataOnly.Theta;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;
import Enumerations.UnitaryThetaMatrixValueFuncType;

public class test4 {

	public static void main(String[] args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "QPN";
		pn.NetworkPort = 1080;

		DataUnitaryThetaMatrix constantValue1 = new DataUnitaryThetaMatrix();
		constantValue1.SetName("A12");
		constantValue1.SetValue(new UnitaryThetaMatrix(2, 2, 
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue, 1.0f),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos,"Th"),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin,"Th"),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin,"Th")));
		
		pn.ConstantPlaceList.add(constantValue1);
		
		DataUnitaryThetaMatrix constantValue2 = new DataUnitaryThetaMatrix();
		constantValue2.SetName("A13");
		constantValue2.SetValue(new UnitaryThetaMatrix(2, 2, 
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,2.0f),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,3.0f),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,4.0f),
				new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.ConstantValue,1.0f)));
		pn.ConstantPlaceList.add(constantValue2);
		
		DataPsivector p1 = new DataPsivector();
		p1.SetName("p1");
		p1.Value = new Psivector(2, new ComplexValue(5.0f, 3.0f), new ComplexValue(1.0f, 2.0f));
		pn.PlaceList.add(p1);

		DataPsivector p2 = new DataPsivector();
		p2.SetName("p2");
		pn.PlaceList.add(p2);

		DataPsivector p3 = new DataPsivector();
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		DataTheta Th = new DataTheta();
		Th.SetName("Th");
		Th.SetValue(new Theta(25.0f));
		pn.ConstantPlaceList.add(Th);

		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");
		
		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		
		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;
		grdT1.Activations.add(new Activation(t1, "p1", "Th", "A12", TransitionOperation.ThetaUnitaryMatrix, "p2"));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// T2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p2");

		Condition T2Ct1 = new Condition(t2, "p2", TransitionCondition.NotNull);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;
		grdT2.Activations.add(new Activation(t2, "p2", "Th", "A13", TransitionOperation.ThetaUnitaryMatrix, "p3"));

		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);

		System.out.println("Exp1 started \n ------------------------------");
		pn.Delay = 3000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);
	}

}
