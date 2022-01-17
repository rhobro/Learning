use std::fs;

fn main() {
    println!("{}", fs::read_to_string("/Users/rho/Desktop/watches.txt").unwrap());
}
