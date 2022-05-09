package com.payingguest.main;

import java.util.List;
import java.util.Scanner;

import com.payingguest.exception.IdNotFoundException;
import com.payingguest.exception.PayingGuestNotFoundException;
import com.payingguest.exception.RoomTypeNotFoundException;
import com.payingguest.model.PayingGuest;
import com.payingguest.model.Rooms;
import com.payingguest.service.IPayingGuestService;
import com.payingguest.service.IRoomService;
import com.payingguest.service.PayingGuestServiceImpl;
import com.payingguest.service.RoomServiceImpl;

public class PayingGuestMain {

	public static void main(String[] args) {

		IPayingGuestService payingGuestInter = new PayingGuestServiceImpl();
		IRoomService roomInter = new RoomServiceImpl();

		Scanner s = new Scanner(System.in);
		while (true) {

			System.out.println("Enter A for Admin");
			System.out.println("Enter C for Customer");
			System.out.println("Enter E to Exit");

			String input = s.next();
			char key = input.toUpperCase().charAt(0);

			if (key == 'A') {
				System.out.println("Enter 1 to add new  Paying Guest");
				System.out.println("Enter 2 to delete Paying Guest");
				System.out.println("Enter 3 to get the Paying Guest by Id");

				int choice = s.nextInt();
				switch (choice) {
				case 1:
					System.out.println("Enter paying Guest ID");
					int payingGuestId = s.nextInt();

					System.out.println("Enter Paying Guest name");
					s.nextLine();
					String name = s.nextLine();

					System.out.println("Enter Paying Guest address");
					String address = s.next();

					System.out.println("Enter Paying Guest gender");
					String pgType = s.next();

					System.out.println("Enter the rating");
					String rating = s.next();

					System.out.println("Enter the roomId");
					Integer roomId = s.nextInt();

					System.out.println(
							"Enter three  for triple sharing , two for double sharing , one for single sharing");
					String roomType = s.next();

					System.out.println("Enter the room cost");
					double cost = s.nextDouble();

					System.out.println("Enter the Total number of rooms");
					int noOfRooms = s.nextInt();

					PayingGuest payingGuest = new PayingGuest(payingGuestId, name, address, pgType, rating);
					payingGuestInter.addPayingGuest(payingGuest);

					Rooms room = new Rooms(roomType, cost, roomId, noOfRooms, payingGuestId);
					roomInter.addRoom(room);

					break;
				case 2:

					System.out.println("Enter Room Id to remove Room  ");
					roomId = s.nextInt();
					roomInter.deleteRoom(roomId);

					System.out.println("Enter the Paying guest Id to remove Paying guest");
					payingGuestId = s.nextInt();
					payingGuestInter.deletePayingGuest(payingGuestId);

					break;
				case 3:

					System.out.println("Enter Paying Guest Id to retrive Paying Guest  ");
					int id = s.nextInt();
					try {
						System.out.println(payingGuestInter.getById(id));
					} catch (IdNotFoundException e) {
						e.printStackTrace();
					}
					break;
				default:
					break;
				}

			} else if (key == 'C') {
				System.out.println("Enter 1 to retrive pg by Location");
				System.out.println("Enter 2 to retrive bg by Type");
				System.out.println("Enter 3  to retrive pg by share");
				int choice = s.nextInt();

				switch (choice) {
				case 1:
					System.out.println("Enter the location");
					String location = s.next();

					try {

						List<PayingGuest> payingGuestList = payingGuestInter.getByLocation(location);
						for (PayingGuest payingGuest2 : payingGuestList) {
							System.out.println(payingGuest2);
						}
					} catch (PayingGuestNotFoundException e) {

						e.printStackTrace();
					}

					break;
				case 2:

					System.out.println("Enter male or female");
					String pgType = s.next();

					try {

						List<PayingGuest> payingGuestListByType = payingGuestInter.getBytype(pgType);
						for (PayingGuest payingGuest2 : payingGuestListByType) {
							System.out.println(payingGuest2);
						}
					} catch (PayingGuestNotFoundException e) {

						e.printStackTrace();
					}

					break;
				case 3:
					System.out.println(
							"Enter three  for triple sharing , two for double sharing , one for single sharing");
					String share = s.next();
					try {
						List<Rooms> payingGuestListByShare = roomInter.getByShare(share);
						for (Rooms room : payingGuestListByShare) {
							System.out.println(room);

						}
					} catch (RoomTypeNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					break;

				default:
					break;
				}

			} else if (key == 'E') {
				System.out.println("Thank you for using the program");
				System.exit(0);
			}

		}

	}
}
