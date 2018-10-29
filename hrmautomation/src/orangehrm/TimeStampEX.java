package orangehrm;

import org.apache.commons.net.ntp.TimeStamp;
import org.omg.CORBA.Current;

public class TimeStampEX
{
	public static void main(String[] args)
	{
		TimeStamp ts=new TimeStamp(System.currentTimeMillis());
	}
}
