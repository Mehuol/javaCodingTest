package com.smallworld;

import com.smallworld.interfaces.TransactionDataFetcherInterface;

public class TransactionDataFetcher {


    private final TransactionDataFetcherInterface transactionDataFetcherInterface;

    public TransactionDataFetcher(TransactionDataFetcherInterface transactionDataFetcherInterface) {
        this.transactionDataFetcherInterface = transactionDataFetcherInterface;
    }

    public void performAction() throws Exception {

        transactionDataFetcherInterface.getTotalTransactionAmount();
//        transactionDataFetcherInterface.getTotalTransactionAmountSentBy("Tom Shelby");
//        transactionDataFetcherInterface.getMaxTransactionAmount();
//        transactionDataFetcherInterface.countUniqueClients();
//        transactionDataFetcherInterface.getTop3TransactionsByAmount();
//        transactionDataFetcherInterface.hasOpenComplianceIssues("Oswald Mosley");
//        transactionDataFetcherInterface.getTransactionsByBeneficiaryName("Michael Gray");
//        transactionDataFetcherInterface.getUnsolvedIssueIds();
//        transactionDataFetcherInterface.getAllSolvedIssueMessages();
//        transactionDataFetcherInterface.getTopSender();

    }


}
