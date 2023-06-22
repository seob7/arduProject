package com.microrobot.arduProject.servelt;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.google.gson.Gson;
import com.microrobot.arduProject.dao.dataDAO;
import com.microrobot.arduProject.dto.dataDTO;

/**
 * Servlet implementation class dataServlet
 */
@WebServlet("/dataServlet")
public class dataServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	    response.setHeader("Access-Control-Allow-Origin", "*");
		response.setContentType("application/json");
		dataDAO datadao = new dataDAO();
        dataDTO datadto = datadao.getTemp_Humid_Data();  
        Gson gson = new Gson();
        String json = gson.toJson(datadto);
        System.out.println(json);
        response.getWriter().write(json);
	}
}
