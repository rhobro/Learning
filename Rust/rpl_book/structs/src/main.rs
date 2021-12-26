fn main() {
    let u = build_user(
        String::from("hello"),
        String::from("darkness"),
    );

    println!("{}", u.email);
    println!("{}", u.username);

    let u = change_username(String::from("new username"), u);

    println!("{}", u.email);
    println!("{}", u.username);

    let col = RGB(32, 55, 255);
    println!("{} {} {}", col.0, col.1, col.2);
}

struct RGB(u8, u8, u8);

struct User {
    active: bool,
    username: String,
    email: String,
    sign_in_count: u64,
}

fn build_user(email: String, username: String) -> User {
    User {
        email,
        username,
        active: true,
        sign_in_count: 1,
    }
}

fn change_username(username: String, profile: User) -> User {
    User {
        username,
        ..profile
    }
}
