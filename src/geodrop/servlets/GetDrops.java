package geodrop.servlets;

import java.io.IOException;
import java.util.ArrayList;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import geodrop.Drop;
import geodrop.GeoDropData;
import geodrop.Location;

public class GetDrops extends HttpServlet
{
	private static final long serialVersionUID = 4L;

	public static final int DISTANCE = 15;
	
	public GetDrops()
	{

	}

	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
	{
		try
		{
			Location l = new Location(request);
			
			ArrayList<Drop> drops = GeoDropData.dropDatabase.getNearbyDrops(l, DISTANCE);
			
			response.getWriter().append("Success\n");
			response.getWriter().append("" + drops.size() + "\n");
			
			for (Drop d : drops)
			{
				response.getWriter().append("" + d.location.latitude + "\n");
				response.getWriter().append("" + d.location.longitude + "\n");
				
				String[] lines = d.message.split("\n");
				response.getWriter().append("" + lines.length + "\n");
				for (String s : lines)
					response.getWriter().append("" + s + "\n");
			}
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
