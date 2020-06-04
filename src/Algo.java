import java.math.BigInteger;
import java.security.SecureRandom;
import java.util.Random;
import parcs.*;

public class Algo implements AM {

 	boolean[] primes;
	
    public Eratosfen(int n) {
        primes=new boolean[n+1];
    }
	
   public void fillSieve() {
        Arrays.fill(primes, true);
        primes[0] = false;
        primes[1] = false;
        for (int i = 2; i < primes.length; ++i) {
            if (primes[i]) {
                for (int j = 2; i * j < primes.length; ++j) {
                    primes[i * j] = false;
                }
            }
        }
    }
    public void run(AMInfo info) {
        int result = 0;
	BigInteger N = (BigInteger) info.parent.readObject();
        int It = info.parent.readInt();
	boolean pr = isPrime(N, It);
	if (pr) {result = 1;}
	else {result = 0;}
        point p = info.createPoint();
        channel c = p.createChannel();
        p.execute("Algo");
        c.write(N);
        c.write(It);
	Eratosfen(int 100);
	    for (int i=0;i<primes.length;++i)
		    if (primes[i]==1) result++;
        info.parent.write(result);
    }
}
