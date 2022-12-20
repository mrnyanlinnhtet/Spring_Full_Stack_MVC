package com.ultron.interceptor;

public class CommonDownloader implements DownloadableInterceptor {
	
	@Override
	public void preProcess() {
		System.out.println("System preprocessing .....");
	}
	
	@Override
	public void successProcess() {
		System.out.println("System Function are Success Processing ....");
	
	}
	
	@Override
	public void onError(Exception e) {
		System.out.println("Error is " + e.getMessage());
	}
	
	@Override
	public void downloadComplete() {
		System.out.println("Downloading Process is Completed ......");
	}

}
