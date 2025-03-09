package Components;

import java.io.Serializable;
import java.util.ArrayList;
import Enumerations.LogicConnector;
import Enumerations.PetriNetState;
import Enumerations.PetriObjectType;
import Enumerations.TransitionCondition;
import Interfaces.PetriObject;
import Utilities.Functions;

public class Condition implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public PetriTransition Parent;

	public PetriObject Value1;
	public PetriObject Value2;

	public String PlaceName1;
	public String PlaceName2;

	public TransitionCondition condition;

	public Condition NextCondition;
	public LogicConnector Connector = LogicConnector.AND;
	public Functions util;

	public Condition() {
		util = new Functions();
	}

	public Condition(PetriTransition Parent, String PlaceName1, TransitionCondition condition, String PlaceName2) {
		util = new Functions();
		this.Parent = Parent;
		this.PlaceName1 = PlaceName1;
		this.PlaceName2 = PlaceName2;
		this.condition = condition;
	}

	public Condition(PetriTransition Parent, String PlaceName1, TransitionCondition condition) {
		util = new Functions();
		this.Parent = Parent;
		this.PlaceName1 = PlaceName1;
		this.condition = condition;
	}

	public void refreshData() {
		this.Value1 = util.GetPetriObjectByName(PlaceName1, Parent.Parent.PlaceList);
		if (Value1 == null) {
			Integer indx = util.GetIndexByName(PlaceName1, Parent.Parent.ConstantPlaceList);
			if (indx > -1)
				this.Value1 = util.GetPetriObjectByName(PlaceName1, Parent.Parent.ConstantPlaceList);
		}
		this.Value2 = util.GetPetriObjectByName(PlaceName2, Parent.Parent.PlaceList);
		if (Value2 == null) {
			Integer indx = util.GetIndexByName(PlaceName2, Parent.Parent.ConstantPlaceList);
			if (indx > -1)
				this.Value2 = util.GetPetriObjectByName(PlaceName2, Parent.Parent.ConstantPlaceList);
		}
	}

	public void SetNextCondition(LogicConnector Connector, Condition NextCondition) {
		this.NextCondition = NextCondition;
		this.Connector = Connector;
	}

	boolean Check() {
		refreshData();
		switch (condition) {
		case NotNull:
			if (Value1 != null && Value1.GetValue() != null)
				return true;
			break;
		case IsNull:
			if (Value1 == null || Value1.GetValue() == null)
				return true;
			break;
		case Equal:
			if (Value1 == null || Value1.GetValue() == Value2.GetValue())
				return true;
			break;
		default:
			break;
		}
		return false;
	}

	public ArrayList<Condition> conditionList;

	public boolean CheckCondition() {
		refreshData();
		conditionList = new ArrayList<Condition>();
		FullList(this);

		boolean andCondition = true;
		for (Condition condition : conditionList) {
			if (condition.Connector == LogicConnector.AND) {
				if (!condition.Check()) {
					andCondition = false;
					break;
				}
			}
		}

		if (andCondition)
			return true;

		for (Condition condition : conditionList) {
			if (condition.Connector == LogicConnector.OR) {
				if (condition.Check()) {
					return true;
				}
			}
		}

		return false;
	}

	void FullList(Condition obj) {
		if (obj == null)
			return;
		conditionList.add(obj);
		FullList(obj.NextCondition);
	}
}
