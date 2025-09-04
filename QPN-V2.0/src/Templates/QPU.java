package Templates;


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

	public class QPU {

		public static void main(String[] args) {

			PetriNet pn = new PetriNet();
			pn.PetriNetName = " QPU";
			pn.NetworkPort = 1080;

			// -------------Unitary Matrixes----------------

			DataUnitaryMatrix constantValue1 = new DataUnitaryMatrix();
			constantValue1.SetName("I");
			constantValue1.SetValue(new UnitaryMatrix(2, 2, 1.0f, 0.0f, 0.0f, 1.0f));
			pn.ConstantPlaceList.add(constantValue1);

			DataUnitaryThetaMatrix constantValue2 = new DataUnitaryThetaMatrix();
			constantValue2.SetName("U0");
			constantValue2.SetValue(
					new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "pc0"), // theta
																															// 0
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "pc0"), // theta 0
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "pc0"), // theta 0
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "pc0"))); // theta 0
			pn.ConstantPlaceList.add(constantValue2);

			DataUnitaryThetaMatrix constantValue3 = new DataUnitaryThetaMatrix();
			constantValue3.SetName("U11");
			constantValue3.SetValue(
					new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "pc1"), // theta
																															// 1
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "pc1"), // theta1
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "pc1"), // theta 1
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "pc1"))); // theta 1
			pn.ConstantPlaceList.add(constantValue3);
			
			
			DataUnitaryThetaMatrix constantValue4 = new DataUnitaryThetaMatrix();
			constantValue4.SetName("U21");
			constantValue4.SetValue(
					new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "pc2"), // theta
																															// 2
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "pc2"), // theta2
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "pc2"), // theta 2
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "pc2"))); // theta 2
			pn.ConstantPlaceList.add(constantValue4);
			
			DataUnitaryThetaMatrix constantValue5 = new DataUnitaryThetaMatrix();
			constantValue5.SetName("U3");
			constantValue5.SetValue(
					new UnitaryThetaMatrix(2, 2, new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "pc3"), // theta
																															// 3
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.MinusSin, "pc3"), // theta3
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Sin, "pc3"), // theta 3
							new UnitaryThetaMatrixValue(UnitaryThetaMatrixValueFuncType.Cos, "pc3"))); // theta 3
			pn.ConstantPlaceList.add(constantValue5);
									
			// ---------------------Places----------------------

			DataQplace pi1 = new DataQplace();
			pi1.SetName("pi1");
			pi1.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
					QplacePrintSetting.Both));//test
			pn.PlaceList.add(pi1);
			
			DataQplace pi2 = new DataQplace();
			pi2.SetName("pi2");
			pi2.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
					QplacePrintSetting.Both));//test
			pn.PlaceList.add(pi2);
			
			DataQplace p0 = new DataQplace();
			p0.SetName("p0");
			p0.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
					QplacePrintSetting.Both));

			pn.PlaceList.add(p0); 

			DataQplace p1 = new DataQplace();
			p1.SetName("p1");
			p1.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
					QplacePrintSetting.Both));
			pn.PlaceList.add(p1);
			
			DataQplace pk = new DataQplace();
			pk.SetName("pk");
			pk.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
					QplacePrintSetting.Both));
			pn.PlaceList.add(pk);

			DataQplace pe1 = new DataQplace();
			pe1.SetName("pe1");
			pe1.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
					QplacePrintSetting.Both));
			pn.PlaceList.add(pe1);
			
			DataQplace pe2 = new DataQplace();
			pe2.SetName("pe2");
			pe2.SetValue(new Qplace(new Vvector(1, new QBit(new ComplexValue(0.0f, 0.0f), new ComplexValue(1.0f, 0.0f))),
					QplacePrintSetting.Both));
			pn.PlaceList.add(pe2);

			DataQplace p11 = new DataQplace();
			p11.SetName("p11");
			pn.PlaceList.add(p11);
			
			DataQplace p12 = new DataQplace();
			p12.SetName("p12");
			pn.PlaceList.add(p12);
			
			DataQplace p13 = new DataQplace();
			p13.SetName("p13");
			pn.PlaceList.add(p13);
			
			DataQplace p14 = new DataQplace();
			p14.SetName("p14");
			pn.PlaceList.add(p14);
			
			DataQplace p15 = new DataQplace();
			p15.SetName("p15");
			pn.PlaceList.add(p15);
			
			DataQplace p21 = new DataQplace();
			p21.SetName("p21");
			pn.PlaceList.add(p21);
			
			DataQplace p22 = new DataQplace();
			p22.SetName("p22");
			pn.PlaceList.add(p22);
			
			DataQplace p23 = new DataQplace();
			p23.SetName("p23");
			pn.PlaceList.add(p23);
			
			DataQplace p31 = new DataQplace();
			p31.SetName("p31");
			pn.PlaceList.add(p31);
			
			DataQplace p32 = new DataQplace();
			p32.SetName("p32");
			pn.PlaceList.add(p32);
			
			DataQplace p41 = new DataQplace();
			p41.SetName("p41");
			pn.PlaceList.add(p41);
			
			DataQplace p42 = new DataQplace();
			p42.SetName("p42");
			pn.PlaceList.add(p42);
			
			DataQplace pm1 = new DataQplace();
			pm1.SetName("pm1");
			pn.PlaceList.add(pm1);
			
			DataQplace pm2 = new DataQplace();
			pm2.SetName("pm2");
			pn.PlaceList.add(pm2);
			
			DataTransfer po1 = new DataTransfer(); //output port to another QPU
			po1.SetName("po1");
			po1.Value = new TransferOperation("localhost", "port", "pi1");  //fill with the IP, port, of the destination QPU
			pn.PlaceList.add(po1);
			
			DataTransfer po2 = new DataTransfer(); //output port to another QPU
			po2.SetName("po2");
			po2.Value = new TransferOperation("localhost", "port", "pi2"); //fill with the IP, port, of the destination QPU
			pn.PlaceList.add(po2);
			
			DataDigital pcs1 = new DataDigital(); // Digital place {0, 1}
			pcs1.SetName("pcs1");
			pcs1.SetValue(new Digital(1));
			pn.PlaceList.add(pcs1);
			
			DataDigital pcs2 = new DataDigital(); // Digital place {0, 1}
			pcs2.SetName("pcs2");
			pcs2.SetValue(new Digital(1));
			pn.PlaceList.add(pcs2);
			
			// ---------------------Thetas----------------------

			DataTheta pc0 = new DataTheta(); // Theta 0
			pc0.SetName("pc0");
			pc0.SetValue(new Theta((float) Math.PI / 4));
			pn.ConstantPlaceList.add(pc0);
			
			DataTheta pc1 = new DataTheta(); // Theta 1
			pc1.SetName("pc1");
			pc1.SetValue(new Theta((float) Math.PI / 4));
			pn.ConstantPlaceList.add(pc1);
			
			DataTheta pc2 = new DataTheta(); // Theta 2
			pc2.SetName("pc2");
			pc2.SetValue(new Theta((float) Math.PI / 4));
			pn.ConstantPlaceList.add(pc2);
			
			DataTheta pc3 = new DataTheta(); // Theta 3
			pc3.SetName("pc3");
			pc3.SetValue(new Theta((float) Math.PI / 4));
			pn.ConstantPlaceList.add(pc3);

			

			// -------------------Transitions----------------------

			// t0------------------------

			PetriTransition t0 = new PetriTransition(pn);
			t0.TransitionName = "t0";
			t0.InputPlaceName.add("p0");
			t0.InputPlaceName.add("p1");
			t0.InputPlaceName.add("pk");
			t0.InputPlaceName.add("pe1");
			t0.InputPlaceName.add("pe2");
	
			t0.IsReversible = true; //the input places will not be null (they stay as they are after the transition is executed)

			Condition T0Ct1 = new Condition(t0, "p0", TransitionCondition.NotNull);
			Condition T0Ct2 = new Condition(t0, "p1", TransitionCondition.NotNull);
			Condition T0Ct3 = new Condition(t0, "pk", TransitionCondition.NotNull);
			Condition T0Ct4 = new Condition(t0, "pe1", TransitionCondition.NotNull);
			Condition T0Ct5 = new Condition(t0, "pe2", TransitionCondition.NotNull);
			T0Ct4.SetNextCondition(LogicConnector.AND, T0Ct5);
			T0Ct3.SetNextCondition(LogicConnector.AND, T0Ct4);
			T0Ct2.SetNextCondition(LogicConnector.AND, T0Ct3);
			T0Ct1.SetNextCondition(LogicConnector.AND, T0Ct2); // linking the two conditions with AND

			GuardMapping grdT0 = new GuardMapping(); // Creating grd to add the 1st condition and mappings (Activations)
			grdT0.condition = T0Ct1;

			ArrayList T00inputList = new ArrayList<String>(); //creating an arraylist for the input places
			T00inputList.add("p0");
			
			ArrayList T01inputList = new ArrayList<String>();
			T01inputList.add("p1");
			
			ArrayList T02inputList = new ArrayList<String>();
			T02inputList.add("pk");
			
			ArrayList T03inputList = new ArrayList<String>();
			T03inputList.add("pe1");
			
			ArrayList T04inputList = new ArrayList<String>();
			T04inputList.add("pe2");
			
			ArrayList T00ConstantList = new ArrayList<String>(); //creating an arraylist for the unitary matrixes
			T00ConstantList.add("U0");
			
			ArrayList T01ConstantList = new ArrayList<String>();
			T01ConstantList.add("U0");
			
			ArrayList T02ConstantList = new ArrayList<String>();
			T02ConstantList.add("U0");
			
			ArrayList T03ConstantList = new ArrayList<String>();
			T03ConstantList.add("U0");
			
			ArrayList T04ConstantList = new ArrayList<String>();
			T04ConstantList.add("U0");
			
			grdT0.Activations.add(new Activation(t0, T00inputList, T00ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p11")); //mapping
			grdT0.Activations.add(new Activation(t0, T01inputList, T01ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p12"));
			grdT0.Activations.add(new Activation(t0, T02inputList, T02ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p13"));
			grdT0.Activations.add(new Activation(t0, T03inputList, T03ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p14"));
			grdT0.Activations.add(new Activation(t0, T04inputList, T04ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p15"));
			t0.GuardMappingList.add(grdT0); // adding the grd to the transition (the transitions can have more than one grd)

			pn.Transitions.add(t0); // adding the transition to the PN

			// t11 ------------------------------------------------
			PetriTransition t11 = new PetriTransition(pn);
			t11.TransitionName = "t11";
			t11.InputPlaceName.add("p11");
			t11.InputPlaceName.add("pi2");
			
			t11.IsReversible = true;

			Condition T11Ct1 = new Condition(t11, "p11", TransitionCondition.NotNull);
			Condition T11Ct2 = new Condition(t11, "pi2", TransitionCondition.NotNull);
			T11Ct1.SetNextCondition(LogicConnector.AND, T11Ct2);

			GuardMapping grdT11 = new GuardMapping();
			grdT11.condition = T11Ct1;

			ArrayList T11inputList = new ArrayList<String>();
			T11inputList.add("pi2"); //the place and the unitary matirx that is added to the same index are multiplied with each other
	
			ArrayList T11ConstantList = new ArrayList<String>();
			T11ConstantList.add("U11"); //is multiplied with pi2
		
			grdT11.Activations.add(new Activation(t11, T11inputList, T11ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p21"));

			t11.GuardMappingList.add(grdT11);

			pn.Transitions.add(t11);
			
			
			// t12 ------------------------------------------------
			PetriTransition t12 = new PetriTransition(pn);
			t12.TransitionName = "t12";
			t12.InputPlaceName.add("p12");
			t12.InputPlaceName.add("p13");
			t12.InputPlaceName.add("p14");
			
			t12.IsReversible = true;

			Condition T12Ct1 = new Condition(t12, "p12", TransitionCondition.NotNull);
			Condition T12Ct2 = new Condition(t12, "p13", TransitionCondition.NotNull);
			Condition T12Ct3 = new Condition(t12, "p14", TransitionCondition.NotNull);
			T12Ct2.SetNextCondition(LogicConnector.AND, T12Ct3);
			T12Ct1.SetNextCondition(LogicConnector.AND, T12Ct2);
	
			GuardMapping grdT12 = new GuardMapping();
			grdT12.condition = T12Ct1;

			ArrayList T120inputList = new ArrayList<String>();
			T120inputList.add("p12");
			
			ArrayList T121inputList = new ArrayList<String>();
			T121inputList.add("p13");
			
			ArrayList T120ConstantList = new ArrayList<String>();
			T120ConstantList.add("I");
			
			ArrayList T121ConstantList = new ArrayList<String>();
			T121ConstantList.add("I");
	
			grdT12.Activations.add(new Activation(t12, T120inputList, T120ConstantList, TransitionOperation.UnitaryMatrixV, "p22")); 
			grdT12.Activations.add(new Activation(t12, T121inputList, T121ConstantList, TransitionOperation.UnitaryMatrixV, "p23")); 

			t12.GuardMappingList.add(grdT12);

			pn.Transitions.add(t12);
			
			
			// t21 ------------------------------------------------
			PetriTransition t21 = new PetriTransition(pn);
			t21.TransitionName = "t21";
			t21.InputPlaceName.add("p21");
			t21.InputPlaceName.add("pi1");
			
			t21.IsReversible = true;

			Condition T21Ct1 = new Condition(t21, "p21", TransitionCondition.NotNull);
			Condition T21Ct2 = new Condition(t21, "pi1", TransitionCondition.NotNull);
			T21Ct1.SetNextCondition(LogicConnector.AND, T21Ct2);

			GuardMapping grdT21 = new GuardMapping();
			grdT21.condition = T21Ct1;

			ArrayList T21inputList = new ArrayList<String>();
			T21inputList.add("pi1"); //the place and the unitary matirx that is added to the same index are multiplied with each other
	
			ArrayList T21ConstantList = new ArrayList<String>();
			T21ConstantList.add("U21"); //is multiplied with pi1
		
			grdT21.Activations.add(new Activation(t21, T21inputList, T21ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p31"));

			t21.GuardMappingList.add(grdT21);

			pn.Transitions.add(t21);

						
			// t22 ------------------------------------------------
			PetriTransition t22 = new PetriTransition(pn);
			t22.TransitionName = "t22";
			t22.InputPlaceName.add("p22");
			t22.InputPlaceName.add("p23");
			
			t22.IsReversible = true;

			Condition T22Ct1 = new Condition(t22, "p22", TransitionCondition.NotNull);
			Condition T22Ct2 = new Condition(t22, "p23", TransitionCondition.NotNull);
			T22Ct1.SetNextCondition(LogicConnector.AND, T22Ct2);
	
			GuardMapping grdT22 = new GuardMapping();
			grdT22.condition = T22Ct1;

			ArrayList T220inputList = new ArrayList<String>();
			T220inputList.add("p22");
			
			ArrayList T220ConstantList = new ArrayList<String>();
			T220ConstantList.add("I");
			
	
			grdT22.Activations.add(new Activation(t22, T220inputList, T220ConstantList, TransitionOperation.UnitaryMatrixV, "p32")); 
			//grdT22.Activations.add(new Activation(t22, "p23", TransitionOperation.SendOverNetwork, "po1")); 

			t22.GuardMappingList.add(grdT22);

			pn.Transitions.add(t22);	
			
			// t23 ------------------------------------------------
			PetriTransition t23 = new PetriTransition(pn);
			t23.TransitionName = "t23";
			t23.InputPlaceName.add("p15");
			
			t23.IsReversible = true;

			Condition T23Ct1 = new Condition(t23, "p15", TransitionCondition.NotNull);
			
	
			GuardMapping grdT23 = new GuardMapping();
			grdT23.condition = T23Ct1;
		
			//grdT23.Activations.add(new Activation(t23, "p15", TransitionOperation.SendOverNetwork, "po2")); 

			t23.GuardMappingList.add(grdT23);

			pn.Transitions.add(t23);	
			
			
			// t3 ------------------------------------------------
			PetriTransition t3 = new PetriTransition(pn);
			t3.TransitionName = "t3";
			t3.InputPlaceName.add("p31");
			t3.InputPlaceName.add("p32");
			
			t3.IsReversible = true;

			Condition T3Ct1 = new Condition(t3, "p31", TransitionCondition.NotNull);
			Condition T3Ct2 = new Condition(t3, "p32", TransitionCondition.NotNull);
			T3Ct1.SetNextCondition(LogicConnector.AND, T3Ct2);
	
			GuardMapping grdT3 = new GuardMapping();
			grdT3.condition = T3Ct1;

			ArrayList T30inputList = new ArrayList<String>();
			T30inputList.add("p31");
			
			ArrayList T31inputList = new ArrayList<String>();
			T31inputList.add("p32");
			
			ArrayList T30ConstantList = new ArrayList<String>();
			T30ConstantList.add("U3");
			
			ArrayList T31ConstantList = new ArrayList<String>();
			T31ConstantList.add("U3");
			
	
			grdT3.Activations.add(new Activation(t3, T30inputList, T30ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p41"));
			grdT3.Activations.add(new Activation(t3, T31inputList, T31ConstantList, TransitionOperation.ThetaUnitaryMatrixV, "p42")); 
			
			t3.GuardMappingList.add(grdT3);

			pn.Transitions.add(t3);	
			
			// tm1 ------------------------------------------------
			PetriTransition tm1 = new PetriTransition(pn); // measurement of the 1st qbit
			tm1.TransitionName = "tm1";
			tm1.InputPlaceName.add("p41");
			tm1.InputPlaceName.add("pcs1");

			Condition Tm1Ct1 = new Condition(tm1, "p41", TransitionCondition.NotNull);
			Condition Tm1Ct2 = new Condition(tm1, "pcs1", TransitionCondition.NotNull);
			Tm1Ct1.SetNextCondition(LogicConnector.AND, Tm1Ct2);

			GuardMapping grdTm1 = new GuardMapping();
			grdTm1.condition = Tm1Ct1;
			grdTm1.Activations.add(new Activation(tm1, "p41", TransitionOperation.Measurement,"pm1")); //measurement, the result is put in alpha only

			tm1.GuardMappingList.add(grdTm1);

			pn.Transitions.add(tm1);
			
			
			// tm2 ------------------------------------------------
			PetriTransition tm2 = new PetriTransition(pn); // measurement of the 1st qbit
			tm2.TransitionName = "tm2";
			tm2.InputPlaceName.add("p42");
			tm2.InputPlaceName.add("pcs2");

			Condition Tm2Ct1 = new Condition(tm2, "p42", TransitionCondition.NotNull);
			Condition Tm2Ct2 = new Condition(tm2, "pcs2", TransitionCondition.NotNull);
			Tm2Ct1.SetNextCondition(LogicConnector.AND, Tm2Ct2);

			GuardMapping grdTm2 = new GuardMapping();
			grdTm2.condition = Tm1Ct1;
			grdTm2.Activations.add(new Activation(tm2, "p42", TransitionOperation.Measurement,"pm2")); //measurement, the result is put in alpha only

			tm2.GuardMappingList.add(grdTm2);

			pn.Transitions.add(tm2);
			
			
			// Start PN----------------------------------------------

			System.out.println("Quantum Task started \n ------------------------------");
			pn.Delay = 1000;
			pn.clearPrint = true;
			PetriNetWindow frame = new PetriNetWindow(false);
			frame.petriNet = pn;
			frame.setVisible(true);

		}

	}



