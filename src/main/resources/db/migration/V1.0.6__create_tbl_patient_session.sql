CREATE TABLE kahiya.patient_session (
 session_id bigint primary key AUTO_INCREMENT,
 token varchar(255),
 login_id bigint REFERENCES kahiya.patient_login(login_id)
);