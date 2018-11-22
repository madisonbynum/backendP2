package dateConvert;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.Scanner;

public class DateConvert {

	public static void main(String[] args) throws ParseException {
		convertor();
	}
	
	public static void convertor() throws ParseException {
		Scanner scan = new Scanner(System.in);
		

		// Array list: unavailable contains all days the room in question is not available to be reserved
		ArrayList<Long> unavailable = new ArrayList<Long>();
		
		// Array: roomsInOut contains several arrays of length=2, which represent several different reservations
		// which contain one check-in date and one check-out date
		String[][] roomsInOut = new String[3][2];
		
		// Array: unixInOut id equivalent to array: roomsInOut where each date is represented as a long Unix 
		// Epoch Time instead of human time 
		Long[][] unixInOut = new Long[3][2];

		// String: checkIn and String: checkOut are used to get information from the scanner to test arbitrary dates
		String checkIn;
		String checkOut;
		
		
		// Manually enter check-in and check-out dates
		System.out.println("Check in date");
		checkIn = (scan.nextLine()+" 12:00:00");
		System.out.println("Check out date");
		checkOut = (scan.nextLine()+" 12:00:00");
		
		
		//		12/1/2018 09:09:09
		//		12/5/2018 09:09:09
		
		// Convert date strings from scanner to Unix Epoch Time
		long epochIn = toUnix(checkIn);
		long epochOut = toUnix(checkOut);
		
		System.out.println(epochIn);
		System.out.println(epochOut);
		
		

		
		roomsInOut[0][0] = "11/22/2018 12:00:00";
		roomsInOut[0][1] = "11/30/2018 12:00:00";
		roomsInOut[1][0] = "12/3/2018 12:00:00";
		roomsInOut[1][1] = "12/8/2018 12:00:00";
		roomsInOut[2][0] = "12/9/2018 12:00:00";
		roomsInOut[2][1] = "12/10/2018 12:00:00";
                                       
		
		
		ArrayList<Long> array1 =toDateArray(toUnix(roomsInOut[0][0]), toUnix(roomsInOut[0][1]));
		ArrayList<Long> array2 =toDateArray(toUnix(roomsInOut[1][0]), toUnix(roomsInOut[1][1]));
		ArrayList<Long> array3 =toDateArray(toUnix(roomsInOut[2][0]), toUnix(roomsInOut[2][1]));
		
		for(int i=0; i<array1.size(); i++) {
			unavailable.add(array1.get(i));
		}
		for(int i=0; i<array2.size(); i++) {
			unavailable.add(array2.get(i));
		}
		for(int i=0; i<array3.size(); i++) {
			unavailable.add(array3.get(i));
		}
		
		System.out.println(unavailable);
		
		
		
		ArrayList<Long> array4 = toDateArray(toUnix(checkIn), toUnix(checkOut));
		System.out.println(array4);
		
		
		isAvailable(array4, unavailable);
	}

	
	
	static long toUnix(String humanDate) throws ParseException{
		long epochOut = new java.text.SimpleDateFormat("MM/dd/yyyy HH:mm:ss").parse(humanDate).getTime() / 1000;
		return epochOut;
	}
	
	
	static ArrayList<Long> toDateArray(long checkIn, long checkOut) throws ParseException {
		// This routine creates an array: date which takes check-in and check-out dates and creates an ArrayList
		// of all days occupied by the reservation
		
		ArrayList<Long> date = new ArrayList<Long>();
		int flag = 0;
		while(flag == 0) {
			if(checkIn < checkOut) {
				date.add(checkIn);
				checkIn += 86400;
			}else{
				flag = 1;
			}
			
		}
		return date;
	}
	
	static boolean isAvailable(ArrayList<Long> userDate, ArrayList<Long> reservedDate) {
		boolean flag = true;	
		for(int i = 0; i<userDate.size(); i++) {
			for(int j = 0; j<reservedDate.size(); j++) {
				System.out.print("Date: "+reservedDate.get(j));
				if(userDate.get(i).equals(reservedDate.get(j))) {
					flag = false;
					
				}
			}
		}
	return flag;
	}

}
