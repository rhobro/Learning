fn main() {
    let cfg = Some(3u8);
    if let Some(max) = cfg {
        println!("max is {}", max);
    }
}
