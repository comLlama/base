package hu.bme.mit.train.system;

import java.util.Scanner;
import java.util.Timer;
import java.util.TimerTask;

public class Main {
	public static void main (String[] args) {
		TrainSystem trainSystem = new TrainSystem();
		Timer timer = new Timer();
		timer.schedule(new TimerTask() {
			@Override
			public void run() {
				trainSystem.getController().followSpeed();
			}
		}, 1000, 5000);

		String line;
		Scanner console = new Scanner(System.in);
		while (!(line = console.nextLine()).equals("q")){
			int joyInput = Integer.parseInt(line);
			trainSystem.getUser().overrideJoystickPosition(joyInput);
		}

		timer.cancel();
		console.close();
	}
}
