package com.ultron.model;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class StringCart implements Serializable {

	private static final long serialVersionUID = 1L;

	private List<String> list;

	public StringCart() {
		list = new ArrayList<String>();
	}

	public List<String> getList() {
		return list;
	}

	public void addToList(String data) {
		list.add(data);
	}

	public int getCount() {
		return list.size();
	}

}
