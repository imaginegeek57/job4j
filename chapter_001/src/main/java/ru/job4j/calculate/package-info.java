package ru.job4j.calculate;

/**
*Package for calculate*
@author Vlad Mon (imaginegeek57@gmail.com)
*@version $id$
@since 0.1
*/
public class Calculate { 
    public String echo(String value) {
        return String.format("%s %s %s", value, value, value);
    }	

	public static void main(String[] args) {
        Calculate calc = new Calculate();
        System.out.println(calc.echo("aah"));
    }		
}	