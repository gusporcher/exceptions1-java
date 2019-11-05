package application;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

import model.entities.Reservetion;
import model.exceptions.DomainException;

public class Program {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");

		try {
			System.out.print("Room number: ");
			int number = sc.nextInt();

			System.out.print("Check in: ");
			Date checkIn = sdf.parse(sc.next());

			System.out.print("Check out: ");
			Date checkOut = sdf.parse(sc.next());

			Reservetion reservetion = new Reservetion(number, checkIn, checkOut);
			System.out.println("Reservaton " + reservetion);

			System.out.println();
			System.out.println("Enter dates to update the reservation");

			System.out.print("Check in: ");
			checkIn = sdf.parse(sc.next());

			System.out.print("Check out: ");
			checkOut = sdf.parse(sc.next());

			reservetion.updateDates(checkIn, checkOut);

			System.out.println("Reservaton " + reservetion);
			
		} catch (ParseException e) {
			System.out.println("invalid date format");
		} catch (DomainException e) {
			System.out.println(e.getMessage());
		}
		sc.close();

	}

}
