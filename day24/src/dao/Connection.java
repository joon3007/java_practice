package dao;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Connection {

	public BufferedReader connect_file_for_reading(String fileName) throws FileNotFoundException, IOException {
		return new BufferedReader(new FileReader(fileName));
	}

	public BufferedWriter connect_file_for_writing(String fileName) throws IOException {
		return new BufferedWriter(new FileWriter(fileName));
	}

	public BufferedWriter connect_file_for_appending(String fileName) throws IOException {
		return new BufferedWriter(new FileWriter(fileName, true));
	}
	
	
}
