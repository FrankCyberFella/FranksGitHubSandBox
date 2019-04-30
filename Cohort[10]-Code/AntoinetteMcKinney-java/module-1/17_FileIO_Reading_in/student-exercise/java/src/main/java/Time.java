import java.time.LocalDateTime;

public class Time {

	public static void getTimeStamp() {
		LocalDateTime now = LocalDateTime.now();
		int year = now.getYear();
		int month = now.getMonthValue();
		int day = now.getDayOfMonth();
		int hour = now.getHour();
		int minute = now.getMinute();
		int second = now.getSecond();

		System.out.printf("%d/%02d/%02d,%02d:%02d:%02d", month, day, year, hour, minute, second);
	}

	public static void main(String... args) {
		getTimeStamp();
	}

}