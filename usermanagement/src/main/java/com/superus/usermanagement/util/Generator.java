package com.superus.usermanagement.util;

import java.util.Random;

import org.springframework.stereotype.Component;

@Component
public class Generator {

	// this function will generate the Vendor ID and user name for the user
		public String generateor(String name) {
			Random rand = new Random();
			long customer_id = (long) (rand.nextDouble() * 10000000000L);
			int x = rand.nextInt(900) + 100;
			String usernmaeString = "SUC"  + x;
			return usernmaeString;
		}
}

