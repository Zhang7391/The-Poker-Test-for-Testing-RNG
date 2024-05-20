package taiwan;

import taiwan.PokerTest;
import java.math.BigDecimal;
import org.junit.jupiter.api.Test;
import java.security.SecureRandom;

import static java.math.RoundingMode.HALF_UP;
import static java.math.MathContext.UNLIMITED;
import static taiwan.PokerTestData.INT_DATA_NUMBER;
import static taiwan.PokerTestData.BYTE_DATA_NUMBER;
import static org.junit.jupiter.api.Assertions.fail;


public class Test_PokerTest
{
	private final PokerTest pokerTest = new PokerTest();
	private final SecureRandom random = new SecureRandom();

	private final int TESTCASE_NUMBER = 2000;


	@Test
	public void byteRNG_Checker()
	{
		final byte[] data = new byte[BYTE_DATA_NUMBER];
		final String exceptionMessage = "Byte RNG not passed.";

		BigDecimal failCounter = BigDecimal.ZERO;

		for(int x=0; TESTCASE_NUMBER>x; x++)
		{
			random.nextBytes(data);
			if(!pokerTest.run(data)) failCounter.add(BigDecimal.ONE, UNLIMITED);
		}

		// Accuracy must be above 99.9%.
		failCounter = failCounter.divide(new BigDecimal(TESTCASE_NUMBER, UNLIMITED), 10, HALF_UP);
		if(failCounter.compareTo(new BigDecimal("0.001", UNLIMITED)) == 1) fail("Accuracy must be above 99.9%.");
	}

	@Test
	public void intRNG_Checker()
	{
		final int[] data = new int[INT_DATA_NUMBER];
		final String exceptionMessage = "Integer RNG not passed.";

		BigDecimal failCounter = BigDecimal.ZERO;

		for(int x=0; TESTCASE_NUMBER>x; x++)
		{
			for(int y=0; INT_DATA_NUMBER>y; y++) data[y] = random.nextInt();
			if(!pokerTest.run(data)) failCounter.add(BigDecimal.ONE, UNLIMITED);
		}

		// Accuracy must be above 99.9%.
		failCounter = failCounter.divide(new BigDecimal(TESTCASE_NUMBER, UNLIMITED), 10, HALF_UP);
		if(failCounter.compareTo(new BigDecimal("0.001", UNLIMITED)) == 1) fail("Accuracy must be above 99.9%.");
	}
}
