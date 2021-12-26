fn main() {
    let home = Ip::V4(127, 0, 0, 1);
    let work = Ip::V6(String::from("hello my dudes"));
}

struct IpAddr {
    type: IpAddrType,
    address: String,
}

enum IpAddrType {
    V4,
    V6,
}

enum Ip {
    V4(u8, u8, u8, u8),
    V6(String),
}

impl Ip {
    fn string(&self) {
        println!("{}", match self {
            V4(a, b, c, d) => a,
            V6(s) => s,
        });
    }
}