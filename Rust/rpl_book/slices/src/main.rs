fn main() {
    let s = String::from("Hello world!");
    println!("{}", first_word(&s));
    
    let subject = String::from("hola me llamo");
    let hola = &subject[..5];
    let llamo = &subject[8..];
    println!("{}", hola);
    println!("{}", llamo);
}

fn first_word(s: &String) -> &str {
    let bytes = s.as_bytes();

    for (i, &item) in bytes.iter().enumerate() {
        if item == b' ' {
            return &s[..i];
        }
    }
    ""
}