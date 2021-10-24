create table kahiya.appointment (
    id uuid primary key,
    doctor_id uuid,
    work_hour_id uuid,
    patient_id uuid,
    prescription_id uuid,
    appointment_date timestamp,
    status varchar(255)
);
