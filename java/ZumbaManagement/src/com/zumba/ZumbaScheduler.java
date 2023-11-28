package com.zumba;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import com.zumba.bean.Participant;
import com.zumba.bean.Batch;

/**
 * We assume there are 3 sessions available and we take five participants for
 * the implementation to be more interesting
 */
public class ZumbaScheduler {

	public static void main(String[] args) {
		List<Batch> batches = new ArrayList<Batch>();

		Scanner scanner = new Scanner(System.in);

		for (int i = 1; i <= 5; i++) {
			System.out.println("Please enter your name:");
			String name = scanner.next();

			System.out.println("Please enter your email:");
			String email = scanner.next();

			System.out.println("Please select Session 1, 2 or 3:");
			int batchNum = Integer.parseInt(scanner.next());

			boolean isBatch = false;
			for (Batch batch : batches) {
				if (batch.getBatchNum() == batchNum) {
					batch.getParticipants().add(new Participant(name, email, batchNum));
					isBatch = true;
				}
			}
			if (!isBatch) {
				Batch batch = new Batch(batchNum,
						new ArrayList<NotificationHandler>(Arrays.asList(new Participant(name, email, batchNum))));
				batches.add(batch);
			}
		}
		scanner.close();

		batches.forEach(Batch::start);
	}
}
