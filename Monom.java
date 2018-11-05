package myMath;
/**
 * This class represents a simple "Monom" of shape a*x^b, where a is a real number and a is an integer (summed a none negative), 
 * see: https://en.wikipedia.org/wiki/Monomial 
 * The class implements function and support simple operations as: construction, value at x, derivative, add and multiply. 
 * @author Uri Hanunov and Olga Mazo
 */
public class Monom implements function
{
	private double _coefficient;
	private int _power;
	
	/**
	 * this function is the constructor 
	 * @param a the coefficient ot the monom
	 * @param b the power of the monom
	 */
	public Monom(double a, int b)
	{
		this.set_coefficient(a);
		this.set_power(b);
	}
	
	/**
	 * this function is the empty constructor
	 * it sets the coefficient and the power to 0
	 */
	public Monom()
	{
		this(0,0);
	}
	
	/**
	 * this function is the copy constructor
	 * @param ot the monom that we copy
	 */
	public Monom(Monom ot)
	{
		this(ot.get_coefficient(), ot.get_power());
	}
	
	/**
	 * this fuction set the coefficient of the monom 
	 * the coefficient can be any real number
	 * @param a the value of the coefficient
	 */
	private void set_coefficient(double a)
	{
		this._coefficient = a;
	}
	
	/**
	 * this fuction set the power of the monom
	 * the power must be bigger or equal to 0
	 * @exception if p smaller than 0
	 * @param p the value of the power
	 */
	private void set_power(int p)
	{
		if(p<0)
		{
			throw new RuntimeException("Err: the power can't be negetive");
		}
		this._power=p;
	}
	
	/**
	 * this function returns the coefficient of the monom
	 * @return the coefficient
	 */
	public double get_coefficient()
	{
		return this._coefficient;
	}
	
	/**
	 * this function returns the power of the monom
	 * @return the power
	 */
	public int get_power()
	{
		return this._power;
	}
	
	/**
	 * represents a function of type y=f(x), where both y and x are real numbers
	 * @param x the number which we check the value of the monom for
	 * @return the value of the monom in the x
	 */
	public double f(double x)
	{   
		//if the power=0 there is only coefficient without power
		if(this._power==0)
		{
			return this._coefficient;
		}
		double mul=1.0;
		for(int i=0 ; i<this._power ; i++)
		{
			mul=mul*x;
		}
		mul=mul*this._coefficient;
		return mul;
	}
	
	/**
	 * this fuction check if two monoms are equal
	 * @param m1 the monom that ew compera
	 * @return true if the monoms are equal, otwerwise false
	 */
	public boolean equals(Monom m1)
	{
		if(m1!=null)
		{   
			//check if the coefficient and the power of both monom's are equal
			if(this._coefficient==m1.get_coefficient() && this._power==m1.get_power())
			{
				return true;
			}
			return false;
		}
		else
		{
			throw new RuntimeException("Err: the monom m1 is null");
		}
	}
	
	/**
	 * this fuction add monom to this monom
	 * @param m1 the monom that we add to this
	 * @exception if m1 is null
	 */
	public void add(Monom m1)
	{
		if(m1!=null)
		{
			//do the add only if the powers are equal
			if(this._power==m1.get_power())
			{
				this._coefficient=this._coefficient+m1.get_coefficient();
			}
		}
		else
		{
			throw new RuntimeException("Err: the monom m1 is null");
		}
	}
	
	/**
	 *this fuction multiply monom whith this monom 
	 * @param m1 the monom that we multiply whith this monom
	 * @exception if m1 is null
	 */
	public void multiply(Monom m1)
	{
		if(m1!=null)
		{
			this._coefficient=this._coefficient*m1.get_coefficient();
			this._power=this._power+m1.get_power();
		}
		else
		{
			throw new RuntimeException("Err: the monom m1 is null");
		}
	}
	
	/**
	 * this function updatas the monom to it's derivative
	 */
	public void derivative()
	{
		if(this._power!=0)
		{
			this._coefficient = this._coefficient*this._power;
			this._power = this._power-1;
		}
		else
		{
			this._coefficient = 0;
		}
	}
	
	/**
	 * this function return a string represnt of the monom
	 * @return string represent of the monom
	 */
	public String toString()
	{
		if(this._power!=0 && this._coefficient!=0)
		{
			//print the coefficient as int and not as double
			if(this._coefficient%1==0)
			{
				if(this._power==1)
				{
					return ((int)this._coefficient + "*X");
				}
				return ((int)this._coefficient + "*X^" + this._power);
			}
			return (this._coefficient + "*X^" + this._power);
		}
		if(this._coefficient==0)
		{
			return "";
		}
		if(this._coefficient%1==0)
		{
			return ((int)this._coefficient+"");
		}
		return (this._coefficient+"");
	}
}