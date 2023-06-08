package com.smallworld.data;

import lombok.Data;

import java.io.Serializable;

@Data

public class Transaction implements Serializable {

    private long mtn;
    private double amount;
    private String senderFullName;
    private int senderAge;
    private String beneficiaryFullName;
    private int beneficiaryAge;
    private int issueId;
    private boolean issueSolved;
    private String issueMessage;

    public Transaction() {
    }

    public Transaction(long mtn, double amount, String senderFullName, int senderAge, String beneficiaryFullName, int beneficiaryAge, int issueId, boolean issueSolved, String issueMessage) {
        this.mtn = mtn;
        this.amount = amount;
        this.senderFullName = senderFullName;
        this.senderAge = senderAge;
        this.beneficiaryFullName = beneficiaryFullName;
        this.beneficiaryAge = beneficiaryAge;
        this.issueId = issueId;
        this.issueSolved = issueSolved;
        this.issueMessage = issueMessage;
    }
}
