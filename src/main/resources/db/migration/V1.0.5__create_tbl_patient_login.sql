CREATE TABLE kahiya.patient_login (
 login_id bigint primary key AUTO_INCREMENT,
 account_status varchar(50),
 fail_attempts int,
 user_name varchar(255),
 password varchar(255),
 patient_id uuid REFERENCES kahiya.patient(patient_id)
);