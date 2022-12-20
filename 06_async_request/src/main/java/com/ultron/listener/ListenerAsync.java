package com.ultron.listener;

import java.io.IOException;

import javax.servlet.AsyncEvent;
import javax.servlet.AsyncListener;

public class ListenerAsync implements AsyncListener {

	@Override
	public void onComplete(AsyncEvent event) throws IOException {
		System.out.println("Linstener Message : Complete");
		
	}

	@Override
	public void onTimeout(AsyncEvent event) throws IOException {
		System.out.println("Linstener Message : On Time Out");
		event.getAsyncContext().complete();
		
	}

	@Override
	public void onError(AsyncEvent event) throws IOException {
		System.out.println("Linstener Message : On Error");
		event.getAsyncContext().dispatch("/views/error.jsp");
		
		
	}

	@Override
	public void onStartAsync(AsyncEvent event) throws IOException {
		System.out.println("Linstener Message : On Start Async");
		
	}

}
