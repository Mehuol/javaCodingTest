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

}
