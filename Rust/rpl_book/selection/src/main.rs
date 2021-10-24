use std::io;

fn main() {
    let mut n = String::new();
    io::stdin().read_line(&mut n).expect("error reading input");
    let n: u128 = match n.trim().parse() {
        Ok(v) => v,
        Err(_) => {
            println!("error parsing");
            return;
        },
    };

    if n < 5 {
        println!("less than 5");
    } else if n < 20 {
        println!("less than 20");
    } else {
        println!("wayyyy to big");
    }
}
