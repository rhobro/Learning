use std::io;
use rand::Rng;
use std::cmp::Ordering;

fn main() {
    println!("Guess the number!");
    let secret = rand::thread_rng().gen_range(1, 20);

    for _ in 0..5 {
        let mut guess = String::new();
        println!("Guess: ");
        io::stdin()
            .read_line(&mut guess)
            .expect("failed to process guess");
        let guess: u16 = match guess.trim().parse().expect("Invalid input") {
            Ok(num) => num,
            Err(_) => continue,
        };

        match guess.cmp(&secret) {
            Ordering::Less => println!("Too small"),
            Ordering::Greater => println!("Too big"),
            Ordering::Equal => {
                println!("Got it!");
                return
            }
        }
    }


}