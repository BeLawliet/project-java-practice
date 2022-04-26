package com.app.models;

public class Course implements Comparable<Course> {
    private Integer courseId;
    private String courseName;

    public Course() {}

    public Course(Integer courseId, String courseName) {
        this.courseId = courseId;
        this.courseName = courseName;
    }

    public Integer getCourseId() {
        return courseId;
    }

    public void setCourseId(Integer courseId) {
        this.courseId = courseId;
    }

    public String getCourseName() {
        return courseName;
    }

    public void setCourseName(String courseName) {
        this.courseName = courseName;
    }

    @Override
    public String toString() {
        return courseId + ". " + courseName;
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((courseId == null) ? 0 : courseId.hashCode());
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null) return false;
        if (getClass() != obj.getClass()) return false;

        Course other = (Course) obj;
        if (courseId == null) {
            if (other.courseId != null) return false;
        } else if (!courseId.equals(other.courseId)) return false;
        return true;
    }

    @Override
    public int compareTo(Course o) {
        return this.courseId.compareTo(o.getCourseId());
    }
}
