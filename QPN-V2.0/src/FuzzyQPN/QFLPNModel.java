package FuzzyQPN;

import java.util.ArrayList;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriNetWindow;
import Components.PetriTransition;
import DataObjects.DataQplace;
import DataOnly.ComplexValue;
import DataOnly.FV;
import DataOnly.QBit;
import DataOnly.QFLRS;
import DataOnly.Qplace;
import DataOnly.Vvector;
import Enumerations.FZ;
import Enumerations.LogicConnector;
import Enumerations.QplacePrintSetting;
import Enumerations.TransitionCondition;
import Enumerations.TransitionOperation;

public class QFLPNModel {
	public static void main(String[] args) {

		PetriNet pn = new PetriNet();
		pn.PetriNetName = "Quantum Task";
		pn.NetworkPort = 1080;

		// ----------------------Constants------------------
		float v = (float) (Math.sqrt(2) / 2);

		QFLRS QFLRS1 = new QFLRS(new FV(FZ.A1), new FV(FZ.A1), new FV(FZ.A1), new FV(FZ.A1), new FV(FZ.A1),
				new FV(FZ.A2), new FV(FZ.A2), new FV(FZ.A3), new FV(FZ.A1), new FV(FZ.A2), new FV(FZ.A3), new FV(FZ.A3),
				new FV(FZ.A4), new FV(FZ.A4), new FV(FZ.A4), new FV(FZ.A4));

		QFLRS QFLRS2 = new QFLRS(new FV(FZ.A4), new FV(FZ.A3), new FV(FZ.A2), new FV(FZ.A1));

		QFLRS QFLRS3 = new QFLRS(new FV(FZ.A3), new FV(FZ.A3), new FV(FZ.A1), new FV(FZ.A1), new FV(FZ.A2),
				new FV(FZ.A2), new FV(FZ.A2), new FV(FZ.A2), new FV(FZ.A2), new FV(FZ.A3), new FV(FZ.A3), new FV(FZ.A1),
				new FV(FZ.A1), new FV(FZ.A1), new FV(FZ.A1), new FV(FZ.A1));

		QFLRS1.Print();
		QFLRS2.Print();
		QFLRS3.Print();

		// ---------------------Places----------------------

		DataQplace pieb = new DataQplace(); // v 2 qbit
		pieb.SetName("pieb");
		pieb.SetValue(new Qplace(new Vvector(2, new QBit(new ComplexValue(v, v), new ComplexValue(v, v)),
				new QBit(new ComplexValue(v, v), new ComplexValue(v, v))), QplacePrintSetting.Both));

		pn.PlaceList.add(pieb);

		DataQplace Aeb = new DataQplace();
		Aeb.SetName("Aeb");
		Aeb.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
				QplacePrintSetting.Both)); // A0
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(0.1f, 0.0f), new ComplexValue(1.0f, 0.0f))),
//				QplacePrintSetting.Both)); //A1
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 1.0f))),
//				QplacePrintSetting.Both)); //A2
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(0.0f, 1.0f), new ComplexValue(0.0f, 1.0f))),
//				QplacePrintSetting.Both)); //A3
		pn.PlaceList.add(Aeb);

		DataQplace p1 = new DataQplace(); // eb
		p1.SetName("p1");
		pn.PlaceList.add(p1);

		DataQplace piPb = new DataQplace(); // v 2 qbit
		piPb.SetName("piPb");
		piPb.SetValue(new Qplace(new Vvector(2, new QBit(new ComplexValue(v, v), new ComplexValue(v, v)),
				new QBit(new ComplexValue(v, v), new ComplexValue(v, v))), QplacePrintSetting.Both));

		pn.PlaceList.add(piPb);

		DataQplace APb = new DataQplace();
		APb.SetName("APb");
		APb.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
				QplacePrintSetting.Both)); // A0
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(0.1f, 0.0f), new ComplexValue(1.0f, 0.0f))),
//				QplacePrintSetting.Both)); //A1
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 1.0f))),
//				QplacePrintSetting.Both)); //A2
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(0.0f, 1.0f), new ComplexValue(0.0f, 1.0f))),
//				QplacePrintSetting.Both)); //A3
		pn.PlaceList.add(APb);

		DataQplace p2 = new DataQplace(); // Pb
		p2.SetName("p2");
		pn.PlaceList.add(p2);

		DataQplace pi3 = new DataQplace(); // v 2 qbit
		pi3.SetName("pi3");
		pi3.SetValue(new Qplace(new Vvector(2, new QBit(new ComplexValue(v, v), new ComplexValue(v, v)),
				new QBit(new ComplexValue(v, v), new ComplexValue(v, v))), QplacePrintSetting.Both));

		pn.PlaceList.add(pi3);

		DataQplace Ai3 = new DataQplace();
		Ai3.SetName("Ai3");
		Ai3.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
				QplacePrintSetting.Both)); // A0
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(0.1f, 0.0f), new ComplexValue(1.0f, 0.0f))),
//				QplacePrintSetting.Both)); //A1
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(1.0f, 0.0f), new ComplexValue(0.0f, 1.0f))),
//				QplacePrintSetting.Both)); //A2
//		p2.SetValue(new Qplace(
//				new Vvector(1, new QBit(new ComplexValue(0.0f, 1.0f), new ComplexValue(0.0f, 1.0f))),
//				QplacePrintSetting.Both)); //A3
		pn.PlaceList.add(Ai3);

		DataQplace p3 = new DataQplace(); // p1 Psi3
		p3.SetName("p3");
		pn.PlaceList.add(p3);

		DataQplace ur1 = new DataQplace(); // ur1
		ur1.SetName("ur1");
		pn.PlaceList.add(ur1);

		DataQplace ur2 = new DataQplace(); // ur2
		ur2.SetName("ur2");
		pn.PlaceList.add(ur2);

		DataQplace ccd = new DataQplace(); // ccd
		ccd.SetName("ccd");
		pn.PlaceList.add(ccd);

		// -------------------Transitions----------------------

		// tieb------------------------

		PetriTransition tieb = new PetriTransition(pn);
		tieb.TransitionName = "tieb";
		tieb.InputPlaceName.add("pieb");
		tieb.InputPlaceName.add("Aeb");

		Condition TiebCt1 = new Condition(tieb, "pieb", TransitionCondition.NotNull);
		Condition TiebCt2 = new Condition(tieb, "Aeb", TransitionCondition.NotNull);
		TiebCt1.SetNextCondition(LogicConnector.AND, TiebCt2);
		GuardMapping grdTieb = new GuardMapping();
		grdTieb.condition = TiebCt1;

		ArrayList<String> inputTieb = new ArrayList<String>();
		inputTieb.add("pieb");
		inputTieb.add("Aeb");

		grdTieb.Activations.add(new Activation(tieb, inputTieb, TransitionOperation.FuzzificationTwoQbits, "p1"));
		tieb.GuardMappingList.add(grdTieb);

		pn.Transitions.add(tieb);

		// tiPb------------------------

		PetriTransition tiPb = new PetriTransition(pn);
		tiPb.TransitionName = "tiPb";
		tiPb.InputPlaceName.add("piPb");
		tiPb.InputPlaceName.add("APb");

		Condition TiPbCt1 = new Condition(tiPb, "piPb", TransitionCondition.NotNull);
		Condition TiPbCt2 = new Condition(tiPb, "APb", TransitionCondition.NotNull);
		TiPbCt1.SetNextCondition(LogicConnector.AND, TiPbCt2);
		GuardMapping grdTiPb = new GuardMapping();
		grdTiPb.condition = TiPbCt1;

		ArrayList<String> inputTiPb = new ArrayList<String>();
		inputTiPb.add("piPb");
		inputTiPb.add("APb");

		grdTiPb.Activations.add(new Activation(tiPb, inputTiPb, TransitionOperation.FuzzificationTwoQbits, "p2"));
		tiPb.GuardMappingList.add(grdTiPb);

		pn.Transitions.add(tiPb);

		// ti3------------------------

		PetriTransition ti3 = new PetriTransition(pn);
		ti3.TransitionName = "ti1";
		ti3.InputPlaceName.add("pi3");
		ti3.InputPlaceName.add("Ai3");

		Condition Ti3Ct1 = new Condition(ti3, "pi3", TransitionCondition.NotNull);
		Condition Ti3Ct2 = new Condition(ti3, "Ai3", TransitionCondition.NotNull);
		Ti3Ct1.SetNextCondition(LogicConnector.AND, Ti3Ct2);
		GuardMapping grdTi3 = new GuardMapping();
		grdTi3.condition = Ti3Ct1;

		ArrayList<String> inputTi3 = new ArrayList<String>();
		inputTi3.add("pi3");
		inputTi3.add("Ai3");

		grdTi3.Activations.add(new Activation(ti3, inputTi3, TransitionOperation.FuzzificationTwoQbits, "p3"));
		ti3.GuardMappingList.add(grdTi3);

		pn.Transitions.add(ti3);

		// t1------------------------

		PetriTransition t1 = new PetriTransition(pn);
		t1.TransitionName = "t1";
		t1.InputPlaceName.add("p1");
		t1.InputPlaceName.add("p2");

		Condition T1Ct1 = new Condition(t1, "p1", TransitionCondition.NotNull);
		Condition T1Ct2 = new Condition(t1, "p2", TransitionCondition.NotNull);
		T1Ct1.SetNextCondition(LogicConnector.AND, T1Ct2);
		GuardMapping grdT1 = new GuardMapping();
		grdT1.condition = T1Ct1;

		ArrayList<String> inputT1 = new ArrayList<String>();
		inputT1.add("p1");
		inputT1.add("p2");

		ArrayList<String> outputT1 = new ArrayList<String>();
		outputT1.add("ur1");

		grdT1.Activations.add(new Activation(t1, inputT1, QFLRS1, TransitionOperation.QFLRS, outputT1));
		t1.GuardMappingList.add(grdT1);

		pn.Transitions.add(t1);

		// t2------------------------

		PetriTransition t2 = new PetriTransition(pn);
		t2.TransitionName = "t2";
		t2.InputPlaceName.add("p3");

		Condition T2Ct1 = new Condition(t2, "p3", TransitionCondition.NotNull);
		;
		GuardMapping grdT2 = new GuardMapping();
		grdT2.condition = T2Ct1;

		ArrayList<String> inputT2 = new ArrayList<String>();
		inputT2.add("p3");

		ArrayList<String> outputT2 = new ArrayList<String>();
		outputT2.add("ur2");

		grdT2.Activations.add(new Activation(t2, inputT2, QFLRS2, TransitionOperation.QFLRS, outputT2));
		t2.GuardMappingList.add(grdT2);

		pn.Transitions.add(t2);

		// t3------------------------

		PetriTransition t3 = new PetriTransition(pn);
		t3.TransitionName = "t3";
		t3.InputPlaceName.add("ur1");
		t3.InputPlaceName.add("ur2");

		Condition T3Ct1 = new Condition(t3, "ur1", TransitionCondition.NotNull);
		Condition T3Ct2 = new Condition(t3, "ur2", TransitionCondition.NotNull);
		T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);
		GuardMapping grdT3 = new GuardMapping();
		grdT3.condition = T3Ct1;

		ArrayList<String> inputT3 = new ArrayList<String>();
		inputT3.add("ur1");
		inputT3.add("ur2");

		ArrayList<String> outputT3 = new ArrayList<String>();
		outputT3.add("ccd");

		grdT3.Activations.add(new Activation(t3, inputT3, QFLRS3, TransitionOperation.QFLRS, outputT3));
		t3.GuardMappingList.add(grdT3);

		pn.Transitions.add(t3);

		// Start PN----------------------------------------------

		System.out.println("Quantum Task started \n ------------------------------");
		pn.Delay = 1000;
		pn.clearPrint = true;
		PetriNetWindow frame = new PetriNetWindow(false);
		frame.petriNet = pn;
		frame.setVisible(true);

	}

}
