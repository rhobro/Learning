use unicode_segmentation::UnicodeSegmentation;

fn main() {
    let s1 = String::from("hello darkness");
    println!("{}", s1);
    let s2 = String::from("my old friend");
    println!("{}", s2);

    let sum = s1 + " " + &s2;
    println!("{}", sum);

    let s1 = String::from("hello darkness");
    let s2 = String::from("my old friend");
    let alternate = format!("{} {}", s1, s2);
    println!("{}", alternate);

    let complex = "नमस्ते";
    for b in complex.bytes() {
        println!("{}", b)
    }
    for c in complex.chars() {
        println!("{}", c)
    }
    for g in complex.graphemes(true) {
        println!("{}", g);
    }
}
