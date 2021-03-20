package assignment.service;

import java.util.Scanner;

import assignment.entities.Candidate;
import assignment.entities.Experience;


public class ExperienceService {

	public Experience createrExperience(Candidate candidate) {
		Scanner sc= new Scanner(System.in);
		Experience experience= (Experience) candidate;
		int expInYear=0;
		String proSkill=null;
		boolean checkExpInYear=true,checkProSkill=true;
		
		do {
			System.out.println("Nhap ExpInYear :");
			try {
				expInYear = Integer.parseInt(sc.nextLine());
				checkExpInYear = false;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}while(checkExpInYear);
		
		do {
			System.out.println("Nhap ProSkill :");
			try {
				proSkill =sc.nextLine();
				checkProSkill = false;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}
		}while(checkProSkill);
		
		experience=new Experience(candidate.getCadidateID(), candidate.getFullName(), candidate.getBirthDay(), candidate.getPhone(),
				candidate.getEmail(), candidate.getCandidate_type(), expInYear, proSkill);
		
		return experience;

	}

}
