package Utilities;

import java.io.Serializable;
import java.util.ArrayList;

import Components.Activation;
import Components.Condition;
import Components.GuardMapping;
import Components.PetriNet;
import Components.PetriTransition;
import DataObjects.DataArcMatrix;
import DataObjects.DataComplexVector;
import DataObjects.DataTransfer;
import DataOnly.ComplexValue;
import DataOnly.Psivector;
import DataOnly.TransferOperation;
import Enumerations.PetriObjectType;
import Enumerations.TransitionOperation;
import Interfaces.PetriObject;
import PetriDataPackage.PetriData;
import PetriDataPackage.Guard;
import PetriDataPackage.GuardActivation;
import PetriDataPackage.GuardCondition;
import PetriDataPackage.Place;
import PetriDataPackage.Transition;

public class Functions implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public float GetProbabilitySum(Psivector resD) {
		float result = 0.0f;
		for (ComplexValue item : resD.ComplexArray) {
			result += item.Real;
		}
		return result;
	}


	public PetriObject GetPetriObjectByName(String name, ArrayList<PetriObject> list) {
		for (PetriObject petriObject : list) {
			if (petriObject != null)
				if (petriObject.GetName().equals(name))
					return petriObject;
		}
		return null;
	}

	public Integer GetIndexByName(String name, ArrayList<PetriObject> list) {
		if (name == null)
			return -1;
		if (!name.contains("-"))  {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null)
					if (list.get(i).GetName().equals(name))
						return i;
			}
		}
		return -1;
	}

	public PetriObject GetFromListByName(String name, ArrayList<PetriObject> list) {
		if (!name.contains("-")) {
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i) != null)
					if (list.get(i).GetName().equals(name))
						return list.get(i);
			}
		}
		return null;
	}

	public boolean SetToListByName(String name, ArrayList<PetriObject> list, PetriObject data) {
		int index = GetIndexByName(name, list);
		if (index == -1)
			return false;

		if (!name.contains("-"))  {
			list.set(index, data);
			return true;
		}
		return false;
	}

	public boolean SetNullToListByName(String name, ArrayList<PetriObject> list) {
		int index = GetIndexByName(name, list);
		if (index == -1)
			return false;

		if (!name.contains("-")) {
			list.get(index).SetValue(null);
			return true;
		}
		return false;
	}

	public boolean TransitionExist(String name, ArrayList<PetriTransition> list) {
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).GetName().equals(name))
				return true;
		}
		return false;
	}

	public PetriNet PetriDataToPetriNet(PetriData pd) {
		PetriNet pn = new PetriNet();
		pn.PetriNetName = pd.Name;
		pn.NetworkPort = pd.Port;

		for (Place p : pd.Places) {
			PetriObject pls;
			switch (p.Type) {
			case DataComplexVector: {
				pls = new DataComplexVector();
				break;
			}
			case DataArcMatrix: {
				pls = new DataArcMatrix();
				break;
			}
			default:
				pls = new DataComplexVector();
				break;
			}

			if (p.Type == PetriObjectType.DataTransfer) {
				DataTransfer trans = new DataTransfer();
				trans.SetName(p.Name);
				trans.Value = (TransferOperation) p.Val;
				pn.PlaceList.add(trans);
			} else {
				pls.SetName(p.Name);
				pls.SetValue(p.Val);
				pn.PlaceList.add(pls);
			}
		}

		for (Place p : pd.ConstantPlaces) {
			PetriObject pls;
			switch (p.Type) {
			case DataComplexVector: {
				pls = new DataComplexVector();
				break;
			}
			case DataArcMatrix: {
				pls = new DataArcMatrix();
				break;
			}
			case DataTransfer: {
				pls = new DataTransfer();
				break;
			}
			default:
				pls = new DataArcMatrix();
				break;
			}

			if (p.Type == PetriObjectType.DataTransfer) {
				DataTransfer trans = new DataTransfer();
				trans.SetName(p.Name);
				trans.Value = (TransferOperation) p.Val;
				pn.ConstantPlaceList.add(trans);
			} else {
				pls.SetName(p.Name);
				pls.SetValue(p.Val);
				pn.ConstantPlaceList.add(pls);
			}
		}

		for (Transition t : pd.Transitions) {
			PetriTransition trs = new PetriTransition(pn);
			trs.TransitionName = t.Name;
			for (String s : t.InputPlaces) {
				trs.InputPlaceName.add(s);
			}

			for (Guard g : t.Guards) {

				GuardMapping tempGuard = new GuardMapping();
				tempGuard.condition = ConvertToCondition(g.GuardCondition, trs);

				for (GuardActivation ga : g.GuardActivations) {
					Activation act = new Activation(trs);
					act.InputPlaceName = ga.InputPlaceName;
					act.InputPlaceNames = ga.InputPlaceNames;
					act.OutputPlaceName = ga.OutputPlaceName;
					act.OutputPlaceNames = ga.OutputPlaceNames;
					act.Operation = ga.Operation;
					act.Parent = trs;
					tempGuard.Activations.add(act);
				}
				trs.GuardMappingList.add(tempGuard);
			}
			trs.Delay = t.Delay;
			pn.Transitions.add(trs);
		}

		return pn;
	}

	public PetriData PetriNetToPetriData(PetriNet pn) {
		PetriData pd = new PetriData();

		pd.Name = pn.PetriNetName;
		pd.Port = pn.NetworkPort;

		for (PetriObject p : pn.PlaceList) {
			pd.Places.add(new Place(p.GetName(), p.GetType(), p.GetValue()));
		}

		for (PetriObject p : pn.ConstantPlaceList) {
			pd.ConstantPlaces.add(new Place(p.GetName(), p.GetType(), p.GetValue()));
		}

		for (PetriTransition t : pn.Transitions) {
			Transition trs = new Transition();
			trs.Name = t.TransitionName;
			for (String s : t.InputPlaceName) {
				trs.InputPlaces.add(s);
			}

			for (GuardMapping g : t.GuardMappingList) {

				Guard tempGuard = new Guard();
				tempGuard.GuardCondition = ConvertToGuardCondition(g.condition);

				for (Activation ga : g.Activations) {
					GuardActivation act = new GuardActivation();
					act.InputPlaceName = ga.InputPlaceName;
					act.InputPlaceNames = ga.InputPlaceNames;
					act.OutputPlaceName = ga.OutputPlaceName;
					act.OutputPlaceNames = ga.OutputPlaceNames;
					act.Operation = ga.Operation;
					tempGuard.GuardActivations.add(act);
				}
				trs.Guards.add(tempGuard);
			}
			trs.Delay = t.Delay;
			pd.Transitions.add(trs);
		}
		return pd;
	}

	public Condition ConvertToCondition(GuardCondition gCon, PetriTransition parent) {
		Condition con1 = new Condition();
		con1.condition = gCon.condition;
		con1.PlaceName1 = gCon.PlaceName1;
		con1.PlaceName2 = gCon.PlaceName2;
		if (gCon.NextCondition != null) {
			con1.SetNextCondition(gCon.Connector, ConvertToCondition(gCon.NextCondition, parent));
		}
		con1.Parent = parent;
		return con1;
	}

	public GuardCondition ConvertToGuardCondition(Condition con) {
		GuardCondition con1 = new GuardCondition();
		con1.condition = con.condition;
		con1.PlaceName1 = con.PlaceName1;
		con1.PlaceName2 = con.PlaceName2;
		if (con.NextCondition != null) {
			con1.SetNextCondition(con.Connector, ConvertToGuardCondition(con.NextCondition));
		}
		return con1;
	}
}
