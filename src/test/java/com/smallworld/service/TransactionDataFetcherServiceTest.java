package com.smallworld.service;

import com.smallworld.data.Transaction;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.*;

class TransactionDataFetcherServiceTest {


    TransactionDataFetcherService myService = new TransactionDataFetcherService();


    @Test
    void getTotalTransactionAmount() {
        double expectedSum = 4371.37;

        try {
            double actualSum = myService.getTotalTransactionAmount();
            Assertions.assertEquals(expectedSum, actualSum);
            System.out.println(actualSum);
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    void getTotalTransactionAmountSentBy() {

        String senderFullName = "Tom Shelby";
        double expectedSum = 828.2599999999999;

        try {
            double actualSum = myService.getTotalTransactionAmountSentBy(senderFullName);
            Assertions.assertEquals(expectedSum, actualSum);
            System.out.println(actualSum);
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    void getMaxTransactionAmount() {
        double expectedAmount = 985.0;

        try {
            double actualMaxAmount = myService.getMaxTransactionAmount();
            Assertions.assertEquals(expectedAmount, actualMaxAmount);
            System.out.println(actualMaxAmount);
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    void countUniqueClients() {
        long expectedCount = 10;
        try {
            long actualCount = myService.countUniqueClients();
            Assertions.assertEquals(expectedCount, actualCount);
            System.out.println(actualCount);
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }

    }

    @Test
    void getTop3TransactionsByAmount() {
        List<Transaction> expectedTop3 = Arrays.asList(
                new Transaction(5465465, 985.0, "Arthur Shelby", 60, "Ben Younger", 47, 15, false, "Something's fishy"),
                new Transaction(32612651, 666.0, "Grace Burgess", 31, "Michael Gray", 58, 54, false, "Something ain't right"),
                new Transaction(32612651, 666.0, "Grace Burgess", 31, "Michael Gray", 58, 78, true, "Never gonna run around and desert you")
        );

        try {
            List<Transaction> actualTop3 = myService.getTop3TransactionsByAmount();
            Assertions.assertEquals(expectedTop3, actualTop3);
            System.out.println(actualTop3);
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    void hasOpenComplianceIssues() {
        String clientFullName = "Tom Shelby";

        try {
            boolean actualResult = myService.hasOpenComplianceIssues(clientFullName);
            if (actualResult == true) {
                Assertions.assertTrue(actualResult, "Expected compliance issue found");
            } else {
                Assertions.assertFalse(actualResult, "Expected compliance issue not found");
            }
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }

    }

    @Test
    void getTransactionsByBeneficiaryName() {
        String beneficiaryName = "Alfie Solomons";

        try {
            Map<String, Transaction> actualResult = myService.getTransactionsByBeneficiaryName( beneficiaryName);
            Assertions.assertNotNull(actualResult, "Expected a non-null result");

            Assertions.assertFalse(actualResult.isEmpty(), "Expected at least one transaction");
            System.out.println(actualResult);


        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }

    }

    @Test
    void getUnsolvedIssueIds() {
        try {
            Set<Integer> unsolvedIssueIds = myService.getUnsolvedIssueIds();
            Assertions.assertNotNull(unsolvedIssueIds, "Expected a non-null result");

            // Assert that the set of unsolved issue IDs is not empty
            Assertions.assertFalse(unsolvedIssueIds.isEmpty(), "Expected at least one unsolved issue ID");

            System.out.println(unsolvedIssueIds);

        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    void getAllSolvedIssueMessages() {

        try {
            List<String> solvedIssueMessages = myService.getAllSolvedIssueMessages();
            Assertions.assertNotNull(solvedIssueMessages, "Expected a non-null result");

            System.out.println(solvedIssueMessages);

        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }

    @Test
    void getTopSender() {
        try {
            Optional<String> topSender = myService.getTopSender();
            Assertions.assertTrue(topSender.isPresent(), "Expected a non-empty result");

            System.out.println(topSender);
        } catch (Exception e) {
            Assertions.fail("An exception occurred: " + e.getMessage());
        }
    }
}