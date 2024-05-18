package taiwan;

import taiwan.PokerTest;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;

import static taiwan.PokerTestData.INT_DATA_NUMBER;
import static taiwan.PokerTestData.BYTE_DATA_NUMBER;
import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test_PokerTest
{
	private final PokerTest pokerTest = new PokerTest();
	private final SecureRandom random = new SecureRandom();


	@Test
	public void byteRNG_Checker()
	{
		final byte[] data = new byte[BYTE_DATA_NUMBER];
		final String exceptionMessage = "Byte RNG not passed.";

		for(int x=0; 2000>x; x++)
		{
			random.nextBytes(data);
			assertTrue(pokerTest.run(data), "Byte RNG not passed.");
		}
	}

	@Test
	public void intRNG_Checker()
	{
		final int[] data = new int[INT_DATA_NUMBER];
		final String exceptionMessage = "Integer RNG not passed.";

		for(int x=0; 2000>x; x++)
		{
			for(int y=0; INT_DATA_NUMBER>y; y++) data[y] = random.nextInt();
			assertTrue(pokerTest.run(data), exceptionMessage);
		}
	}
}
