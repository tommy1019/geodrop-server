package geodrop;

import javax.servlet.http.HttpServletRequest;

public class Location
{
	public static final double EARTH_RADIUS = 6371000;

	public double latitude;
	public double longitude;

	public Location(HttpServletRequest request)
	{
		latitude = Double.parseDouble(request.getParameter("latitude"));
		longitude = Double.parseDouble(request.getParameter("longitude"));
	}

	public Location(double latitude, double longitude)
	{
		this.latitude = latitude;
		this.longitude = longitude;
	}

	public double distanceTo(Location location)
	{
		double rho1 = Math.toRadians(location.latitude);
		double rho2 = Math.toRadians(latitude);
		double delta1 = Math.toRadians(location.latitude - latitude);
		double delta2 = Math.toRadians(longitude - location.longitude);

		double a = Math.sin(delta1 / 2) * Math.sin(delta1 / 2) + Math.cos(rho1) * Math.cos(rho2) * Math.sin(delta2 / 2) * Math.sin(delta2 / 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c;
	}
}
