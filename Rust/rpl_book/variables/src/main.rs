use std::io;
use std::io::Write;

fn main() {
    loop {
        let mut guess = String::new();
        loop {
            print!("Index: ");
            io::stdout().flush().unwrap();
            let rs = io::stdin()
                .read_line(&mut guess);
            if rs.is_ok() { break }
            println!("Invalid input")
        }
        let guess: u128 = match guess.trim().parse() {
            Ok(n) => n,
            Err(_) => continue
        };

        println!("{}", fib(guess))
    }
}

fn fib(n: u128) -> u128 {
    match n {
        0 => 0,
        1 => 1,
        _ => fib(n - 2) + fib(n - 1)
    }
}
