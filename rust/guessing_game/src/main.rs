use rand::Rng;
use std::cmp::Ordering;
use std::io;

const GUESS_RANGE_LOW: u32 = 1;
const GUESS_RANGE_HIGH: u32 = 100;

fn main() {
    println!(
        "Guess the number! (between {low} and {high})",
        low = GUESS_RANGE_LOW,
        high = GUESS_RANGE_HIGH
    );

    let secret_number = rand::thread_rng().gen_range(GUESS_RANGE_LOW..=GUESS_RANGE_HIGH);

    loop {
        println!("Please input your guess");

        let mut guess = String::new();

        io::stdin()
            .read_line(&mut guess)
            .expect("Failed to read line");

        let guess: u32 = match guess.trim().parse() {
            Ok(num) => num,
            Err(_) => {
                match guess.trim() {
                    "quit" | "exit" | "stop" => break,
                    _ => continue,
                };
            }
        };

        match guess.cmp(&secret_number) {
            Ordering::Less => println!("Too small!"),
            Ordering::Greater => println!("Too big!"),
            Ordering::Equal => {
                println!("You win!");
                break;
            }
        }
    }
}
