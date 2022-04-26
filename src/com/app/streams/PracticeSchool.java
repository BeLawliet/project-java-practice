package com.app.streams;

import java.util.HashSet;
import java.util.Optional;
import java.util.Set;
import java.util.TreeSet;
import javax.swing.JOptionPane;
import com.app.models.Course;
import com.app.models.Student;

public class PracticeSchool {
	private static final String TITLE_REGISTER_STUDENT = "New Register";
	private static final String TITLE_ALL_REGISTER = "All available registers";
	private static final String SUCCESS_REGISTER = "Successful registration";
	private static final String GREETING = "Thanks for your time";
	
	// Show all available menu	
	private static Integer showMenus(int typeMenu) {
		if (typeMenu == 1) {
			return Integer.parseInt(JOptionPane.showInputDialog(null, "========= Welcome to our app ========="
																	   + "\n=== Menu:"
																	   + "\n1. Register students"
																	   + "\n2. Register courses"
																	   + "\n3. List of students"
																	   + "\n4. List of courses"
																	   + "\n5. Exit",
																	   "Management", JOptionPane.INFORMATION_MESSAGE));
		} else if (typeMenu == 2) {
			return Integer.parseInt(JOptionPane.showInputDialog(null, "========= Add courses ========="
																	   + "\n1. Add"
																	   + "\n2. Close",
																	   "Management", JOptionPane.INFORMATION_MESSAGE));
		}
		
		return null;
	}
	
	private static Student registerNewStudent(int index, String name, String lastName, int age, Set<Course> courses) {
		Set<Course> studentCourses = new HashSet<>();
		
		// Show all list of courses
		System.out.println("\n=== All available courses");
		courses.forEach(System.out::println);
		
		int optionCourses;
		do {
			optionCourses = showMenus(2);
			
			if (optionCourses == 1) {
				int indexCourse = Integer.parseInt(JOptionPane.showInputDialog("Enter Id of course to add:"));
				studentCourses.add(getCourse(courses, indexCourse));
			}
			
		} while(optionCourses != 2);

		return new Student(index, name, lastName, age, studentCourses);
	}
	
	private static Course getCourse(Set<Course> courses, int index) {
		Optional<Course> optionalCourse = courses.stream().filter(c -> c.getCourseId().equals(index)).findAny();
		
		if (optionalCourse.isPresent()) {
			return optionalCourse.get();
		}
		
		return null;
	}
	
	public static void main(String[] args) {
		TreeSet<Student> school = new TreeSet<>((o1, o2) -> o1.getStudentId().compareTo(o2.getStudentId()));
		TreeSet<Course> courses = new TreeSet<>();

		int option;
		int index;
		do {
			option = showMenus(1);
			
			switch (option) {
			case 1:
				index = school.size() + 1;
				String name = JOptionPane.showInputDialog(null, "Name:", TITLE_REGISTER_STUDENT, JOptionPane.INFORMATION_MESSAGE);
				String lastName =JOptionPane.showInputDialog(null, "Last Name:", TITLE_REGISTER_STUDENT, JOptionPane.INFORMATION_MESSAGE);
				int age = Integer.parseInt(JOptionPane.showInputDialog(null, "Age:", TITLE_REGISTER_STUDENT, JOptionPane.INFORMATION_MESSAGE));
			
				// Register student and their courses
				school.add(registerNewStudent(index, name, lastName, age, courses));
				
				JOptionPane.showMessageDialog(null, SUCCESS_REGISTER);
				break;
			case 2:
				index = courses.size() + 1;
				String newCourse = JOptionPane.showInputDialog("Course name:");
				
				if ((newCourse.equals("")) ||(newCourse == null)) {
					JOptionPane.showMessageDialog(null, "Enter a valid name", "Error", JOptionPane.ERROR_MESSAGE);
				} else {
					courses.add(new Course(index, newCourse));
					JOptionPane.showMessageDialog(null, SUCCESS_REGISTER);
				}
				break;
			case 3:
				System.out.println("\n" + TITLE_ALL_REGISTER);
				school.forEach(System.out::println);
				break;
			case 4:
				System.out.println("\n" + TITLE_ALL_REGISTER);
				courses.forEach(System.out::println);
				break;
			case 5:
				JOptionPane.showMessageDialog(null, GREETING);
				break;
			default:
				JOptionPane.showMessageDialog(null, GREETING);
				break;
			}
		} while (option != 5);
	}
}
