package com.ultron;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.ultron.listener.ListenerAsync;

@WebServlet(urlPatterns = "/",asyncSupported = true)
public class HelloAsync extends HttpServlet {

	private static final long serialVersionUID = 1L;

	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		var out = resp.getWriter();
		var asyncContext = req.startAsync();
		asyncContext.setTimeout(2000);
		asyncContext.addListener(new ListenerAsync());
		
		if(null != req.getParameter("error")) {
			 throw new RuntimeException("Error in Hello Async Page ! >>>>>>>>>>>>");
		}

		out.append("""
				<html>
				<head>
				<title>
				Async Request
				</title>
				</head>
				<body>
				<h1>Hello Async Servlet</h1>
					""");
		 
		asyncContext.start(getTest("Job 1"));

		out.append("""
				<p>This is heavy weight process</p>
				<a href="/">Request Again</a>
				</body>
				</html>
					""");

	}
	
	private Runnable getTest(String task) {
		return ()->{
			try {
				System.out.println("Heavy Weight %s Work Start !..".formatted(task));
				Thread.sleep(10000);
				System.out.println("Heavy Weight %s Work End !".formatted(task));
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		};
	}

}
