import java.io.*;
import java.util.Comparator;
import java.util.Arrays;

class Comp implements Comparator<String>
{
   public int compare(String str1,String str2)
   {
	//to check if both or one of the strings is null
	//If one string is null then the other string will be the larger one
	//if both are null then both the strings are equal
	
	if(str1==null && str2!=null)
		return -1;
	else if(str2==null && str1!=null)
	        return 1;
	else if(str1==null && str2==null)
	        return 0;
	        
	        
	boolean val=true;//for tracking of previous occurred value
	int len1=str1.length();
	int len2=str2.length();
	int i=0,j=0;
	int ans=0;//for char diff
	
	while(i<len1 &&  j<len2)
	{
		char a=str1.charAt(i);
		char b=str2.charAt(j);
			
		/*for trialing zeroes i.e kloh00000100.txt and kloh00100.txt are same
	          so trailing zeroes should not be considered*/
             	if(val && (a=='0' || b=='0'))
		{
                	while(i<len1 && str1.charAt(i)=='0' )
				i++;
			while(j<len2 && str2.charAt(j)=='0' )
			      	j++;
		}
		else
		{   
			/*
			  If char in both strings is a digit(0-9):
			  If both the string lengths are same then first diff in numbers
			  gives the smaller/larger number.
			*/
			if(checkdig(a)==1 && checkdig(b)==1)
			{
				if(val)
					val=false;//If the previous occurred char is digit the val is set as false
				if(ans==0)
				        ans=a-b;//To find out the first diff in numbers
				i++;
				j++;
			}
			else
			{
			       
				//Both or one of the char in the strings is not a digit
			          
				if(!val)//indicates that previous character was a digit
				{   
				        //If the next char of 1st one is a digit,then 1st string is larger
         				if(checkdig(a)==1)
						return 1;
						    
				  	//else If the next char of 2nd one is a digit,then 2nd string is larger
					else if(checkdig(b)==1)
						return -1;
						    
					//if any previous diff exists,it determines larger/smaller string
					if(ans!=0)
						return ans;
					val=true;
				}
				    
				/*
				   Condition : If one of the char in the strings is neither a digit 
				                  nor a english alphabet i.e special chars like "+,/, ,*".
				                  The one containing the special chars is always smaller
				*/
				if(isdigorchar(a) && !isdigorchar(b))
				{
					return 1;//if 2nd one contains a special char,it is smaller
				}
				else if (!isdigorchar(a) && isdigorchar(b))
				{
					return -1;//if 1st one contains a special char,it is smaller
				}
				    
				/*
				   Condition : If char in both the strings is a special char or 
				                   a english alphabet
				*/
				 else
				{    
				       /*In normal ordering case sensitvity is not considerd,
				         so conversion of all chars to lower case chars*/

					if(isupper(a))
						a+=32;
					if(isupper(b))
						b+=32;

					//comapring if the chars in both strings are equal/smaller/greater    
					if(a!=b)
					        return (a-b);
					else
					{
					        i++;
						j++;
					}
				}
				
				
			}
				
		}
	}
		
	// Condition :  If the lengths are unequal

	if(i<len1) 
	{   
		/*if the len of first one is larger,the current char is digit 
		 then the first string is the larger one eg-compare(text1002,text100)*/

		if(!val && checkdig(str1.charAt(i))==1)
			return 1;
	}
	if (j<len2) 
	{
		/*if the len of 2nd one is larger,the current char is digit 
		  then the 2nd string is the larger one eg-compare(,text100.txt,text1002.txt)*/

		if(!val && checkdig(str2.charAt(j))==1)
			return -1;
	}
		
	//for cases like (kloh300t,kloh500),here kloh300t is smaller
	if(ans!=0)
		return ans;
		
	//if all the chars are same the string smaller in length will be smaller
		return (len1-i+j-len2);
		
   }
	
   public boolean isdigorchar(char p)
   {
		if(p>='0' && p<='9')
			return true;
	     	if(p>='A' && p<='Z')
			return true;
	     	if(p>='a' && p<='z')
			return true;
	     	return false;
		
   }
	
   public boolean isupper(char x)
   {
		return (x>='A' && x<='Z');
   }
	
   public int checkdig(char x)
   {
       		if (x > 47 && x < 58)
    	   		return 1;
       		else
    	   		return 0;
   }
    
   public static void main (String[] args)
   {
	   	Comp test=new Comp();
	    
	 // ex of problem statement
        	System.out.println(test.compare("1 2 10", "1 10 2") < 0);
		System.out.println(test.compare("1/5", "1/20") < 0);
        	System.out.println(test.compare("1210", "1102") > 0);
        	System.out.println(test.compare("-5", "-4") > 0);
        	System.out.println(test.compare("text2", "text10") < 0);
        	System.out.println(test.compare("text2", "text1") > 0);
        	System.out.println(test.compare("text1", "text10") < 0);
    
        //checking for equal string length
        	System.out.println(test.compare("192345","191213") > 0);
        	System.out.println(test.compare("hello12", "hello09") > 0);
        	System.out.println(test.compare("he112","hp112") <0);
        
        //check for diff strign length
        	System.out.println(test.compare("text112", "text1115") < 0);
        	System.out.println(test.compare("123", "12") > 0);
        	System.out.println(test.compare("5text", "12text")<0);
        
        //check with inclusion of delimiters
        	System.out.println(test.compare("text1++2", "text1+2") < 0);
        	System.out.println(test.compare("h e llo", "hello") < 0);
        	System.out.println(test.compare("text1/123", "text1/127")<0);
        	System.out.println(test.compare("7.8.9.3.2", "7.8.9.3.1")>0);
        	System.out.println(test.compare("file12 45", "file12+45")<0);
        
        //checking in case of case sensitivity
        	System.out.println(test.compare("kloh", "KLOH") == 0);
        	System.out.println(test.compare("KLoH10", "kloh10")== 0);
        
        
        //check for trailing zeroes
        	System.out.println(test.compare("kloh000100", "kloh000000100") == 0);
        	System.out.println(test.compare("kloh012", "kloh12")== 0);
        	System.out.println(test.compare("KLoH0000123", "kloh000012")> 0);
        	System.out.println(test.compare("KLoH001text0000003", "kloh000001text03")== 0);
        
        //checking in case of nulls
        	System.out.println(test.compare(null, "") < 0);
        	System.out.println(test.compare("", null) > 0);
        	System.out.println(test.compare(null, null) == 0);
        
       //check for large strings
        	System.out.println(test.compare("kloh123456666666688888888888882345678902345672345672345672345676543234565", "kloh12345666677777734567898762345678765")> 0);
        
        //checking for miscellaneous cases
        	System.out.println(test.compare("kloh300t", "kloh500")<0);
        	System.out.println(test.compare("kloh300t", "kloh300")>0);
        
        //Sorting of string Arrays
        
        	String[] trail = new String[] {"test2.txt", "test10.txt", "test1.txt"};
        	String[] ans = new String[] {"test1.txt", "test2.txt", "test10.txt"};
        
        	Arrays.sort(trail, test);
        	System.out.println(Arrays.equals(trail,ans));
        
        	trail=new String[]{"1t2345.txt","3t234.txt","1text.txt","1t234.txt","1a.txt"};
        	ans=new String[]{"1a.txt","1t234.txt","1t2345.txt","1text.txt","3t234.txt"};
        	Arrays.sort(trail, test);
        	System.out.println(Arrays.equals(trail,ans));
        
        	trail=new String[]{"0000001aaaa","125.txt","01ZZZZ.txt","12text.txt","12+7.txt"};
        	ans=new String[]{"0000001aaaa","01ZZZZ.txt","12+7.txt","12text.txt","125.txt"};
        	Arrays.sort(trail, test);
        	System.out.println(Arrays.equals(trail,ans));
   }
    
}
