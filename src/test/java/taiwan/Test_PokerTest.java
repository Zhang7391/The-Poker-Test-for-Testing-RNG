package taiwan;

import taiwan.PokerTest;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;


public class Test_PokerTest
{
	private final int DOUBLE_LENGTH = 8;
	private final int BYTE_DATA_NUMBERS = 2500;

	@Test
	public void StabilityChecker()
	{
		int now = 0;
		byte[] data = new byte[BYTE_DATA_NUMBERS];

		SecureRandom random = new SecureRandom();
		random.nextBytes(data);

		PokerTest.run(data);
	}

	@Test
	public void RNG_Checker()
	{
	}
}
