package com.ultron.interceptor;

public class Downloader {

	private Downloadable manager;
	private DownloadableInterceptor common;

	public Downloader(DownloadManager manager, CommonDownloader common) {
		super();
		this.manager = manager;
		this.common = common;
	}

	public void doDownload() {

		try {

			common.preProcess();
			manager.download();
			common.successProcess();

		} catch (Exception e) {
			common.onError(e);
		} finally {
			common.downloadComplete();
		}

	}

	public static void main(String[] args) {

		var m = new DownloadManager();
		var c = new CommonDownloader();

		var download = new Downloader(m, c);

		download.doDownload();

	}

}
