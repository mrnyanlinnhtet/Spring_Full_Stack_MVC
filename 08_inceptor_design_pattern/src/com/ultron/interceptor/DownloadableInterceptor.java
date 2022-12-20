package com.ultron.interceptor;

public interface DownloadableInterceptor {
	
	default void preProcess() {}
	default void successProcess() {}
	default void onError(Exception e) {}
	default void downloadComplete() {}

}
