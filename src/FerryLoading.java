import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class FerryLoading

{
	private boolean isItLeft = false;
	private int trips = 0;
	private static Queue<Integer> leftQueue = new LinkedList<>();
	private static Queue<Integer> rightQueue = new LinkedList<>();

	public boolean doesItFit(int currSpace, int carSize) {
		if (currSpace >= carSize) {
			return true;
		}return false;
	}

	public static void enqueue(String carSide, int carSize) {
		if (carSide.charAt(0) == 'l') {
			leftQueue.add(carSize);
		} else {
			rightQueue.add(carSize);
		}
	}

	public void fillBoat(int currSpace) {
		isItLeft = !isItLeft;
		if (isItLeft && !leftQueue.isEmpty()) {
			fillBoatHelper(currSpace, leftQueue);
		} else if (!isItLeft && !rightQueue.isEmpty()){
			fillBoatHelper(currSpace, rightQueue);
		}
	}

	public void fillBoatHelper(int currSpace, Queue<Integer> carQueue) {
		if (doesItFit(currSpace, carQueue.peek())) {
			int removedCarSize = carQueue.poll();
			if (!carQueue.isEmpty()) {
				fillBoatHelper(currSpace - removedCarSize, carQueue);
			}
		}
	}

	public int travel(int boatSize) {
		while (!leftQueue.isEmpty() || !rightQueue.isEmpty()) {
			fillBoat(boatSize);
			trips++;
		}
		return trips;
	}

	public static void main(String[] args) {
		Kattio scanner = new Kattio(System.in);
		int amntRuns = scanner.getInt();
		for (int i = 0; i < amntRuns; i++) {
			int boatSize = scanner.getInt() * 100;
			int amntCars = scanner.getInt();
			for (int j = 0; j < amntCars; j++) {
				int carSize = scanner.getInt();
				String carSide = scanner.getWord();
				enqueue(carSide, carSize);
			}
			FerryLoading ferry = new FerryLoading();
			System.out.println(ferry.travel(boatSize));
		}
		scanner.close();
	}
}


