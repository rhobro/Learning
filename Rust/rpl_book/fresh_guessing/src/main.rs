use std::io;
use std::cmp::Ordering;
use rand::Rng;

fn main() {
    println!("Welcome to the Rust sample guessing game");

    // generate random number
    let secret = rand::thread_rng().gen_range(1..11);

    loop {
        println!("Make a guess");
        let mut guess = String::new();
        io::stdin()
            .read_line(&mut guess)
            .expect("Error reading input");
        let guess: u32 = match guess.trim().parse() {
            Ok(val) => val,
            Err(_) => continue,
        };

        // compare
        match guess.cmp(&secret) {
            Ordering::Less => println!("small"),
            Ordering::Greater => println!("large"),
            Ordering::Equal => {
                println!("Correct!");
                break;
            },
        }
    }
}
