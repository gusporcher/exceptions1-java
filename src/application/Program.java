package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservetion;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		System.out.print("Room number: ");
		int number = sc.nextInt();

		System.out.print("Check in: ");
		Date checkIn = sdf.parse(sc.next());

		System.out.print("Check out: ");
		Date checkOut = sdf.parse(sc.next());

		if (!checkOut.after(checkIn)) {
			System.out.println("Error in reservetion date!");
		} else {
			Reservetion reservetion = new Reservetion(number, checkIn, checkOut);
			System.out.println("Reservaton " + reservetion);

			System.out.println();
			System.out.println("Enter dates to update the reservation");

			System.out.print("Check in: ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check out: ");
			checkOut = sdf.parse(sc.next());

			Date now = new Date();
			if (checkIn.before(now) || checkOut.before(now)) {
				System.out.println("Error in reservation!");
			} else if (!checkOut.after(checkIn)) {
				System.out.println("Error in reservetion date!");
			} else {
				reservetion.updateDates(checkIn, checkOut);
				System.out.println("Reservaton " + reservetion);
			}

		}
		sc.close();

	}

}
