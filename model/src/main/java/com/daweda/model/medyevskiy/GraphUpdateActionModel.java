package com.daweda.model.medyevskiy;

import java.util.ArrayList;
import java.util.List;

public class GraphUpdateActionModel {

	private long time;
	private List<Integer> deleteList; //indexes of deleted elements
	private List<GraphModel> addList; //value of added points
	
	public GraphUpdateActionModel(long currentTime) {
		super();
		time = currentTime;
		deleteList = new ArrayList<Integer>();
		addList = new ArrayList<GraphModel>();
	}
	
	

	public GraphUpdateActionModel(long time, List<Integer> deleteList,
			List<GraphModel> addList) {
		super();
		this.time = time;
		this.deleteList = deleteList;
		this.addList = addList;
	}



	public long getTime() {
		return time;
	}

	public void setTime(long time) {
		this.time = time;
	}

	public List<Integer> getDeleteList() {
		return deleteList;
	}

	public void setDeleteList(List<Integer> deleteList) {
		this.deleteList = deleteList;
	}



	public List<GraphModel> getAddList() {
		return addList;
	}



	public void setAddList(List<GraphModel> addList) {
		this.addList = addList;
	}

	
	
	
	
}
