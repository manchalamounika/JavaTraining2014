package binarysearchprograms;

import java.util.Scanner;

public class Employee {
	int empId;
	String empName;

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

}

// abstract creteria class

abstract class MyCreteria {

	abstract public boolean compare(Object[] addEmp, Object sEmp);

}

// Creteria class with methods implementations and main method

class Creteria extends MyCreteria {

	static int count = 1;

	static Scanner in = new Scanner(System.in);

	static Employee[] addEmp = new Employee[100];

	public Creteria() {
			}

	public void readEmps() {

		System.out
				.println("type negative number for id to end giving Employee details");

		while (true) {

			System.out.println("Enter id");

			int a = in.nextInt();

			if (a < 0)
				break;
			System.out.println("Enter name");

			String name = in.next();

			addEmp[count] = new Employee();
			addEmp[count].setEmpId(a);
			addEmp[count].setEmpName(name);
			
			count++;

		}

	}

	public void dispEmp(Employee[] addEmp) {

			for (int i = 1; i < count; i++) {

			System.out.print("     Employee name " + addEmp[i].getEmpName());
			System.out.println("                      Employee Id "
					+ addEmp[i].getEmpId());

			
		}

	}

	public void sortEmp(Employee[] addEmp) {

		Employee temp = new Employee();

		for (int i = 1; i < count; i++) {
			for (int j = 1; j < (count - i - 1); j++) {
				if (addEmp[j].empId > addEmp[j + 1].empId) {
					temp = addEmp[j];
					addEmp[j] = addEmp[j + 1];
					addEmp[j + 1] = temp;

				}
			}
		}
	}

	public static boolean biSearchEmp(Employee[] addEmp, boolean type, int mid) {
		int low = 1;
		int high = count;
		int keynum = 0;

		String keyStr = null;

		if (type) {

			keynum = in.nextInt();
			do {
				mid = (low + high) / 2;
				if (keynum < addEmp[mid].empId)
					high = mid - 1;
				else if (keynum > addEmp[mid].empId)
					low = mid + 1;
			} while (keynum != addEmp[mid].empId && low <= high);
			if (keynum == addEmp[mid].empId) {
								return true;
			} else {
								return false;
			}

		}

		else {
			System.out.println("Enter name to Search");
			keyStr = in.next();
			int c = 0;

			for (c = 1; c < count; c++) {
				if (addEmp[c].empName.equals(keyStr)) /*
													 * Searching element is
													 * present
													 */
				{
								return true;
				}
			}
			if (c == count) /* Searching element is absent */
			{
				
				return false;
			}
			return false;
		}

	}

	public static void main(String args[]) {
		Creteria c1 = new Creteria();

		Employee sEmp = new Employee();

		c1.readEmps();
		c1.dispEmp(addEmp);
		c1.sortEmp(addEmp);
		System.out.println(addEmp);
		c1.dispEmp(addEmp);

		boolean type, result;
		int mid = 0;

		type = c1.compare(addEmp, sEmp);
		result = biSearchEmp(addEmp, type, mid);
		if (result)
			System.out.println("Element found");
		else
			System.out.println("Element not found");

	}

	@Override
	public boolean compare(Object[] addEmp, Object sEmp) {
		int type;

		while (true) {
			System.out
					.println("Enter 0 to serach by id and 1 to search by name");
			type = in.nextInt();
			

			if (type == 0) {
				System.out.println("Enter id to Search");
				return true;
			}
			if (type == 1)
				return false;
		}
	}
}
