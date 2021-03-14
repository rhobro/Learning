use rand::Rng;
use std::cmp::Ordering;
use std::io;

fn main() {
    let min = 1;
    let max = 20;
    let n_guesses = 6;

    println!("Guess the number, between {} and {}!", min, max);
    let secret = rand::thread_rng().gen_range(min, max);

    for g in 1..1 + n_guesses {
        let mut guess = String::new();
        println!("Guess {}: ", g);
        io::stdin()
            .read_line(&mut guess)
            .expect("failed to process guess");
        let guess: u16 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                println!("Invalid input");
                continue;
            }
        };

        match guess.cmp(&secret) {
            Ordering::Less => println!("Too small"),
            Ordering::Greater => println!("Too big"),
            Ordering::Equal => {
                println!("Got it!");
                return;
            }
        }
    }
}
