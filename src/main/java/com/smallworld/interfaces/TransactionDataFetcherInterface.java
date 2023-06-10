package com.smallworld.interfaces;

import com.smallworld.data.Transaction;

import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

public interface TransactionDataFetcherInterface {
    public double getTotalTransactionAmount() throws Exception;
    public double getTotalTransactionAmountSentBy(String senderFullName) throws Exception;
    public double getMaxTransactionAmount() throws Exception ;
    public long countUniqueClients() throws Exception ;
    public List<Transaction> getTop3TransactionsByAmount() throws Exception ;
    public boolean hasOpenComplianceIssues(String clientFullName) throws Exception;
    public Map<String, Transaction> getTransactionsByBeneficiaryName(String beneficiaryName) throws Exception;
    public Set<Integer> getUnsolvedIssueIds() throws Exception;
    public List<String> getAllSolvedIssueMessages() throws Exception;
    public Optional<String> getTopSender() throws Exception;
}
