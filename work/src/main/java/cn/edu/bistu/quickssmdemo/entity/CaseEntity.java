package cn.edu.bistu.quickssmdemo.entity;

import java.io.Serializable;

public class CaseEntity implements Serializable {
//    某种疾病的例子
    private Integer caseId;
    private String caseTitle;
    private String caseInfo;
    private String caseDetail;
    private String caseSelf;
    private String caseCheck;
    private String caseResult;
    private String caseProcess;
    private String caseOther;
    private String caseComb;

    public String getCaseComb() {
        return caseComb;
    }

    public void setCaseComb(String caseComb) {
        this.caseComb = caseComb;
    }

    private boolean marked;

    public Integer getCaseId() {
        return caseId;
    }

    public void setCaseId(Integer caseId) {
        this.caseId = caseId;
    }

    public String getCaseTitle() {
        return caseTitle;
    }

    public void setCaseTitle(String caseTitle) {
        this.caseTitle = caseTitle;
    }

    public String getCaseInfo() {
        return caseInfo;
    }

    public void setCaseInfo(String caseInfo) {
        this.caseInfo = caseInfo;
    }

    public String getCaseDetail() {
        return caseDetail;
    }

    public void setCaseDetail(String caseDetail) {
        this.caseDetail = caseDetail;
    }

    public String getCaseSelf() {
        return caseSelf;
    }

    public void setCaseSelf(String caseSelf) {
        this.caseSelf = caseSelf;
    }

    public String getCaseCheck() {
        return caseCheck;
    }

    public void setCaseCheck(String caseCheck) {
        this.caseCheck = caseCheck;
    }

    public String getCaseResult() {
        return caseResult;
    }

    public void setCaseResult(String caseResult) {
        this.caseResult = caseResult;
    }

    public String getCaseProcess() {
        return caseProcess;
    }

    public void setCaseProcess(String caseProcess) {
        this.caseProcess = caseProcess;
    }

    public String getCaseOther() {
        return caseOther;
    }

    public void setCaseOther(String caseOther) {
        this.caseOther = caseOther;
    }

    public boolean isMarked() {
        return marked;
    }

    public void setMarked(boolean marked) {
        this.marked = marked;
    }
}
