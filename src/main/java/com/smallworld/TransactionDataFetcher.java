package com.smallworld;

import com.smallworld.service.TransactionDataFetcherService;

public class TransactionDataFetcher {


    static TransactionDataFetcherService transactionDataFetcherService = new TransactionDataFetcherService();


    public static void main(String[] args) throws Exception {

//        System.out.println(TransactionDataFetcherService.getTotalTransactionAmount());
//        System.out.println(TransactionDataFetcherService.getTotalTransactionAmountSentBy("Tom Shelby"));
//        System.out.println(TransactionDataFetcherService.getMaxTransactionAmount());
//        System.out.println(TransactionDataFetcherService.countUniqueClients());
//        System.out.println(TransactionDataFetcherService.getTop3TransactionsByAmount());
//        System.out.println(TransactionDataFetcherService.hasOpenComplianceIssues("Oswald Mosley"));
//        System.out.println(TransactionDataFetcherService.getTransactionsByBeneficiaryName("Michael Gray"));
//        System.out.println(TransactionDataFetcherService.getUnsolvedIssueIds());
//        System.out.println(TransactionDataFetcherService.getAllSolvedIssueMessages());
        System.out.println(TransactionDataFetcherService.getTopSender());

    }


}
