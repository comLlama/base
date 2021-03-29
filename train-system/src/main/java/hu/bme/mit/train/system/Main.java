package hu.bme.mit.train.system;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static void main (String[] args) {
		TrainSystem trainSystem = new TrainSystem();
		Timer timer = new Timer();

		int interval;
		Scanner console = new Scanner(System.in);
		System.out.println("Choose an update interval in seconds:");
		try {
			interval = 1000 * Integer.parseInt(console.nextLine());
		} catch (NumberFormatException e){
			interval = 5000;
		}
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				trainSystem.getController().followSpeed();
			}
		}, 1000, interval);

		String line;
		while (!(line = console.nextLine()).equals("q")){
			try {
				int joyInput = Integer.parseInt(line);
				trainSystem.getUser().overrideJoystickPosition(joyInput);
			} catch (NumberFormatException e) {
				System.out.println("NaN");
			}
		}

		timer.cancel();
		console.close();
	}
}
