fn main() {
    let r = Rect {
        width: 30,
        height: 30,
    };

    dbg!(&r);
}

#[derive(Debug)]
struct Rect {
    width: u32,
    height: u32,
}

fn area(r: &Rect) -> u32 {
    r.width * r.height
}