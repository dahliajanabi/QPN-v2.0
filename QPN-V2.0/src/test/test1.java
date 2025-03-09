package test;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataArcMatrix;
import DataObjects.DataComplexVector;
import DataOnly.ArcMatrix;
import DataOnly.ComplexValue;
import DataOnly.ComplexVector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class test1 {

	public static void main(String[] args) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = "QPN";
		pn.NetworkPort = 1080;

		DataArcMatrix constantValue1 = new DataArcMatrix();
		constantValue1.SetName("A12");
		constantValue1.SetValue(new ArcMatrix(2, 2, 1.0f, 5.0f, 3.0f, 2.0f));
		pn.ConstantPlaceList.add(constantValue1);

		DataArcMatrix constantValue2 = new DataArcMatrix();
		constantValue2.SetName("A13");
		constantValue2.SetValue(new ArcMatrix(2, 2, 2.0f, 3.0f, 4.0f, 1.0f));
		pn.ConstantPlaceList.add(constantValue2);

		DataComplexVector p1 = new DataComplexVector();
		p1.SetName("p1");
		p1.Value = new ComplexVector(2, new ComplexValue(5.0f, 3.0f), new ComplexValue(1.0f, 2.0f));
		pn.PlaceList.add(p1);

		DataComplexVector p2 = new DataComplexVector();
		p2.SetName("p2");
		pn.PlaceList.add(p2);

		DataComplexVector p3 = new DataComplexVector();
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		// T1 ------------------------------------------------
		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);

		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;
		grdT1.Activations.add(new Activation(t1, "p1", "A12", TransitionOperation.UnitaryMatrix, "p2"));

		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// T2 ------------------------------------------------
		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p1");

		Condition T2Ct1 = new Condition(t2, "p1", TransitionCondition.NotNull);

		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;
		grdT2.Activations.add(new Activation(t2,"p1", "A13", TransitionOperation.UnitaryMatrix, "p3"));

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
