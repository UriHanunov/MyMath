package myMath;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.function.Predicate;
import myMath.Monom;
/**
 * This class represents a Polynom with add, multiply functionality, it also should support the following:
 * 1. Riemann's Integral: https://en.wikipedia.org/wiki/Riemann_integral
 * 2. Finding a numerical value between two values (currently support root only f(x)=0).
 * 3. Derivative
 * @author Uri Hanunov and Olga Mazo
 */
public class Polynom implements Polynom_able
{
	private ArrayList<Monom> monoms;
	
	/**
	 * this function is a constructor that gets string tnd make it a polynom
	 * @param a the string that the constructor get
	 */
	public Polynom(String a)
	{
		this.monoms = new ArrayList<Monom>();
		a = a.trim(); // delete spaces
		String [] parts = a.split("\\+|\\-"); //new array with all the monoms without '+' or '-'
		if(parts.length==1) //if the string has only one monom, make monom from the string and add it to the array list
		{
			Monom m = monomFromString(a);
			this.monoms.add(m);
		}
		else //the string has more than one monom
		{
			char [] plusMinus; //in this array we save all the signs (+/-)
			int i; //from where we beginning the string
			int j=1; //the place in the array plusMinus
			int k; //from where we beginning the string
			if(a.charAt(0)=='-') //if the first monom negative --> put - in the first place in the signs array
			{
				plusMinus = new char[parts.length-1];
				i=1; //start from 1
				k=1; //start from 1
				plusMinus[0]='-';
			}
			else //if the first monom positive --> put - in the first place in the signs array
			{
				plusMinus = new char[parts.length];
				i=0; //start from 0
				k=0; //start from 0
				plusMinus[0]='+';
			}
			for(; i<a.length() ; i++) //going through all the string and put the signs in the array of signs
			{
				if(a.charAt(i)=='+')
				{
					plusMinus[j]='+';
					j++;
				}
				if(a.charAt(i)=='-')
				{
					plusMinus[j]='-';
					j++;
				}
			}
			j=0; //reset the pointer of the array signs
			for(; k<parts.length ; k++) //check all the monoms in the array parts
			{
				Monom m = monomFromString(parts[k]);
				if(plusMinus[j]=='+') //if the sign is + so we add as it to the polynom arraylist
				{
					this.monoms.add(m);
					j++;
				}
				else //if the sign is - so we add with - before the coefficient
				{
					double temp = m.get_coefficient()*-1;
					Monom m2 = new Monom(temp,m.get_power());
					this.monoms.add(m2);
					j++;
				}
			}
		}
		Monom_Comperator smpByPower = new Monom_Comperator(); //sort the arraylist of polynom by the power
		this.monoms.sort(smpByPower);
		for(int i=0; i<this.monoms.size()-1 ; i++)//if there are monoms in the polynom with same power we united them
		{
			if(this.monoms.get(i).get_power()==this.monoms.get(i+1).get_power())
			{
				this.monoms.get(i).add(this.monoms.get(i+1));
				this.monoms.remove(i+1);
				i--;
			}
		}
	}
	

	/**
	 * this function is the empty constructor
	 */
	public Polynom()
	{
		this.monoms = new ArrayList<Monom>();
	}
	
	/**
	 * represents a function of type y=f(x), where both y and x are real numbers
	 * @param x the number which we check the value of the polynom for
	 * @return the value of the polynom at the x 
	 */
	public double f(double x)
	{
		Iterator<Monom> it = this.monoms.iterator();
		double answer = 0.0; //save the value of all the monoms in the polynom and united them
		while(it.hasNext())
		{
			Monom m = it.next();
			answer=answer+m.f(x);
		}
		return answer;
	}


	/**
     * this function add Polynom_able to this 
     * @param p1 the polynom which we add to this
     * @exception if p1 is nul
     */
	public void add(Polynom_able p1)
	{
		if(p1!=null)
		{
			Iterator<Monom> it = p1.iteretor();
			while(it.hasNext())
			{
				Monom m = it.next();
				this.add(m); 
			}
		}
		else
		{
			throw new RuntimeException("Err:the polynom is null");
		}
	}


	/**
	 * this function add monom to this 
	 * @param m1 the monom that we add to this
	 * @exception if m1 is null
	 */
	public void add(Monom m1)
	{
		if(m1!=null)
		{
			Iterator<Monom> it = this.monoms.iterator();
			boolean added = false;
			while(it.hasNext())
			{
				Monom m = it.next();
				if(m.get_power()==m1.get_power())
				{
					m.add(m1);
					added = true;
				}
			}
			if(!added)
			{
				this.monoms.add(m1);
			}
		}
		else
		{
			throw new RuntimeException("Err:the monom m1 is null");
		}
	}


	/**
	 * this function substract Polynom_able from this
	 * @param p1 the polynom that we substract
	 * @exception if p1 is null
	 */
	public void substract(Polynom_able p1)
	{
		if(p1!=null)
		{
			Iterator<Monom> it = p1.iteretor();
			Monom m2= new Monom(-1,0); //make new monom that will be -1 
			while(it.hasNext())
			{
				Monom m = it.next();
				m.multiply(m2); //multiply the monom that we need to substract with -1 
			}
			this.add(p1); //add to this -p1
		}
		else
		{
			throw new RuntimeException("Err: the string 's' is null");
		}
	}
	
	/**
	 * this function multiply Polynom_able whith this
	 * @param p1 the polynom that we multuplty
	 * @exception if p1 is null
	 */
	public void multiply(Polynom_able p1)
	{
		ArrayList<Monom> temp = new ArrayList<Monom>(); //temp array list in which we save the result
		Iterator<Monom> it = this.monoms.iterator(); //going through all the polynom
		while(it.hasNext())
		{
			Monom m = it.next();
			Iterator<Monom> it2 = p1.iteretor();
			while(it2.hasNext())
			{
				Monom m2=it2.next();
				Monom m3=new Monom(m);//helper variable to not forget the original monom m 
				m3.multiply(m2);
				temp.add(m3); //add to temp the result of multiply
			}
		}
		Monom_Comperator smpByPower = new Monom_Comperator(); 
		temp.sort(smpByPower); //sort the temp array
		for(int i=0; i<temp.size()-1 ; i++)
		{
			if(temp.get(i).get_power()==temp.get(i+1).get_power()) //if there are monoms in the polynom with same power we united them
			{
				temp.get(i).add(temp.get(i+1));
				temp.remove(i+1);
				i--;
			}
		}
		this.monoms.removeAll(monoms); //remove the array of this
		for(int i=0; i<temp.size() ; i++) //copy from temp to this
		{
			this.monoms.add(temp.get(i));
		}
	}


	/**
	 * this function check if Polynom_able is equal to this by comparing thet string represnt
	 * @param p1 the polynom that we compare to this
	 * @return true if they equal, otherwise false
	 */
	public boolean equals(Polynom_able p1)
	{
		String one = this.toString();
		String two = p1.toString();
		if(one.equals(two))
		{
			return true;
		}
		return false;
	}


	/**
	 * this function check if the polynom is the 0 polynom
	 * @return true if it the 0 polynom. otherwise false
	 */
	public boolean isZero()
	{
		Iterator<Monom> it = this.monoms.iterator();
		while(it.hasNext())
		{
			Monom m = it.next();
			if(m.get_coefficient()!=0)
			{
				return false;
			}
		}
		return true;
	}
	
	/**
	 * Compute a value x' (x0<=x'<=x1) for with |f(x')| < eps
	 * assuming (f(x0)*f(x1)<=0, returns f(x2) such that:
	 * 	(i) x0<=x2<=x2 && (ii) f(x2)<eps
	 * @param x0 starting point
	 * @param x1 end point
	 * @param eps step (positive) value
	 * @return the closest x that give us 0
	 */
	public double root(double x0, double x1, double eps)
	{
		double mid=0; //save the middle between x0 and x1
		while(this.f(x0)*this.f(x1)<0) //if the y value of x0 and x1 are - and + so check 
		{
			if(this.f(x0)<=eps && this.f(x0)>=0) //if x0 is close to eps
				return x0;
			if(this.f(x1)<=eps && this.f(x1)>=0) //if x1 is close to eps
				return x1;
			mid = (x0+x1)/2; //calculate the middle
			double a = this.f(mid); //the y value in this point
			a=Math.abs(a);
			if(a<=eps && a>=0) //if the mid close to eps
			{
				return mid;
			}
			if(this.f(mid)*this.f(x0)<0) //if the y value of x0 and mid are - and + so put in x1 the value of mid
				x1=mid;
			else //else put in x0 the value of mid
				x0=mid;
		}
		return mid;
	}

	/**
	 * deep copy semantics
	 * @return the copied polynom
	 */
	public Polynom_able copy()
	{
		Polynom_able copied = new Polynom();
		for(int i=0; i<this.monoms.size() ; i++) //copy from this to a new one
		{
			copied.add(this.monoms.get(i));
		}
		return copied;
	}

	/**
	 * Compute a new Polynom which is the derivative of this Polynom
	 * @return the derivative of this 
	 */
	public Polynom_able derivative()
	{
		Polynom_able deriva = new Polynom(); //save here the derivative of the polynom
		Iterator<Monom> it = this.monoms.iterator();
		while(it.hasNext())
		{
			Monom m = it.next();
			Monom m2 = new Monom(m); //put here monom m for not changing it
			m2.derivative();
			deriva.add(m2); //add to the new polynom
		}
		return deriva; //return the polynom
	}

	/**
	 * Compute Riemann's Integral over this Polynom starting from x0, till x1 using eps size steps
	 * @return the approximated area above the x-axis below this Polynom and between the [x0,x1] range.
	 */
	public double area(double x0, double x1, double eps)
	{
		double answer=0.0; //save the area every time
		double numOfRec = (x1-x0)/eps; //number of rectangles
		for(int i=0 ; i<numOfRec ; i++)
		{
			if(this.f(x0)>0) //if the value of y is bigger than 0 so adeed the area to the sum of area
			{
				answer=answer+(f(x0)*eps);
			}
			x0=x0+eps; //the next rectangle
		}
		return answer; //return the sum of the rectangles
	}

	/**
	 * this function return the Iterator over this polynom
	 * @return an Iterator (of Monoms) over this Polynom
	 */
	public Iterator<Monom> iteretor()
	{
		return this.monoms.iterator();
	}
	
	/**
	 * @return string represent of this
	 */
	public String toString()
	{
		
		Monom_Comperator smpByPower = new Monom_Comperator(); //sort the arry
		this.monoms.sort(smpByPower);
		Iterator<Monom> it = this.monoms.iterator();
		String print = "";
		boolean checkFirst = true; //if the first monom is positive so don't print '+' before it
		while(it.hasNext())
		{
			Monom m = it.next();
			if(checkFirst) //if is the first monom so print it as it
			{
				print=print+m.toString();
				checkFirst=false;
			}
			else
			{
				String s=m.toString(); //the string of the monom
				if(s.charAt(0)!='-') //if it starts with +
				{
					print=print+"+"; //print + before the monom
				}
				print=print+m.toString(); //print the monom, if it - it's print it with the monom
			}
		}
		if(this.isZero()) // if all the polynom is zero
		{
			return "0"; //print 0
		}
		return print;//return all the string of polynom
	}
	
	
	private Monom monomFromString(String s)
	{
		if(s==null)
		{
			throw new RuntimeException("Err: the string 's' is null");
		}
		double coefficient=0.0;
		int power=0;
		s = s.toLowerCase(); //all the letters are smalls
		int index_x = s.indexOf('x'); //find index of x
		if(index_x<0) //if there is not x
		{
			int countPoints=0; //count how many points are in the coefficient
			for(int i=0 ; i<s.length() ; i++)
			{
				if(s.charAt(i)<48 || s.charAt(i)>57) //check if all the chars are numbers
				{
					if(s.charAt(i)=='.') //if it is not a number but is a point so count +1 to the points
					{
						countPoints++;
					}
					else //all the reset is not good
					{
						throw new RuntimeException("Err: the string 's' is illegal");
					}
				}
			}
			if(countPoints>1) //we can't afford more than one point
			{
				throw new RuntimeException("Err: there is more than one point at the coefficient");
			}
			coefficient=Double.parseDouble(s); //make it a number
			Monom m= new Monom(coefficient, power); //make a new monom
			return m;
		}
		else if(index_x==s.length()-1) //if there is x but not power
		{
			power=1;
			if(s.length()==1) // if there is just x 
			{
				coefficient=1;
				Monom m= new Monom(coefficient, power);
				return m;
			}
			int countPoints=0; //like berfore
			int countMul=0; //count how many * there are in the string
			for(int i=0 ; i<index_x ; i++) //this "for" is like the previews one just with count of *
			{
				if(s.charAt(i)<48 || s.charAt(i)>57) 
				{
					if(s.charAt(i)=='.')
					{
						countPoints++;
					}
					else if(s.charAt(i)=='*')
					{
						countMul++;
					}
					else
					{
						throw new RuntimeException("Err: the string 's' is illegal");
					}
				}
			}
			if(countPoints>1 || (countPoints==1 && s.length()==2) || countMul>1 || (countMul==1 && s.charAt(index_x-1)!='*') || (countMul==1 && s.length()==2)) //all the bad options 
			{
				throw new RuntimeException("Err: the string 's' is illegal");
			}
			if(countMul==1) //if there is one *
			{
				String temp = s.substring(0, index_x-1); //make a new string
				coefficient=Double.parseDouble(temp); //make from it a number
				Monom m= new Monom(coefficient, power);
				return m;
			}
			String temp = s.substring(0, index_x); // //make a new string but until the x because we don't have *
			coefficient=Double.parseDouble(temp); ////make from it a number
			Monom m= new Monom(coefficient, power);
			return m;
		}
		else //if there is coefficient and power
		{
			int index_power = s.indexOf('^'); //find the sign '^'
			if(index_power<0) //if there is not '^'
			{
				throw new RuntimeException("Err: there is no a sign of '^' - the string is illegal");
			}
			if(index_power==s.length()-1) //if there is not number after the ^
			{
				throw new RuntimeException("Err: there is no number in the power - the string is illegal");
			}
			for(int i=index_power+1 ; i<s.length() ; i++)//check if all the chars in the power are digits
			{
				if(s.charAt(i)<48 || s.charAt(i)>57)
				{
					throw new RuntimeException("Err: the string 's' is illegal - the numbers in the power are not good");
				}
			}
			String tempPower = s.substring(index_power+1, s.length()); //make a new string for the power
			power=Integer.parseInt(tempPower); //make a number from the string
			if(index_x==0)//if the coefficient is one
			{
				coefficient=1;
				Monom m= new Monom(coefficient, power);
				return m;
			}
			int countPoints=0;//like before, check the points and the *
			int countMul=0;
			for(int i=0 ; i<index_x ; i++)
			{
				if(s.charAt(i)<48 || s.charAt(i)>57)
				{
					if(s.charAt(i)=='.')
					{
						countPoints++;
					}
					else if(s.charAt(i)=='*')
					{
						countMul++;
					}
					else
					{
						throw new RuntimeException("Err: the string 's' is illegal");
					}
				}
			}
			if(countPoints>1 || (countPoints==1 && s.charAt(0)=='.' && index_x==1) || countMul>1 || (countMul==1 && s.charAt(index_x-1)!='*') || (countMul==1 && s.length()==2)) //all the bad options
			{
				throw new RuntimeException("Err: the string 's' is illegal");
			}
			if(countMul==1) //if there is sign of * in the string
			{
				String temp = s.substring(0, index_x-1); //make new string for the coefficient
				coefficient=Double.parseDouble(temp); //make a number from the string
				Monom m= new Monom(coefficient, power);
				return m;
			}
			String temp = s.substring(0, index_x); //make new string for the coefficient, in this case we dont have *
			coefficient=Double.parseDouble(temp); //make a number from the string
			Monom m= new Monom(coefficient, power);
			return m;
		}
	}
	
}