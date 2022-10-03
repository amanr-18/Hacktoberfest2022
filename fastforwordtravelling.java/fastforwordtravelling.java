import java.math.*;

import java.util.*;

import java.io.*;

public class Main {



    void solve() {

        int t=ni();

        fact=new long[1000001];

        inv=new long[1000001];

        fact[0]=1;

        for(int i=1;i<=1e6;i++) fact[i]=(fact[i-1]*i)%M;

        inv[1000000]=modInverse(fact[1000000],M);

        for(int i=1000000-1;i>=0;i--) inv[i]=(inv[i+1]*(i+1))%M;

        out :while(t-->0){

            int n=ni();

            int a[]=new int[n+1];

            for(int i=1;i<=n;i++) a[ni()]++;

            long ans=1;

            for(int i=1;i<=n;i++){

                if(a[i]%i!=0){

                    pw.println("0");

                    continue out;

                }

                if(a[i]==0) continue;

                long d=1;

                d=(d*inv[a[i]/i])%M;

                while(a[i]!=0){

                    d=(d*get(a[i],i))%M;

                    a[i]-=i;

                }

                ans=(ans*d)%M;



            }

            pw.println(ans);

        }

    }

    long fact[];

    long inv[];

    long get(int n,int r){

        long ans=fact[n];

        ans=(ans*inv[n-r])%M;

        ans=(ans*modInverse(r,M))%M;

        return ans;

    }

    long mul(long a, long b,long M)

    {

        return (a*1L*b)%M;

    }

    long modpow(long a, long b,long M)

    {

        long r=1;

        while(b>0)

        {

            if((b&1)>0) r=mul(r,a,M);

            a=mul(a,a,M);

            b>>=1;

        }

        return r;

    }



    long modInverse(long A, long M)

    {



        return modpow(A,M-2,M);

    }



    long M=998244353;

    InputStream is;

    PrintWriter pw;

    String INPUT = "";

    void run() throws Exception {

        is = INPUT.isEmpty() ? System.in : new ByteArrayInputStream(INPUT.getBytes());

        pw = new PrintWriter(System.out);

        long s = System.currentTimeMillis();

        solve();

        pw.flush();

        if(!INPUT.isEmpty())tr(System.currentTimeMillis()-s+"ms");

    }



    public static void main(String[] args) throws Exception { new Main().run(); }



    private byte[] inbuf = new byte[1024];

    public int lenbuf = 0, ptrbuf = 0;



    private int readByte() {

        if(lenbuf == -1)throw new InputMismatchException();

        if(ptrbuf >= lenbuf){

            ptrbuf = 0;

            try { lenbuf = is.read(inbuf); } catch (IOException e) { throw new InputMismatchException(); }

            if(lenbuf <= 0)return -1;

        }

        return inbuf[ptrbuf++];

    }



    private boolean isSpaceChar(int c) { return !(c >= 33 && c <= 126); }

    private int skip() { int b; while((b = readByte()) != -1 && isSpaceChar(b)); return b; }



    private double nd() { return Double.parseDouble(ns()); }

    private char nc() { return (char)skip(); }



    private String ns() {

        int b = skip();

        StringBuilder sb = new StringBuilder();

        while(!(isSpaceChar(b))){ // when nextLine, (isSpaceChar(b) && b != ' ')

            sb.appendCodePoint(b);

            b = readByte();

        }

        return sb.toString();

    }



    private char[] ns(int n) {

        char[] buf = new char[n];

        int b = skip(), p = 0;

        while(p < n && !(isSpaceChar(b))){

            buf[p++] = (char)b;

            b = readByte();

        }

        return n == p ? buf : Arrays.copyOf(buf, p);

    }



    private char[][] nm(int n, int m) {

        char[][] map = new char[n][];

        for(int i = 0;i < n;i++)map[i] = ns(m);

        return map;

    }



    private int[] na(int n) {

        int[] a = new int[n];

        for(int i = 0;i < n;i++)a[i] = ni();

        return a;

    }



    private int ni() {

        int num = 0, b;

        boolean minus = false;

        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));

        if(b == '-'){

            minus = true;

            b = readByte();

        }



        while(true){

            if(b >= '0' && b <= '9'){

                num = num * 10 + (b - '0');

            }else{

                return minus ? -num : num;

            }

            b = readByte();

        }

    }



    private long nl() {

        long num = 0;

        int b;

        boolean minus = false;

        while((b = readByte()) != -1 && !((b >= '0' && b <= '9') || b == '-'));

        if(b == '-'){

            minus = true;

            b = readByte();

        }



        while(true){

            if(b >= '0' && b <= '9'){

                num = num * 10 + (b - '0');

            }else{

                return minus ? -num : num;

            }

            b = readByte();

        }

    }



    private void tr(Object... o) { if(INPUT.length() > 0)System.out.println(Arrays.deepToString(o)); }

}
