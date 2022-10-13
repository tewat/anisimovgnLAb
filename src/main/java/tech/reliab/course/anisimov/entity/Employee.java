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
    private String bankOfWorkId;
    private Boolean isWorkingFromOffice;
    private String officeId;
    private Boolean canIssueLoans;
    private int salary;

    //region ===================== Constructors ======================
    public Employee(
            String id,
            FullName fullName,
            Date birthDate,
            String jobPosition,
            String bankOfWorkId,
            Boolean isWorkingFromOffice,
            String officeId,
            Boolean canIssueLoans,
            int salary
    ) {
        this.id = id;
        this.fullName = fullName;
        this.birthDate = birthDate;
        this.jobPosition = jobPosition;
        this.bankOfWorkId = bankOfWorkId;
        this.isWorkingFromOffice = isWorkingFromOffice;
        this.officeId = officeId;
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

    public void setBankOfWorkId(String bankOfWorkId) {
        this.bankOfWorkId = bankOfWorkId;
    }

    public void setWorkingFromOffice(Boolean workingFromOffice) {
        isWorkingFromOffice = workingFromOffice;
    }

    public void setOfficeId(String officeId) {
        this.officeId = officeId;
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

    public String getBankOfWorkId() {
        return bankOfWorkId;
    }

    public Boolean getWorkingFromOffice() {
        return isWorkingFromOffice;
    }

    public String getOfficeId() {
        return officeId;
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
        return getId().equals(employee.getId()) && getFullName().equals(employee.getFullName()) && getBankOfWorkId().equals(employee.getBankOfWorkId());
    }

    @Override
    public int hashCode() {
        return Objects.hash(getId(), getFullName(), getBankOfWorkId());
    }

    @Override
    public String toString() {
        return "Employee{" +
                "id='" + id + '\'' +
                ", fullName=" + fullName +
                ", birthDate=" + birthDate +
                ", jobPosition='" + jobPosition + '\'' +
                ", bankOfWorkId=" + bankOfWorkId +
                ", isWorkingFromOffice=" + isWorkingFromOffice +
                ", officeId=" + officeId +
                ", canIssueLoans=" + canIssueLoans +
                ", salary=" + salary +
                '}';
    }
}
