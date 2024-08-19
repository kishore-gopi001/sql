package BusResv;

import java.util.Scanner; //nested package/ hierarchical package


public class BusDemo {

	public static void main(String[] args)  {
		
		BusDAO busdao = new BusDAO();
		
		try {
			busdao.displayBusInfo();
			
			int userOpt = 1;
			Scanner scanner = new Scanner(System.in);
			int businfo = 3;
			while(businfo == 3){
				System.out.println(" enter 3 for add your bus information or enter 1 for booking");
				businfo = scanner.nextInt();
				if (businfo == 3)
				Bus.addBusInfo();
			}
					
			while(userOpt==1) {
				System.out.println("Enter 1 to Book and 2 to exit");
				userOpt = scanner.nextInt();
				if(userOpt == 1) {
					Booking booking = new Booking();
					if(booking.isAvailable()) {
						BookingDAO bookingdao = new BookingDAO();
						bookingdao.addBooking(booking);
						System.out.println("Your booking is confirmed");
					}
					else
						System.out.println("Sorry. Bus is full. Try another bus or date.");
				}
				
			}
			scanner.close();
		}
		
		catch(Exception e) {
			System.out.println(e);
		}
	}

}
