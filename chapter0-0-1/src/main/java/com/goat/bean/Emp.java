package com.goat.bean;

import java.util.Date;

/**
 * Created by 64274 on 2018/8/21.
 *
 * @author 山羊来了
 * @Description: TODO
 * @date 2018/8/21---20:00
 * empno ename job mgr hiredate sal comm deptno

EMPNO  int
ENAME   String
JOB   String
MGR    int
HIREDATE  date
SAL  double
COMM double
DEPTNO int

 */
public class Emp {
    private Integer EMPNO;
    private String ENAME;
    private String EMENAMEPNO;
    private String JOB;
    private Integer MGR;
    private Date HIREDATE;
    private Double SAL;
    private Double COMM;
    private Integer DEPTNO;

    public Integer getEMPNO() {
        return EMPNO;
    }

    public void setEMPNO(Integer EMPNO) {
        this.EMPNO = EMPNO;
    }

    public String getENAME() {
        return ENAME;
    }

    public void setENAME(String ENAME) {
        this.ENAME = ENAME;
    }

    public String getEMENAMEPNO() {
        return EMENAMEPNO;
    }

    public void setEMENAMEPNO(String EMENAMEPNO) {
        this.EMENAMEPNO = EMENAMEPNO;
    }

    public String getJOB() {
        return JOB;
    }

    public void setJOB(String JOB) {
        this.JOB = JOB;
    }

    public Integer getMGR() {
        return MGR;
    }

    public void setMGR(Integer MGR) {
        this.MGR = MGR;
    }

    public Date getHIREDATE() {
        return HIREDATE;
    }

    public void setHIREDATE(Date HIREDATE) {
        this.HIREDATE = HIREDATE;
    }

    public Double getSAL() {
        return SAL;
    }

    public void setSAL(Double SAL) {
        this.SAL = SAL;
    }

    public Double getCOMM() {
        return COMM;
    }

    public void setCOMM(Double COMM) {
        this.COMM = COMM;
    }

    public Integer getDEPTNO() {
        return DEPTNO;
    }

    public void setDEPTNO(Integer DEPTNO) {
        this.DEPTNO = DEPTNO;
    }
}
