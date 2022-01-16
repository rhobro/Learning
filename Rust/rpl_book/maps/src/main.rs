use std::collections::HashMap;

fn main() {
    let mut scores = HashMap::new();

    scores.insert(String::from("Blue"), 10);
    scores.insert(String::from("Yellow"), 50);

    let teams = vec![String::from("Blue"), String::from("Yellow")];
    let scores = vec![10, 50];

    let mut scores: HashMap<_, _> = teams.into_iter().zip(scores.into_iter()).collect();

    for (k, v) in &scores {
        println!("{}: {}", k, v);
    }

    scores.entry(String::from("Blue")).or_insert(20);
    scores.entry(String::from("Green")).or_insert(100);
}
