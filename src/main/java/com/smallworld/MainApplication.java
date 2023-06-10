package com.smallworld;

import com.smallworld.interfaces.TransactionDataFetcherInterface;
import com.smallworld.service.TransactionDataFetcherService;

public class MainApplication {
    public static void main(String[] args) throws Exception {


        TransactionDataFetcherInterface transactionDataFetcherInterface = new TransactionDataFetcherService();;

        TransactionDataFetcher transactionDataFetcherService = new TransactionDataFetcher(transactionDataFetcherInterface);

        transactionDataFetcherService.performAction();

    }


}
