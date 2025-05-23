package com.mine01;


public class Emp {
    private Integer empno;
    private String ename;

    public Emp() {
    }

    public Emp(String ename) {
        this.ename = ename;
    }

    public Integer getEmpno() {
        return empno;
    }

    public void setEmpno(Integer empno) {
        this.empno = empno;
    }

    public String getEname() {
        return ename;
    }

    public void setEname(String ename) {
        this.ename = ename;
    }

    @Override
    public String toString() {
        return "Emp{" + "empno=" + empno + ", ename='" + ename + '\'' + '}';
    }
}