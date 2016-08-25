package ingram.jr.cipherCollection.ciphers;

public class RSA extends Cipher {
	
	/**
	 * Must be prime with q.
	 */
	private int p;
	
	/**
	 * Must be prime with q.
	 */
	private int q;
	
	/**
	 * n = p*q
	 */
	private int n;
	
	/**
	 * m = (p-1)(q-1)
	 */
	private int m;
	
	/**
	 * Must be coprime with m.
	 * 1 < e < m 
	 * (n, e) forms the public key.
	 * (ed = 1 mod m) forms private key.
	 **/ 
	private int e;
	
	/**Private key: d
	 * ed = 1 mod (p-1)(q-1)
	 **/
	private int d;
	
	public RSA(){
		
	}
	
	@Override
	public void encrypt(String word) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void decrypt(String wordToBeDecrypted) {
		// TODO Auto-generated method stub
		
	}
		
	/**Sets the value of p.
	 * @throws IllegalArgumentException if p is not prime.
	 * @param p Value of q, must be above 1 and below 2147483647.
	 */
	private void setP(int p){
		if(eratothenes(p)){
			this.p = p;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	/**Sets the value of q.
	 * @throws IllegalArgumentException if q is not prime.
	 * @param q Value of q, must be above 1 and below 2147483647.
	 */
	private void setQ(int q){
		if(eratothenes(q)){
			this.q = q;
		}else{
			throw new IllegalArgumentException();
		}

	}
	
	/**Sets the value of n as n=pq and m as m=(p-1)(q-1)
	 * 	
	 */
	private void setNAndM(){
		n = p*q;
		m = (p-1)*(q-1);
	}
	
	/**
	 * 
	 * @param p
	 * @param q
	 */
	public void setPQAndDerivatives(int p, int q){
		setP(p);
		setQ(q);
		setNAndM();
	}
	
	
	/**Performs sieve of Eratosthenes to check if number is prime
	 * @return true if prime, false if not prime.
	 */
	private boolean eratothenes(int a){
		if(a == 2 | a == 3 | a == 5 | a == 7){
			return true;
		}else if(a <= 1 | a >= Integer.MAX_VALUE | a % 2 == 0 | a % 3 == 0 | a % 5 == 0 | a % 7 == 0){
			return false;
		}else{
			return true;
		}	
	}
	
	/** Performs extended Euclidan algorithm on the parameters.
	 * 
	 * @param a
	 * @param b
	 * @return 
	 */
	public static int extendedAlgorithm(int a, int b) {
		//hcf(k, pq) = 1
		//n = qd + r
		//b acts as the divisor (d).
		int x = 0; 
		int prevX = 1; 
		while (b != 0){
			int quotient = a / b; 
			int remainder = a % b;
			
			//Higher = lower and lower = remainder
			a = b;
			b = remainder; 
			int temp = x;
			x = prevX - quotient * x; //x = previous x - ((a/b) * x).  Generates new x.
			prevX = temp;
		}
		return prevX;
	}
}

