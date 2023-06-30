package application;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class Program {

	public static void main(String[] args) throws ParseException {

		Scanner input = new Scanner(System.in);

		Map<String, Integer> votes = new LinkedHashMap<>();

		System.out.print("Enter file full path: ");
		// c:\temp\votos.csv
		String path = input.nextLine();

		try (BufferedReader bufferedReader = new BufferedReader(new FileReader(path))) {

			String line = bufferedReader.readLine();
			while (line != null) {

				String[] fields = line.split(",");
				String name = fields[0];
				int count = Integer.parseInt(fields[1]);

				if (votes.containsKey(name)) {
					int votesUntilNow = votes.get(name);
					votes.put(name, count + votesUntilNow);
				}

				else {
					votes.put(name, count);
				}

				line = bufferedReader.readLine();
			}

			for (String nickname : votes.keySet()) {
				System.out.println(nickname + ": " + votes.get(nickname));
			}

		} catch (IOException erro) {
			System.out.println("Erro: " + erro.getMessage());
		}

		input.close();
	}
}