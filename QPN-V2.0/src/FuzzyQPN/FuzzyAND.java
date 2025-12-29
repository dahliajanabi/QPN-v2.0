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

public class FuzzyAND {
	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Quantum Task";
		pn.NetworkPort = 1080;
		
		float v = (float) (Math.sqrt(2)/2);
		// ---------------------Places----------------------

		DataQplace p1 = new DataQplace(); // v
		p1.SetName("p1");
		p1.SetValue(new Qplace(
				new Vvector(1, new QBit(new ComplexValue(v, v), new ComplexValue(v,v))),
				QplacePrintSetting.Both));

		pn.PlaceList.add(p1);

		DataQplace p2 = new DataQplace(); 
		p2.SetName("p2");
		p2.SetValue(new Qplace(
				new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
				QplacePrintSetting.Both)); //A0
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(0.1f, 0.0f), new ComplexValue(1.0f, 0.0f))),
//				QplacePrintSetting.Both)); //A1
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 1.0f))),
//				QplacePrintSetting.Both)); //A2
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(0.0f, 1.0f), new ComplexValue(0.0f, 1.0f))),
//				QplacePrintSetting.Both)); //A3
		pn.PlaceList.add(p2);
		
		DataQplace p3 = new DataQplace(); //result
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		// -------------------Transitions----------------------

		// t0------------------------

		PetriTransition t0 = new PetriTransition(pn);
		t0.TransitionName = "t0";
		t0.InputPlaceName.add("p1");
		t0.InputPlaceName.add("p2");

		Condition T0Ct1 = new Condition(t0, "p1", TransitionCondition.NotNull);
		Condition T0Ct2 = new Condition(t0, "p2", TransitionCondition.NotNull);
		T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2);
		GuardMapping grdT0 = new GuardMapping();
		grdT0.condition = T0Ct1;
		
		ArrayList <String> input0 = new ArrayList<String>();
		input0.add("p1");
		input0.add("p2");

		grdT0.Activations
				.add(new Activation(t0, input0, TransitionOperation.FuzzyAND, "p3"));
		t0.GuardMappingList.add(grdT0);

		pn.Transitions.add(t0);

		// Start PN----------------------------------------------

		System.out.println("Quantum Task started \n ------------------------------");
		pn.Delay = 1000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}

}
