package geodrop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import geodrop.Drop;
import geodrop.GeoDropData;
import geodrop.Location;

public class AddDrop extends HttpServlet
{
	private static final long serialVersionUID = 3L;

	public AddDrop()
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Location l = new Location(request);
			GeoDropData.dropDatabase.drops.add(new Drop(l, request.getParameter("message").replace('_', ' ').replace(';', '\n')));
			
			System.out.println("Added Message at (" + l.latitude + ", " + l.longitude + ")");
			
			response.getWriter().append("Success");
		}
		catch (NumberFormatException | NullPointerException e)
		{
			response.getWriter().append("Err");
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
