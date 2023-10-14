package com.ibtihadj.fedapay.fedapay.playloads.responses;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;
import java.util.Map;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class TransactionResponse {
    private String klass;
    private long id;
    private String reference;
    private double amount;
    private String description;
    private String callback_url;
    private String status;
    private long customer_id;
    private int currency_id;
    private String mode;
    private String operation;
    private Map<String, Object> metadata;
    private Double commission;
    private Double fees;
    private Double fixed_commission;
    private Double amount_transferred;
    private String created_at;
    private String updated_at;
    private String approved_at;
    private String canceled_at;
    private String declined_at;
    private String refunded_at;
    private String transferred_at;
    private String deleted_at;
    private String last_error_code;
    private Map<String, Object> custom_metadata;
    private Double amount_debited;
    private String receipt_url;
    private Long payment_method_id;
    private Map<String, Object> sub_accounts_commissions;
    private String transaction_key;
    private String merchant_reference;
    private long account_id;
    private Long balance_id;

    @Override
    public String toString() {
        return "TransactionResponse{" +
                "\n  klass='" + klass + '\'' +
                "\n  id=" + id +
                "\n  reference='" + reference + '\'' +
                "\n  amount=" + amount +
                "\n  description='" + description + '\'' +
                "\n  callback_url='" + callback_url + '\'' +
                "\n  status='" + status + '\'' +
                "\n  customer_id=" + customer_id +
                "\n  currency_id=" + currency_id +
                "\n  mode='" + mode + '\'' +
                "\n  operation='" + operation + '\'' +
                "\n  metadata=" + metadata +
                "\n  commission=" + commission +
                "\n  fees=" + fees +
                "\n  fixed_commission=" + fixed_commission +
                "\n  amount_transferred=" + amount_transferred +
                "\n  created_at='" + created_at + '\'' +
                "\n  updated_at='" + updated_at + '\'' +
                "\n  approved_at='" + approved_at + '\'' +
                "\n  canceled_at='" + canceled_at + '\'' +
                "\n  declined_at='" + declined_at + '\'' +
                "\n  refunded_at='" + refunded_at + '\'' +
                "\n  transferred_at='" + transferred_at + '\'' +
                "\n  deleted_at='" + deleted_at + '\'' +
                "\n  last_error_code='" + last_error_code + '\'' +
                "\n  custom_metadata=" + custom_metadata +
                "\n  amount_debited=" + amount_debited +
                "\n  receipt_url='" + receipt_url + '\'' +
                "\n  payment_method_id=" + payment_method_id +
                "\n  sub_accounts_commissions=" + sub_accounts_commissions +
                "\n  transaction_key='" + transaction_key + '\'' +
                "\n  merchant_reference='" + merchant_reference + '\'' +
                "\n  account_id=" + account_id +
                "\n  balance_id=" + balance_id +
                "\n}";
    }

}
