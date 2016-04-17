package geodrop;

import java.util.ArrayList;

public class DropDatabase
{
	public static final double CLOSE_DISTANCE = 7.0;
	
	public ArrayList<Drop> drops = new ArrayList<>();
	
	public boolean getIfNearby(Location location)
	{
		System.out.println("------------------");
		for (Drop d : drops)
		{
			System.out.println(d.location.distanceTo(location));
			if (d.location.distanceTo(location) < CLOSE_DISTANCE)
				return true;
		}
		
		return false;
	}

	public ArrayList<Drop> getNearbyDrops(Location location, int distance)
	{
		ArrayList<Drop> drops = new ArrayList<>();
		
		System.out.println("------------------");
		for (Drop d : this.drops)
		{
			System.out.println(d.location.distanceTo(location));
			if (d.location.distanceTo(location) < distance)
				drops.add(d);
		}
		
		return drops;
	}
}
