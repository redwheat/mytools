package com.ex.mytools.utils.transaction;

import com.ex.mytools.utils.CapFunc;
import com.ex.mytools.utils.CapRetFunc;
import com.ex.mytools.utils.SpringContextUtils;
import org.springframework.transaction.support.TransactionSynchronizationManager;

/**
 * 封装事务操作
 * @author RedWheat
 * @date 2025/2/12 10:08
 */
public class TransactionHelper {
    private static final TransactionWrapper WRAPPER = (TransactionWrapper) SpringContextUtils.getBean("TransactionWrapper");

    public TransactionHelper() {
    }

    public static <R> R transactionDeal(CapRetFunc<R> retFunc) {
        return WRAPPER.deal(retFunc);
    }

    public static <R> R newTransactionDeal(CapRetFunc<R> retFunc) {
        return WRAPPER.dealNew(retFunc);
    }

    public static <R> R nestedTransactionDeal(CapRetFunc<R> retFunc) {
        return WRAPPER.dealNested(retFunc);
    }

    public static void transactionDeal(CapFunc retFunc) {
        WRAPPER.deal(() -> {
            retFunc.apply();
            return null;
        });
    }

    public static void newTransactionDeal(CapFunc retFunc) {
        WRAPPER.dealNew(() -> {
            retFunc.apply();
            return null;
        });
    }

    public static <R> R nestedTransactionDeal(CapFunc retFunc) {
        return WRAPPER.dealNested(() -> {
            retFunc.apply();
            return null;
        });
    }

    public static <R> R dealIsolated(int isolatedLevel, CapRetFunc<R> retFunc) {
        Integer currentTransactionIsolationLevel = TransactionSynchronizationManager.getCurrentTransactionIsolationLevel();

        R var3;
        try {
            TransactionSynchronizationManager.setCurrentTransactionIsolationLevel(isolatedLevel);
            var3 = retFunc.apply();
        } finally {
            TransactionSynchronizationManager.setCurrentTransactionIsolationLevel(currentTransactionIsolationLevel);
        }

        return var3;
    }

    public static <R> R dealIsolated(int isolatedLevel, CapFunc retFunc) {
        return dealIsolated(isolatedLevel, () -> {
            retFunc.apply();
            return null;
        });
    }
}
