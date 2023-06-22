<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@ page import="java.sql.*" %>

<%
String host = "localhost";
String user = "root";
String pw = "03630";
String dbName = "temphumid";

Connection connection = null;
PreparedStatement statement = null;

try {
    Class.forName("com.mysql.cj.jdbc.Driver");
    connection = DriverManager.getConnection("jdbc:mysql://" + host + "/" + dbName + "?useUnicode=true&characterEncoding=UTF-8", user, pw);

    if (connection != null) {
        out.println("MySQL successfully connected!<br/>");

        String id = request.getParameter("id");
        String temp = request.getParameter("temp");
        String humid = request.getParameter("humid");

        out.println("<br/>id = " + id);
        out.println(", ");
        out.println("<br/>temp = " + temp);
        out.println(", ");
        out.println("humid = " + humid + "<br/>");

        String query = "UPDATE temp_humid_data SET temp = ?, humid = ? WHERE id = ?";
        statement = connection.prepareStatement(query);
        statement.setString(1, temp);
        statement.setString(2, humid);
        statement.setString(3, id);
        statement.executeUpdate();

        out.println("<br/>Success!!");
    } else {
        out.println("MySQL could not be connected");
    }
} catch (Exception e) {
    e.printStackTrace();
} finally {
    if (statement != null) {
        try {
            statement.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
    if (connection != null) {
        try {
            connection.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
%>