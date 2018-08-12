package com.nijanthan;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "student")
public class Student {
	
	 private static final long serialVersionUID = -3009157732242241606L;
	 
	    @Id
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private long id;
	    
	    private String name;
	    
	    private long mark;

		public long getId() {
			return id;
		}

		public void setId(long id) {
			this.id = id;
		}

		public String getName() {
			return name;
		}

		public void setName(String name) {
			this.name = name;
		}

		public long getMark() {
			return mark;
		}

		public void setMark(long mark) {
			this.mark = mark;
		}
	    
	    
}
