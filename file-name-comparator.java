
public class comparator {
	
	public int compare(String str1,String str2)
	{
		boolean val=true;
		int len1=str1.length();
		int len2=str2.length();
		int i=0,j=0;
		int ans=0;
		
		while(i<len1 &&  j< len2)
		{
			char a=str1.charAt(i);
			char b=str2.charAt(i);
			
			if(checkdig(a)==1 && checkdig(b)==1)
			{
				if(val)
				  val=false;
				if(ans==0)
				  ans=a-b;
				i++;
				j++;
			}
			else
			{
				if(a==' ' || b==' ')
				{
					if(a==' ')
						i++;
					if(b==' ')
						j++;
					continue;
				}
				
				if(!isdigorchar(a) || !isdigorchar(b))
				{
					if(!isdigorchar(a))
						i++;
					if(!isdigorchar(b))
						j++;
					continue;
				}
					
				if(!val)
				{
					if(checkdig(a)==1)
						return 1;
					else if(checkdig(b)==1)
						return -1;
					if(ans!=0)
						ans=diff(a,b);
					val=true;
				}
				else
				{
					if(a>b)
						return 1;
					else if(a<b)
						return -1;
					else
					{
						i++;
						j++;
					}
				}
				
				
			}
				
		}
		if(i<len1) 
		{
			if(val && checkdig(str1.charAt(i))==1)
			return -1;
		}
		else if (j<len2) 
		{
			if(val && checkdig(str2.charAt(j))==1)
			return 1;
		}
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
	public int diff(char p,char q)
	{
		 if (isupper(p))
	            p += 32;
	     if (isupper(q))
	            q += 32;
          return p - q;
	}
	public boolean isupper(char x)
	{
		return (x>='A' && x<='Z');
	}
	
   public int checkdig(char p)
    {
       if (p > 47 && p < 58)
    	   return 1;
       else
    	   return 0;
    }

}
