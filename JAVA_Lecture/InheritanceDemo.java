package exam;

import java.util.*;


public class InheritanceDemo {
	int npp = 0; // �� ��� ��
	Person[] ppv; // ��� Ŭ����
	Student[] stv; // �л� Ŭ����
	Faculty[] profv; // ���� Ŭ����
	Staff jigwon; // ������ Ŭ����
	Course[] crsv; // ����Ŭ����

	public static void main(String[] args){
    	InheritanceDemo pcis = new InheritanceDemo(); // ������û Ŭ���� ����
    	pcis.recruit_employees(); // ���� ���
    	pcis.run_school(); //recruit_�л�(); open_����(); register_��������();
    	pcis.report(); // ������ �Ұ�, �������, �����⼮��, ���� �ð�ǥ
	}

	InheritanceDemo() {
		ppv = new Person[100]; // ���Ŭ������ 100�� �����Ѵ�.
		npp = 0; // ������ڸ� ���� ������ 0���� �ʱ�ȭ�Ѵ�.
	}
	void recruit_employees() {
		profv = new Faculty[6]; // ���� Ŭ������ 2�� �����Ѵ�.
		profv[0] = new Faculty("�豳��", 48, "�λ�� ����", 5000000, "��������","�ڹ� �������α׷���");//��������
		profv[1] = new Faculty("�ڱ���", 38, "�λ�� �ؿ�뱸", 4000000, "��������", "��ǻ�ͱ׷��Ƚ�");//��������
		profv[2] = new Faculty("�ֱ���", 52, "�λ�� ������", 6000000, "��������", "�����н�ȣó��");//��������
		profv[3] = new Faculty("�ӱ���", 44, "�λ�� ������", 8000000, "��������", "��ǻ�ͱ���");//��������
		profv[4] = new Faculty("�㱳��", 46, "�λ�� ���ϱ�", 5000000, "��������", "�˰��� �� �ǽ�");//��������
		profv[5] = new Faculty("������", 40, "�λ�� ������", 4000000, "��������", "�����ذ���");//��������

		jigwon = new Staff("�ڰ���", 42, 4000000, "���к���");//��������
		jigwon.setDepartment("������");//������ �μ��� ����

		ppv[npp++] = profv[0]; // ���Ŭ������ �����߰�
		ppv[npp++] = profv[1]; // ���Ŭ������ �����߰�
		ppv[npp++] = profv[2]; // ���Ŭ������ �����߰�
		ppv[npp++] = profv[3]; // ���Ŭ������ �����߰�
		ppv[npp++] = profv[4]; // ���Ŭ������ �����߰�
		ppv[npp++] = profv[5]; // ���Ŭ������ �����߰�
		ppv[npp++] = jigwon; // ���Ŭ������ �����߰�
	}

	void report() { // ������ �Ұ�, �������, �����⼮��, ���� �ð�ǥ
		print_people(); // �� ����� ���
		print_�������(); // �������
		for(int i=0;i<crsv.length;i++)
			print_�⼮��(crsv[i]);//������ ���
		for(int i=0;i<stv.length;i++)
			print_�л��ð�ǥ(stv[i]);//�л��ð�ǥ ���
	}

	void run_school() {
		recruit_�л�();
		open_����();
		register_��������();
	}

	void recruit_�л�() { 
		String namev[] = { "��", "��", "��", "��", "��", "��", "��", "��", "��", "Ȳ" }; // �л����� �̸��� �ִ� �迭 ����
		int agev[] = { 21, 24, 22, 19, 21, 21, 21, 21, 23, 21 }; // �л����� ���� �迭 ����
		
		stv = new Student[namev.length]; // �л��� �� ��ŭ �л�Ŭ������ �����Ѵ�.
		for(int i=0;i<namev.length;i++){
			stv[i] = new Student(namev[i], agev[i], 2, 2009123456+i, "IT���������"); // �����ڸ� �̿��Ͽ� �л������� �Է��Ѵ�.
			ppv[npp++] = stv[i]; // ppv�� ��ü���, stv�� �л����
		}
	}

	void open_����() {
		crsv = new Course[6]; // �� ���� ����, �̸� = 8��
		crsv[0] = new Course("�ڹ�                ", profv[0], "�� 5-6, �� 5-6", "1320");// �����ڸ� �̿��Ͽ� ���������� �Է��Ѵ�.
		crsv[1] = new Course("��ǻ�ͱ׷��Ƚ� ", profv[1], "�� 6-9       ", "1325");
		crsv[2] = new Course("�����н�ȣó�� ", profv[2], "�� 2-4, �� 2-3", "1325");
		crsv[3] = new Course("��ǻ�ͱ���       ", profv[3], "ȭ 5-6, �� 2-3", "320 ");
		crsv[4] = new Course("�˰���׽ǽ� ", profv[4], "ȭ 8-9, �� 2-3", "2226");
		crsv[5] = new Course("�����ذ���    ", profv[5], "�� 7-8, �� 7-9", "1322");
		
	}

	void register_��������() {
		Course c1 = crsv[0];// ������ �����Ѵ�.
		Course c2 = crsv[1];
		Course c3 = crsv[2];
		Course c4 = crsv[3];
		Course c5 = crsv[4];
		Course c6 = crsv[5];
		int c1_list[] = {0,1,4,5}; // c1 ���� ��û��
		int c2_list[] = {2,3,8,9}; // c2 ���� ��û��
		int c3_list[] = {6,7};
		int c4_list[] = {1,2,3,9};
		int c5_list[] = {5,6,7,8};
		int c6_list[] = {0,5,6};
		for(int i=0;i<c1_list.length;i++)
			stv[c1_list[i]].registerCourse(c1); // �л�Ŭ������ �ִ� �޼ҵ忡 ������ �Ѱ��ش�.
		for(int i=0;i<c2_list.length;i++)
			stv[c2_list[i]].registerCourse(c2); // �л�Ŭ������ �ִ� �޼ҵ忡 ������ �Ѱ��ش�.
		for(int i=0;i<c3_list.length;i++)
			stv[c3_list[i]].registerCourse(c3);// �л�Ŭ������ �ִ� �޼ҵ忡 ������ �Ѱ��ش�.
		for(int i=0;i<c4_list.length;i++)
			stv[c4_list[i]].registerCourse(c4);// �л�Ŭ������ �ִ� �޼ҵ忡 ������ �Ѱ��ش�.
		for(int i=0;i<c5_list.length;i++)
			stv[c5_list[i]].registerCourse(c5);// �л�Ŭ������ �ִ� �޼ҵ忡 ������ �Ѱ��ش�.
		for(int i=0;i<c6_list.length;i++)
			stv[c6_list[i]].registerCourse(c6);// �л�Ŭ������ �ִ� �޼ҵ忡 ������ �Ѱ��ش�.
		System.out.println(c1.getTitle() + ": " + (c1_list.length) + "�� - ����.");
		System.out.println(c2.getTitle() + ": " + (c2_list.length) + "�� - ����.");
		System.out.println(c3.getTitle() + ": " + (c3_list.length) + "�� - ����.");
		System.out.println(c4.getTitle() + ": " + (c4_list.length) + "�� - ����.");
		System.out.println(c5.getTitle() + ": " + (c5_list.length) + "�� - ����.");
		System.out.println(c6.getTitle() + ": " + (c6_list.length) + "�� - ����.");
	}

	void print_people() { // ��ü ��� �� ��ŭ ������ ����Ѵ�.
		for (int i = 0; i < npp; i++) {
			System.out.println("<" + (i + 1) + ">---------------------------");
			ppv[i].info();
		}
	}

	void print_�������() { // ������� ������ ����Ѵ�.
		System.out.println("\n - ���� ��� -");
		for(int i=0;i<crsv.length;i++)
			crsv[i].info();
	}

	void print_�⼮��(Course cs) {
		System.out.println("--------------------------------------------------------");
		System.out.println("����: "+cs.getTitle() + "(" + cs.getTP() + ")" + " ��米��: "+cs.lecturer.getName());//�����̸�, �ð�, ��米�� ���
		System.out.print(" ");
		for(int n=1;n<=16;n++)
			System.out.printf("%3d", n); // ���������ķ�
		System.out.println();
		cs.listRegistrants(); // �ش���� ������û�� ������� ������ ����Ѵ�.
	}

	void print_�л��ð�ǥ(Student st) { // �л����� �ð�ǥ�� ����Ѵ�.
		System.out.println("\n<<��������/�ð�ǥ>>");
		System.out.println("�̸�:"+st.getName());
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

	// ������ ������ ���� �޼ҵ��
	public void setName(String name) { // private ������ ����
		this.name = name;
	}

	public String getName() { // private ������ ���� ��ȯ
		return name;
	}

	public void setAge(int age) { // private ������ ����
		this.age = age;
	}

	public int getAge() { // private ������ ���� ��ȯ
		return age;
	}

	public void setAddress(String address) { // private ������ ����
		this.address = address;
	}

	public String getAddress() { // // private ������ ���� ��ȯ
		return address;
	}

	public void info() {
		System.out.println("�̸� : " + name);
		System.out.println("���� : " + age);
		System.out.println("�ּ� : " + address);
	}
}

class Student extends Person { // Student�� Person�� ��ӹ޴´�.
	private int studentNo; // �й�
	private int grade; // �г�
	private String major; // ����

	Course myCoursev[] = new Course[6]; // �ִ� 3������ �����Ҽ� �ְ� 3���� �����Ѵ�.
	int nCourses = 0; // ������ ������ ���� ����.

	Student() {
		super(); // �θ�Ŭ������ �����ڸ� ��� ����
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
		super.info(); // �θ�Ŭ������ info�Լ��� ��ӹ���
		System.out.println("�г� : " + grade);
		System.out.println("�й� : " + studentNo);
		System.out.println("���� : " + major);
	}

	void registerCourse(Course c) {
		if (check() == true) // ���������� ��û �������� Ȯ��
			return;
		myCoursev[nCourses++] = c; // ��û �����ϸ� �߰�
		c.register(this); // ����Ŭ������ ������ ���� �߰��Ѵ�.
	}

	boolean check() { // ��û�� ������ 3���� �̻����� �ƴ��� Ȯ��
		if (nCourses >= 7)
			System.out.println("no more courses");
		return nCourses >= 7;
	}

	Course getCourse(int i) {
		return myCoursev[i];
	}
}

class Employee extends Person {
	private int salary; // �޿�
	private String position; // �Ҽ�
	private Employee supervisor; // ���� ���

	Employee() {
		super(); // Person���� ��ӹ���
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

	public void info() { // ������ ������ ����Ѵ�.
		super.info();
		System.out.println("�޿� : " + salary);
		System.out.println("�Ҽ� : " + position);
		if (supervisor != null) // ���� ��簡 ������ ����� �̸� ���
			System.out.println("��� : " + supervisor.getName());
	}
}

class Faculty extends Employee { // Employee�� ��ӹ���
	private String course; // ����

	Course coursev[] = new Course[6]; // ����6�� ����
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
		// check? - ���񰳼��� ��������
		coursev[nCourses++] = c; // ������ �����Ѵ�.
	}

	public void info() {
		super.info();
		System.out.println("���� : " + course);
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

	public void setDepartment(String department) { // �μ��� �����Ѵ�.
		this.department = department;
	}

	public String getDepartment() {
		return department;
	}

	public void info() {
		super.info();
		System.out.println("�μ� : " + department);
	}

}

class Course {
	String title, time, room;
	Faculty lecturer; // ����
	Student regist[]; // �л�Ŭ����
	Vector vregist; // ���͸� �̿��Ͽ� �߰�

	Course() {
		regist = new Student[10]; // �л� 
		vregist = new Vector();
	}

	Course(String nam, Faculty prof, String tim, String rum) {
		this();
		title = nam;
		time = tim;
		room = rum;
		lecturer = prof;
		prof.openCourse(this); // ������ openCourse�� ������ �߰��Ѵ�.
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
		vregist.add(st); // ��û�� �л��� �߰��Ѵ�.
	}

	void dropme(Student st) {
		vregist.removeElement(st);
	}
	
	void listRegistrants(){ // �ش���� ������û�� ������� ������ ����Ѵ�.
		for(int i=0;i<vregist.size();i++){ // ���� ��û�� �л��� ��
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
		System.out.println(title + "��米��: " + lecturer.getName() + ", �ð�: " + time + "���ǽ�: " + room);
	}

}
