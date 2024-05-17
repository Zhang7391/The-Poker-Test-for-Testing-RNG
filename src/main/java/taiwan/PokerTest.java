package taiwan;

import java.security.InvalidParameterException;

import static java.lang.Math.pow;


public class PokerTest
{
	public PokerTest() {}

	private static InvalidParameterException lengthInvalid() {return new InvalidParameterException("The test data MUST BE exactly 20000 bits or 2500 Bytes in length.");}

	public static boolean run(byte[] data)
	{
		if(data.length != 2500) throw lengthInvalid();

		final int[] table = new int[16];
		for(int x=0; 16>x; x++) table[x] = 0;

		final int[] digits = new int[]{1, 2, 4, 8};
		for(byte zone : data)
		{
			for(int x=0; 2>x; x++)
			{
				int index = 0;

				for(int pos=0; 4>pos; pos++)
				{
					index += ((zone & 0x1) * digits[pos]);
					zone >>= 1;
				}

				table[index] += 1;
			}
		}

		for(int x : table) System.out.println(x);
		System.out.println("---------");

		double result = 0.0D;

		for(int x=0; 16>x; x++) result += (pow((double)table[x], 2.0D) - 5000D);
		result *= (16.0D / 5000.0D);


		if(46.17D > result && result > 2.16D) return true;
		return false;
	}

	public static boolean run(int[] data)
	{
		if(data.length != 625) throw lengthInvalid();

		return false;
	}
}
