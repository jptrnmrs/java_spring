package test06;

import java.util.ArrayList;
import java.util.List;

public class Doctor {
    private String name; // 의사 이름
    private String id;   // 의사 아이디
    private String special; // 전문 분야
    private List<Patient> patients; // 담당 환자 리스트

    // 생성자
    public Doctor(String name, String id, String special) {
        this.name = name;
        this.id = id;
        this.special = special;
        this.patients = new ArrayList<>(); // 환자 리스트 초기화
    }

    // 환자 추가 메서드
    public void addPatient(Patient patient) {
        patients.add(patient);
    }

	@Override
	public String toString() {
		String s ="";
		for(Patient p : patients) s+=p;
		return "의사: " + name + "(ID:" + id + ", 전문분야: " + special + ")\n담당 환자 목록:\n"
				+ s;
	}

    
}
