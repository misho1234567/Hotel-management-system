package Hotel;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import Hotel.extras.Extra;
import builders.ExtraBuilder;


public class Master {
	
	public static void main(String[] args) {
		// TODO Auto-generated method stub
			
		Scanner scan = new Scanner(System.in);
		List<Extra> extras = new ArrayList<>();
		List<Reservation> reservations = new ArrayList<>();
		List<Stay> stays = new ArrayList<>();
		
		Stay stay = null;
		System.out.println("Колко престоя искате?");
		int NumOfRooms = Integer.valueOf(scan.nextLine());
		for(int i = 0; i < NumOfRooms; i++) {
			System.out.println("Имате ли резервация?");
			String res = scan.nextLine();
			System.out.println("Стая.");
			int id = i;
			System.out.println("Махимален брой хора: ");
			int capacity = Integer.valueOf(scan.nextLine());
			System.out.println("Цена: ");
			double baseRate = Double.valueOf(scan.nextLine());
			Room room;
			System.out.println("Какъв тип ще е стаята(Стандарт, Бизнес, Апартамент)?");
			String type = scan.nextLine();
			boolean isWorkTrip = false;
			if(type.equals("Апартамент")) {
				System.out.println("Има ли изглед към море? (да / не)");
				String view = scan.nextLine();
				boolean seaView;
				if(view.equals("да")) {
					seaView = true; 
				}else {
					seaView = false;
				}
				room = new SuiteRoom(id, capacity, baseRate, seaView);
			}else if(type.equals("Бизнес")){
				System.out.println("Часове за срещи: ");
				int freeMeetingHours = Integer.valueOf(scan.nextLine());
				room = new BusinessRoom(id, capacity, baseRate, freeMeetingHours);
				System.out.println("Командировка?");
				String trip = scan.nextLine();
				if(trip.equals("Да")) {
					isWorkTrip = true;
				}
			}else {
				room = new StandardRoom(id, capacity, baseRate);
			}
			
			System.out.println("Престои.");
			System.out.println("Име: ");
			String customerName = scan.nextLine(); 
			System.out.println("Дни:");
			int nights = Integer.valueOf(scan.nextLine());
			System.out.println("Брой гости:");
			int guests = Integer.valueOf(scan.nextLine());
			
			System.out.println("Сезон  (LOW, MID, PEAK):");
			String season = scan.nextLine();
			
			
			if(res.equals("Да")){
			Reservation reservation = new Reservation(room, customerName, guests, nights);
			reservations.add(reservation);
			stay = new Stay(nights, guests, season, isWorkTrip, extras, room, customerName, reservation);
			stay.addStay(stay);
			
			} else {
				stay = new Stay(nights, guests, season, isWorkTrip, extras, room,customerName);
				stay.addStay(stay);
			}
			System.out.println("Искате ли екстри? (Да / Не)");
			String ifExtras = scan.nextLine();
			if(ifExtras.equals("Да")){ 
				int option = 0;
				ExtraBuilder extraBuilder = new ExtraBuilder();
				extraBuilder.addDays(nights);
				extraBuilder.addGuests(guests);
				System.out.println("Меню");
				System.out.println("1.Закуска");
				System.out.println("2.Паркинг");
				System.out.println("3.Домашен любимец");
				System.out.println("4.Закъснение с на напускане");
				System.out.println("5.Спа");
				System.out.println("6.Изход");
				while(option < 6) {
					option = Integer.valueOf(scan.nextLine());
					stay.addExtra(extraBuilder.createExtra(option));
					
					}
				}
			}
	
		for(int i = 0; i < NumOfRooms;i++ ) {
		System.out.println(stay.printInvoice());
		}
	}

}
