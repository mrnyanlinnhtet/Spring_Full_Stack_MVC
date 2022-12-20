package com.ultron.root.services;

public class StreamState {

	private volatile boolean timeout;

	public synchronized void getTimeout() {
		timeout = true;
	}

	public synchronized boolean isTimeout() {
		return timeout;
	}

}
