using System;

class Hello
{
    static void Main()
    {
        long i = 1;
        while (true) {
            Console.WriteLine(String.Format("{0} - {1}", i, fib(i)));
            i++;
        }
    }

    static long fib(long n)
    {
        if (n == 0)
        {
            return 0;
        } else if (n == 1)
        {
            return 1;
        }

        return fib(n - 2) + fib(n - 1);
    }
}