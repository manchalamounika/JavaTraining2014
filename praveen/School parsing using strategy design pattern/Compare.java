package com.vl.school.handlers;

import java.util.Comparator;

import com.vl.school.beans.Student;


public class Compare implements Comparator<Student>{

	@Override
	public int compare(Student o1, Student o2) {
		// TODO Auto-generated method stub
		return o1.getSDOB().compareTo(o2.getSDOB());
	}
	
}