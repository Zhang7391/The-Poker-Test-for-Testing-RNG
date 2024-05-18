# The Poker Test

A part of FIPS 140-2 test.  

# Introduction

FIPS 140-2 has four tests for randomness:  
1. The Runs Test
2. The Poker Test
3. The Monobit Test
4. The Long Run Test

But, only the test "The Poker Test" has been implemented.  

# Getting start
## Maven

```sh
git clone https://github.com/Zhang7391/The-Poker-Test-for-Testing-RNG.git
cd The-Poker-Test-for-Testing-RNG
mvn clean test
```

# The Criteria for Tests
## The Runs Test
- FIPS 140-1:  

| Length of Run | Required Interval |
| :-----------: | :---------------- |
| 1             | 2,267 - 2,733     |
| 2             | 1,079 - 1,421     |
| 3             | 502 - 748         |
| 4             | 223 - 402         |
| 5             | 90 - 223          |
| 6+            | 90 - 223          |

- FIPS 140-2:  

| Length of Run	| Required Interval |
| :-----------:	| :---------------- |
| 1             | 2,315 – 2,685     |
| 2             | 1,114 - 1,386     |
| 3             | 527 - 723         |
| 4             | 240 - 384         |
| 5             | 103 - 209         |
| 6+            | 103 - 209         |

> P.S. DATE OF CHANGE: 2001 October 10.  
> References: National Institute of Standards and Technology. (2001, May 25). CHANGE NOTICES. FIPS PUB 140-2, SECURITY REQUIREMENTS FOR CRYPTOGRAPHIC MODULES. https://nvlpubs.nist.gov/nistpubs/fips/nist.fips.140-2.pdf#page=62  

## The Poker Test
- FIPS 140-1: 1.03 < x < 57.4  
- FIPS 140-2: 2.16 < x < 46.17  

## The Monobit Test
- FIPS 140-1: 9,654 < x < 10,346  
- FIPS 140-2: 9,725 < x < 10,275  

## The Long Run Test
- FIPS 140-1: A long run is defined to be a run of length 34 or more (of either zeros or ones)  
- FIPS 140-2: A long run is defined to be a run of length 26 or more (of either zeros or ones)  

# References
1. National Institute of Standards and Technology. (1994, January 11). FIPS PUB 140-1. Security Requirements for Cryptographic Modules. https://csrc.nist.gov/pubs/fips/140-1/upd1/final  
2. National Institute of Standards and Technology. (2001, May 25). FIPS PUB 140-2. Security Requirements for Cryptographic Modules. https://csrc.nist.gov/pubs/fips/140-2/upd2/final  
3. S. Snouffer (NIST), Annabelle Lee (NIST), Arthur Oldehoeft (NIST). (2001, June). NIST SP 800-29. A Comparison of the Security Requirements for Cryptographic Modules in FIPS 140-1 and FIPS 140-2. https://csrc.nist.gov/pubs/sp/800/29/final  
4. Ananda Vithanage, Takakuni Shimizu. (2003, October 2). FIPS 140-2(Change Notice 1) Random Number Tests. －Distribution Functions and Observed values of RPG100. https://www.fdk.com/cyber-e/pdf/HM-RAE103.pdf  
