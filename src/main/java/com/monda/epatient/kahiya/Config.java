package com.monda.epatient.kahiya;

import com.monda.epatient.kahiya.model.PaymentEntity;

public class Config {
    public static final String STORAGE_PATH = "/";

    public static final String PATH_SEPARATOR = "/";

    public static PaymentEntity.PaymentProvider paymentProvider = PaymentEntity.PaymentProvider.PAYHERE;
}
