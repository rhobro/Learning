fn main() {
    let x = 5;

    let x = x + 1;

    {
        let x = x * 2;
        println!("The value of x in the inner scope is: {}", x);
    }

    println!("The value of x is: {}", x);

    let x = '😂';
    println!("{}", x);

    let tup = (500, 5.5, true);
    let (x, y, z) = tup;
    println!("{} {}", tup.0, x);
    println!("{} {}", tup.1, y);
    println!("{} {}", tup.2, z);

    let months = ["Jan", "Feb", "Mar", "Apr", "May", "Jun", "Jul", "Aug", "Sep", "Oct", "Nov", "Dec"];
    let a: [f64; 5] = [2e20, 2e21, 2e22, 2e23, 2e24];
    println!("{}", a[4]);
    let a = [3; 5];
    println!("{}", a[3]);
}
