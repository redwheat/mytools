package com.ex.mytools.utils.transaction;

import com.ex.mytools.utils.CapRetFunc;
import org.springframework.stereotype.Component;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author RedWheat
 * @date 2025/2/12 10:09
 */
@Component("TransactionWrapper")
public class TransactionWrapper {
    public TransactionWrapper() {
    }

    @Transactional(
            rollbackFor = {Exception.class}
    )
    public <R> R deal(CapRetFunc<R> retFunc) {
        return retFunc.apply();
    }

    @Transactional(
            rollbackFor = {Exception.class},
            propagation = Propagation.REQUIRES_NEW
    )
    public <R> R dealNew(CapRetFunc<R> retFunc) {
        return retFunc.apply();
    }

    @Transactional(
            rollbackFor = {Exception.class},
            propagation = Propagation.NESTED
    )
    public <R> R dealNested(CapRetFunc<R> retFunc) {
        return retFunc.apply();
    }
}
