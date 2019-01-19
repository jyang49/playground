package demo;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Random;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class Counter extends HttpServlet {
	private static final long serialVersionUID = 1L;
	private static int counter =0;
       
    public Counter() {
        super();
    }

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		deplay();
		PrintWriter out = response.getWriter();
		out.println("<html>");
		out.println("<body>");
		out.println("count=" + getCounter());
		out.println("</body>");
		out.println("</html>");	
		System.out.println("count=" + counter);
	}

	private void deplay() {
		Random rand = new Random();
		int n = rand.nextInt(100) + 1;
		try {
			Thread.sleep(10 * n);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		doGet(request, response);
	}
	
	private synchronized int getCounter() {
		return ++counter;
	}

}

