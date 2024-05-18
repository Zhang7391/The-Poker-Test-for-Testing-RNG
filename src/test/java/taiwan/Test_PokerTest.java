package taiwan;

import taiwan.PokerTest;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test_PokerTest
{
	private final int DOUBLE_LENGTH = 8;
	private final int INT_DATA_NUMBER = 625;
	private final int BYTE_DATA_NUMBER = 2500;

	private final PokerTest pokerTest = new PokerTest();
	private final SecureRandom random = new SecureRandom();


	@Test
	public void byteRNG_Checker()
	{
		byte[] data = new byte[BYTE_DATA_NUMBER];

		for(int x=0; 2000>x; x++)
		{
			random.nextBytes(data);
			assertTrue(pokerTest.run(data));
		}
	}

	@Test
	public void intRNG_Checker()
	{
		int[] data = new int[INT_DATA_NUMBER];

		for(int x=0; 2000>x; x++)
		{
			for(int y=0; INT_DATA_NUMBER>y; y++) data[y] = random.nextInt();
			assertTrue(pokerTest.run(data));
		}
	}
}
