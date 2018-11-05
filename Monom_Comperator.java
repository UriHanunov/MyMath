package myMath;
import java.util.Comparator;
/**
 * 
 * @author Uri Hanunov and Olga Mazo
 *
 */
public class Monom_Comperator implements Comparator<Monom>
{
	public int compare(Monom arg0, Monom arg1)
	{
		if(arg0.get_power()>arg1.get_power())
			return -1;
		else if(arg0.get_power()==arg1.get_power())
		{
			return 0;
		}
		else
			return 1;
	}
}