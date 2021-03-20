package assignment.service;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

import assignment.dao.CandidateDao;
import assignment.dao.CandidateDaoImpl;
import assignment.entities.Candidate;
import assignment.entities.Experience;
import assignment.entities.Fresher;
import assignment.entities.Inter;
import assignment.exception.BirthDayException;
import assignment.exception.EmailException;
import assignment.exception.ExceptionCandidateType;
import assignment.exception.ExceptionID;
import assignment.exception.ExceptionPhone;
import assignment.utils.ConvertDateToLocalDate;
import assignment.utils.Validator;

public class CandidateService {

	public Candidate createrCandidate() {
		Scanner sc = new Scanner(System.in);
		Candidate candidate = null;
		String candidateID = null, candiateName = null, phone = null, email = null, strDate = null;
		Date birthDay = null;
		int candidate_type = 0;
		boolean checkID = true, checkName = true, checkPhone = true, checkemail = true;
		boolean checkDate = true;
		CandidateDao candidateDao = new CandidateDaoImpl();
		List<Candidate> listCandidate = null;
		do {
			System.out.println("Nhap ID : ");
			if ((listCandidate = candidateDao.selectAllCandidate()).isEmpty()) {
				try {
					candidateID = sc.nextLine();
					if (!new Validator().checkCandiateID(candidateID)) {
						throw new ExceptionID("Vui long nhap dung ID");
					}
					
					checkID = false;
				} catch (ExceptionID e) {
					System.out.println(e.getMessage());
				} catch (NullPointerException e) {
					System.out.println("Vui long nhap ");
				}
			}else {
				try {
					candidateID = sc.nextLine();
					if (!new Validator().checkCandiateID(candidateID)) {
						throw new ExceptionID("Vui long nhap dung ID");
					}
					if(!new Validator().checkIDtrung(candidateID, listCandidate)) {
						throw new ExceptionID("Vui long ko nhap trung ID");
					}
					checkID = false;
				} catch (ExceptionID e) {
					System.out.println(e.getMessage());
				} catch (NullPointerException e) {
					System.out.println("Vui long nhap ");
				}
			}
			
		} while (checkID);

		do {
			System.out.println("Nhap Name :");
			try {
				candiateName = sc.nextLine();
				checkName = false;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			}

		} while (checkName);

		do {
			System.out.println("Nhap BirthDay :");
			DateFormat stf = new SimpleDateFormat("dd-mm-yyyy");
			try {
				strDate = sc.nextLine();
				birthDay = stf.parse(strDate);
				LocalDate localdate = new ConvertDateToLocalDate().oldDateToLocalDate(birthDay);
				if (!new Validator().validatetorBirthDayYear(localdate)) {
					throw new BirthDayException("Vui long nhap date lon 1990 va be hon 2020");
				}
				checkDate = false;
			} catch (ParseException e) {
				System.out.println("Vui long nhap lai :");
			} catch (BirthDayException e) {
				System.out.println(e.getMessage());
			}
		} while (checkDate);

		do {
			System.out.println("Nhap phone :");
			try {
				phone = sc.nextLine();
				if (!new Validator().checkPhone(phone)) {
					throw new ExceptionPhone("Vui long nhap dung dinh dang phone ");
				}
				checkPhone = false;
			} catch (NullPointerException e) {
				System.out.println(e.getMessage());
			} catch (ExceptionPhone e) {
				System.out.println(e.getMessage());
			}

		} while (checkPhone);

		do {
			System.out.println("Nhap email :");
			try {
				email = sc.nextLine();
				if (!new Validator().checkEmail(email)) {
					throw new EmailException("Vui long nhap dung dinh dang email !");
				}
				checkemail = false;
			} catch (NullPointerException e) {
				System.out.println("Vui long nhap lai !");
			} catch (EmailException e) {
				System.out.println(e.getMessage());
			}

		} while (checkemail);
		System.out.println("nhap lc cua ban : 0: Experience, 1: Fresher, 2: Inter");
		try {
			candidate_type = Integer.parseInt(sc.nextLine());
			if (candidate_type < 1 && candidate_type > 2) {
				throw new ExceptionCandidateType("Vui long nhap 0: Experience, 1: Fresher, 2: Inter! ");
			}
		} catch (ExceptionCandidateType e) {
			System.out.println(e.getMessage());
		} catch (NullPointerException e) {
			System.out.println("vui long nhap");
		} catch (NumberFormatException e) {
			System.out.println("Vui long nhap so!");
		}
		switch (candidate_type) {
		case 0: {
			candidate = new Experience(candidateID, candiateName, birthDay, phone, email, candidate_type);
			break;
		}
		case 1: {
			candidate = new Fresher(candidateID, candiateName, birthDay, phone, email, candidate_type);
			break;
		}
		case 2: {
			candidate = new Inter(candidateID, candiateName, birthDay, phone, email, candidate_type);
			break;
		}
		default:
			break;
		}

		return candidate;
	}

	public List<Candidate> getAllCandidate() {
		List<Candidate> listCandidates = new ArrayList<>();
		CandidateDao candidateDao = new CandidateDaoImpl();
		listCandidates = candidateDao.selectAllCandidate();
		return listCandidates;
	}

	public List<Candidate> removeEmaiTrung(List<Candidate> candidateList) {
		for (int i = 0; i < candidateList.size(); i++) {
			System.out.println(candidateList.size());
			for (int j = i + 1; j < candidateList.size(); j++) {
				if (candidateList.get(i).getEmail().equals(candidateList.get(j).getEmail())) {
					System.out.println(j);
					candidateList.remove(j);
				}
			}
		}
		return candidateList;
	}

	public void sortCandidateType(List<Candidate> candidateslist) {
		Collections.sort(candidateslist, new Comparator<Candidate>() {
			@Override
			public int compare(Candidate o1, Candidate o2) {
				if (o1.getCandidate_type() == o2.getCandidate_type()) {
					if (ConvertDateToLocalDate.oldDateToLocalDate(o1.getBirthDay()).getYear() == ConvertDateToLocalDate
							.oldDateToLocalDate(o2.getBirthDay()).getYear()) {
						return 0;
					} else if (ConvertDateToLocalDate.oldDateToLocalDate(o1.getBirthDay())
							.getYear() > ConvertDateToLocalDate.oldDateToLocalDate(o2.getBirthDay()).getYear()) {
						return -1;
					} else {
						return 1;
					}
				} else if (o1.getCandidate_type() > o2.getCandidate_type()) {
					return 1;
				} else {
					return -1;
				}
			}
		});
		for (Candidate candidate : candidateslist) {
			candidate.showInfor();
			System.out.println("--------------------");
		}
	}

	public void nameString(List<Candidate> candidateslist) {
		List<String> ss = new ArrayList<>();
		for (int i = 0; i < candidateslist.size(); i++) {
			ss.add(candidateslist.get(i).getFullName());
		}
		String s = String.join(", ", ss);
		System.out.println("Cach 1 :" + s);
		String k = "";
		for (int i = 0; i < candidateslist.size(); i++) {
			k = k.concat(candidateslist.get(i).getFullName());
			if (i < candidateslist.size() - 1) {
				k = k.concat(", ");
			}
		}
		System.out.println("cach 2 " + k);

	}

	public void nameStringBuffer(List<Candidate> candidateslist) {
		String DELIMITER = ", ";
		StringBuffer sb = new StringBuffer();
		for (int i = 0; i < candidateslist.size(); i++) {
			sb.append(candidateslist.get(i).getFullName());
			if (i < candidateslist.size() - 1) {
				sb.append(DELIMITER);
			}
		}
		System.out.println(sb.toString());
	}

}
