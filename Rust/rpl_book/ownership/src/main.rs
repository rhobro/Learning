fn main() {
    let literal = "hello";
    let mut strr = String::from(literal);
    println!("{}", strr);
    strr.push_str("asdfasdf");
    println!("{}", strr);

    let x = 234;
    let y = x;
    println!("x: {}", x);
    println!("y: {}", y);

    let s1 = String::from(literal);
    let s2 = s1;
    let s3 = s2.clone();
    println!("{}", s3);
}
