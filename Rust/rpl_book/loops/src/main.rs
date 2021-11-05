fn main() {
    let x = {
        let mut i = 0;
        loop {
            i += 1;

            if i == 100 {
                break i * 10;
            }
        }
    };
    println!("{}", x);
}
