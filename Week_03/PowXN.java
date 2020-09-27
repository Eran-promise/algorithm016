package week03;

public class PowXN {

    public double myPow(double x, int n) {
        long N = n;
        if(N < 0){
            x = 1 / x;
            N = -N;
        }
        return fastPow(x, N);
    }

    private double fastPow(double x, long n){
        if(n == 0) return 1.0;
        double temp = fastPow(x, n/2);
        return n % 2 == 0? temp*temp:temp * temp * x;
    }
}
