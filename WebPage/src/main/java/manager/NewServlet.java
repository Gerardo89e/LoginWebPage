package manager;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;

import manager.Manager;

public class NewServlet extends HttpServlet{
	public void doGet(HttpServletRequest request,
            HttpServletResponse response) throws IOException,
                                                 ServletException {
		List<Manager> users = new ArrayList<>();
		
		Gson gson = new Gson();
		String userJSON = gson.toJson(users);
		
		PrintWriter printWriter = response.getWriter();
		response.setContentType("application/json");
		printWriter.write(userJSON);
		printWriter.close();
}
	
	public void doPost(HttpServletRequest request,HttpServletResponse response) throws ServletException, IOException{
		String jsonData =request.getParameter("book.id");
		String jsonData2 =request.getParameter("book.name");
		System.out.println("it is in newservlet");
		StringBuffer jb = new StringBuffer();
		BufferedReader reader = request.getReader();
		//StringBuffer json = new StringBuffer();
		StringBuilder text = new StringBuilder(); 
		jb.append("{");
		jb.append("\"post\" : true ,");
		String line = null;
		while((line=reader.readLine()) != null) {
			jb.append(line);
			System.out.println(line);
			
			response.setContentType("/post");
	        response.setHeader("Cache-Control", "nocache");
	        response.setStatus(200);
			response.getWriter().write(text.toString());
	        //response.setCharacterEncoding("utf-8");
			//System.out.println(jb.toString());

		}
		
		text.append("}");

		


	        
	}
}
