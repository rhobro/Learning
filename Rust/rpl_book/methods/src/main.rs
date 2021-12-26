fn main() {
    let r = Rect {
        width: 33,
        height: 43,
    };
    println!("{}", r.area());

    let r2 = Rect {
        width: 323,
        height: 4,
    };
    let r3 = Rect {
        width: 21,
        height: 14,
    };
    let r4 = Rect::square(5);
    println!("{}", r.can_hold(&r2));
    println!("{}", r.can_hold(&r3));
    println!("{}", r.can_hold(&r4));
}

#[derive(Debug)]
struct Rect {
    width: u32,
    height: u32,
}

impl Rect {
    fn area(&self) -> u32 {
        self.width * self.height
    }

    fn can_hold(&self, other: &Rect) -> bool {
        self.width > other.width && self.height > other.height
    }

    fn square(size: u32) -> Rect {
        Rect {
            width: size,
            height: size,
        }
    }
}