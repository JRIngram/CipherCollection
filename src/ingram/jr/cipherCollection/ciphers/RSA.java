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
	 * de = 1 mod (p-1)(q-1)
	 **/
	private int d;
	
	public RSA(){
		super();
	}
	
	@Override
	public void encrypt(String word) {
		
	}

	@Override
	public void decrypt(String wordToBeDecrypted) {
		
	}
		
	/**Sets the value of p.
	 * @throws IllegalArgumentException if p is not prime.
	 * @param p Value of p, must be above 1 and below 2147483647.
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
	
	/**Sets the values of p, q, n and m
	 * 
	 * @param p Value of p, must be above 1 and below 2147483647.
	 * @param q Value of q, must be above 1 and below 2147483647.
	 */
	public void setPQAndDerivatives(int p, int q){
		if((p * q) > Integer.MAX_VALUE){
			throw new IllegalArgumentException();
		}else{
			setP(p);
			setQ(q);
			setNAndM();
		}
	}
	
	public int getP(){
		return p;
	}
	
	public int getQ(){
		return q;
	}
	/**Returns value of n.
	 * 
	 * @return n which is equal to p*q.
	 */
	public int getN(){
		return n;
	}
	
	/**Returns the value of m.
	 * 
	 * @return m which is equal (p-1)(q-1)
	 */
	public int getM(){
		return m;
	}
	
	/**Sets the value of e, must be coprime with m.
	 * 
	 * @param e The value of e, must be above 1 and below m.
	 */
	public void setE(int e){
		if(euclidean(e,m) == 1  && m > e && e > 1){
			this.e = e;
		}
		else{
			throw new IllegalArgumentException();
		}
	}
	
	public int getE(){
		return e;
	}
	
	public void setD(){
		d = extendedEuclidean(e, m);
	}
	
	public int getD(){
		return d;
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
	 * @param a Should be the value of e
	 * @param b Should be the value of m
	 * @return The value of d, such that d*e % m = 1
	 */
	public int extendedEuclidean(int a, int b) {
		//hcf(k, pq) = 1
		//n = qd + r
		//b acts as the divisor (d).
		int originalB = b;
		int prevX = 1;
		int x = 0;
		int prevY = 0;
		int y = 1;
		
		while(b != 0){
			int quotient = a/b;
			
			int tempX = x;
			x = prevX - (quotient * x);
			prevX = tempX;
			
			int tempY = y;
			y = prevY - (quotient * y);
			prevY = tempY;
			
			int tempA;
			tempA = a;
			a = b;
			b = tempA % b;
			
		}
		System.out.println(prevX);
		System.out.println(prevY);
		if(prevX < 0){
			prevX = originalB + prevX;
			System.out.println("PREVX NOW: "+ prevX);
		}
		return prevX;
	}
	
	/**Calculates highest common factor.
	 * 
	 * @param a Higher number
	 * @param b Lower number
	 *
	 */
	private int euclidean(int a, int b){
		if(a > 1 && b > 1){
			if(b > a){
				int temp = a;
				a = b;
				b = temp;	
			}
		}
		while(a % b != 0){
			int tmp = a;
			a = b;
			b = tmp % b;
		}
		return b;
	}
	
	public static int fastModExp(int message, int mod, int exp){
		try{
			String exponent = Integer.toBinaryString(exp);
			int l = 1;
			for(int i = exponent.length() - 1; i >=0; i--){
				if(exponent.charAt(i) == '1'){
					l = (l * message) % mod;    			
				}
				message = (message * message) % mod;	
			}
			return l;
		}
		catch(Exception e){
			System.out.println("ERROR IN fastModExp!");
			return 0;
		}
	}

}

