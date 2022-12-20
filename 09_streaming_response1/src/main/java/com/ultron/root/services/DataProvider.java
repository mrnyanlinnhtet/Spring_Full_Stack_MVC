package com.ultron.root.services;

import java.io.IOException;
import java.util.List;

import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;
import org.springframework.web.servlet.mvc.method.annotation.ResponseBodyEmitter;

@Service
public class DataProvider {

	private final List<String> subjects;

	public DataProvider() {
		subjects = List.of("Java SE", "Java EE", "Spring", "Angular", "Java FX", "React JS", "Kotlin", "Dart");
	}

	@Async
	public void stream(ResponseBodyEmitter emitter) {

		var timeoutState = new StreamState();
		emitter.onTimeout(() -> {
			synchronized (timeoutState) {
				timeoutState.getTimeout();
			}
		});

		try {
			for (var data : subjects) {
				Thread.sleep(1000L);
				synchronized (this) {

					if (timeoutState.isTimeout()) {
						break;
					}

					emitter.send(data);

				}

			}

		} catch (InterruptedException | IOException e) {
			e.printStackTrace();
		}finally {
			emitter.complete();
		}

	}

}
