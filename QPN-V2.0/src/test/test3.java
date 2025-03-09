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
import DataOnly.Psivector;
import DataOnly.QBit;
import DataOnly.Vvector;
import Enumerations.LogicConnector;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class test3 {
	public static void main(String[] args) {

		Vvector v = new Vvector(2, new QBit(new ComplexValue(3f, 2f), new ComplexValue(3f, 2f)),
				new QBit(new ComplexValue(3f, 2f), new ComplexValue(3f, 2f)));

		Psivector p= v.GetPsi();
		
		String s= p.toString(true);
	}
}
