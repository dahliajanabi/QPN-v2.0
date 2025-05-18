package Components;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;
import java.util.Collections;

import DataObjects.DataQplace;
import Enumerations.PetriNetState;
import Enumerations.PetriObjectType;
import Interfaces.PetriObject;
import Utilities.DataOverNetwork;
import Utilities.Functions;

public class PetriNet implements PetriObject, Runnable, Cloneable, Serializable {

	/**
	 *
	 */
	private static final long serialVersionUID = 1L;
	public PetriNetState PetriState = PetriNetState.None;
	// ----------------------------------------------------------------------------------------------

	public interface DataLoadFinishedListener {
		public void onDataLoadFinishedListener(String data_type);
	}

	public DataLoadFinishedListener m_lDataLoadFinished = new DataLoadFinishedListener() {

		@Override
		public void onDataLoadFinishedListener(String data_type) {
			// TODO Auto-generated method stub

		}
	};

	public void setDataLoadFinishedListener(DataLoadFinishedListener dlf) {
		this.m_lDataLoadFinished = dlf;
	}

	// ----------------------------------------------------------------------------------------------
	@Override
	public void AddElement(Object value) {
		// TODO Auto-generated method stub

	}

	@Override
	public void Execute() {
		// TODO Auto-generated method stub
	}

	@Override
	public PetriObjectType GetType() {
		return PetriObjectType.PetriNet;
	}

	public Object GetValue() {
		return null;
	}

	@Override
	public void SetValue(Object value) {

	}

	private String name = "";

	@Override
	public String GetName() {
		return name;
	}

	@Override
	public void SetName(String name) {
		this.name = name;
	}

	public ArrayList<PetriObject> PlaceList;
	public ArrayList<PetriObject> ConstantPlaceList;
	public Functions util;

	public PetriNet() {
		util = new Functions();
		Transitions = new ArrayList<PetriTransition>();
		PlaceList = new ArrayList<PetriObject>();
		ConstantPlaceList = new ArrayList<PetriObject>();
	}

	public ArrayList<PetriTransition> Transitions;

	public String PetriNetName;
	public double Throughput  = 0.0;
	public boolean StopFlag;
	public boolean PauseFlag;
	public Integer Delay = 1000;
	public ArrayList<PetriTransition> ReversibleExecutionList;
	public ArrayList<PetriTransition> NonReversibleExecutionList;

	private Thread networkThread;

	public String msg;
	public boolean clearPrint = false;
	public boolean PrintingImaginaryNumbers = true;

	@Override
	public void Start() {
		PetriState = PetriNetState.Started;
		networkThread = new Thread();

		NetworkListener myRunnable = new NetworkListener(this);
		networkThread = new Thread(myRunnable);
		networkThread.start();

		msg = "####################  " + PetriNetName + " Started  #####################";
		PrintThis(msg, null);

		ReversibleExecutionList = new ArrayList<PetriTransition>();
		NonReversibleExecutionList = new ArrayList<PetriTransition>();

		StopFlag = false;
		PauseFlag = false;
		while (!StopFlag) {
			try {
				Thread.sleep(Delay);
			} catch (InterruptedException ex) {
				Thread.currentThread().interrupt();
			}

			if (PauseFlag) {
				continue;
			}

			PrintPetri();
			String conditionsStatus = "";
			ArrayList<String> toNull = new ArrayList<String>();
			for (int i = 0; i < Transitions.size(); ++i) {

				if (Transitions.get(i).IsReversible
						&& !util.TransitionExist(Transitions.get(i).GetName(), ReversibleExecutionList)
						|| !Transitions.get(i).IsReversible
						&& !util.TransitionExist(Transitions.get(i).GetName(), NonReversibleExecutionList)) {
					if (Transitions.get(i).CheckConditions()) {
						try {
							toNull.addAll(Transitions.get(i).BookTokens());
							// PrintThis(Transitions.get(i).GetName() + " tokens are booked!", null);
						} catch (CloneNotSupportedException e) {
							PrintThis(e.getMessage(), e);
						}
						PetriTransition trr = Transitions.get(i);
						trr.InitialDelay = trr.Delay;
						if (trr.IsReversible) {
							ReversibleExecutionList.add(trr);
						} else {
							NonReversibleExecutionList.add(trr);
						}
					} else {
						conditionsStatus += "[" + Transitions.get(i).TransitionName + " conditions are false]";
					}
				}
			}

			if (!clearPrint) {
				if (conditionsStatus != "") {
					PrintThis(conditionsStatus, null);
				}
				PrintReversibleExecutionList();
				PrintNonReversibleExecutionList();
			}
			Collections.shuffle(ReversibleExecutionList);
			Collections.shuffle(NonReversibleExecutionList);
			if (!clearPrint) {
				PrintReversibleExecutionList();
				PrintNonReversibleExecutionList();
			}
			for (int i = 0; i < NonReversibleExecutionList.size(); ++i) {
				if (NonReversibleExecutionList.get(i).InitialDelay == 0) {
					try {
						NonReversibleExecutionList.get(i).Activate();
						PrintThis(NonReversibleExecutionList.get(i).GetName() + " executed:", null);
					} catch (CloneNotSupportedException | IOException e) {
						PrintThis(e.getMessage(), e);
					}
				}
				NonReversibleExecutionList.get(i).InitialDelay--;
			}
			for (int i = 0; i < ReversibleExecutionList.size(); ++i) {
				if (ReversibleExecutionList.get(i).InitialDelay == 0) {
					try {
						ReversibleExecutionList.get(i).Activate();
						PrintThis(ReversibleExecutionList.get(i).GetName() + " executed:", null);
					} catch (CloneNotSupportedException | IOException e) {
						PrintThis(e.getMessage(), e);
					}
				}
				ReversibleExecutionList.get(i).InitialDelay--;
			}

			for (String string : toNull) {
				PetriObject currentInputPlace = util.GetPetriObjectByName(string, PlaceList);
				currentInputPlace.SetValue(null);
			}

			for (int i = 0; i < ReversibleExecutionList.size(); ++i) {
				if (ReversibleExecutionList.get(i).InitialDelay < 0) {
					ReversibleExecutionList.remove(i);
					i--;
				}
			}
			for (int i = 0; i < NonReversibleExecutionList.size(); ++i) {
				if (NonReversibleExecutionList.get(i).InitialDelay < 0) {
					NonReversibleExecutionList.remove(i);
					i--;
				}
			}
		}
	}

	public void PrintThis(String text, Exception e) {
//		m_lDataLoadFinished.onDataLoadFinishedListener(text);
//		if (e != null) {
//			e.printStackTrace();
//		}
//		System.out.println(text);
	}

	@Override
	public void Stop() {
		StopFlag = true;
		for (int i = 0; i < Transitions.size(); ++i) {
			Transitions.get(i).Stop();
		}
		PrintThis("####################  " + PetriNetName + " Ended  #####################", null);
		PetriState = PetriNetState.Stopped;
	}

	public void PrintPlaceList() {
//
//		ArrayList<String> toPrint = new ArrayList<String>();
//		boolean isAllNull = true;
//		for (PetriObject petriObject : PlaceList) {
//			if (petriObject == null) {
//				toPrint.add("NULL");
//			} else if (petriObject.IsPrintable()) {
//
//				String placeString=petriObject.ToStringWithParam(PrintingImaginaryNumbers);
//				toPrint.add(placeString);
//				if(!placeString.contains("Null"))
//				{
//					isAllNull = false;
//				}
//			}
//		}
//
//		if (!isAllNull) {
//			for (String item : toPrint)
//				PrintThis(item, null);
//		}
	}

	public void PrintPetri() {
//		if (clearPrint) {
//			String toPrint = "-----------------------------------------------------------";
//			PrintThis(toPrint, null);
//			PrintPlaceList();
//			return;
//		}
//		ArrayList<String> temp1 = new ArrayList<String>();
//		for (PetriObject petriObject : PlaceList) {
//			if (petriObject == null)
//				temp1.add("NULL");
//			else if (petriObject.IsPrintable())
//				temp1.add(petriObject.ToStringWithParam(PrintingImaginaryNumbers));
//		}
//
//		msg = name + " PlaceList [" + String.join("  ", temp1) + "]";
//		PrintThis(msg, null);
//
//		temp1 = new ArrayList<String>();
//		for (PetriObject petriObject : ConstantPlaceList) {
//			if (petriObject == null)
//				temp1.add("NULL");
//			else if (petriObject.IsPrintable())
//				temp1.add(petriObject.ToStringWithParam(PrintingImaginaryNumbers));
//		}
//
//		msg = name + " ConstantPlaceList [" + String.join("  ", temp1) + "]";
//		PrintThis(msg, null);
	}

	public void PrintReversibleExecutionList() {
//		ArrayList<String> temp1 = new ArrayList<String>();
//		for (PetriObject petriObject : ReversibleExecutionList) {
//			if (petriObject == null)
//				temp1.add("NULL");
//			else
//				temp1.add(petriObject.ToStringWithParam(PrintingImaginaryNumbers));
//		}
//
//		msg = name + " ReversibleExecutionList [" + String.join(",", temp1) + "]";
//		PrintThis(msg, null);
	}

	public void PrintNonReversibleExecutionList() {
//		ArrayList<String> temp1 = new ArrayList<String>();
//		for (PetriObject petriObject : NonReversibleExecutionList) {
//			if (petriObject == null)
//				temp1.add("NULL");
//			else
//				temp1.add(petriObject.ToStringWithParam(PrintingImaginaryNumbers));
//		}
//
//		msg = name + " NonReversibleExecutionList [" + String.join(",", temp1) + "]";
//		PrintThis(msg, null);
	}

	private DataOverNetwork inputdata = new DataOverNetwork();
	private boolean stop;
	public Integer NetworkPort = 0;

	public class NetworkListener implements Runnable {
		private PetriNet net;

		public NetworkListener(PetriNet net) {
			this.net = net;
		}

		public void run() {
			ServerSocket ss = null;
			try {
				if (NetworkPort == 0)
					return;
				ss = new ServerSocket(NetworkPort);

				msg = "Waiting For Commands over this port:" + NetworkPort;
				PrintThis(msg, null);

				Socket s;
				ObjectInputStream ois;
				while (!net.stop) {
					s = ss.accept();
					s.setReuseAddress(true);
					ois = new ObjectInputStream(s.getInputStream());

					try {
						net.inputdata = (DataOverNetwork) ois.readObject();
						Integer index = net.util.GetIndexByName(net.inputdata.petriObject.GetName(), net.PlaceList);

						if (net.inputdata.petriObject.GetType() != PetriObjectType.PetriData) {
							net.PlaceList.set(index, net.inputdata.petriObject);
						}
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}

					msg = "$$$$$$$$$$$$$$$ I got an Input From NetWork for " + net.inputdata.petriObject.GetName();
					PrintThis(msg, null);
				}
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	@Override
	public void run() {
		Start();
	}

	public boolean Printable = true;

	@Override
	public boolean IsPrintable() {
		return Printable;
	}

	private boolean token;

	@Override
	public void SetToken(boolean token) {
		this.token = token;
	}

	@Override
	public boolean GetToken() {
		return this.token;
	}

	@Override
	public String ToStringWithParam(boolean b) {
		return toString();
	}

	public DataQplace getPlaceByName(String pName) {
		Functions util = new Functions();
		PetriObject input1 = util.GetFromListByName(pName, this.PlaceList);
		if (input1 == null && !(input1 instanceof DataQplace)) {
			return null;
		}
		DataQplace result = (DataQplace) ((DataQplace) input1).clone();
		return result;
	}
}
