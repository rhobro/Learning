fn main() {
    let c = Coin::PENCE_10;
    println!("{}", c.value());

    match c {
        Coin::PENCE_1 => println!("1p"),
        Coin::PENCE_10 => println!("10p"),
        
    }
}

enum Coin {
    PENCE_1,
    PENCE_2,
    PENCE_5,
    PENCE_10,
    PENCE_20,
    PENCE_50,
    POUND_1,
    POUND_2,
}

impl Coin {
    fn value(&self) -> f64 {
        match self {
            Coin::PENCE_1 => 0.01,
            Coin::PENCE_2 => 0.02,
            Coin::PENCE_5 => 0.05,
            Coin::PENCE_10 => 0.1,
            Coin::PENCE_20 => 0.2,
            Coin::PENCE_50 => 0.5,
            Coin::POUND_1 => 1.,
            Coin::POUND_2 => 2.,
        }
    }
}