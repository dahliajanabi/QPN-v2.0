package Utilities;

import java.io.Serializable;

import Interfaces.PetriObject;


public class DataOverNetwork implements Serializable
{/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public PetriObject petriObject; // could have task or vector
	public int NetWorkPort = 1080;// default in case none initiated
	public String IP = "127.0.0.1";// default in case none initiated

	public DataOverNetwork(PetriObject petriObject, int NetWorkPort, String IP)
	{
		this.petriObject = petriObject;
		this.NetWorkPort = NetWorkPort;
		this.IP = IP;
	}

	public DataOverNetwork()
	{
	}
}
