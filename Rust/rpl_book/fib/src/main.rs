fn main() {
    println!("{}", fib(1));
    println!("{}", fib(2));
    println!("{}", fib(3));
    println!("{}", fib(4));
    println!("{}", fib(10));
    println!("{}", fib(100));
}

fn fib(n: u64) -> u64 {
    if n == 1 || n == 2 {
        return 1;
    }
    fib(n - 2) + fib(n - 1)
}
