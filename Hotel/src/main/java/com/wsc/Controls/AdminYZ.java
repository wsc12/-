package com.wsc.Controls;

import java.io.IOException;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.SQLException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.alibaba.fastjson.JSONObject;
import com.wsc.model.admin;

import java.sql.PreparedStatement;
import java.sql.ResultSet;

/**
 * Servlet implementation class AdminYZ
 */
@WebServlet("/AdminYZ")
public class AdminYZ extends HttpServlet {
	private static final long serialVersionUID = 1L;
    int aa=2222;
    /**
     * @see HttpServlet#HttpServlet()
     */
    public AdminYZ() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
    	
    	
    }
	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		PrintWriter out=response.getWriter();
			Connection con=getConnection.startConnection();
			request.setCharacterEncoding("utf-8");
			response.setContentType("text/html;charset=utf-8");
			String name=request.getParameter("name");
			String password=request.getParameter("password");
			MD5 md=new MD5();
			String sql="select * from admin where name=?";
			admin ad=null;
			JSONObject obj=null;
			try {
				PreparedStatement ps=con.prepareStatement(sql);
				ps.setString(1, name);
				ResultSet rs=ps.executeQuery();
				if(rs.next())
				{
					 ad=new admin();
					 ad.setId(rs.getInt("id"));
					 ad.setName(rs.getString("name"));
					 ad.setPassword(rs.getString("password"));
					 ad.setStatus(rs.getString("status"));
					 if(md.md5crypt(password).equals(rs.getString("password"))) {
						 obj=new JSONObject();
						 obj.put("id", rs.getInt("id"));
						 obj.put("name", rs.getString("name"));
						 obj.put("password", rs.getString("password"));
						 obj.put("status", rs.getString("status"));
					 }
					 
						 
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			out.print(obj);
			out.flush();
			out.close();
			
	}

}
