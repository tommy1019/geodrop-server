package geodrop.servlets;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import geodrop.GeoDropData;
import geodrop.Location;

public class GetIfNearby extends HttpServlet
{
	private static final long serialVersionUID = 2L;

	public GetIfNearby()
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Location l = new Location(request);

			if (GeoDropData.dropDatabase.getIfNearby(l))
			{
				response.getWriter().append("true");
			}
			else
			{
				response.getWriter().append("false");
			}
		}
		catch (NumberFormatException | NullPointerException e)
		{
			response.getWriter().append("Error: " + e.getMessage());
		}
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		doGet(request, response);
	}

}
