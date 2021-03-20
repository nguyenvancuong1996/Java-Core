package fa.training;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.util.ArrayList;
import java.util.List;

public class MainReadCSV {

	public static void main(String[] args) {

		List<Student> listStudent = readStudentFromCSV("STD.csv");

		for (Student student : listStudent) {
			System.out.println(student.toString());
		}
		checkCsvFormat("STD.csv");
	}

	private static List<Student> readStudentFromCSV(String fileName) {
		List<Student> listStudents = new ArrayList<>();

		try {
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			String line = null;
			while ((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				Student student = new Student(fields[0], fields[1], fields[2], fields[3],
						Double.parseDouble(fields[4]));
				listStudents.add(student);
			}
			br.close();
		} catch (Exception e) {

		}
		return listStudents;

	}

	private static void checkCsvFormat(String fileName) {
		try{
			BufferedReader br = new BufferedReader(new FileReader(fileName));
			FileWriter fileWriter = new FileWriter("error.txt");
			BufferedWriter bufferWriter = new BufferedWriter(fileWriter);
			String line =null;
			int i=1;
			
			while((line = br.readLine()) != null) {
				String[] fields = line.split(",");
				StringBuilder stringBuilder = new StringBuilder();
				if(Validator.isValidPhoneNumber(fields[2]) == false && Validator.isEmail(fields[3]) == false) {
					stringBuilder.append("Line "+i+": co loi sai dinh dang StdPhone, StdEmail");
				}
				else if(Validator.isValidPhoneNumber(fields[2]) == false) {
					stringBuilder.append("Line "+i+": co loi sai dinh dang StdPhone");
				}
				else if(Validator.isEmail(fields[3]) == false) {
					stringBuilder.append("Line "+i+": co loi sai dinh dang StdEmail");
				}
				bufferWriter.write(stringBuilder.toString()+"\n");
				i++;
			}
			bufferWriter.close();
			br.close();
		}catch (Exception e) {
			
		}
	}

}
