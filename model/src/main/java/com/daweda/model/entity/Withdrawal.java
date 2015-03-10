package com.daweda.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;

/**
 * Created by elena on 20.02.15.
 */
@Entity
@Table(name="withdrawal")
@NamedQuery(name="Withdrawal.findAll", query="SELECT w FROM Withdrawal w")
public class Withdrawal implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy=GenerationType.AUTO)
    @Column(name="id_withdrawal", unique=true, nullable=false)
    private long idWithdrawal;

    @Column(name="amount", nullable=false)
    private double amount;

    @Column(name="is_processed")
    private boolean isProcessed;

    @Column(name="opened_time", nullable=false)
    private Timestamp openedTime;

    @Column(name="processed_time")
    private Timestamp processedTime;

    //bi-directional many-to-one association to Account
    @ManyToOne(fetch=FetchType.EAGER)
    @JoinColumn(name="account_id", nullable=false)
    private Account account;

    public Withdrawal() {
    }

    public long getIdWithdrawal() {
        return this.idWithdrawal;
    }

    public void setIdWithdrawal(long idWithdrawal) {
        this.idWithdrawal = idWithdrawal;
    }

    public double getAmount() {
        return this.amount;
    }

    public void setAmount(double amount) {
        this.amount = amount;
    }

    public boolean getIsProcessed() {
        return this.isProcessed;
    }

    public void setIsProcessed(boolean isProcessed) {
        this.isProcessed = isProcessed;
    }

    public Timestamp getOpenedTime() {
        return this.openedTime;
    }

    public void setOpenedTime(Timestamp openedTime) {
        this.openedTime = openedTime;
    }

    public Timestamp getProcessedTime() {
        return this.processedTime;
    }

    public void setProcessedTime(Timestamp processedTime) {
        this.processedTime = processedTime;
    }

    public Account getAccount() {
        return this.account;
    }

    public void setAccount(Account account) {
        this.account = account;
    }

}
