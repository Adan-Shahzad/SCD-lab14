public class Practice2 {
    public static void basicPrimeCheck(int l) {
        long startTime = System.currentTimeMillis();
        int primeCount = 0;
        for (int num = 2; num <= l; num++) {
            boolean isPrime = true;
            for (int divisor = 2; divisor <= num / 2; divisor++) {
                if (num % divisor == 0) {
                    isPrime = false;
                    break;
                }
            }
            if (isPrime) {
                primeCount++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Basic method:");
        System.out.println("Total primes found: " + primeCount);
        System.out.println("Execution time: " + (endTime - startTime) + " ms\n");
    }
    public static void sieveOfEratosthenes(int l) {
        long startTime = System.currentTimeMillis();

        boolean[] isPrime = new boolean[l + 1];
        for (int i = 2; i <= l; i++) {
            isPrime[i] = true;
        }
        for (int p = 2; p * p <= l; p++) {
            if (isPrime[p]) {
                for (int i = p * p; i <= l; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        int primeCount = 0;
        for (int i = 2; i <= l; i++) {
            if (isPrime[i]) {
                primeCount++;
            }
        }
        long endTime = System.currentTimeMillis();
        System.out.println("Sieve of Eratosthenes method:");
        System.out.println("Total primes found: " + primeCount);
        System.out.println("Execution time: " + (endTime - startTime) + " ms\n");
    }

    public static void main(String[] args) {
        int limit = 50000;
        System.out.println("Finding primes using basic nested loops:");
        basicPrimeCheck(limit);
        System.out.println("Finding primes using Sieve of Eratosthenes:");
        sieveOfEratosthenes(limit);
    }
}
