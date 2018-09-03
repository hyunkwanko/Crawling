package exam;

import java.util.*;


public class InheritanceDemo {
	int npp = 0; // 총 사람 수
	Person[] ppv; // 사람 클래스
	Student[] stv; // 학생 클래스
	Faculty[] profv; // 교수 클래스
	Staff jigwon; // 스태프 클래스
	Course[] crsv; // 과목클래스

	public static void main(String[] args){
    	InheritanceDemo pcis = new InheritanceDemo(); // 수강신청 클래스 생성
    	pcis.recruit_employees(); // 직원 고용
    	pcis.run_school(); //recruit_학생(); open_강좌(); register_수강과목();
    	pcis.report(); // 구성원 소개, 수강편람, 과목출석부, 개인 시간표
	}

	InheritanceDemo() {
		ppv = new Person[100]; // 사람클래스를 100개 생성한다.
		npp = 0; // 사람숫자를 세는 변수로 0으로 초기화한다.
	}
	void recruit_employees() {
		profv = new Faculty[6]; // 교수 클래스를 2개 생성한다.
		profv[0] = new Faculty("김교수", 48, "부산시 남구", 5000000, "공과대학","자바 응용프로그래밍");//교수생성
		profv[1] = new Faculty("박교수", 38, "부산시 해운대구", 4000000, "공과대학", "컴퓨터그래픽스");//교수생성
		profv[2] = new Faculty("최교수", 52, "부산시 금정구", 6000000, "공과대학", "디지털신호처리");//교수생성
		profv[3] = new Faculty("임교수", 44, "부산시 동래구", 8000000, "공과대학", "컴퓨터구조");//교수생성
		profv[4] = new Faculty("허교수", 46, "부산시 사하구", 5000000, "공과대학", "알고리즘 및 실습");//교수생성
		profv[5] = new Faculty("지교수", 40, "부산시 연제구", 4000000, "공과대학", "문제해결기법");//교수생성

		jigwon = new Staff("박과장", 42, 4000000, "대학본부");//직원생성
		jigwon.setDepartment("서무과");//직원의 부서를 결정

		ppv[npp++] = profv[0]; // 사람클래스에 교수추가
		ppv[npp++] = profv[1]; // 사람클래스에 교수추가
		ppv[npp++] = profv[2]; // 사람클래스에 교수추가
		ppv[npp++] = profv[3]; // 사람클래스에 교수추가
		ppv[npp++] = profv[4]; // 사람클래스에 교수추가
		ppv[npp++] = profv[5]; // 사람클래스에 교수추가
		ppv[npp++] = jigwon; // 사람클래스에 직원추가
	}

	void report() { // 구성원 소개, 수강편람, 과목출석부, 개인 시간표
		print_people(); // 총 사람들 출력
		print_수강편람(); // 수업출력
		for(int i=0;i<crsv.length;i++)
			print_출석부(crsv[i]);//과목을 출력
		for(int i=0;i<stv.length;i++)
			print_학생시간표(stv[i]);//학생시간표 출력
	}

	void run_school() {
		recruit_학생();
		open_강좌();
		register_수강과목();
	}

	void recruit_학생() { 
		String namev[] = { "강", "김", "고", "박", "신", "심", "이", "조", "최", "황" }; // 학생들의 이름이 있는 배열 생성
		int agev[] = { 21, 24, 22, 19, 21, 21, 21, 21, 23, 21 }; // 학생들의 나이 배열 생성
		
		stv = new Student[namev.length]; // 학생의 수 만큼 학생클래스를 생성한다.
		for(int i=0;i<namev.length;i++){
			stv[i] = new Student(namev[i], agev[i], 2, 2009123456+i, "IT융합응용공"); // 생성자를 이용하여 학생정보를 입력한다.
			ppv[npp++] = stv[i]; // ppv는 전체명단, stv는 학생명단
		}
	}

	void open_강좌() {
		crsv = new Course[6]; // 두 과목만 개설, 이름 = 8자
		crsv[0] = new Course("자바                ", profv[0], "월 5-6, 수 5-6", "1320");// 생성자를 이용하여 과목정보를 입력한다.
		crsv[1] = new Course("컴퓨터그래픽스 ", profv[1], "목 6-9       ", "1325");
		crsv[2] = new Course("디지털신호처리 ", profv[2], "월 2-4, 수 2-3", "1325");
		crsv[3] = new Course("컴퓨터구조       ", profv[3], "화 5-6, 목 2-3", "320 ");
		crsv[4] = new Course("알고리즘및실습 ", profv[4], "화 8-9, 금 2-3", "2226");
		crsv[5] = new Course("문제해결기법    ", profv[5], "월 7-8, 수 7-9", "1322");
		
	}

	void register_수강과목() {
		Course c1 = crsv[0];// 과목을 생성한다.
		Course c2 = crsv[1];
		Course c3 = crsv[2];
		Course c4 = crsv[3];
		Course c5 = crsv[4];
		Course c6 = crsv[5];
		int c1_list[] = {0,1,4,5}; // c1 과목 신청자
		int c2_list[] = {2,3,8,9}; // c2 과목 신청자
		int c3_list[] = {6,7};
		int c4_list[] = {1,2,3,9};
		int c5_list[] = {5,6,7,8};
		int c6_list[] = {0,5,6};
		for(int i=0;i<c1_list.length;i++)
			stv[c1_list[i]].registerCourse(c1); // 학생클래스에 있는 메소드에 과목을 넘겨준다.
		for(int i=0;i<c2_list.length;i++)
			stv[c2_list[i]].registerCourse(c2); // 학생클래스에 있는 메소드에 과목을 넘겨준다.
		for(int i=0;i<c3_list.length;i++)
			stv[c3_list[i]].registerCourse(c3);// 학생클래스에 있는 메소드에 과목을 넘겨준다.
		for(int i=0;i<c4_list.length;i++)
			stv[c4_list[i]].registerCourse(c4);// 학생클래스에 있는 메소드에 과목을 넘겨준다.
		for(int i=0;i<c5_list.length;i++)
			stv[c5_list[i]].registerCourse(c5);// 학생클래스에 있는 메소드에 과목을 넘겨준다.
		for(int i=0;i<c6_list.length;i++)
			stv[c6_list[i]].registerCourse(c6);// 학생클래스에 있는 메소드에 과목을 넘겨준다.
		System.out.println(c1.getTitle() + ": " + (c1_list.length) + "명 - 성공.");
		System.out.println(c2.getTitle() + ": " + (c2_list.length) + "명 - 성공.");
		System.out.println(c3.getTitle() + ": " + (c3_list.length) + "명 - 성공.");
		System.out.println(c4.getTitle() + ": " + (c4_list.length) + "명 - 성공.");
		System.out.println(c5.getTitle() + ": " + (c5_list.length) + "명 - 성공.");
		System.out.println(c6.getTitle() + ": " + (c6_list.length) + "명 - 성공.");
	}

	void print_people() { // 전체 사람 수 만큼 정보를 출력한다.
		for (int i = 0; i < npp; i++) {
			System.out.println("<" + (i + 1) + ">---------------------------");
			ppv[i].info();
		}
	}

	void print_수강편람() { // 과목들의 정보를 출력한다.
		System.out.println("\n - 수강 편람 -");
		for(int i=0;i<crsv.length;i++)
			crsv[i].info();
	}

	void print_출석부(Course cs) {
		System.out.println("--------------------------------------------------------");
		System.out.println("과목: "+cs.getTitle() + "(" + cs.getTP() + ")" + " 담당교수: "+cs.lecturer.getName());//과목이름, 시간, 담당교수 출력
		System.out.print(" ");
		for(int n=1;n<=16;n++)
			System.out.printf("%3d", n); // 오른쪽정렬로
		System.out.println();
		cs.listRegistrants(); // 해당과목에 수강신청한 사람들의 정보를 출력한다.
	}

	void print_학생시간표(Student st) { // 학생들의 시간표를 출력한다.
		System.out.println("\n<<수강과목/시간표>>");
		System.out.println("이름:"+st.getName());
		for(int i=0;i<st.nCourses;i++){ // 
			Course c = st.getCourse(i);
			System.out.println(c.getTitle() + " (" +c.getTP()+") by"+c.lecturer.getName());
		}
	}
}

class Person {
	private String name;
	private int age;
	private String address;

	Person() {
		name = "No name yet.";
		age = 0;
		address = "";
	}

	Person(String name, int age) {
		this.name = name;
		this.age = age;
		address = "";
	}

	Person(String name, int age, String address) {
		this.name = name;
		this.age = age;
		this.address = address;
	}

	// 데이터 접근을 위한 메소드들
	public void setName(String name) { // private 변수에 접근
		this.name = name;
	}

	public String getName() { // private 변수의 값을 반환
		return name;
	}

	public void setAge(int age) { // private 변수에 접근
		this.age = age;
	}

	public int getAge() { // private 변수의 값을 반환
		return age;
	}

	public void setAddress(String address) { // private 변수에 접근
		this.address = address;
	}

	public String getAddress() { // // private 변수의 값을 반환
		return address;
	}

	public void info() {
		System.out.println("이름 : " + name);
		System.out.println("나이 : " + age);
		System.out.println("주소 : " + address);
	}
}

class Student extends Person { // Student는 Person을 상속받는다.
	private int studentNo; // 학번
	private int grade; // 학년
	private String major; // 전공

	Course myCoursev[] = new Course[6]; // 최대 3과목을 수강할수 있게 3개를 생성한다.
	int nCourses = 0; // 생성한 과목의 수를 센다.

	Student() {
		super(); // 부모클래스의 생성자를 상속 받음
		grade = 0;
		studentNo = 0;
		major = "Not yet";
	}

	Student(String name, int age, int grade, int studentNo, String major) {
		super(name, age);
		this.grade = grade;
		this.studentNo = studentNo;
		this.major = major;
	}

	Student(String name, int age, String address, int grade, int studentNo, String major) {
		super(name, age, address);
		this.grade = grade;
		this.studentNo = studentNo;
		this.major = major;
	}

	public void setGrade(int grade) {
		this.grade = grade;
	}

	public int getGrade() {
		return grade;
	}

	public void setStudentNo(int studentNo) {
		this.studentNo = studentNo;
	}

	public int getStudentNo() {
		return studentNo;
	}

	public void setMajor(String major) {
		this.major = major;
	}

	public String getMajor() {
		return major;
	}

	public void info() {
		super.info(); // 부모클래스의 info함수를 상속받음
		System.out.println("학년 : " + grade);
		System.out.println("학번 : " + studentNo);
		System.out.println("전공 : " + major);
	}

	void registerCourse(Course c) {
		if (check() == true) // 다음과목이 신청 가능한지 확인
			return;
		myCoursev[nCourses++] = c; // 신청 가능하면 추가
		c.register(this); // 과목클래스에 생성한 것을 추가한다.
	}

	boolean check() { // 신청한 과목이 3과목 이상인지 아닌지 확인
		if (nCourses >= 7)
			System.out.println("no more courses");
		return nCourses >= 7;
	}

	Course getCourse(int i) {
		return myCoursev[i];
	}
}

class Employee extends Person {
	private int salary; // 급여
	private String position; // 소속
	private Employee supervisor; // 직속 상사

	Employee() {
		super(); // Person으로 상속받음
		salary = 0;
		position = "Not yet";
		supervisor = null;
	}

	Employee(String name, int age, int salary, String position) {
		super(name, age);
		this.salary = salary;
		this.position = position;
	}

	Employee(String name, int age, String address, int salary, String position) {
		super(name, age, address);
		this.salary = salary;
		this.position = position;
	}

	Employee(String name, int age, int salary, String position, Employee supervisor) {
		super(name, age);
		this.salary = salary;
		this.position = position;
		this.supervisor = supervisor;
	}

	Employee(String name, int age, String address, int salary, String position, Employee supervisor) {
		super(name, age, address);
		this.salary = salary;
		this.position = position;
		this.supervisor = supervisor;
	}

	public void setSalary(int salary) {
		this.salary = salary;
	}

	public int getSalary() {
		return salary;
	}

	public void setPosition(String position) {
		this.position = position;
	}

	public String getPosition() {
		return position;
	}

	public void setSupervisor(Employee supervisor) {
		this.supervisor = supervisor;
	}

	public Employee getSupervisor() {
		return supervisor;
	}

	public void info() { // 직원의 정보를 출력한다.
		super.info();
		System.out.println("급여 : " + salary);
		System.out.println("소속 : " + position);
		if (supervisor != null) // 만약 상사가 있으면 상사의 이름 출력
			System.out.println("상사 : " + supervisor.getName());
	}
}

class Faculty extends Employee { // Employee를 상속받음
	private String course; // 교수

	Course coursev[] = new Course[6]; // 교수6명 생성
	int nCourses = 0;

	Faculty() {
		super();
		course = "Not yet";
	}

	Faculty(String name, int age, String address, int salary, String position) {
		super(name, age, address, salary, position);
		course = "Not yet";
	}
	
	Faculty(String name, int age, String address, int salary, String position, String course) {
		super(name, age, address, salary, position);
		this.course = course;
	}

	Faculty(String name, int age, int salary, String position, Employee supervisor) {
		super(name, age, salary, position, supervisor);
		course = "Not yet";
	}

	Faculty(String name, int age, String address, int salary, String position, Employee supervisor) {
		super(name, age, address, salary, position, supervisor);
		course = "Not yet";
	}

	public void setCourse(String course) {
		this.course = course;
	}

	public String getCourse() {
		return course;
	}

	void openCourse(Course c) {
		// check? - 과목개설이 가능한지
		coursev[nCourses++] = c; // 과목을 개설한다.
	}

	public void info() {
		super.info();
		System.out.println("강의 : " + course);
	}
}

class Staff extends Employee {
	private String department;

	Staff() {
		super();
		department = "Not yet";
	}

	Staff(String name, int age, int salary, String position) {
		super(name, age, salary, position);
		department = "Not yet";
	}

	Staff(String name, int age, String address, int salary, String position) {
		super(name, age, address, salary, position);
		department = "Not yet";
	}

	Staff(String name, int age, int salary, String position, Employee supervisor) {
		super(name, age, salary, position, supervisor);
		department = "Not yet";
	}

	Staff(String name, int age, String address, int salary, String position, Employee supervisor) {
		super(name, age, address, salary, position, supervisor);
		department = "Not yet";
	}

	public void setDepartment(String department) { // 부서를 설정한다.
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void info() {
		super.info();
		System.out.println("부서 : " + department);
	}

}

class Course {
	String title, time, room;
	Faculty lecturer; // 교수
	Student regist[]; // 학생클래스
	Vector vregist; // 벡터를 이용하여 추가

	Course() {
		regist = new Student[10]; // 학생 
		vregist = new Vector();
	}

	Course(String nam, Faculty prof, String tim, String rum) {
		this();
		title = nam;
		time = tim;
		room = rum;
		lecturer = prof;
		prof.openCourse(this); // 교수의 openCourse에 과목을 추가한다.
	}

	String getTitle() {
		return title;
	}

	Faculty getLecturer() {
		return lecturer;
	}

	String getTP() {
		return time + " #" + room;
	}

	int numRegist() {
		return vregist.size();
	}

	void register(Student st) {
		vregist.add(st); // 신청한 학생을 추가한다.
	}

	void dropme(Student st) {
		vregist.removeElement(st);
	}
	
	void listRegistrants(){ // 해당과목에 수강신청한 사람들의 정보를 출력한다.
		for(int i=0;i<vregist.size();i++){ // 과목에 신청한 학생의 수
			Student st = (Student) vregist.elementAt(i); //
			System.out.print(st.getName());
			System.out.print(" ");
			for(int j=0;j<16;j++)
				System.out.print("  .");
			if((i+1)%5==0){
				System.out.print("\n     ");
				for(int j=0;j<16;j++)
					System.out.print("   --");
			}
			System.out.println();
		}
	}
	
	// *
	void info() {
		System.out.println(title + "담당교수: " + lecturer.getName() + ", 시간: " + time + "강의실: " + room);
	}

}
