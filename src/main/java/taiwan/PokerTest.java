package taiwan;

import java.nio.ByteBuffer;
import java.math.BigDecimal;
import java.security.InvalidParameterException;

import static java.math.RoundingMode.HALF_UP;
import static java.math.MathContext.UNLIMITED;


public class PokerTest
{
	public PokerTest() {}

	// Exception.
	private InvalidParameterException lengthInvalid() {return new InvalidParameterException("The test data MUST BE exactly 20000 bits or 2500 Bytes in length.");}

	// [2^0, 2^1, 2^2, 2^3]
	final int[] digits = new int[]{1, 2, 4, 8};

	public boolean run(byte[] data)
	{
		// Test data MUST BE 20000 bits.
		if(data.length != 2500) throw lengthInvalid();

		// Storing the occurrences of the 16 conditions.
		// 0000, 0001, 0010, ..., 1111
		final int[] table = new int[16];
		for(int x=0; 16>x; x++) table[x] = 0;

		// Process each Byte.
		for(byte zone : data)
			for(int index : this.getPositions(zone))
				table[index] += 1;

		BigDecimal result = this.mainPokerTest(table);

		// The test passes if 46.17 > result > 2.16.
		if((result.compareTo(new BigDecimal("2.16", UNLIMITED)) == 1) &&
		   (result.compareTo(new BigDecimal("46.17", UNLIMITED)) == -1)) return true;
		return false;
	}

	public boolean run(int[] data)
	{
		// Test data MUST BE 20000 bits.
		if(data.length != 625) throw lengthInvalid();

		// Storing the occurrences of the 16 conditions.
		// 0000, 0001, 0010, ..., 1111
		final int[] table = new int[16];
		for(int x=0; 16>x; x++) table[x] = 0;

		// Process each int.
		for(int integer : data)
			for(int index : this.getPositions(integer))
				table[index] += 1;

		BigDecimal result = this.mainPokerTest(table);

		// The test passes if 46.17 > result > 2.16.
		if((result.compareTo(new BigDecimal("2.16", UNLIMITED)) == 1) &&
		   (result.compareTo(new BigDecimal("46.17", UNLIMITED)) == -1)) return true;
		return false;
	}

	private int[] getPositions(int value)
	{
		int now = 0;

		// A int have 32 bits.
		final int[] indexes = new int[8];

		// Convert int to Byte.
		for(byte part : ByteBuffer.allocate(4).putInt(value).array())
			for(int x : this.getPositions(part))
			{
				indexes[now] = x;
				now += 1;
			}

		return indexes;
	}

	private int[] getPositions(byte value)
	{
		// A Byte have 8 bits.
		final int[] indexes = new int[2];

		for(int x=0; 2>x; x++)
		{
			int index = 0;

			for(int pos=0; 4>pos; pos++)
			{
				// Read a bit.
				index += ((value & 0x1) * this.digits[pos]);
				value >>= 1;
			}

			indexes[x] = index;
		}

		return indexes;
	}

	private BigDecimal mainPokerTest(int[] table)
	{
		BigDecimal result = BigDecimal.ZERO;						// 0.0
		BigDecimal fievThousand = new BigDecimal(5000, UNLIMITED);  // 5000.0
		
		// According to the FIPS 140-2 the poker test standard.
		for(int x=0; 16>x; x++)
			result = result.add((new BigDecimal(table[x], UNLIMITED)).pow(2, UNLIMITED), UNLIMITED);
		result = result.multiply((new BigDecimal(16, UNLIMITED)).divide(fievThousand, 10, HALF_UP), UNLIMITED);
		result = result.subtract(fievThousand, UNLIMITED);

		return result;
	}
}
