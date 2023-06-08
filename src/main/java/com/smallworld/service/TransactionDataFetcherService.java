package com.smallworld.service;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.smallworld.data.Transaction;

import java.io.File;
import java.util.*;
import java.util.stream.Collectors;

public class TransactionDataFetcherService {
    static ObjectMapper objectMapper = new ObjectMapper();
    static String absoluteFilePath = "transactions.json";
    static File jsonFile = new File(absoluteFilePath);

    /**
     * Returns the sum of the amounts of all transactions
     */
    public static double getTotalTransactionAmount() throws Exception {
        double sumOfTransactions = 0.0;
        List<Double> al = new ArrayList<>();

        try {
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });

            for (Transaction datum : data) {
                al.add(datum.getAmount());
            }

            for (double number : al) {
                sumOfTransactions += number;
            }

            System.out.println("Sum of the amounts of all transactions.");

        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException();

        } catch (Exception e) {
            throw new Exception();
        }

        return sumOfTransactions;
    }

    /**
     * Returns the sum of the amounts of all transactions sent by the specified client
     */
    public static double getTotalTransactionAmountSentBy(String senderFullName) throws Exception {
        double sumOfTransactions = 0.0;
        List<Double> al = new ArrayList<>();
        try {
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });

            for (Transaction datum : data) {
                if (datum.getSenderFullName().equals(senderFullName)) {
                    al.add(datum.getAmount());

                }
            }

            for (double number : al) {
                sumOfTransactions += number;
            }

            System.out.println("Sum of the amounts of all transactions of the specified client");


        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException();

        } catch (Exception e) {
            throw new Exception();
        }
        return sumOfTransactions;
    }

    /**
     * Returns the highest transaction amount
     */
    public static double getMaxTransactionAmount() throws Exception {
        double maxTransactionAmount = 0.0;
        List<Double> al = new ArrayList<>();
        try {
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });


            for (Transaction datum : data) {
                if (datum.getAmount() > maxTransactionAmount) {
                    maxTransactionAmount = datum.getAmount();
                }
            }

            System.out.println("The highest transaction amount in the given data is");

        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException();

        } catch (Exception e) {
            throw new Exception();

        }

        return maxTransactionAmount;
    }

    /**
     * Counts the number of unique clients that sent or received a transaction
     */
    public static long countUniqueClients() throws Exception {
        long count = 0;

        List<Long> list = new ArrayList<>();

        try {
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });
            for (Transaction datum : data) {

                list.add(datum.getMtn());

            }

            count = list.stream().distinct().count();
            System.out.println("Number of unique clients");


        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            throw new Exception();
        }

        return count;
    }

    /**
     * Returns the 3 transactions with the highest amount sorted by amount descending
     */
    public static List<Transaction> getTop3TransactionsByAmount() throws Exception {
        List<Transaction> list = new ArrayList<>();
        try {
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });

            list = data.stream()
                    .sorted(Comparator.comparingDouble(Transaction::getAmount).reversed())
                    .limit(3)
                    .collect(Collectors.toList());


            System.out.println("The 3 transactions with the highest amount sorted by amount descending.");


        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            throw new Exception();
        }

        return list;
    }

    /**
     * Returns whether a client (sender or beneficiary) has at least one transaction with a compliance
     * issue that has not been solved
     */
    public static boolean hasOpenComplianceIssues(String clientFullName) throws Exception {
        boolean hasOpenComplianceIssues;
        List<Transaction> dummyList = new ArrayList<>();
        try {
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });

            for (Transaction obj : data) {
                if (obj.getSenderFullName().equals(clientFullName)) {
                    dummyList.add(obj);
                } else if (obj.getBeneficiaryFullName().equals(clientFullName)) {
                    dummyList.add(obj);
                }
            }


            hasOpenComplianceIssues = dummyList.stream()
                    .anyMatch(obj -> obj.isIssueSolved() == false);


            if (hasOpenComplianceIssues) {
                System.out.println("Compliance issue found");
            } else {
                System.out.println("Compliance issue not found");
            }


        } catch (UnsupportedOperationException e) {
            throw new UnsupportedOperationException();
        } catch (Exception e) {
            throw new Exception();
        }

        return hasOpenComplianceIssues;

    }

    /**
     * Returns all transactions indexed by beneficiary name
     */
    public static Map<String, Transaction> getTransactionsByBeneficiaryName(String beneficiaryName) throws Exception {
        Map<String, Transaction> result = new HashMap<>();
        try {
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });
            int i = 0;
            for (Transaction obj : data) {


                if (obj.getBeneficiaryFullName().equals(beneficiaryName)){
                    String key = "data" + i;
                    result.put(key, obj);
                    i++;

                };
            }

            System.out.println("Transactions indexed by beneficiary name");

        } catch (UnsupportedOperationException e) {

            throw new UnsupportedOperationException();
        } catch (Exception e) {
            throw new Exception();
        }

        return result;
    }

    /**
     * Returns the identifiers of all open compliance issues
     */
    public static Set<Integer> getUnsolvedIssueIds() throws Exception {
        Set<Integer>  issueIds;
        try {
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });
            issueIds = data.stream()
                    .filter(transaction -> !transaction.isIssueSolved())
                    .map(Transaction::getIssueId)
                    .collect(Collectors.toSet());

            System.out.println("Issue ids of compliance issues");

        } catch (UnsupportedOperationException e) {

            throw new UnsupportedOperationException();
        } catch (Exception e) {
            throw new Exception();
        }
        return issueIds;
    }

    /**
     * Returns a list of all solved issue messages
     */
    public static List<String> getAllSolvedIssueMessages() throws Exception{
        List<String> stringList;
        try {
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });
            stringList = data.stream()
                    .filter(obj -> obj.isIssueSolved())
                    .map(Transaction::getIssueMessage)
                    .collect(Collectors.toList());

            System.out.println("List of all solved issue messages");

        } catch (UnsupportedOperationException e) {

            throw new UnsupportedOperationException();
        } catch (Exception e) {
            throw new Exception();
        }
        return stringList;
    }

    /**
     * Returns the senderFullName of the sender with the most total sent amount
     */
    public static Optional<String> getTopSender() throws Exception{
        Optional<String> senderFullName;
        try{
            List<Transaction> data = objectMapper.readValue(jsonFile, new TypeReference<List<Transaction>>() {
            });
            senderFullName = data.stream()
                    .collect(Collectors.groupingBy(Transaction::getSenderFullName, Collectors.summingDouble(Transaction::getAmount)))
                    .entrySet()
                    .stream()
                    .max(Map.Entry.comparingByValue())
                    .map(Map.Entry::getKey);

            System.out.println("The sender with the most total sent amount");
        }catch (UnsupportedOperationException e){
            throw new UnsupportedOperationException();
        }catch (Exception e){
            throw new Exception();
        }

        return senderFullName;
    }


}
