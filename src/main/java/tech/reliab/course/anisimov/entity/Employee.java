package tech.reliab.course.anisimov.entity;

import tech.reliab.course.anisimov.entity.internalComponents.FullName;

import java.util.Date;
import java.util.Objects;

final public class Employee {
    //region ===================== Properties ======================
    private String id;
    private FullName fullName;
    private Date birthDate;
    private String jobPosition;
    private Bank bankOfWork;
    private Boolean isWorkingFromOffice;
    private BankOffice office;
    private Boolean canIssueLoans;
    private int salary;

    //region ===================== Constructors ======================
    public Employee(
            String id,
            FullName fullName,
            Date birthDate,
            String jobPosition,
            Bank bankOfWork,
            Boolean isWorkingFromOffice,
            BankOffice office,
            Boolean canIssueLoans,
            int salary
    ) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.jobPosition = jobPosition;
        this.bankOfWork = bankOfWork;
        this.isWorkingFromOffice = isWorkingFromOffice;
        this.office = office;
        this.canIssueLoans = canIssueLoans;
        this.salary = salary;
    }

    //region ===================== Setters ======================
    public void setId(String id) {
        this.id = id;
    }

    public void setFullName(FullName fullName) {
        this.fullName = fullName;
    }

    public void setBirthDate(Date birthDate) {
        this.birthDate = birthDate;
    }

    public void setJobPosition(String jobPosition) {
        this.jobPosition = jobPosition;
    }

    public void setBankOfWork(Bank bankOfWork) {
        this.bankOfWork = bankOfWork;
    }

    public void setWorkingFromOffice(Boolean workingFromOffice) {
        isWorkingFromOffice = workingFromOffice;
    }

    public void setOffice(BankOffice office) {
        this.office = office;
    }

    public void setCanIssueLoans(Boolean canIssueLoans) {
        this.canIssueLoans = canIssueLoans;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    //region ===================== Getters ======================
    public String getId() {
        return id;
    }

    public FullName getFullName() {
        return fullName;
    }

    public Date getBirthDate() {
        return birthDate;
    }

    public String getJobPosition() {
        return jobPosition;
    }

    public Bank getBankOfWork() {
        return bankOfWork;
    }

    public Boolean getWorkingFromOffice() {
        return isWorkingFromOffice;
    }

    public BankOffice getOffice() {
        return office;
    }

    public Boolean getCanIssueLoans() {
        return canIssueLoans;
    }

    public int getSalary() {
        return salary;
    }

    //region ===================== Object overrides ======================
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Employee employee = (Employee) o;
        return getId().equals(employee.getId()) && getFullName().equals(employee.getFullName()) && getBankOfWork().equals(employee.getBankOfWork());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getBankOfWork());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", fullName=" + fullName +
                ", birthDate=" + birthDate +
                ", jobPosition='" + jobPosition + '\'' +
                ", bankOfWork=" + bankOfWork +
                ", isWorkingFromOffice=" + isWorkingFromOffice +
                ", office=" + office +
                ", canIssueLoans=" + canIssueLoans +
                ", salary=" + salary +
                '}';
    }
}
