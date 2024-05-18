package taiwan;

import taiwan.PokerTest;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;

import static org.junit.jupiter.api.Assertions.assertTrue;


public class Test_PokerTest
{
	private final int DOUBLE_LENGTH = 8;
	private final int BYTE_DATA_NUMBERS = 2500;

	@Test
	public void StabilityChecker()
	{
		SecureRandom random = new SecureRandom();
		byte[] data = new byte[BYTE_DATA_NUMBERS];

		for(int x=0; 7391>x; x++)
		{
			random.nextBytes(data);
			assertTrue(PokerTest.run(data));
		}
	}

	@Test
	public void RNG_Checker()
	{
	}
}
